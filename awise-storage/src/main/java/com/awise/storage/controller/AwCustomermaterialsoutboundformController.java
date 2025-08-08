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
import com.awise.storage.domain.AwCustomermaterialsoutboundform;
import com.awise.storage.service.IAwCustomermaterialsoutboundformService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 客供材料出库单Controller
 * 
 * @author awise
 * @date 2024-04-23
 */
@RestController
@RequestMapping("/storage/CustomerMaterialsOutboundForm")
public class AwCustomermaterialsoutboundformController extends BaseController
{
    @Autowired
    private IAwCustomermaterialsoutboundformService awCustomermaterialsoutboundformService;

    /**
     * 查询客供材料出库单列表
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsOutboundForm:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwCustomermaterialsoutboundform awCustomermaterialsoutboundform)
    {
        startPage();
        List<AwCustomermaterialsoutboundform> list = awCustomermaterialsoutboundformService.selectAwCustomermaterialsoutboundformList(awCustomermaterialsoutboundform);
        return getDataTable(list);
    }

    /**
     * 导出客供材料出库单列表
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsOutboundForm:export')")
    @Log(title = "客供材料出库单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwCustomermaterialsoutboundform awCustomermaterialsoutboundform)
    {
        List<AwCustomermaterialsoutboundform> list = awCustomermaterialsoutboundformService.selectAwCustomermaterialsoutboundformList(awCustomermaterialsoutboundform);
        ExcelUtil<AwCustomermaterialsoutboundform> util = new ExcelUtil<AwCustomermaterialsoutboundform>(AwCustomermaterialsoutboundform.class);
        util.exportExcel(response, list, "客供材料出库单数据");
    }

    /**
     * 获取客供材料出库单详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsOutboundForm:query')")
    @GetMapping(value = "/{deliveryNoteID}")
    public AjaxResult getInfo(@PathVariable("deliveryNoteID") String deliveryNoteID)
    {
        return success(awCustomermaterialsoutboundformService.selectAwCustomermaterialsoutboundformByDeliveryNoteID(deliveryNoteID));
    }

    /**
     * 新增客供材料出库单
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsOutboundForm:add')")
    @Log(title = "客供材料出库单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwCustomermaterialsoutboundform awCustomermaterialsoutboundform)
    {
        return toAjax(awCustomermaterialsoutboundformService.insertAwCustomermaterialsoutboundform(awCustomermaterialsoutboundform));
    }

    /**
     * 修改客供材料出库单
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsOutboundForm:edit')")
    @Log(title = "客供材料出库单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwCustomermaterialsoutboundform awCustomermaterialsoutboundform)
    {
        return toAjax(awCustomermaterialsoutboundformService.updateAwCustomermaterialsoutboundform(awCustomermaterialsoutboundform));
    }

    /**
     * 删除客供材料出库单
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsOutboundForm:remove')")
    @Log(title = "客供材料出库单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deliveryNoteIDs}")
    public AjaxResult remove(@PathVariable String[] deliveryNoteIDs)
    {
        return toAjax(awCustomermaterialsoutboundformService.deleteAwCustomermaterialsoutboundformByDeliveryNoteIDs(deliveryNoteIDs));
    }
}
