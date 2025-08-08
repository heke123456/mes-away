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
import com.awise.storage.domain.AwTooloutboundorder;
import com.awise.storage.service.IAwTooloutboundorderService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 刀具出库单Controller
 * 
 * @author awise
 * @date 2023-12-08
 */
@RestController
@RequestMapping("/storage/ToolOutboundOrder")
public class AwTooloutboundorderController extends BaseController
{
    @Autowired
    private IAwTooloutboundorderService awTooloutboundorderService;

    /**
     * 查询刀具出库单列表
     */
    @PreAuthorize("@ss.hasPermi('storage:ToolOutboundOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwTooloutboundorder awTooloutboundorder)
    {
        startPage();
        List<AwTooloutboundorder> list = awTooloutboundorderService.selectAwTooloutboundorderList(awTooloutboundorder);
        return getDataTable(list);
    }

    /**
     * 导出刀具出库单列表
     */
    @PreAuthorize("@ss.hasPermi('storage:ToolOutboundOrder:export')")
    @Log(title = "刀具出库单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwTooloutboundorder awTooloutboundorder)
    {
        List<AwTooloutboundorder> list = awTooloutboundorderService.selectAwTooloutboundorderList(awTooloutboundorder);
        ExcelUtil<AwTooloutboundorder> util = new ExcelUtil<AwTooloutboundorder>(AwTooloutboundorder.class);
        util.exportExcel(response, list, "刀具出库单数据");
    }

    /**
     * 获取刀具出库单详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:ToolOutboundOrder:query')")
    @GetMapping(value = "/{deliveryNoteID}")
    public AjaxResult getInfo(@PathVariable("deliveryNoteID") String deliveryNoteID)
    {
        return success(awTooloutboundorderService.selectAwTooloutboundorderByDeliveryNoteID(deliveryNoteID));
    }

    /**
     * 新增刀具出库单
     */
    @PreAuthorize("@ss.hasPermi('storage:ToolOutboundOrder:add')")
    @Log(title = "刀具出库单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwTooloutboundorder awTooloutboundorder)
    {
        return toAjax(awTooloutboundorderService.insertAwTooloutboundorder(awTooloutboundorder));
    }

    /**
     * 修改刀具出库单
     */
    @PreAuthorize("@ss.hasPermi('storage:ToolOutboundOrder:edit')")
    @Log(title = "刀具出库单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwTooloutboundorder awTooloutboundorder)
    {
        return toAjax(awTooloutboundorderService.updateAwTooloutboundorder(awTooloutboundorder));
    }

    /**
     * 删除刀具出库单
     */
    @PreAuthorize("@ss.hasPermi('storage:ToolOutboundOrder:remove')")
    @Log(title = "刀具出库单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deliveryNoteIDs}")
    public AjaxResult remove(@PathVariable String[] deliveryNoteIDs)
    {
        return toAjax(awTooloutboundorderService.deleteAwTooloutboundorderByDeliveryNoteIDs(deliveryNoteIDs));
    }
}
