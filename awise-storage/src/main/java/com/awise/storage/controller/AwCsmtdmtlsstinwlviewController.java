package com.awise.storage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.awise.storage.domain.AwCsmtdmtlsstinwlist;
import com.awise.storage.domain.AwWarehousing;
import com.awise.storage.service.IAwCsmtdmtlsstinwlistService;
import com.awise.storage.service.IAwWarehousingService;
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
import com.awise.storage.domain.AwCsmtdmtlsstinwlview;
import com.awise.storage.service.IAwCsmtdmtlsstinwlviewService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 客供入库Controller
 * 
 * @author awise
 * @date 2023-12-21
 */
@RestController
@RequestMapping("/storage/CsmtdmtlsstinwLView")
public class AwCsmtdmtlsstinwlviewController extends BaseController
{
    @Autowired
    private IAwCsmtdmtlsstinwlviewService awCsmtdmtlsstinwlviewService;
    @Autowired
    private IAwCsmtdmtlsstinwlistService awCsmtdmtlsstinwlistService;
    @Autowired
    private IAwWarehousingService awWarehousingService;

    /**
     * 查询客供入库列表
     */
    @PreAuthorize("@ss.hasPermi('storage:CsmtdmtlsstinwLView:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwCsmtdmtlsstinwlview awCsmtdmtlsstinwlview)
    {
        startPage();
        List<AwCsmtdmtlsstinwlview> list = awCsmtdmtlsstinwlviewService.selectAwCsmtdmtlsstinwlviewList(awCsmtdmtlsstinwlview);
        return getDataTable(list);
    }

    /**
     * 导出客供入库列表
     */
    @PreAuthorize("@ss.hasPermi('storage:CsmtdmtlsstinwLView:export')")
    @Log(title = "客供入库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwCsmtdmtlsstinwlview awCsmtdmtlsstinwlview)
    {
        List<AwCsmtdmtlsstinwlview> list = awCsmtdmtlsstinwlviewService.selectAwCsmtdmtlsstinwlviewList(awCsmtdmtlsstinwlview);
        ExcelUtil<AwCsmtdmtlsstinwlview> util = new ExcelUtil<AwCsmtdmtlsstinwlview>(AwCsmtdmtlsstinwlview.class);
        util.exportExcel(response, list, "客供入库数据");
    }

    /**
     * 获取客供入库详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:CsmtdmtlsstinwLView:query')")
    @GetMapping(value = "/{warehouseEntryID}")
    public AjaxResult getInfo(@PathVariable("warehouseEntryID") String warehouseEntryID)
    {
        return success(awCsmtdmtlsstinwlviewService.selectAwCsmtdmtlsstinwlviewByWarehouseEntryID(warehouseEntryID));
    }

    /**
     * 新增客供入库
     */
    @PreAuthorize("@ss.hasPermi('storage:CsmtdmtlsstinwLView:add')")
    @Log(title = "客供入库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwCsmtdmtlsstinwlview awCsmtdmtlsstinwlview)
    {

        AwWarehousing awWarehousing = new AwWarehousing();
        awWarehousing.setWarehouseEntryID(awCsmtdmtlsstinwlview.getWarehouseEntryID());
        awWarehousing.setWarehousingDate(awCsmtdmtlsstinwlview.getWarehousingDate());
        awWarehousing.setCreator(awCsmtdmtlsstinwlview.getCreator());
        awWarehousing.setAcceptedBy(awCsmtdmtlsstinwlview.getAcceptedBy());
        awWarehousing.setWarehouseKeeper(awCsmtdmtlsstinwlview.getWarehouseKeeper());
        awWarehousing.setOperator(awCsmtdmtlsstinwlview.getOperator());
        awWarehousing.setNotes(awCsmtdmtlsstinwlview.getNotes());
        awWarehousing.setStatus(awCsmtdmtlsstinwlview.getStatus());

        AwCsmtdmtlsstinwlist awCsmtdmtlsstinwlist = new AwCsmtdmtlsstinwlist();
        awCsmtdmtlsstinwlist.setWarehouseEntryID(awCsmtdmtlsstinwlview.getWarehouseEntryID());

        awWarehousingService.insertAwWarehousing(awWarehousing);
        awCsmtdmtlsstinwlistService.insertAwCsmtdmtlsstinwlist(awCsmtdmtlsstinwlist);

        return toAjax(1);
    }

    /**
     * 修改客供入库
     */
    @PreAuthorize("@ss.hasPermi('storage:CsmtdmtlsstinwLView:edit')")
    @Log(title = "客供入库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwCsmtdmtlsstinwlview awCsmtdmtlsstinwlview)
    {
        return toAjax(awCsmtdmtlsstinwlviewService.updateAwCsmtdmtlsstinwlview(awCsmtdmtlsstinwlview));
    }

    /**
     * 删除客供入库
     */
    @PreAuthorize("@ss.hasPermi('storage:CsmtdmtlsstinwLView:remove')")
    @Log(title = "客供入库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{warehouseEntryIDs}")
    public AjaxResult remove(@PathVariable String[] warehouseEntryIDs)
    {
        awCsmtdmtlsstinwlistService.deleteAwCsmtdmtlsstinwlistByWarehouseEntryIDs(warehouseEntryIDs);
        awWarehousingService.deleteAwWarehousingByWarehouseEntryIDs(warehouseEntryIDs);
        return toAjax(1);
    }
}
