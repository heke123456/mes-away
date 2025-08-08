package com.awise.finance.controller;

import com.away.common.annotation.Log;
import com.away.common.core.controller.BaseController;
import com.away.common.core.domain.AjaxResult;
import com.away.common.core.page.TableDataInfo;
import com.away.common.enums.BusinessType;
import com.away.common.utils.poi.ExcelUtil;
import com.awise.finance.domain.AwDetailreconciliation;
import com.awise.finance.service.IAwDetailreconciliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 对账详细Controller
 * 
 * @author awise
 * @date 2023-12-22
 */
@RestController
@RequestMapping("/finance/DetailReconciliation")
public class AwDetailreconciliationController extends BaseController
{
    @Autowired
    private IAwDetailreconciliationService awDetailreconciliationService;

    /**
     * 查询对账详细列表
     */
    @PreAuthorize("@ss.hasPermi('finance:DetailReconciliation:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwDetailreconciliation awDetailreconciliation)
    {
        startPage();
        List<AwDetailreconciliation> list = awDetailreconciliationService.selectAwDetailreconciliationList(awDetailreconciliation);
        return getDataTable(list);
    }

    /**
     * 导出对账详细列表
     */
    @PreAuthorize("@ss.hasPermi('finance:DetailReconciliation:export')")
    @Log(title = "对账详细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwDetailreconciliation awDetailreconciliation)
    {
        List<AwDetailreconciliation> list = awDetailreconciliationService.selectAwDetailreconciliationList(awDetailreconciliation);
        ExcelUtil<AwDetailreconciliation> util = new ExcelUtil<AwDetailreconciliation>(AwDetailreconciliation.class);
        util.exportExcel(response, list, "对账详细数据");
    }



    /**
     * 获取对账详细详细信息
     */
    @PreAuthorize("@ss.hasPermi('finance:DetailReconciliation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awDetailreconciliationService.selectAwDetailreconciliationById(id));
    }

    /**
     * 新增对账详细
     */
    @PreAuthorize("@ss.hasPermi('finance:DetailReconciliation:add')")
    @Log(title = "对账详细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwDetailreconciliation awDetailreconciliation)
    {
        return toAjax(awDetailreconciliationService.insertAwDetailreconciliation(awDetailreconciliation));
    }

    /**
     * 修改对账详细
     */
    @PreAuthorize("@ss.hasPermi('finance:DetailReconciliation:edit')")
    @Log(title = "对账详细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwDetailreconciliation awDetailreconciliation)
    {
        return toAjax(awDetailreconciliationService.updateAwDetailreconciliation(awDetailreconciliation));
    }

    /**
     * 删除对账详细
     */
    @PreAuthorize("@ss.hasPermi('finance:DetailReconciliation:remove')")
    @Log(title = "对账详细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awDetailreconciliationService.deleteAwDetailreconciliationByIds(ids));
    }
}
