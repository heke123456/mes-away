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
import com.awise.storage.domain.AwToolstorageform;
import com.awise.storage.service.IAwToolstorageformService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 刀具入库单Controller
 * 
 * @author awise
 * @date 2023-12-06
 */
@RestController
@RequestMapping("/storage/toolStorageform")
public class AwToolstorageformController extends BaseController
{
    @Autowired
    private IAwToolstorageformService awToolstorageformService;

    /**
     * 查询刀具入库单列表
     */
    @PreAuthorize("@ss.hasPermi('storage:toolStorageform:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwToolstorageform awToolstorageform)
    {
        startPage();
        List<AwToolstorageform> list = awToolstorageformService.selectAwToolstorageformList(awToolstorageform);
        return getDataTable(list);
    }

    /**
     * 导出刀具入库单列表
     */
    @PreAuthorize("@ss.hasPermi('storage:toolStorageform:export')")
    @Log(title = "刀具入库单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwToolstorageform awToolstorageform)
    {
        List<AwToolstorageform> list = awToolstorageformService.selectAwToolstorageformList(awToolstorageform);
        ExcelUtil<AwToolstorageform> util = new ExcelUtil<AwToolstorageform>(AwToolstorageform.class);
        util.exportExcel(response, list, "刀具入库单数据");
    }

    /**
     * 获取刀具入库单详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:toolStorageform:query')")
    @GetMapping(value = "/{warehouseEntryID}")
    public AjaxResult getInfo(@PathVariable("warehouseEntryID") String warehouseEntryID)
    {
        return success(awToolstorageformService.selectAwToolstorageformByWarehouseEntryID(warehouseEntryID));
    }

    /**
     * 新增刀具入库单
     */
    @PreAuthorize("@ss.hasPermi('storage:toolStorageform:add')")
    @Log(title = "刀具入库单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwToolstorageform awToolstorageform)
    {
        return toAjax(awToolstorageformService.insertAwToolstorageform(awToolstorageform));
    }

    /**
     * 修改刀具入库单
     */
    @PreAuthorize("@ss.hasPermi('storage:toolStorageform:edit')")
    @Log(title = "刀具入库单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwToolstorageform awToolstorageform)
    {
        return toAjax(awToolstorageformService.updateAwToolstorageform(awToolstorageform));
    }

    /**
     * 删除刀具入库单
     */
    @PreAuthorize("@ss.hasPermi('storage:toolStorageform:remove')")
    @Log(title = "刀具入库单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{warehouseEntryIDs}")
    public AjaxResult remove(@PathVariable String[] warehouseEntryIDs)
    {
        return toAjax(awToolstorageformService.deleteAwToolstorageformByWarehouseEntryIDs(warehouseEntryIDs));
    }
}
