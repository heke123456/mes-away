package com.awise.finance.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.away.common.utils.bean.BeanCopyUtils;
import com.awise.finance.domain.AwDetailreconciliation;
import com.awise.finance.domain.Vo.AwStatementofaccountVo;
import com.awise.finance.service.IAwDetailreconciliationService;
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
import com.awise.finance.domain.AwStatementofaccount;
import com.awise.finance.service.IAwStatementofaccountService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 对账单Controller
 * 
 * @author awise
 * @date 2023-12-22
 */
@RestController
@RequestMapping("/finance/StatementOfAccount")
public class AwStatementofaccountController extends BaseController
{
    @Autowired
    private IAwStatementofaccountService awStatementofaccountService;

    @Autowired
    private IAwDetailreconciliationService awDetailreconciliationService;

    /**
     * 查询对账单列表
     */
    @PreAuthorize("@ss.hasPermi('finance:StatementOfAccount:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwStatementofaccount awStatementofaccount)
    {
        startPage();
        List<AwStatementofaccount> list = awStatementofaccountService.selectAwStatementofaccountList(awStatementofaccount);
        return getDataTable(list);
    }

    /**
     * 导出对账单列表
     */
    @PreAuthorize("@ss.hasPermi('finance:StatementOfAccount:export')")
    @Log(title = "对账单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwStatementofaccount awStatementofaccount)
    {
        List<AwStatementofaccount> list = awStatementofaccountService.selectAwStatementofaccountList(awStatementofaccount);
        ExcelUtil<AwStatementofaccount> util = new ExcelUtil<AwStatementofaccount>(AwStatementofaccount.class);
        util.exportExcel(response, list, "对账单数据");
    }


//    导出全部

    @PreAuthorize("@ss.hasPermi('finance:StatementOfAccount:export')")
    @Log(title = "对账单", businessType = BusinessType.EXPORT)
    @PostMapping("/export/all")
    public void exportAll(HttpServletResponse response, AwStatementofaccount awStatementofaccount)
    {
        List<AwStatementofaccount> list = awStatementofaccountService.selectAwStatementofaccountList(awStatementofaccount);
        List<AwStatementofaccountVo> awStatementofaccountVos = BeanCopyUtils.copyBeanList(list, AwStatementofaccountVo.class);
        for (AwStatementofaccountVo awStatementofaccountVo : awStatementofaccountVos) {
            AwDetailreconciliation awDetailreconciliation = new AwDetailreconciliation();
            awDetailreconciliation.setStatementOfAccountID(awStatementofaccountVo.getStatementOfAccountID());
            List<AwDetailreconciliation> awDetailreconciliations = awDetailreconciliationService.selectAwDetailreconciliationList(awDetailreconciliation);
            awStatementofaccountVo.setDetailreconciliationList(awDetailreconciliations);
        }
        ExcelUtil<AwStatementofaccountVo> util = new ExcelUtil<AwStatementofaccountVo>(AwStatementofaccountVo.class);
        util.exportExcel(response, awStatementofaccountVos, "对账单数据");
    }






    /**
     * 获取对账单详细信息
     */
    @PreAuthorize("@ss.hasPermi('finance:StatementOfAccount:query')")
    @GetMapping(value = "/{statementOfAccountID}")
    public AjaxResult getInfo(@PathVariable("statementOfAccountID") String statementOfAccountID)
    {
        return success(awStatementofaccountService.selectAwStatementofaccountByStatementOfAccountID(statementOfAccountID));
    }

    /**
     * 新增对账单
     */
    @PreAuthorize("@ss.hasPermi('finance:StatementOfAccount:add')")
    @Log(title = "对账单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwStatementofaccount awStatementofaccount)
    {
        return toAjax(awStatementofaccountService.insertAwStatementofaccount(awStatementofaccount));
    }

    /**
     * 修改对账单
     */
    @PreAuthorize("@ss.hasPermi('finance:StatementOfAccount:edit')")
    @Log(title = "对账单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwStatementofaccount awStatementofaccount)
    {
        return toAjax(awStatementofaccountService.updateAwStatementofaccount(awStatementofaccount));
    }

    /**
     * 删除对账单
     */
    @PreAuthorize("@ss.hasPermi('finance:StatementOfAccount:remove')")
    @Log(title = "对账单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{statementOfAccountIDs}")
    public AjaxResult remove(@PathVariable String[] statementOfAccountIDs)
    {
        return toAjax(awStatementofaccountService.deleteAwStatementofaccountByStatementOfAccountIDs(statementOfAccountIDs));
    }
}
