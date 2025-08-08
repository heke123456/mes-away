package com.awise.order.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

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
import com.awise.order.domain.AwAdditional;
import com.awise.order.service.IAwAdditionalService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 订单附加信息Controller
 * 
 * @author awise
 * @date 2023-08-14
 */



@Slf4j
@RestController
@RequestMapping("/order/additional")
public class AwAdditionalController extends BaseController
{
    @Autowired
    private IAwAdditionalService awAdditionalService;

    /**
     * 查询订单附加信息列表
     */
    @PreAuthorize("@ss.hasPermi('order:additional:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwAdditional awAdditional)
    {
        startPage();
        List<AwAdditional> list = awAdditionalService.selectAwAdditionalList(awAdditional);
        return getDataTable(list);
    }

    /**
     * 导出订单附加信息列表
     */
    @PreAuthorize("@ss.hasPermi('order:additional:export')")
    @Log(title = "订单附加信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwAdditional awAdditional)
    {
        List<AwAdditional> list = awAdditionalService.selectAwAdditionalList(awAdditional);
        ExcelUtil<AwAdditional> util = new ExcelUtil<AwAdditional>(AwAdditional.class);
        util.exportExcel(response, list, "订单附加信息数据");
    }

    /**
     * 获取订单附加信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('order:additional:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {

        return success(awAdditionalService.selectAwAdditionalById(id));
    }

    /**
     * 新增订单附加信息
     */
    @PreAuthorize("@ss.hasPermi('order:additional:add')")
    @Log(title = "订单附加信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwAdditional awAdditional)
    {


        return toAjax(awAdditionalService.insertAwAdditional(awAdditional));
    }

    /**
     * 修改订单附加信息
     */
    @PreAuthorize("@ss.hasPermi('order:additional:edit')")
    @Log(title = "订单附加信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwAdditional awAdditional)
    {
        return toAjax(awAdditionalService.updateAwAdditional(awAdditional));
    }

    /**
     * 删除订单附加信息
     */
    @PreAuthorize("@ss.hasPermi('order:additional:remove')")
    @Log(title = "订单附加信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awAdditionalService.deleteAwAdditionalByIds(ids));
    }
}
