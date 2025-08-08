package com.awise.finance.controller;

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
import com.awise.finance.domain.AwReconciliation;
import com.awise.finance.service.IAwReconciliationService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 对账Controller
 * 
 * @author awise
 * @date 2023-12-22
 */
@RestController
@RequestMapping("/finance/Reconciliation")
public class AwReconciliationController extends BaseController
{
    @Autowired
    private IAwReconciliationService awReconciliationService;

    /**
     * 查询对账列表
     */
    @PreAuthorize("@ss.hasPermi('finance:Reconciliation:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwReconciliation awReconciliation)
    {
        startPage();
        List<AwReconciliation> list = awReconciliationService.selectAwReconciliationList(awReconciliation);
        return getDataTable(list);
    }

    /**
     * 导出对账列表
     */
    @PreAuthorize("@ss.hasPermi('finance:Reconciliation:export')")
    @Log(title = "对账", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwReconciliation awReconciliation)
    {
        List<AwReconciliation> list = awReconciliationService.selectAwReconciliationList(awReconciliation);
        ExcelUtil<AwReconciliation> util = new ExcelUtil<AwReconciliation>(AwReconciliation.class);
        util.exportExcel(response, list, "对账数据");
    }

    /**
     * 获取对账详细信息
     */
    @PreAuthorize("@ss.hasPermi('finance:Reconciliation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awReconciliationService.selectAwReconciliationById(id));
    }

    /**
     * 新增对账
     */
    @PreAuthorize("@ss.hasPermi('finance:Reconciliation:add')")
    @Log(title = "对账", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwReconciliation awReconciliation)
    {
        return toAjax(awReconciliationService.insertAwReconciliation(awReconciliation));
    }

    /**
     * 修改对账
     */
    @PreAuthorize("@ss.hasPermi('finance:Reconciliation:edit')")
    @Log(title = "对账", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwReconciliation awReconciliation)
    {
        return toAjax(awReconciliationService.updateAwReconciliation(awReconciliation));
    }

    /**
     * 删除对账
     */
    @PreAuthorize("@ss.hasPermi('finance:Reconciliation:remove')")
    @Log(title = "对账", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awReconciliationService.deleteAwReconciliationByIds(ids));
    }
}
