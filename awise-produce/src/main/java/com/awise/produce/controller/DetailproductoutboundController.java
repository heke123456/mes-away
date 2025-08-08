package com.awise.produce.controller;

import com.away.common.annotation.Log;
import com.away.common.core.controller.BaseController;
import com.away.common.core.domain.AjaxResult;
import com.away.common.core.page.TableDataInfo;
import com.away.common.enums.BusinessType;
import com.away.common.utils.poi.ExcelUtil;
import com.awise.produce.domain.Detailproductoutbound;
import com.awise.produce.service.IDetailproductoutboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 产品出库详单Controller
 * 
 * @author awise
 * @date 2023-10-16
 */
@RestController
@RequestMapping("/produce/detailproductoutbound")
public class DetailproductoutboundController extends BaseController
{
    @Autowired
    private IDetailproductoutboundService detailproductoutboundService;

    /**
     * 查询产品出库详单列表
     */
    @PreAuthorize("@ss.hasPermi('produce:detailproductoutbound:list')")
    @GetMapping("/list")
    public TableDataInfo list(Detailproductoutbound detailproductoutbound)
    {
        startPage();
        List<Detailproductoutbound> list = detailproductoutboundService.selectDetailproductoutboundList(detailproductoutbound);
        return getDataTable(list);
    }

    /**
     * 导出产品出库详单列表
     */
    @PreAuthorize("@ss.hasPermi('produce:detailproductoutbound:export')")
    @Log(title = "产品出库详单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Detailproductoutbound detailproductoutbound)
    {
        List<Detailproductoutbound> list = detailproductoutboundService.selectDetailproductoutboundList(detailproductoutbound);
        ExcelUtil<Detailproductoutbound> util = new ExcelUtil<Detailproductoutbound>(Detailproductoutbound.class);
        util.exportExcel(response, list, "产品出库详单数据");
    }

    /**
     * 获取产品出库详单详细信息
     */
    @PreAuthorize("@ss.hasPermi('produce:detailproductoutbound:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(detailproductoutboundService.selectDetailproductoutboundById(id));
    }

    /**
     * 新增产品出库详单
     */
    @PreAuthorize("@ss.hasPermi('produce:detailproductoutbound:add')")
    @Log(title = "产品出库详单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Detailproductoutbound detailproductoutbound)
    {
        return toAjax(detailproductoutboundService.insertDetailproductoutbound(detailproductoutbound));
    }

    /**
     * 修改产品出库详单
     */
    @PreAuthorize("@ss.hasPermi('produce:detailproductoutbound:edit')")
    @Log(title = "产品出库详单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Detailproductoutbound detailproductoutbound)
    {
        return toAjax(detailproductoutboundService.updateDetailproductoutbound(detailproductoutbound));
    }

    /**
     * 删除产品出库详单
     */
    @PreAuthorize("@ss.hasPermi('produce:detailproductoutbound:remove')")
    @Log(title = "产品出库详单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(detailproductoutboundService.deleteDetailproductoutboundByIds(ids));
    }
}
