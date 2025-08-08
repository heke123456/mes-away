package com.awise.storage.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.awise.storage.domain.AwLocalmaterialsEn;
import com.awise.storage.service.IAwLocalmaterialsEnService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.away.common.annotation.Log;
import com.away.common.core.controller.BaseController;
import com.away.common.core.domain.AjaxResult;
import com.away.common.enums.BusinessType;
import com.awise.storage.domain.AwLocalmaterials;
import com.awise.storage.service.IAwLocalmaterialsService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 本地材料实时库存Controller
 * 
 * @author awise
 * @date 2023-08-03
 */
@RestController
@RequestMapping("/storage/localmaterials")
public class AwLocalmaterialsController extends BaseController
{
    @Autowired
    private IAwLocalmaterialsService awLocalmaterialsService;

    @Autowired
    private IAwLocalmaterialsEnService awLocalmaterialsEnService;

    /**
     * 查询本地材料实时库存列表
     */
    @PreAuthorize("@ss.hasPermi('storage:localmaterials:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwLocalmaterials awLocalmaterials)
    {
        startPage();
        List<AwLocalmaterials> list = awLocalmaterialsService.selectAwLocalmaterialsList(awLocalmaterials);
        return getDataTable(list);
    }

    /**
     * 查询本地材料实时库存实体列表
     */
    @PreAuthorize("@ss.hasPermi('storage:localmaterials:enlist')")
    @GetMapping("/enlist")
    public TableDataInfo list(AwLocalmaterialsEn awLocalmaterialsEn)
    {
        startPage();
        List<AwLocalmaterialsEn> list = awLocalmaterialsEnService.selectAwLocalmaterialsEnList(awLocalmaterialsEn);
        return getDataTable(list);
    }

    /**
     * 导出本地材料实时库存列表
     */
    @PreAuthorize("@ss.hasPermi('storage:localmaterials:export')")
    @Log(title = "本地材料实时库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwLocalmaterialsEn awLocalmaterialsEn)
    {
        List<AwLocalmaterialsEn> list = awLocalmaterialsEnService.selectAwLocalmaterialsEnList(awLocalmaterialsEn);

        ExcelUtil<AwLocalmaterialsEn> util = new ExcelUtil<AwLocalmaterialsEn>(AwLocalmaterialsEn.class);
        util.exportExcel(response, list, "本地材料实时库存数据");
    }

    /***
     *  本地实时库存新增
     */
    @PreAuthorize("@ss.hasPermi('storage:localmaterials:addnumber')")
    @PostMapping("/ByNumbner/add")
    public AjaxResult addByNumber(@RequestBody() List<Map<String,String>> lmlist){

        return awLocalmaterialsService.addByNumber(lmlist)?success():error();
    }

    /***
     *  本地实时库存减少
     */
    @PreAuthorize("@ss.hasPermi('storage:localmaterials:reducenumber')")
    @PostMapping("/ByNumbner/reduce")
    public AjaxResult reduceByNumber(@RequestBody() List<Map<String,String>> lmlist){

        return awLocalmaterialsService.reduceByNumber(lmlist)?success():error();
    }

    /**
     * 获取本地材料实时库存详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:localmaterials:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awLocalmaterialsService.selectAwLocalmaterialsById(id));
    }

    /**
     * 新增本地材料实时库存
     */
    @PreAuthorize("@ss.hasPermi('storage:localmaterials:add')")
    @Log(title = "本地材料实时库存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwLocalmaterials awLocalmaterials)
    {
        return toAjax(awLocalmaterialsService.insertAwLocalmaterials(awLocalmaterials));
    }

    /**
     * 修改本地材料实时库存
     */
    @PreAuthorize("@ss.hasPermi('storage:localmaterials:edit')")
    @Log(title = "本地材料实时库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwLocalmaterials awLocalmaterials)
    {
        return toAjax(awLocalmaterialsService.updateAwLocalmaterials(awLocalmaterials));
    }

    /**
     * 删除本地材料实时库存
     */
    @PreAuthorize("@ss.hasPermi('storage:localmaterials:remove')")
    @Log(title = "本地材料实时库存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awLocalmaterialsService.deleteAwLocalmaterialsByIds(ids));
    }
}
