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
import com.awise.produce.domain.AwProductdeliveryform;
import com.awise.produce.service.IAwProductdeliveryformService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 产品出库单Controller
 * 
 * @author awise
 * @date 2023-10-14
 */
@RestController
@RequestMapping("/produce/productdeliveryform")
public class AwProductdeliveryformController extends BaseController
{
    @Autowired
    private IAwProductdeliveryformService awProductdeliveryformService;

    /**
     * 查询产品出库单列表
     */
    @PreAuthorize("@ss.hasPermi('produce:productdeliveryform:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwProductdeliveryform awProductdeliveryform)
    {
        startPage();
        List<AwProductdeliveryform> list = awProductdeliveryformService.selectAwProductdeliveryformList(awProductdeliveryform);
        return getDataTable(list);
    }

    /**
     * 导出产品出库单列表
     */
    @PreAuthorize("@ss.hasPermi('produce:productdeliveryform:export')")
    @Log(title = "产品出库单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwProductdeliveryform awProductdeliveryform)
    {
        List<AwProductdeliveryform> list = awProductdeliveryformService.selectAwProductdeliveryformList(awProductdeliveryform);
        ExcelUtil<AwProductdeliveryform> util = new ExcelUtil<AwProductdeliveryform>(AwProductdeliveryform.class);
        util.exportExcel(response, list, "产品出库单数据");
    }

    /**
     * 获取产品出库单详细信息
     */
    @PreAuthorize("@ss.hasPermi('produce:productdeliveryform:query')")
    @GetMapping(value = "/{deliveryNoteID}")
    public AjaxResult getInfo(@PathVariable("deliveryNoteID") String deliveryNoteID)
    {
        return success(awProductdeliveryformService.selectAwProductdeliveryformByDeliveryNoteID(deliveryNoteID));
    }

    /**
     * 新增产品出库单
     */
    @PreAuthorize("@ss.hasPermi('produce:productdeliveryform:add')")
    @Log(title = "产品出库单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwProductdeliveryform awProductdeliveryform)
    {
        return toAjax(awProductdeliveryformService.insertAwProductdeliveryform(awProductdeliveryform));
    }

    /**
     * 修改产品出库单
     */
    @PreAuthorize("@ss.hasPermi('produce:productdeliveryform:edit')")
    @Log(title = "产品出库单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwProductdeliveryform awProductdeliveryform)
    {
        return toAjax(awProductdeliveryformService.updateAwProductdeliveryform(awProductdeliveryform));
    }

    /**
     * 删除产品出库单
     */
    @PreAuthorize("@ss.hasPermi('produce:productdeliveryform:remove')")
    @Log(title = "产品出库单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deliveryNoteIDs}")
    public AjaxResult remove(@PathVariable String[] deliveryNoteIDs)
    {
        return toAjax(awProductdeliveryformService.deleteAwProductdeliveryformByDeliveryNoteIDs(deliveryNoteIDs));
    }
}
