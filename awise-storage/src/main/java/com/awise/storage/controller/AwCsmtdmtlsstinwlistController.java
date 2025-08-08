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
import com.awise.storage.domain.AwCsmtdmtlsstinwlist;
import com.awise.storage.service.IAwCsmtdmtlsstinwlistService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 客供材料入库单Controller
 * 
 * @author awise
 * @date 2023-12-21
 */
@RestController
@RequestMapping("/storage/CsmtdmtlsstinwList")
public class AwCsmtdmtlsstinwlistController extends BaseController
{
    @Autowired
    private IAwCsmtdmtlsstinwlistService awCsmtdmtlsstinwlistService;

    /**
     * 查询客供材料入库单列表
     */
    @PreAuthorize("@ss.hasPermi('storage:CsmtdmtlsstinwList:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwCsmtdmtlsstinwlist awCsmtdmtlsstinwlist)
    {
        startPage();
        List<AwCsmtdmtlsstinwlist> list = awCsmtdmtlsstinwlistService.selectAwCsmtdmtlsstinwlistList(awCsmtdmtlsstinwlist);
        return getDataTable(list);
    }

    /**
     * 导出客供材料入库单列表
     */
    @PreAuthorize("@ss.hasPermi('storage:CsmtdmtlsstinwList:export')")
    @Log(title = "客供材料入库单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwCsmtdmtlsstinwlist awCsmtdmtlsstinwlist)
    {
        List<AwCsmtdmtlsstinwlist> list = awCsmtdmtlsstinwlistService.selectAwCsmtdmtlsstinwlistList(awCsmtdmtlsstinwlist);
        ExcelUtil<AwCsmtdmtlsstinwlist> util = new ExcelUtil<AwCsmtdmtlsstinwlist>(AwCsmtdmtlsstinwlist.class);
        util.exportExcel(response, list, "客供材料入库单数据");
    }

    /**
     * 获取客供材料入库单详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:CsmtdmtlsstinwList:query')")
    @GetMapping(value = "/{warehouseEntryID}")
    public AjaxResult getInfo(@PathVariable("warehouseEntryID") String warehouseEntryID)
    {
        return success(awCsmtdmtlsstinwlistService.selectAwCsmtdmtlsstinwlistByWarehouseEntryID(warehouseEntryID));
    }

    /**
     * 新增客供材料入库单
     */
    @PreAuthorize("@ss.hasPermi('storage:CsmtdmtlsstinwList:add')")
    @Log(title = "客供材料入库单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwCsmtdmtlsstinwlist awCsmtdmtlsstinwlist)
    {
        return toAjax(awCsmtdmtlsstinwlistService.insertAwCsmtdmtlsstinwlist(awCsmtdmtlsstinwlist));
    }

    /**
     * 修改客供材料入库单
     */
    @PreAuthorize("@ss.hasPermi('storage:CsmtdmtlsstinwList:edit')")
    @Log(title = "客供材料入库单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwCsmtdmtlsstinwlist awCsmtdmtlsstinwlist)
    {
        return toAjax(awCsmtdmtlsstinwlistService.updateAwCsmtdmtlsstinwlist(awCsmtdmtlsstinwlist));
    }

    /**
     * 删除客供材料入库单
     */
    @PreAuthorize("@ss.hasPermi('storage:CsmtdmtlsstinwList:remove')")
    @Log(title = "客供材料入库单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{warehouseEntryIDs}")
    public AjaxResult remove(@PathVariable String[] warehouseEntryIDs)
    {
        return toAjax(awCsmtdmtlsstinwlistService.deleteAwCsmtdmtlsstinwlistByWarehouseEntryIDs(warehouseEntryIDs));
    }
}
