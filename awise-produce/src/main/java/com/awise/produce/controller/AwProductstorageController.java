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
import com.awise.produce.domain.AwProductstorage;
import com.awise.produce.service.IAwProductstorageService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 产品入库Controller
 * 
 * @author awise
 * @date 2023-10-16
 */
@RestController
@RequestMapping("/produce/productstorage")
public class AwProductstorageController extends BaseController
{
    @Autowired
    private IAwProductstorageService awProductstorageService;

    /**
     * 查询产品入库列表
     */
    @PreAuthorize("@ss.hasPermi('produce:productstorage:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwProductstorage awProductstorage)
    {
        startPage();
        List<AwProductstorage> list = awProductstorageService.selectAwProductstorageList(awProductstorage);
        return getDataTable(list);
    }

    /**
     * 导出产品入库列表
     */
    @PreAuthorize("@ss.hasPermi('produce:productstorage:export')")
    @Log(title = "产品入库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwProductstorage awProductstorage)
    {
        List<AwProductstorage> list = awProductstorageService.selectAwProductstorageList(awProductstorage);
        ExcelUtil<AwProductstorage> util = new ExcelUtil<AwProductstorage>(AwProductstorage.class);
        util.exportExcel(response, list, "产品入库数据");
    }

    /**
     * 获取产品入库详细信息
     */
    @PreAuthorize("@ss.hasPermi('produce:productstorage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awProductstorageService.selectAwProductstorageById(id));
    }

    /**
     * 新增产品入库
     */
    @PreAuthorize("@ss.hasPermi('produce:productstorage:add')")
    @Log(title = "产品入库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwProductstorage awProductstorage)
    {
        return toAjax(awProductstorageService.insertAwProductstorage(awProductstorage));
    }

    /**
     * 修改产品入库
     */
    @PreAuthorize("@ss.hasPermi('produce:productstorage:edit')")
    @Log(title = "产品入库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwProductstorage awProductstorage)
    {
        return toAjax(awProductstorageService.updateAwProductstorage(awProductstorage));
    }

    /**
     * 删除产品入库
     */
    @PreAuthorize("@ss.hasPermi('produce:productstorage:remove')")
    @Log(title = "产品入库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awProductstorageService.deleteAwProductstorageByIds(ids));
    }
}
