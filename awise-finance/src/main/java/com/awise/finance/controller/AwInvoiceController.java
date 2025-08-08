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
import com.awise.finance.domain.AwInvoice;
import com.awise.finance.service.IAwInvoiceService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 发票信息Controller
 * 
 * @author awise
 * @date 2023-08-03
 */
@RestController
@RequestMapping("/finance/invoice")
public class AwInvoiceController extends BaseController
{
    @Autowired
    private IAwInvoiceService awInvoiceService;

    /**
     * 查询发票信息列表
     */
    @PreAuthorize("@ss.hasPermi('finance:invoice:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwInvoice awInvoice)
    {
        startPage();
        List<AwInvoice> list = awInvoiceService.selectAwInvoiceList(awInvoice);
        return getDataTable(list);
    }

    /**
     * 导出发票信息列表
     */
    @PreAuthorize("@ss.hasPermi('finance:invoice:export')")
    @Log(title = "发票信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwInvoice awInvoice)
    {
        List<AwInvoice> list = awInvoiceService.selectAwInvoiceList(awInvoice);
        ExcelUtil<AwInvoice> util = new ExcelUtil<AwInvoice>(AwInvoice.class);
        util.exportExcel(response, list, "发票信息数据");
    }

    /**
     * 获取发票信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('finance:invoice:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(awInvoiceService.selectAwInvoiceById(id));
    }

    /**
     * 新增发票信息
     */
    @PreAuthorize("@ss.hasPermi('finance:invoice:add')")
    @Log(title = "发票信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwInvoice awInvoice)
    {
        return toAjax(awInvoiceService.insertAwInvoice(awInvoice));
    }

    /**
     * 修改发票信息
     */
    @PreAuthorize("@ss.hasPermi('finance:invoice:edit')")
    @Log(title = "发票信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwInvoice awInvoice)
    {
        return toAjax(awInvoiceService.updateAwInvoice(awInvoice));
    }

    /**
     * 删除发票信息
     */
    @PreAuthorize("@ss.hasPermi('finance:invoice:remove')")
    @Log(title = "发票信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(awInvoiceService.deleteAwInvoiceByIds(ids));
    }
}
