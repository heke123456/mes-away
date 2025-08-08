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
import com.awise.storage.domain.AwToolclassification;
import com.awise.storage.service.IAwToolclassificationService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 刀具分类Controller
 * 
 * @author awise
 * @date 2023-07-27
 */
@RestController
@RequestMapping("/toolclassification/toolclassification")
public class AwToolclassificationController extends BaseController
{
    @Autowired
    private IAwToolclassificationService awToolclassificationService;

    /**
     * 查询刀具分类列表
     */
    @PreAuthorize("@ss.hasPermi('toolclassification:toolclassification:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwToolclassification awToolclassification)
    {
        startPage();
        List<AwToolclassification> list = awToolclassificationService.selectAwToolclassificationList(awToolclassification);
        return getDataTable(list);
    }

    /**
     * 导出刀具分类列表
     */
    @PreAuthorize("@ss.hasPermi('toolclassification:toolclassification:export')")
    @Log(title = "刀具分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwToolclassification awToolclassification)
    {
        List<AwToolclassification> list = awToolclassificationService.selectAwToolclassificationList(awToolclassification);
        ExcelUtil<AwToolclassification> util = new ExcelUtil<AwToolclassification>(AwToolclassification.class);
        util.exportExcel(response, list, "刀具分类数据");
    }

    /**
     * 获取刀具分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('toolclassification:toolclassification:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awToolclassificationService.selectAwToolclassificationById(id));
    }

    /**
     * 新增刀具分类
     */
    @PreAuthorize("@ss.hasPermi('toolclassification:toolclassification:add')")
    @Log(title = "刀具分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwToolclassification awToolclassification)
    {
        return toAjax(awToolclassificationService.insertAwToolclassification(awToolclassification));
    }

    /**
     * 修改刀具分类
     */
    @PreAuthorize("@ss.hasPermi('toolclassification:toolclassification:edit')")
    @Log(title = "刀具分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwToolclassification awToolclassification)
    {
        return toAjax(awToolclassificationService.updateAwToolclassification(awToolclassification));
    }

    /**
     * 删除刀具分类
     */
    @PreAuthorize("@ss.hasPermi('toolclassification:toolclassification:remove')")
    @Log(title = "刀具分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awToolclassificationService.deleteAwToolclassificationByIds(ids));
    }
}
