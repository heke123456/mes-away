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
import com.awise.storage.domain.AwOutboundorder;
import com.awise.storage.service.IAwOutboundorderService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 出库单Controller
 * 
 * @author ruoyi
 * @date 2023-10-14
 */
@RestController
@RequestMapping("/storage/outboundorder")
public class AwOutboundorderController extends BaseController
{
    @Autowired
    private IAwOutboundorderService awOutboundorderService;

    /**
     * 查询出库单列表
     */
    @PreAuthorize("@ss.hasPermi('storage:outboundorder:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwOutboundorder awOutboundorder)
    {
        startPage();
        List<AwOutboundorder> list = awOutboundorderService.selectAwOutboundorderList(awOutboundorder);
        return getDataTable(list);
    }

    /**
     * 导出出库单列表
     */
    @PreAuthorize("@ss.hasPermi('storage:outboundorder:export')")
    @Log(title = "出库单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwOutboundorder awOutboundorder)
    {
        List<AwOutboundorder> list = awOutboundorderService.selectAwOutboundorderList(awOutboundorder);
        ExcelUtil<AwOutboundorder> util = new ExcelUtil<AwOutboundorder>(AwOutboundorder.class);
        util.exportExcel(response, list, "出库单数据");
    }

    /**
     * 获取出库单详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:outboundorder:query')")
    @GetMapping(value = "/{deliveryNoteID}")
    public AjaxResult getInfo(@PathVariable("deliveryNoteID") String deliveryNoteID)
    {
        return success(awOutboundorderService.selectAwOutboundorderByDeliveryNoteID(deliveryNoteID));
    }

    /**
     * 新增出库单
     */
    @PreAuthorize("@ss.hasPermi('storage:outboundorder:add')")
    @Log(title = "出库单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwOutboundorder awOutboundorder)
    {
        return toAjax(awOutboundorderService.insertAwOutboundorder(awOutboundorder));
    }

    /**
     * 修改出库单
     */
    @PreAuthorize("@ss.hasPermi('storage:outboundorder:edit')")
    @Log(title = "出库单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwOutboundorder awOutboundorder)
    {
        return toAjax(awOutboundorderService.updateAwOutboundorder(awOutboundorder));
    }

    /**
     * 删除出库单
     */
    @PreAuthorize("@ss.hasPermi('storage:outboundorder:remove')")
    @Log(title = "出库单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deliveryNoteIDs}")
    public AjaxResult remove(@PathVariable String[] deliveryNoteIDs)
    {
        return toAjax(awOutboundorderService.deleteAwOutboundorderByDeliveryNoteIDs(deliveryNoteIDs));
    }
}
