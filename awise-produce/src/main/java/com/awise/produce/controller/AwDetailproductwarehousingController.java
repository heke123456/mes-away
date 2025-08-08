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
import com.awise.produce.domain.AwDetailproductwarehousing;
import com.awise.produce.service.IAwDetailproductwarehousingService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 产品入库详单Controller
 * 
 * @author awise
 * @date 2023-10-24
 */
@RestController
@RequestMapping("/produce/detailproductwarehousing")
public class AwDetailproductwarehousingController extends BaseController
{
    @Autowired
    private IAwDetailproductwarehousingService awDetailproductwarehousingService;

    /**
     * 查询产品入库详单列表
     */
    @PreAuthorize("@ss.hasPermi('produce:detailproductwarehousing:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwDetailproductwarehousing awDetailproductwarehousing)
    {
        startPage();
        List<AwDetailproductwarehousing> list = awDetailproductwarehousingService.selectAwDetailproductwarehousingList(awDetailproductwarehousing);
        return getDataTable(list);
    }

    /**
     * 导出产品入库详单列表
     */
    @PreAuthorize("@ss.hasPermi('produce:detailproductwarehousing:export')")
    @Log(title = "产品入库详单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwDetailproductwarehousing awDetailproductwarehousing)
    {
        List<AwDetailproductwarehousing> list = awDetailproductwarehousingService.selectAwDetailproductwarehousingList(awDetailproductwarehousing);
        ExcelUtil<AwDetailproductwarehousing> util = new ExcelUtil<AwDetailproductwarehousing>(AwDetailproductwarehousing.class);
        util.exportExcel(response, list, "产品入库详单数据");
    }

    /**
     * 获取产品入库详单详细信息
     */
    @PreAuthorize("@ss.hasPermi('produce:detailproductwarehousing:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awDetailproductwarehousingService.selectAwDetailproductwarehousingById(id));
    }

    /**
     * 新增产品入库详单
     */
    @PreAuthorize("@ss.hasPermi('produce:detailproductwarehousing:add')")
    @Log(title = "产品入库详单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwDetailproductwarehousing awDetailproductwarehousing)
    {
        return toAjax(awDetailproductwarehousingService.insertAwDetailproductwarehousing(awDetailproductwarehousing));
    }

    /**
     * 修改产品入库详单
     */
    @PreAuthorize("@ss.hasPermi('produce:detailproductwarehousing:edit')")
    @Log(title = "产品入库详单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwDetailproductwarehousing awDetailproductwarehousing)
    {
        return toAjax(awDetailproductwarehousingService.updateAwDetailproductwarehousing(awDetailproductwarehousing));
    }

    /**
     * 删除产品入库详单
     */
    @PreAuthorize("@ss.hasPermi('produce:detailproductwarehousing:remove')")
    @Log(title = "产品入库详单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awDetailproductwarehousingService.deleteAwDetailproductwarehousingByIds(ids));
    }
}
