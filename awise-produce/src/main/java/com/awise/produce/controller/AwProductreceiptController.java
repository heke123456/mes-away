package com.awise.produce.controller;

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
import com.awise.produce.domain.AwProductreceipt;
import com.awise.produce.service.IAwProductreceiptService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 产品入库单Controller
 * 
 * @author awise
 * @date 2023-10-14
 */
@RestController
@RequestMapping("/produce/productreceipt")
public class AwProductreceiptController extends BaseController
{
    @Autowired
    private IAwProductreceiptService awProductreceiptService;

    /**
     * 查询产品入库单列表
     */
    @PreAuthorize("@ss.hasPermi('produce:productreceipt:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwProductreceipt awProductreceipt)
    {
        startPage();
        List<AwProductreceipt> list = awProductreceiptService.selectAwProductreceiptList(awProductreceipt);
        return getDataTable(list);
    }

    /**
     * 导出产品入库单列表
     */
    @PreAuthorize("@ss.hasPermi('produce:productreceipt:export')")
    @Log(title = "产品入库单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwProductreceipt awProductreceipt)
    {
        List<AwProductreceipt> list = awProductreceiptService.selectAwProductreceiptList(awProductreceipt);
        ExcelUtil<AwProductreceipt> util = new ExcelUtil<AwProductreceipt>(AwProductreceipt.class);
        util.exportExcel(response, list, "产品入库单数据");
    }

    /**
     * 获取产品入库单详细信息
     */
    @PreAuthorize("@ss.hasPermi('produce:productreceipt:query')")
    @GetMapping(value = "/{warehouseEntryID}")
    public AjaxResult getInfo(@PathVariable("warehouseEntryID") String warehouseEntryID)
    {
        return success(awProductreceiptService.selectAwProductreceiptByWarehouseEntryID(warehouseEntryID));
    }

    /**
     * 新增产品入库单
     */
    @PreAuthorize("@ss.hasPermi('produce:productreceipt:add')")
    @Log(title = "产品入库单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwProductreceipt awProductreceipt)
    {
        return toAjax(awProductreceiptService.insertAwProductreceipt(awProductreceipt));
    }

    /**
     * 修改产品入库单
     */
    @PreAuthorize("@ss.hasPermi('produce:productreceipt:edit')")
    @Log(title = "产品入库单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwProductreceipt awProductreceipt)
    {
        return toAjax(awProductreceiptService.updateAwProductreceipt(awProductreceipt));
    }

    /**
     * 删除产品入库单
     */
    @PreAuthorize("@ss.hasPermi('produce:productreceipt:remove')")
    @Log(title = "产品入库单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{warehouseEntryIDs}")
    public AjaxResult remove(@PathVariable String[] warehouseEntryIDs)
    {
        return toAjax(awProductreceiptService.deleteAwProductreceiptByWarehouseEntryIDs(warehouseEntryIDs));
    }
}
