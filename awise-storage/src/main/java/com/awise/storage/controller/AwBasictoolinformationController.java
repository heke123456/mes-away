package com.awise.storage.controller;

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
import com.awise.storage.domain.AwBasictoolinformation;
import com.awise.storage.service.IAwBasictoolinformationService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * BasicToolInformationController
 * 
 * @author awise
 * @date 2023-12-06
 */
@RestController
@RequestMapping("/storage/BasicToolInformation")
public class AwBasictoolinformationController extends BaseController
{
    @Autowired
    private IAwBasictoolinformationService awBasictoolinformationService;

    /**
     * 查询BasicToolInformation列表
     */
    @PreAuthorize("@ss.hasPermi('storage:BasicToolInformation:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwBasictoolinformation awBasictoolinformation)
    {
        startPage();
        List<AwBasictoolinformation> list = awBasictoolinformationService.selectAwBasictoolinformationList(awBasictoolinformation);
        return getDataTable(list);
    }

    /**
     * 导出BasicToolInformation列表
     */
    @PreAuthorize("@ss.hasPermi('storage:BasicToolInformation:export')")
    @Log(title = "BasicToolInformation", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwBasictoolinformation awBasictoolinformation)
    {
        List<AwBasictoolinformation> list = awBasictoolinformationService.selectAwBasictoolinformationList(awBasictoolinformation);
        ExcelUtil<AwBasictoolinformation> util = new ExcelUtil<AwBasictoolinformation>(AwBasictoolinformation.class);
        util.exportExcel(response, list, "BasicToolInformation数据");
    }

    /**
     * 获取BasicToolInformation详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:BasicToolInformation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(awBasictoolinformationService.selectAwBasictoolinformationById(id));
    }

    /**
     * 新增BasicToolInformation
     */
    @PreAuthorize("@ss.hasPermi('storage:BasicToolInformation:add')")
    @Log(title = "BasicToolInformation", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwBasictoolinformation awBasictoolinformation)
    {
        return toAjax(awBasictoolinformationService.insertAwBasictoolinformation(awBasictoolinformation));
    }

    /**
     * 修改BasicToolInformation
     */
    @PreAuthorize("@ss.hasPermi('storage:BasicToolInformation:edit')")
    @Log(title = "BasicToolInformation", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwBasictoolinformation awBasictoolinformation)
    {
        return toAjax(awBasictoolinformationService.updateAwBasictoolinformation(awBasictoolinformation));
    }

    /**
     * 删除BasicToolInformation
     */
    @PreAuthorize("@ss.hasPermi('storage:BasicToolInformation:remove')")
    @Log(title = "BasicToolInformation", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(awBasictoolinformationService.deleteAwBasictoolinformationByIds(ids));
    }
}
