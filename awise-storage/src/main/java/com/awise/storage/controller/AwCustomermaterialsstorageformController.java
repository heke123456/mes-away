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
import com.awise.storage.domain.AwCustomermaterialsstorageform;
import com.awise.storage.service.IAwCustomermaterialsstorageformService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 客供入库单Controller
 * 
 * @author awise
 * @date 2024-04-21
 */
@RestController
@RequestMapping("/storage/CustomerMaterialsStorageForm")
public class AwCustomermaterialsstorageformController extends BaseController
{
    @Autowired
    private IAwCustomermaterialsstorageformService awCustomermaterialsstorageformService;

    /**
     * 查询客供入库单列表
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsStorageForm:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwCustomermaterialsstorageform awCustomermaterialsstorageform)
    {
        startPage();
        List<AwCustomermaterialsstorageform> list = awCustomermaterialsstorageformService.selectAwCustomermaterialsstorageformList(awCustomermaterialsstorageform);
        return getDataTable(list);
    }

    /**
     * 导出客供入库单列表
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsStorageForm:export')")
    @Log(title = "客供入库单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwCustomermaterialsstorageform awCustomermaterialsstorageform)
    {
        List<AwCustomermaterialsstorageform> list = awCustomermaterialsstorageformService.selectAwCustomermaterialsstorageformList(awCustomermaterialsstorageform);
        ExcelUtil<AwCustomermaterialsstorageform> util = new ExcelUtil<AwCustomermaterialsstorageform>(AwCustomermaterialsstorageform.class);
        util.exportExcel(response, list, "客供入库单数据");
    }

    /**
     * 获取客供入库单详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsStorageForm:query')")
    @GetMapping(value = "/{warehouseEntryID}")
    public AjaxResult getInfo(@PathVariable("warehouseEntryID") String warehouseEntryID)
    {
        return success(awCustomermaterialsstorageformService.selectAwCustomermaterialsstorageformByWarehouseEntryID(warehouseEntryID));
    }

    /**
     * 新增客供入库单
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsStorageForm:add')")
    @Log(title = "客供入库单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwCustomermaterialsstorageform awCustomermaterialsstorageform)
    {
        return toAjax(awCustomermaterialsstorageformService.insertAwCustomermaterialsstorageform(awCustomermaterialsstorageform));
    }

    /**
     * 修改客供入库单
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsStorageForm:edit')")
    @Log(title = "客供入库单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwCustomermaterialsstorageform awCustomermaterialsstorageform)
    {
        return toAjax(awCustomermaterialsstorageformService.updateAwCustomermaterialsstorageform(awCustomermaterialsstorageform));
    }

    /**
     * 删除客供入库单
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsStorageForm:remove')")
    @Log(title = "客供入库单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{warehouseEntryIDs}")
    public AjaxResult remove(@PathVariable String[] warehouseEntryIDs)
    {
        return toAjax(awCustomermaterialsstorageformService.deleteAwCustomermaterialsstorageformByWarehouseEntryIDs(warehouseEntryIDs));
    }
}
