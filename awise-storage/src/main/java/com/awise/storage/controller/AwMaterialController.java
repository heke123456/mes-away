package com.awise.storage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.awise.storage.domain.AwMaterialEn;
import com.awise.storage.service.IAwMaterialEnService;
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
import com.awise.storage.domain.AwMaterial;
import com.awise.storage.service.IAwMaterialService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 材料基本信息Controller
 * 
 * @author awise
 * @date 2023-08-02
 */
@RestController
@RequestMapping("/storage/material")
public class AwMaterialController extends BaseController
{
    @Autowired
    private IAwMaterialService awMaterialService;
    @Autowired
    private IAwMaterialEnService awMaterialEnService;

    /**
     * 查询材料基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('storage:material:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwMaterial awMaterial)
    {
        startPage();
        List<AwMaterial> list = awMaterialService.selectAwMaterialList(awMaterial);
        return getDataTable(list);
    }

    /**
     * 查询材料基本信息实体列表
     */
    @PreAuthorize("@ss.hasPermi('storage:material:enlist')")
    @GetMapping("/enlist")
    public TableDataInfo list(AwMaterialEn awMaterialEn)
    {
        startPage();
        List<AwMaterialEn> list = awMaterialEnService.selectAwMaterialEnList(awMaterialEn);
        return getDataTable(list);
    }

    /**
     * 导出材料基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('storage:material:export')")
    @Log(title = "材料基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwMaterialEn awMaterialEn)
    {
        List<AwMaterialEn> list = awMaterialEnService.selectAwMaterialEnList(awMaterialEn);
        ExcelUtil<AwMaterialEn> util = new ExcelUtil<AwMaterialEn>(AwMaterialEn.class);
        util.exportExcel(response, list, "材料基本信息数据");
    }

    /**
     * 获取材料基本信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:material:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(awMaterialService.selectAwMaterialById(id));
    }

    /**
     * 新增材料基本信息
     */
    @PreAuthorize("@ss.hasPermi('storage:material:add')")
    @Log(title = "材料基本信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwMaterial awMaterial)
    {
        return toAjax(awMaterialService.insertAwMaterial(awMaterial));
    }

    /**
     * 修改材料基本信息
     */
    @PreAuthorize("@ss.hasPermi('storage:material:edit')")
    @Log(title = "材料基本信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwMaterial awMaterial)
    {
        return toAjax(awMaterialService.updateAwMaterial(awMaterial));
    }

    /**
     * 删除材料基本信息
     */
    @PreAuthorize("@ss.hasPermi('storage:material:remove')")
    @Log(title = "材料基本信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(awMaterialService.deleteAwMaterialByIds(ids));
    }
}
