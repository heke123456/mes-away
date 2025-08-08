package com.awise.file.controller;

import java.io.*;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.awise.file.utils.OpenFile;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/awise/file")
public class AwFileController {

    @Value("${away.profile}")
    String file_path;

    /**
     * 文件上传
     * @return
     */
    @PreAuthorize("@ss.hasPermi('awise:file:update')")
    @PostMapping("/update")
    public String update(@RequestParam("files") MultipartFile[] files)
    {
        String file_names = "";
        for(MultipartFile file:files){
            OpenFile openFile = new OpenFile(file,file_path);
            openFile.saveFile();
            file_names += openFile.getFile_name()+";";
        }

        return file_names;
    }

    /**
     * 文件下载
     * @return
     */
    @PreAuthorize("@ss.hasPermi('awise:file:download')")
    @GetMapping("/download/{filename}")
    public void download(@PathVariable  String filename, HttpServletResponse response) throws IOException {
        // 将文件写入输入流
        File file = new File(file_path+"/"+filename);
        FileInputStream fileInputStream = new FileInputStream(file);
        Tika tika = new Tika();
        String mimeType = tika.detect(file);
        InputStream fis = new BufferedInputStream(fileInputStream);
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();

        // 清空response
        response.reset();
        // 设置response的Header
        response.setCharacterEncoding("UTF-8");
        //Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
        //attachment表示以附件方式下载   inline表示在线打开   "Content-Disposition: inline; filename=文件名.mp3"
        // filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
        // 告知浏览器文件的大小
        response.addHeader("Content-Length", "" + file.length());
        OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
//        response.setContentType("application/octet-stream");
        response.setContentType(mimeType);
        outputStream.write(buffer);
        outputStream.flush();


    }

    /**
     * 文件删除
     * @return
     */
    @PreAuthorize("@ss.hasPermi('awise:file:delete')")
    @GetMapping("/delete")
    public String delete(@RequestParam("filename") String filename) throws IOException {
        // 将文件写入输入流
        File file = new File(file_path+"/"+filename);
        boolean delete = file.delete();
        return delete==true?"成功":"失败";
    }
}
