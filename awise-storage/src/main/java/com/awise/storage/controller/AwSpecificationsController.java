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
import com.awise.storage.domain.AwSpecifications;
import com.awise.storage.service.IAwSpecificationsService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 规格类型Controller
 * 
 * @author awise
 * @date 2023-08-01
 */
@RestController
@RequestMapping("/storage/specifications")
public class AwSpecificationsController extends BaseController
{
    @Autowired
    private IAwSpecificationsService awSpecificationsService;

    /**
     * 查询规格类型列表
     */
    @PreAuthorize("@ss.hasPermi('storage:specifications:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwSpecifications awSpecifications)
    {
        startPage();
        List<AwSpecifications> list = awSpecificationsService.selectAwSpecificationsList(awSpecifications);
        return getDataTable(list);
    }

    /**
     * 导出规格类型列表
     */
    @PreAuthorize("@ss.hasPermi('storage:specifications:export')")
    @Log(title = "规格类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwSpecifications awSpecifications)
    {
        List<AwSpecifications> list = awSpecificationsService.selectAwSpecificationsList(awSpecifications);
        ExcelUtil<AwSpecifications> util = new ExcelUtil<AwSpecifications>(AwSpecifications.class);
        util.exportExcel(response, list, "规格类型数据");
    }

    /**
     * 获取规格类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:specifications:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awSpecificationsService.selectAwSpecificationsById(id));
    }

    /**
     * 新增规格类型
     */
    @PreAuthorize("@ss.hasPermi('storage:specifications:add')")
    @Log(title = "规格类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwSpecifications awSpecifications)
    {
        return toAjax(awSpecificationsService.insertAwSpecifications(awSpecifications));
    }

    /**
     * 修改规格类型
     */
    @PreAuthorize("@ss.hasPermi('storage:specifications:edit')")
    @Log(title = "规格类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwSpecifications awSpecifications)
    {
        return toAjax(awSpecificationsService.updateAwSpecifications(awSpecifications));
    }

    /**
     * 删除规格类型
     */
    @PreAuthorize("@ss.hasPermi('storage:specifications:remove')")
    @Log(title = "规格类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awSpecificationsService.deleteAwSpecificationsByIds(ids));
    }
}
