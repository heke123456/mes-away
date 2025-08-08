package com.awise.storage.controller;

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
import com.awise.storage.domain.AwDetailcustomermaterialsstorage;
import com.awise.storage.service.IAwDetailcustomermaterialsstorageService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 客供材料入库详细Controller
 * 
 * @author awise
 * @date 2024-04-21
 */
@RestController
@RequestMapping("/storage/DetailCustomerMaterialsStorage")
public class AwDetailcustomermaterialsstorageController extends BaseController
{
    @Autowired
    private IAwDetailcustomermaterialsstorageService awDetailcustomermaterialsstorageService;

    /**
     * 查询客供材料入库详细列表
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailCustomerMaterialsStorage:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwDetailcustomermaterialsstorage awDetailcustomermaterialsstorage)
    {
        startPage();
        List<AwDetailcustomermaterialsstorage> list = awDetailcustomermaterialsstorageService.selectAwDetailcustomermaterialsstorageList(awDetailcustomermaterialsstorage);
        return getDataTable(list);
    }

    /**
     * 导出客供材料入库详细列表
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailCustomerMaterialsStorage:export')")
    @Log(title = "客供材料入库详细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwDetailcustomermaterialsstorage awDetailcustomermaterialsstorage)
    {
        List<AwDetailcustomermaterialsstorage> list = awDetailcustomermaterialsstorageService.selectAwDetailcustomermaterialsstorageList(awDetailcustomermaterialsstorage);
        ExcelUtil<AwDetailcustomermaterialsstorage> util = new ExcelUtil<AwDetailcustomermaterialsstorage>(AwDetailcustomermaterialsstorage.class);
        util.exportExcel(response, list, "客供材料入库详细数据");
    }

    /**
     * 获取客供材料入库详细详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailCustomerMaterialsStorage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awDetailcustomermaterialsstorageService.selectAwDetailcustomermaterialsstorageById(id));
    }

    /**
     * 新增客供材料入库详细
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailCustomerMaterialsStorage:add')")
    @Log(title = "客供材料入库详细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwDetailcustomermaterialsstorage awDetailcustomermaterialsstorage)
    {
        return toAjax(awDetailcustomermaterialsstorageService.insertAwDetailcustomermaterialsstorage(awDetailcustomermaterialsstorage));
    }

    /**
     * 修改客供材料入库详细
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailCustomerMaterialsStorage:edit')")
    @Log(title = "客供材料入库详细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwDetailcustomermaterialsstorage awDetailcustomermaterialsstorage)
    {
        return toAjax(awDetailcustomermaterialsstorageService.updateAwDetailcustomermaterialsstorage(awDetailcustomermaterialsstorage));
    }

    /**
     * 删除客供材料入库详细
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailCustomerMaterialsStorage:remove')")
    @Log(title = "客供材料入库详细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awDetailcustomermaterialsstorageService.deleteAwDetailcustomermaterialsstorageByIds(ids));
    }
}
