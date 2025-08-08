package com.awise.file.utils;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class OpenFile {
    private InputStream inputStream = null;
    private FileOutputStream outStream = null;
    private MultipartFile file = null;
    private String file_name = null;
    private String save_file_path = null;

    public OpenFile(MultipartFile file,String save_file_path){
        this.file = file;
        this.file_name = String.valueOf(file.hashCode())+"."+file.getOriginalFilename().split("\\.")[file.getOriginalFilename().split("\\.").length-1];
        this.save_file_path = save_file_path;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public FileOutputStream getOutStream() {
        return outStream;
    }

    public void setOutStream(FileOutputStream outStream) {
        this.outStream = outStream;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getSave_file_path() {
        return save_file_path;
    }

    public void setSave_file_path(String save_file_path) {
        this.save_file_path = save_file_path;
    }

    // 读取文件
    public String readFile()  {
        String tmp="";
        try {
            this.inputStream = this.file.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(this.inputStream, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(inputStreamReader);
            while(br.ready()){
                tmp += br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    // 存储文件
    public void saveFile() {
        try {
            this.makeDirPath();
            this.inputStream = this.file.getInputStream();
            this.outStream = new FileOutputStream(this.save_file_path+"/"+this.file_name);

            int len = -1;
            byte[] b = new byte[1024];
            while ((len = this.inputStream.read(b)) != -1) {
                this.outStream.write(b, 0, len);
            }
            this.inputStream.close();
            this.outStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 创建目录
    public void makeDirPath(){
        File dir = new File(this.save_file_path);
        if(!dir.exists()){
            dir.mkdirs();
        }
    }
}
