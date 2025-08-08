package com.awise.storage.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.awise.storage.domain.AwCustomermaterialsinventoryEn;
import com.awise.storage.service.IAwCustomermaterialsinventoryEnService;
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
import com.awise.storage.domain.AwCustomermaterialsinventory;
import com.awise.storage.service.IAwCustomermaterialsinventoryService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 客供材料实时库存Controller
 * 
 * @author awise
 * @date 2024-04-22
 */
@RestController
@RequestMapping("/storage/CustomerMaterialsInventory")
public class AwCustomermaterialsinventoryController extends BaseController
{
    @Autowired
    private IAwCustomermaterialsinventoryService awCustomermaterialsinventoryService;
    @Autowired
    private IAwCustomermaterialsinventoryEnService  awCustomermaterialsinventoryEnService;

    /**
     * 查询客供材料实时库存列表
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsInventory:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwCustomermaterialsinventory awCustomermaterialsinventory)
    {
        startPage();
        List<AwCustomermaterialsinventory> list = awCustomermaterialsinventoryService.selectAwCustomermaterialsinventoryList(awCustomermaterialsinventory);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsInventory:enlist')")
    @GetMapping("/enlist")
    public TableDataInfo enlist(AwCustomermaterialsinventoryEn awCustomermaterialsinventoryen)
    {
        startPage();
        List<AwCustomermaterialsinventoryEn> list = awCustomermaterialsinventoryEnService.selectAwCustomermaterialsinventoryEnList(awCustomermaterialsinventoryen);
        return getDataTable(list);
    }


    /**
     * 导出客供材料实时库存列表
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsInventory:export')")
    @Log(title = "客供材料实时库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwCustomermaterialsinventoryEn awCustomermaterialsinventoryen)
    {
        List<AwCustomermaterialsinventoryEn> list = awCustomermaterialsinventoryEnService.selectAwCustomermaterialsinventoryEnList(awCustomermaterialsinventoryen);
        ExcelUtil<AwCustomermaterialsinventoryEn> util = new ExcelUtil<AwCustomermaterialsinventoryEn>(AwCustomermaterialsinventoryEn.class);
        util.exportExcel(response, list, "客供材料实时库存数据");
    }

    /**
     * 获取客供材料实时库存详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsInventory:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awCustomermaterialsinventoryService.selectAwCustomermaterialsinventoryById(id));
    }

    /**
     * 新增客供材料实时库存
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsInventory:add')")
    @Log(title = "客供材料实时库存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwCustomermaterialsinventory awCustomermaterialsinventory)
    {
        return toAjax(awCustomermaterialsinventoryService.insertAwCustomermaterialsinventory(awCustomermaterialsinventory));
    }

    /**
     * 修改客供材料实时库存
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsInventory:edit')")
    @Log(title = "客供材料实时库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwCustomermaterialsinventory awCustomermaterialsinventory)
    {
        return toAjax(awCustomermaterialsinventoryService.updateAwCustomermaterialsinventory(awCustomermaterialsinventory));
    }

    /**
     * 删除客供材料实时库存
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsInventory:remove')")
    @Log(title = "客供材料实时库存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awCustomermaterialsinventoryService.deleteAwCustomermaterialsinventoryByIds(ids));
    }

    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsInventory:addnumber')")
    @PostMapping("/ByNumbner/add")
    public AjaxResult addByNumber(@RequestBody() List<Map<String,String>> lmlist){

        return awCustomermaterialsinventoryService.addByNumber(lmlist)?success():error();
    }

    /***
     *  本地实时库存减少
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsInventory:reducenumber')")
    @PostMapping("/ByNumbner/reduce")
    public AjaxResult reduceByNumber(@RequestBody() List<Map<String,String>> lmlist){

        return awCustomermaterialsinventoryService.reduceByNumber(lmlist)?success():error();
    }
}
