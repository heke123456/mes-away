package com.awise.order.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.awise.order.domain.AwSaleorderEn;
import com.awise.order.service.IAwSaleorderEnService;
import lombok.extern.slf4j.Slf4j;
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
import com.awise.order.domain.AwSaleorder;
import com.awise.order.service.IAwSaleorderService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 订单Controller
 * 
 * @author awise
 * @date 2023-08-03
 */




@Slf4j
@RestController
@RequestMapping("/order/saleorder")
public class AwSaleorderController extends BaseController
{
    @Autowired
    private IAwSaleorderService awSaleorderService;

    @Autowired
    private IAwSaleorderEnService awSaleorderEnService;

    /**
     * 查询订单列表
     */
    @PreAuthorize("@ss.hasPermi('order:saleorder:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwSaleorder awSaleorder)
    {
        startPage();
        List<AwSaleorder> list = awSaleorderService.selectAwSaleorderList(awSaleorder);
        return getDataTable(list);
    }

    /**
     * 查询订单列表实体
     */
    @PreAuthorize("@ss.hasPermi('order:saleorder:enlist')")
    @GetMapping("/enlist")
    public TableDataInfo list(AwSaleorderEn awSaleorderEn)
    {
        startPage();
        List<AwSaleorderEn> list = awSaleorderEnService.selectAwSaleorderEnList(awSaleorderEn);
        return getDataTable(list);
    }

    /**
     * 导出订单列表
     */
    @PreAuthorize("@ss.hasPermi('order:saleorder:export')")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwSaleorder awSaleorder)
    {
        List<AwSaleorder> list = awSaleorderService.selectAwSaleorderList(awSaleorder);
        ExcelUtil<AwSaleorder> util = new ExcelUtil<AwSaleorder>(AwSaleorder.class);
        util.exportExcel(response, list, "订单数据");
    }

    /**
     * 获取订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('order:saleorder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(awSaleorderService.selectAwSaleorderById(id));
    }

    /**
     * 新增订单
     */
    @PreAuthorize("@ss.hasPermi('order:saleorder:add')")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwSaleorder awSaleorder)
    {
        Date now_date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");


        awSaleorder.setId(sdf.format(now_date)+awSaleorder.hashCode());
        awSaleorder.setIsDel("0");
        awSaleorder.setCreateTime(now_date);
        AjaxResult ajaxResult = toAjax(awSaleorderService.insertAwSaleorder(awSaleorder)).put("id",awSaleorder.getId());


        return ajaxResult;
    }

    /**
     * 修改订单
     */
    @PreAuthorize("@ss.hasPermi('order:saleorder:edit')")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwSaleorder awSaleorder)
    {
        return toAjax(awSaleorderService.updateAwSaleorder(awSaleorder));
    }

    /**
     * 删除订单
     */
    @PreAuthorize("@ss.hasPermi('order:saleorder:remove')")
    @Log(title = "订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(awSaleorderService.deleteAwSaleorderByIds(ids));
    }
}
