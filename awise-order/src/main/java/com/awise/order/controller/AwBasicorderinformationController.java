package com.awise.order.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.away.common.annotation.Log;
import com.away.common.core.controller.BaseController;
import com.away.common.core.domain.AjaxResult;
import com.away.common.enums.BusinessType;
import com.awise.order.domain.AwBasicorderinformation;
import com.awise.order.service.IAwBasicorderinformationService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * VIEWController
 * 
 * @author awise
 * @date 2023-12-22
 */
@RestController
@RequestMapping("/order/BasicOrderInformation")
public class AwBasicorderinformationController extends BaseController
{
    @Autowired
    private IAwBasicorderinformationService awBasicorderinformationService;

    /**
     * 查询VIEW列表
     */
    @PreAuthorize("@ss.hasPermi('order:BasicOrderInformation:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwBasicorderinformation awBasicorderinformation)
    {
        startPage();
        List<AwBasicorderinformation> list = awBasicorderinformationService.selectAwBasicorderinformationList(awBasicorderinformation);
        return getDataTable(list);
    }

    /**
     * 导出VIEW列表
     */
    @PreAuthorize("@ss.hasPermi('order:BasicOrderInformation:export')")
    @Log(title = "VIEW", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwBasicorderinformation awBasicorderinformation)
    {
        List<AwBasicorderinformation> list = awBasicorderinformationService.selectAwBasicorderinformationList(awBasicorderinformation);
        ExcelUtil<AwBasicorderinformation> util = new ExcelUtil<AwBasicorderinformation>(AwBasicorderinformation.class);
        util.exportExcel(response, list, "VIEW数据");
    }

    /**
     * 获取VIEW详细信息
     */
    @PreAuthorize("@ss.hasPermi('order:BasicOrderInformation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(awBasicorderinformationService.selectAwBasicorderinformationById(id));
    }

    /**
     * 新增VIEW
     */
    @PreAuthorize("@ss.hasPermi('order:BasicOrderInformation:add')")
    @Log(title = "VIEW", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwBasicorderinformation awBasicorderinformation)
    {
        return toAjax(awBasicorderinformationService.insertAwBasicorderinformation(awBasicorderinformation));
    }

    /**
     * 修改VIEW
     */
    @PreAuthorize("@ss.hasPermi('order:BasicOrderInformation:edit')")
    @Log(title = "VIEW", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwBasicorderinformation awBasicorderinformation)
    {
        return toAjax(awBasicorderinformationService.updateAwBasicorderinformation(awBasicorderinformation));
    }

    /**
     * 删除VIEW
     */
    @PreAuthorize("@ss.hasPermi('order:BasicOrderInformation:remove')")
    @Log(title = "VIEW", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(awBasicorderinformationService.deleteAwBasicorderinformationByIds(ids));
    }
}
