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
import com.awise.storage.domain.AwCustomermaterialsstorage;
import com.awise.storage.service.IAwCustomermaterialsstorageService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 客供入库Controller
 * 
 * @author awise
 * @date 2024-04-21
 */
@RestController
@RequestMapping("/storage/CustomerMaterialsStorage")
public class AwCustomermaterialsstorageController extends BaseController
{
    @Autowired
    private IAwCustomermaterialsstorageService awCustomermaterialsstorageService;




    /**
     * 查询客供入库列表
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsStorage:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwCustomermaterialsstorage awCustomermaterialsstorage)
    {
        startPage();
        List<AwCustomermaterialsstorage> list = awCustomermaterialsstorageService.selectAwCustomermaterialsstorageList(awCustomermaterialsstorage);
        return getDataTable(list);
    }

    /**
     * 导出客供入库列表
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsStorage:export')")
    @Log(title = "客供入库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwCustomermaterialsstorage awCustomermaterialsstorage)
    {
        List<AwCustomermaterialsstorage> list = awCustomermaterialsstorageService.selectAwCustomermaterialsstorageList(awCustomermaterialsstorage);
        ExcelUtil<AwCustomermaterialsstorage> util = new ExcelUtil<AwCustomermaterialsstorage>(AwCustomermaterialsstorage.class);
        util.exportExcel(response, list, "客供入库数据");
    }

    /**
     * 获取客供入库详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsStorage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awCustomermaterialsstorageService.selectAwCustomermaterialsstorageById(id));
    }

    /**
     * 新增客供入库
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsStorage:add')")
    @Log(title = "客供入库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwCustomermaterialsstorage awCustomermaterialsstorage)
    {
        return toAjax(awCustomermaterialsstorageService.insertAwCustomermaterialsstorage(awCustomermaterialsstorage));
    }

    /**
     * 修改客供入库
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsStorage:edit')")
    @Log(title = "客供入库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwCustomermaterialsstorage awCustomermaterialsstorage)
    {
        return toAjax(awCustomermaterialsstorageService.updateAwCustomermaterialsstorage(awCustomermaterialsstorage));
    }

    /**
     * 删除客供入库
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsStorage:remove')")
    @Log(title = "客供入库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awCustomermaterialsstorageService.deleteAwCustomermaterialsstorageByIds(ids));
    }
}
