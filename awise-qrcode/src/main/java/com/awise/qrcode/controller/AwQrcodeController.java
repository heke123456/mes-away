package com.awise.qrcode.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletResponse;

import com.awise.qrcode.units.QrCodeUnit;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import com.away.common.annotation.Log;
import com.away.common.core.controller.BaseController;
import com.away.common.core.domain.AjaxResult;
import com.away.common.enums.BusinessType;
import com.awise.qrcode.domain.AwQrcode;
import com.awise.qrcode.service.IAwQrcodeService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 二维码Controller
 * 
 * @author awise
 * @date 2023-09-18
 */
@RestController
@RequestMapping("/awise/qrcode")
@Component
public class AwQrcodeController extends BaseController
{
    @Autowired
    private IAwQrcodeService awQrcodeService;

    QrCodeUnit qrCodeUnit = new QrCodeUnit();

    @Value("${qrcode.url}")
    String url;

    @Value("${qrcode.size}")
    Integer size;

    @Value("${away.profile}")
    String filepath;

    @Value("${qrcode.filetype}")
    String filetype;

    @Value("${qrcode.multiple}")
    Integer multiple;


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @PreAuthorize("@ss.hasPermi('awise:qrcode:get')")
    @GetMapping("/get")
    public AjaxResult getQrCode(
            @RequestParam("productiontasksformID")String productiontasksformID,
            @RequestParam("productiontasksID")String productiontasksID,
            @RequestParam("processingprocessID")String processingprocessID
    ) throws IOException, WriterException, ParseException {
        AjaxResult to_ajax = toAjax(1);
        AwQrcode awQrcode =  awQrcodeService.selectAwQrcodeByProcessingprocessID(Long.valueOf(processingprocessID));// 写一个sql用工序id来查询，通过二维码创建时间排序，取最新码。
        String query = String.format("?productiontasksformID=%s&productiontasksID=%s&processingprocessID=%s",productiontasksformID,productiontasksID,processingprocessID);
        if(awQrcode == null){
            awQrcode = this.qrCodeUnit.createQrCode(this.url, this.size, this.multiple, this.filetype, this.filepath, productiontasksformID, productiontasksID, processingprocessID, query);
            awQrcodeService.insertAwQrcode(awQrcode);
        }else {
            String fileurl = awQrcode.getFileurl();
            File file = new File(this.filepath+fileurl);
            if (!file.exists()){
                awQrcode = this.qrCodeUnit.createQrCode(this.url, this.size, this.multiple, this.filetype, this.filepath, productiontasksformID, productiontasksID, processingprocessID, query);
                awQrcodeService.insertAwQrcode(awQrcode);
            }
        }


        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s_date = df.format(new Date(awQrcode.getCreateTime().getTime() + Long.valueOf(awQrcode.getEffectiveDuration()) * 60 * 1000));

        Date date = df.parse(s_date);
        Date new_date = new Date();
        if (date.before(new_date)){

        }else {
            awQrcode = this.qrCodeUnit.createQrCode(this.url, this.size, this.multiple, this.filetype, this.filepath, productiontasksformID, productiontasksID, processingprocessID, query);
            awQrcodeService.insertAwQrcode(awQrcode);
        }
        String fileurl = awQrcode.getFileurl();

        to_ajax.put("date",fileurl);
        return to_ajax;
    }

    /**
     * 查询二维码列表
     */
    @PreAuthorize("@ss.hasPermi('qrcode:qrcode:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwQrcode awQrcode)
    {
        startPage();
        List<AwQrcode> list = awQrcodeService.selectAwQrcodeList(awQrcode);
        return getDataTable(list);
    }

    /**
     * 导出二维码列表
     */
    @PreAuthorize("@ss.hasPermi('qrcode:qrcode:export')")
    @Log(title = "二维码", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwQrcode awQrcode)
    {
        List<AwQrcode> list = awQrcodeService.selectAwQrcodeList(awQrcode);
        ExcelUtil<AwQrcode> util = new ExcelUtil<AwQrcode>(AwQrcode.class);
        util.exportExcel(response, list, "二维码数据");
    }

    /**
     * 获取二维码详细信息
     */
    @PreAuthorize("@ss.hasPermi('qrcode:qrcode:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awQrcodeService.selectAwQrcodeById(id));
    }

    /**
     * 新增二维码
     */
    @PreAuthorize("@ss.hasPermi('qrcode:qrcode:add')")
    @Log(title = "二维码", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwQrcode awQrcode)
    {
        return toAjax(awQrcodeService.insertAwQrcode(awQrcode));
    }

    /**
     * 修改二维码
     */
    @PreAuthorize("@ss.hasPermi('qrcode:qrcode:edit')")
    @Log(title = "二维码", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwQrcode awQrcode)
    {
        return toAjax(awQrcodeService.updateAwQrcode(awQrcode));
    }

    /**
     * 删除二维码
     */
    @PreAuthorize("@ss.hasPermi('qrcode:qrcode:remove')")
    @Log(title = "二维码", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awQrcodeService.deleteAwQrcodeByIds(ids));
    }
}
