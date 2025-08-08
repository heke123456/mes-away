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
import com.awise.order.domain.AwDetailmaterialsubscription;
import com.awise.order.service.IAwDetailmaterialsubscriptionService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 申购材料详细Controller
 * 
 * @author awise
 * @date 2023-10-17
 */
@RestController
@RequestMapping("/order/detailmaterialsubscription")
public class AwDetailmaterialsubscriptionController extends BaseController
{
    @Autowired
    private IAwDetailmaterialsubscriptionService awDetailmaterialsubscriptionService;

    /**
     * 查询申购材料详细列表
     */
    @PreAuthorize("@ss.hasPermi('order:detailmaterialsubscription:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwDetailmaterialsubscription awDetailmaterialsubscription)
    {
        startPage();
        List<AwDetailmaterialsubscription> list = awDetailmaterialsubscriptionService.selectAwDetailmaterialsubscriptionList(awDetailmaterialsubscription);
        return getDataTable(list);
    }

    /**
     * 导出申购材料详细列表
     */
    @PreAuthorize("@ss.hasPermi('order:detailmaterialsubscription:export')")
    @Log(title = "申购材料详细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwDetailmaterialsubscription awDetailmaterialsubscription)
    {
        List<AwDetailmaterialsubscription> list = awDetailmaterialsubscriptionService.selectAwDetailmaterialsubscriptionList(awDetailmaterialsubscription);
        ExcelUtil<AwDetailmaterialsubscription> util = new ExcelUtil<AwDetailmaterialsubscription>(AwDetailmaterialsubscription.class);
        util.exportExcel(response, list, "申购材料详细数据");
    }

    /**
     * 获取申购材料详细详细信息
     */
    @PreAuthorize("@ss.hasPermi('order:detailmaterialsubscription:query')")
    @GetMapping(value = "/{materialSubscription}")
    public AjaxResult getInfo(@PathVariable("materialSubscription") String materialSubscription)
    {
        return success(awDetailmaterialsubscriptionService.selectAwDetailmaterialsubscriptionByMaterialSubscription(materialSubscription));
    }

    /**
     * 新增申购材料详细
     */
    @PreAuthorize("@ss.hasPermi('order:detailmaterialsubscription:add')")
    @Log(title = "申购材料详细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwDetailmaterialsubscription awDetailmaterialsubscription)
    {
        return toAjax(awDetailmaterialsubscriptionService.insertAwDetailmaterialsubscription(awDetailmaterialsubscription));
    }

    /**
     * 修改申购材料详细
     */
    @PreAuthorize("@ss.hasPermi('order:detailmaterialsubscription:edit')")
    @Log(title = "申购材料详细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwDetailmaterialsubscription awDetailmaterialsubscription)
    {
        return toAjax(awDetailmaterialsubscriptionService.updateAwDetailmaterialsubscription(awDetailmaterialsubscription));
    }

    /**
     * 删除申购材料详细
     */
    @PreAuthorize("@ss.hasPermi('order:detailmaterialsubscription:remove')")
    @Log(title = "申购材料详细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{materialSubscriptions}")
    public AjaxResult remove(@PathVariable String[] materialSubscriptions)
    {
        return toAjax(awDetailmaterialsubscriptionService.deleteAwDetailmaterialsubscriptionByMaterialSubscriptions(materialSubscriptions));
    }
}
