package com.awise.finance.controller;

import com.away.common.annotation.Log;
import com.away.common.core.controller.BaseController;
import com.away.common.core.domain.AjaxResult;
import com.away.common.core.page.TableDataInfo;
import com.away.common.enums.BusinessType;
import com.away.common.utils.poi.ExcelUtil;
import com.awise.finance.domain.AwOutsourcingreconciliation;
import com.awise.finance.service.IAwOutsourcingreconciliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 外协对账详细Controller
 * 
 * @author awise
 * @date 2023-12-26
 */
@RestController
@RequestMapping("/finance/OutsourcingReconciliation")
public class AwOutsourcingreconciliationController extends BaseController
{
    @Autowired
    private IAwOutsourcingreconciliationService awOutsourcingreconciliationService;

    /**
     * 查询外协对账详细列表
     */
    @PreAuthorize("@ss.hasPermi('finance:OutsourcingReconciliation:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwOutsourcingreconciliation awOutsourcingreconciliation)
    {
        startPage();
        List<AwOutsourcingreconciliation> list = awOutsourcingreconciliationService.selectAwOutsourcingreconciliationList(awOutsourcingreconciliation);
        return getDataTable(list);
    }

    /**
     * 导出外协对账详细列表
     */
    @PreAuthorize("@ss.hasPermi('finance:OutsourcingReconciliation:export')")
    @Log(title = "外协对账详细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwOutsourcingreconciliation awOutsourcingreconciliation)
    {
        List<AwOutsourcingreconciliation> list = awOutsourcingreconciliationService.selectAwOutsourcingreconciliationList(awOutsourcingreconciliation);
        ExcelUtil<AwOutsourcingreconciliation> util = new ExcelUtil<AwOutsourcingreconciliation>(AwOutsourcingreconciliation.class);
        util.exportExcel(response, list, "外协对账详细数据");
    }





    /**
     * 获取外协对账详细详细信息
     */
    @PreAuthorize("@ss.hasPermi('finance:OutsourcingReconciliation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awOutsourcingreconciliationService.selectAwOutsourcingreconciliationById(id));
    }

    /**
     * 新增外协对账详细
     */
    @PreAuthorize("@ss.hasPermi('finance:OutsourcingReconciliation:add')")
    @Log(title = "外协对账详细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwOutsourcingreconciliation awOutsourcingreconciliation)
    {
        return toAjax(awOutsourcingreconciliationService.insertAwOutsourcingreconciliation(awOutsourcingreconciliation));
    }

    /**
     * 修改外协对账详细
     */
    @PreAuthorize("@ss.hasPermi('finance:OutsourcingReconciliation:edit')")
    @Log(title = "外协对账详细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwOutsourcingreconciliation awOutsourcingreconciliation)
    {
        return toAjax(awOutsourcingreconciliationService.updateAwOutsourcingreconciliation(awOutsourcingreconciliation));
    }

    /**
     * 删除外协对账详细
     */
    @PreAuthorize("@ss.hasPermi('finance:OutsourcingReconciliation:remove')")
    @Log(title = "外协对账详细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awOutsourcingreconciliationService.deleteAwOutsourcingreconciliationByIds(ids));
    }
}
