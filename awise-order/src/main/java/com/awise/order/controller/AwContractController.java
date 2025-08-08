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
import com.awise.order.domain.AwContract;
import com.awise.order.service.IAwContractService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 合同存储Controller
 * 
 * @author awise
 * @date 2023-08-03
 */
@RestController
@RequestMapping("/order/contract")
public class AwContractController extends BaseController
{
    @Autowired
    private IAwContractService awContractService;

    /**
     * 查询合同存储列表
     */
    @PreAuthorize("@ss.hasPermi('order:contract:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwContract awContract)
    {
        startPage();
        System.out.println("放发");
        List<AwContract> list = awContractService.selectAwContractList(awContract);
        System.out.println(list);
        return getDataTable(list);
    }

    /**
     * 导出合同存储列表
     */
    @PreAuthorize("@ss.hasPermi('order:contract:export')")
    @Log(title = "合同存储", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwContract awContract)
    {
        List<AwContract> list = awContractService.selectAwContractList(awContract);
        ExcelUtil<AwContract> util = new ExcelUtil<AwContract>(AwContract.class);
        util.exportExcel(response, list, "合同存储数据");
    }

    /**
     * 获取合同存储详细信息
     */
    @PreAuthorize("@ss.hasPermi('order:contract:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(awContractService.selectAwContractById(id));
    }

    /**
     * 新增合同存储
     */
    @PreAuthorize("@ss.hasPermi('order:contract:add')")
    @Log(title = "合同存储", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwContract awContract)
    {
        return toAjax(awContractService.insertAwContract(awContract));
    }

    /**
     * 修改合同存储
     */
    @PreAuthorize("@ss.hasPermi('order:contract:edit')")
    @Log(title = "合同存储", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwContract awContract)
    {
        return toAjax(awContractService.updateAwContract(awContract));
    }

    /**
     * 删除合同存储
     */
    @PreAuthorize("@ss.hasPermi('order:contract:remove')")
    @Log(title = "合同存储", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(awContractService.deleteAwContractByIds(ids));
    }
}
