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
import com.awise.order.domain.AwProduct;
import com.awise.order.service.IAwProductService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 产品存储Controller
 * 
 * @author awise
 * @date 2023-08-03
 */
@RestController
@RequestMapping("/order/product")
public class AwProductController extends BaseController
{
    @Autowired
    private IAwProductService awProductService;

    /**
     * 查询产品存储列表
     */
    @PreAuthorize("@ss.hasPermi('order:product:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwProduct awProduct)
    {
        startPage();
        List<AwProduct> list = awProductService.selectAwProductList(awProduct);
        return getDataTable(list);
    }

    /**
     * 导出产品存储列表
     */
    @PreAuthorize("@ss.hasPermi('order:product:export')")
    @Log(title = "产品存储", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwProduct awProduct)
    {
        List<AwProduct> list = awProductService.selectAwProductList(awProduct);
        ExcelUtil<AwProduct> util = new ExcelUtil<AwProduct>(AwProduct.class);
        util.exportExcel(response, list, "产品存储数据");
    }

    /**
     * 获取产品存储详细信息
     */
    @PreAuthorize("@ss.hasPermi('order:product:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(awProductService.selectAwProductById(id));
    }

    /**
     * 新增产品存储
     */
    @PreAuthorize("@ss.hasPermi('order:product:add')")
    @Log(title = "产品存储", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwProduct awProduct)
    {
        return toAjax(awProductService.insertAwProduct(awProduct));
    }

    /**
     * 修改产品存储
     */
    @PreAuthorize("@ss.hasPermi('order:product:edit')")
    @Log(title = "产品存储", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwProduct awProduct)
    {
        return toAjax(awProductService.updateAwProduct(awProduct));
    }

    /**
     * 删除产品存储
     */
    @PreAuthorize("@ss.hasPermi('order:product:remove')")
    @Log(title = "产品存储", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(awProductService.deleteAwProductByIds(ids));
    }
}
