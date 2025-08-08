package com.awise.order.controller;

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
import com.awise.order.domain.AwPurchaserequisition;
import com.awise.order.service.IAwPurchaserequisitionService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 材料申购Controller
 * 
 * @author awise
 * @date 2023-10-17
 */
@RestController
@RequestMapping("/order/purchaserequisition")
public class AwPurchaserequisitionController extends BaseController
{
    @Autowired
    private IAwPurchaserequisitionService awPurchaserequisitionService;

    /**
     * 查询材料申购列表
     */
    @PreAuthorize("@ss.hasPermi('order:purchaserequisition:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwPurchaserequisition awPurchaserequisition)
    {
        startPage();
        List<AwPurchaserequisition> list = awPurchaserequisitionService.selectAwPurchaserequisitionList(awPurchaserequisition);
        return getDataTable(list);
    }

    /**
     * 导出材料申购列表
     */
    @PreAuthorize("@ss.hasPermi('order:purchaserequisition:export')")
    @Log(title = "材料申购", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwPurchaserequisition awPurchaserequisition)
    {
        List<AwPurchaserequisition> list = awPurchaserequisitionService.selectAwPurchaserequisitionList(awPurchaserequisition);
        ExcelUtil<AwPurchaserequisition> util = new ExcelUtil<AwPurchaserequisition>(AwPurchaserequisition.class);
        util.exportExcel(response, list, "材料申购数据");
    }

    /**
     * 获取材料申购详细信息
     */
    @PreAuthorize("@ss.hasPermi('order:purchaserequisition:query')")
    @GetMapping(value = "/{subscribeID}")
    public AjaxResult getInfo(@PathVariable("subscribeID") String subscribeID)
    {
        return success(awPurchaserequisitionService.selectAwPurchaserequisitionBySubscribeID(subscribeID));
    }

    /**
     * 新增材料申购
     */
    @PreAuthorize("@ss.hasPermi('order:purchaserequisition:add')")
    @Log(title = "材料申购", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwPurchaserequisition awPurchaserequisition)
    {
        return toAjax(awPurchaserequisitionService.insertAwPurchaserequisition(awPurchaserequisition));
    }

    /**
     * 修改材料申购
     */
    @PreAuthorize("@ss.hasPermi('order:purchaserequisition:edit')")
    @Log(title = "材料申购", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwPurchaserequisition awPurchaserequisition)
    {
        return toAjax(awPurchaserequisitionService.updateAwPurchaserequisition(awPurchaserequisition));
    }

    /**
     * 删除材料申购
     */
    @PreAuthorize("@ss.hasPermi('order:purchaserequisition:remove')")
    @Log(title = "材料申购", businessType = BusinessType.DELETE)
	@DeleteMapping("/{subscribeIDs}")
    public AjaxResult remove(@PathVariable String[] subscribeIDs)
    {
        return toAjax(awPurchaserequisitionService.deleteAwPurchaserequisitionBySubscribeIDs(subscribeIDs));
    }
}
