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
import com.awise.order.domain.AwMaterialsubscription;
import com.awise.order.service.IAwMaterialsubscriptionService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 申购材料Controller
 * 
 * @author awise
 * @date 2023-10-17
 */
@RestController
@RequestMapping("/order/materialsubscription")
public class AwMaterialsubscriptionController extends BaseController
{
    @Autowired
    private IAwMaterialsubscriptionService awMaterialsubscriptionService;

    /**
     * 查询申购材料列表
     */
    @PreAuthorize("@ss.hasPermi('order:materialsubscription:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwMaterialsubscription awMaterialsubscription)
    {
        startPage();
        List<AwMaterialsubscription> list = awMaterialsubscriptionService.selectAwMaterialsubscriptionList(awMaterialsubscription);
        return getDataTable(list);
    }

    /**
     * 导出申购材料列表
     */
    @PreAuthorize("@ss.hasPermi('order:materialsubscription:export')")
    @Log(title = "申购材料", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwMaterialsubscription awMaterialsubscription)
    {
        List<AwMaterialsubscription> list = awMaterialsubscriptionService.selectAwMaterialsubscriptionList(awMaterialsubscription);
        ExcelUtil<AwMaterialsubscription> util = new ExcelUtil<AwMaterialsubscription>(AwMaterialsubscription.class);
        util.exportExcel(response, list, "申购材料数据");
    }

    /**
     * 获取申购材料详细信息
     */
    @PreAuthorize("@ss.hasPermi('order:materialsubscription:query')")
    @GetMapping(value = "/{materialSubscription}")
    public AjaxResult getInfo(@PathVariable("materialSubscription") String materialSubscription)
    {
        return success(awMaterialsubscriptionService.selectAwMaterialsubscriptionByMaterialSubscription(materialSubscription));
    }

    /**
     * 新增申购材料
     */
    @PreAuthorize("@ss.hasPermi('order:materialsubscription:add')")
    @Log(title = "申购材料", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwMaterialsubscription awMaterialsubscription)
    {
        return toAjax(awMaterialsubscriptionService.insertAwMaterialsubscription(awMaterialsubscription));
    }

    /**
     * 修改申购材料
     */
    @PreAuthorize("@ss.hasPermi('order:materialsubscription:edit')")
    @Log(title = "申购材料", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwMaterialsubscription awMaterialsubscription)
    {
        return toAjax(awMaterialsubscriptionService.updateAwMaterialsubscription(awMaterialsubscription));
    }

    /**
     * 删除申购材料
     */
    @PreAuthorize("@ss.hasPermi('order:materialsubscription:remove')")
    @Log(title = "申购材料", businessType = BusinessType.DELETE)
	@DeleteMapping("/{materialSubscriptions}")
    public AjaxResult remove(@PathVariable String[] materialSubscriptions)
    {
        return toAjax(awMaterialsubscriptionService.deleteAwMaterialsubscriptionByMaterialSubscriptions(materialSubscriptions));
    }
}
