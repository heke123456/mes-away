package com.awise.produce.controller;

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
import com.awise.produce.domain.AwProductoutbound;
import com.awise.produce.service.IAwProductoutboundService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 产品出库Controller
 * 
 * @author awise
 * @date 2023-10-16
 */
@RestController
@RequestMapping("/produce/productoutbound")
public class AwProductoutboundController extends BaseController
{
    @Autowired
    private IAwProductoutboundService awProductoutboundService;

    /**
     * 查询产品出库列表
     */
    @PreAuthorize("@ss.hasPermi('produce:productoutbound:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwProductoutbound awProductoutbound)
    {
        startPage();
        List<AwProductoutbound> list = awProductoutboundService.selectAwProductoutboundList(awProductoutbound);
        return getDataTable(list);
    }

    /**
     * 导出产品出库列表
     */
    @PreAuthorize("@ss.hasPermi('produce:productoutbound:export')")
    @Log(title = "产品出库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwProductoutbound awProductoutbound)
    {
        List<AwProductoutbound> list = awProductoutboundService.selectAwProductoutboundList(awProductoutbound);
        ExcelUtil<AwProductoutbound> util = new ExcelUtil<AwProductoutbound>(AwProductoutbound.class);
        util.exportExcel(response, list, "产品出库数据");
    }

    /**
     * 获取产品出库详细信息
     */
    @PreAuthorize("@ss.hasPermi('produce:productoutbound:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awProductoutboundService.selectAwProductoutboundById(id));
    }

    /**
     * 新增产品出库
     */
    @PreAuthorize("@ss.hasPermi('produce:productoutbound:add')")
    @Log(title = "产品出库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwProductoutbound awProductoutbound)
    {
        return toAjax(awProductoutboundService.insertAwProductoutbound(awProductoutbound));
    }

    /**
     * 修改产品出库
     */
    @PreAuthorize("@ss.hasPermi('produce:productoutbound:edit')")
    @Log(title = "产品出库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwProductoutbound awProductoutbound)
    {
        return toAjax(awProductoutboundService.updateAwProductoutbound(awProductoutbound));
    }

    /**
     * 删除产品出库
     */
    @PreAuthorize("@ss.hasPermi('produce:productoutbound:remove')")
    @Log(title = "产品出库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awProductoutboundService.deleteAwProductoutboundByIds(ids));
    }
}
