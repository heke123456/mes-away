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
import com.awise.storage.domain.AwToolstorage;
import com.awise.storage.service.IAwToolstorageService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 刀具入库Controller
 * 
 * @author awise
 * @date 2023-12-06
 */
@RestController
@RequestMapping("/storage/toolStorage")
public class AwToolstorageController extends BaseController
{
    @Autowired
    private IAwToolstorageService awToolstorageService;

    /**
     * 查询刀具入库列表
     */
    @PreAuthorize("@ss.hasPermi('storage:toolStorage:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwToolstorage awToolstorage)
    {
        startPage();
        List<AwToolstorage> list = awToolstorageService.selectAwToolstorageList(awToolstorage);
        return getDataTable(list);
    }

    /**
     * 导出刀具入库列表
     */
    @PreAuthorize("@ss.hasPermi('storage:toolStorage:export')")
    @Log(title = "刀具入库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwToolstorage awToolstorage)
    {
        List<AwToolstorage> list = awToolstorageService.selectAwToolstorageList(awToolstorage);
        ExcelUtil<AwToolstorage> util = new ExcelUtil<AwToolstorage>(AwToolstorage.class);
        util.exportExcel(response, list, "刀具入库数据");
    }

    /**
     * 获取刀具入库详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:toolStorage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(awToolstorageService.selectAwToolstorageById(id));
    }

    /**
     * 新增刀具入库
     */
    @PreAuthorize("@ss.hasPermi('storage:toolStorage:add')")
    @Log(title = "刀具入库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwToolstorage awToolstorage)
    {
        return toAjax(awToolstorageService.insertAwToolstorage(awToolstorage));
    }

    /**
     * 修改刀具入库
     */
    @PreAuthorize("@ss.hasPermi('storage:toolStorage:edit')")
    @Log(title = "刀具入库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwToolstorage awToolstorage)
    {
        return toAjax(awToolstorageService.updateAwToolstorage(awToolstorage));
    }

    /**
     * 删除刀具入库
     */
    @PreAuthorize("@ss.hasPermi('storage:toolStorage:remove')")
    @Log(title = "刀具入库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(awToolstorageService.deleteAwToolstorageByIds(ids));
    }
}
