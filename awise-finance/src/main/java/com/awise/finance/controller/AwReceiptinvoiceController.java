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
import com.awise.finance.domain.AwReceiptinvoice;
import com.awise.finance.service.IAwReceiptinvoiceService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 入库发票信息Controller
 * 
 * @author ruoyi
 * @date 2023-10-14
 */
@RestController
@RequestMapping("/finance/receiptinvoice")
public class AwReceiptinvoiceController extends BaseController
{
    @Autowired
    private IAwReceiptinvoiceService awReceiptinvoiceService;

    /**
     * 查询入库发票信息列表
     */
    @PreAuthorize("@ss.hasPermi('finance:receiptinvoice:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwReceiptinvoice awReceiptinvoice)
    {
        startPage();
        List<AwReceiptinvoice> list = awReceiptinvoiceService.selectAwReceiptinvoiceList(awReceiptinvoice);
        return getDataTable(list);
    }

    /**
     * 导出入库发票信息列表
     */
    @PreAuthorize("@ss.hasPermi('finance:receiptinvoice:export')")
    @Log(title = "入库发票信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwReceiptinvoice awReceiptinvoice)
    {
        List<AwReceiptinvoice> list = awReceiptinvoiceService.selectAwReceiptinvoiceList(awReceiptinvoice);
        ExcelUtil<AwReceiptinvoice> util = new ExcelUtil<AwReceiptinvoice>(AwReceiptinvoice.class);
        util.exportExcel(response, list, "入库发票信息数据");
    }

    /**
     * 获取入库发票信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('finance:receiptinvoice:query')")
    @GetMapping(value = "/{receiptInvoiceID}")
    public AjaxResult getInfo(@PathVariable("receiptInvoiceID") String receiptInvoiceID)
    {
        return success(awReceiptinvoiceService.selectAwReceiptinvoiceByReceiptInvoiceID(receiptInvoiceID));
    }

    /**
     * 新增入库发票信息
     */
    @PreAuthorize("@ss.hasPermi('finance:receiptinvoice:add')")
    @Log(title = "入库发票信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwReceiptinvoice awReceiptinvoice)
    {
        return toAjax(awReceiptinvoiceService.insertAwReceiptinvoice(awReceiptinvoice));
    }

    /**
     * 修改入库发票信息
     */
    @PreAuthorize("@ss.hasPermi('finance:receiptinvoice:edit')")
    @Log(title = "入库发票信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwReceiptinvoice awReceiptinvoice)
    {
        return toAjax(awReceiptinvoiceService.updateAwReceiptinvoice(awReceiptinvoice));
    }

    /**
     * 删除入库发票信息
     */
    @PreAuthorize("@ss.hasPermi('finance:receiptinvoice:remove')")
    @Log(title = "入库发票信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{receiptInvoiceIDs}")
    public AjaxResult remove(@PathVariable String[] receiptInvoiceIDs)
    {
        return toAjax(awReceiptinvoiceService.deleteAwReceiptinvoiceByReceiptInvoiceIDs(receiptInvoiceIDs));
    }
}
