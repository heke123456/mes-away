package com.awise.finance.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.away.common.utils.bean.BeanCopyUtils;
import com.awise.finance.domain.AwOutsourcingreconciliation;
import com.awise.finance.domain.Vo.AwOutsourcingstatementsVo;
import com.awise.finance.service.IAwOutsourcingreconciliationService;
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
import com.awise.finance.domain.AwOutsourcingstatements;
import com.awise.finance.service.IAwOutsourcingstatementsService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 外协对账Controller
 * 
 * @author awise
 * @date 2023-12-26
 */
@RestController
@RequestMapping("/finance/OutsourcingStatements")
public class AwOutsourcingstatementsController extends BaseController
{
    @Autowired
    private IAwOutsourcingstatementsService awOutsourcingstatementsService;

    @Autowired
    private IAwOutsourcingreconciliationService awOutsourcingreconciliationService;


    /**
     * 查询外协对账列表
     */
    @PreAuthorize("@ss.hasPermi('finance:OutsourcingStatements:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwOutsourcingstatements awOutsourcingstatements)
    {
        startPage();
        List<AwOutsourcingstatements> list = awOutsourcingstatementsService.selectAwOutsourcingstatementsList(awOutsourcingstatements);
        return getDataTable(list);
    }

    /**
     * 导出外协对账列表
     */
    @PreAuthorize("@ss.hasPermi('finance:OutsourcingStatements:export')")
    @Log(title = "外协对账", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwOutsourcingstatements awOutsourcingstatements)
    {
        List<AwOutsourcingstatements> list = awOutsourcingstatementsService.selectAwOutsourcingstatementsList(awOutsourcingstatements);
        ExcelUtil<AwOutsourcingstatements> util = new ExcelUtil<AwOutsourcingstatements>(AwOutsourcingstatements.class);
        util.exportExcel(response, list, "外协对账数据");
    }



    /**
     * 导出外协对账列表
     */
    @PreAuthorize("@ss.hasPermi('finance:OutsourcingStatements:export')")
    @Log(title = "外协对账", businessType = BusinessType.EXPORT)
    @PostMapping("/export/all")
    public void exportAll(HttpServletResponse response, AwOutsourcingstatements awOutsourcingstatements)
    {
        List<AwOutsourcingstatements> list = awOutsourcingstatementsService.selectAwOutsourcingstatementsList(awOutsourcingstatements);

        List<AwOutsourcingstatementsVo> awOutsourcingstatementsVos = BeanCopyUtils.copyBeanList(list, AwOutsourcingstatementsVo.class);
        for (AwOutsourcingstatementsVo awOutsourcingstatementsVo : awOutsourcingstatementsVos) {
            AwOutsourcingreconciliation awOutsourcingreconciliation = new AwOutsourcingreconciliation();
            awOutsourcingreconciliation.setOutsourcingStatementsID(awOutsourcingstatementsVo.getOutsourcingStatementsID());
            List<AwOutsourcingreconciliation> awOutsourcingreconciliations = awOutsourcingreconciliationService.selectAwOutsourcingreconciliationList(awOutsourcingreconciliation);
            awOutsourcingstatementsVo.setAwOutsourcingreconciliationsList(awOutsourcingreconciliations);
        }
        ExcelUtil<AwOutsourcingstatementsVo> util = new ExcelUtil<AwOutsourcingstatementsVo>(AwOutsourcingstatementsVo.class);
        util.exportExcel(response, awOutsourcingstatementsVos, "外协对账数据");
    }
    /**
     * 获取外协对账详细信息
     */
    @PreAuthorize("@ss.hasPermi('finance:OutsourcingStatements:query')")
    @GetMapping(value = "/{outsourcingStatementsID}")
    public AjaxResult getInfo(@PathVariable("outsourcingStatementsID") String outsourcingStatementsID)
    {
        return success(awOutsourcingstatementsService.selectAwOutsourcingstatementsByOutsourcingStatementsID(outsourcingStatementsID));
    }

    /**
     * 新增外协对账
     */
    @PreAuthorize("@ss.hasPermi('finance:OutsourcingStatements:add')")
    @Log(title = "外协对账", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwOutsourcingstatements awOutsourcingstatements)
    {
        return toAjax(awOutsourcingstatementsService.insertAwOutsourcingstatements(awOutsourcingstatements));
    }

    /**
     * 修改外协对账
     */
    @PreAuthorize("@ss.hasPermi('finance:OutsourcingStatements:edit')")
    @Log(title = "外协对账", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwOutsourcingstatements awOutsourcingstatements)
    {
        return toAjax(awOutsourcingstatementsService.updateAwOutsourcingstatements(awOutsourcingstatements));
    }

    /**
     * 删除外协对账
     */
    @PreAuthorize("@ss.hasPermi('finance:OutsourcingStatements:remove')")
    @Log(title = "外协对账", businessType = BusinessType.DELETE)
	@DeleteMapping("/{outsourcingStatementsIDs}")
    public AjaxResult remove(@PathVariable String[] outsourcingStatementsIDs)
    {
        return toAjax(awOutsourcingstatementsService.deleteAwOutsourcingstatementsByOutsourcingStatementsIDs(outsourcingStatementsIDs));
    }
}
