package com.awise.produce.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.awise.produce.domain.Vo.AwProductinventoryVo;
import com.awise.produce.service.IAwProductinventoryServiceVo;
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
import com.awise.produce.domain.AwProductinventory;
import com.awise.produce.service.IAwProductinventoryService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 产品库存Controller
 * 
 * @author awise
 * @date 2024-04-28
 */
@RestController
@RequestMapping("/produce/ProductInventory")
public class AwProductinventoryController extends BaseController
{
    @Autowired
    private IAwProductinventoryService awProductinventoryService;

    @Autowired
    private IAwProductinventoryServiceVo  awProductinventoryServiceVo;

    /**
     * 查询产品库存列表
     */
    @PreAuthorize("@ss.hasPermi('produce:ProductInventory:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwProductinventoryVo awProductinventoryvo)
    {
        startPage();
        List<AwProductinventoryVo> list = awProductinventoryServiceVo.selectAwProductinventoryList(awProductinventoryvo);
        return getDataTable(list);
    }

    /**
     * 导出产品库存列表
     */
    @PreAuthorize("@ss.hasPermi('produce:ProductInventory:export')")
    @Log(title = "产品库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwProductinventoryVo awProductinventoryVo)
    {
        List<AwProductinventoryVo> list = awProductinventoryServiceVo.selectAwProductinventoryList(awProductinventoryVo);
        ExcelUtil<AwProductinventoryVo> util = new ExcelUtil<AwProductinventoryVo>(AwProductinventoryVo.class);
        util.exportExcel(response, list, "产品库存数据");
    }

    /**
     * 获取产品库存详细信息
     */
    @PreAuthorize("@ss.hasPermi('produce:ProductInventory:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awProductinventoryService.selectAwProductinventoryById(id));
    }

    /**
     * 新增产品库存
     */
    @PreAuthorize("@ss.hasPermi('produce:ProductInventory:add')")
    @Log(title = "产品库存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwProductinventory awProductinventory)
    {
        return toAjax(awProductinventoryService.insertAwProductinventory(awProductinventory));
    }

    /**
     * 修改产品库存
     */
    @PreAuthorize("@ss.hasPermi('produce:ProductInventory:edit')")
    @Log(title = "产品库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwProductinventory awProductinventory)
    {
        return toAjax(awProductinventoryService.updateAwProductinventory(awProductinventory));
    }

    /**
     * 删除产品库存
     */
    @PreAuthorize("@ss.hasPermi('produce:ProductInventory:remove')")
    @Log(title = "产品库存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awProductinventoryService.deleteAwProductinventoryByIds(ids));
    }


    /***
     *  本地实时库存新增
     */
    @PreAuthorize("@ss.hasPermi('storage:ProductInventory:addnumber')")
    @PostMapping("/ByNumbner/add")
    public AjaxResult addByNumber(@RequestBody() List<Map<String,String>> lmlist){

        return awProductinventoryService.addByNumber(lmlist)?success():error();
    }

    /***
     *  本地实时库存减少
     */
    @PreAuthorize("@ss.hasPermi('storage:ProductInventory:reducenumber')")
    @PostMapping("/ByNumbner/reduce")
    public AjaxResult reduceByNumber(@RequestBody() List<Map<String,String>> lmlist){

        return awProductinventoryService.reduceByNumber(lmlist)?success():error();
    }


}
