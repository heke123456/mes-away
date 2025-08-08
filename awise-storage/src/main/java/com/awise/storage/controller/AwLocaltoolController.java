package com.awise.storage.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.awise.storage.domain.AwLocaltoolEn;
import com.awise.storage.service.IAwLocaltoolEnService;
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
import com.awise.storage.domain.AwLocaltool;
import com.awise.storage.service.IAwLocaltoolService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 刀具库存Controller
 *
 * @author awise
 * @date 2023-12-18
 */
@RestController
@RequestMapping("/storage/LocalTool")
public class AwLocaltoolController extends BaseController
{
    @Autowired
    private IAwLocaltoolService awLocaltoolService;

    @Autowired
    private IAwLocaltoolEnService awLocaltoolEnService;

    /**
     * 查询刀具库存列表
     */
    @PreAuthorize("@ss.hasPermi('storage:LocalTool:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwLocaltool awLocaltool)
    {
        startPage();
        List<AwLocaltool> list = awLocaltoolService.selectAwLocaltoolList(awLocaltool);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('storage:LocalTool:enlist')")
    @GetMapping("/enlist")
    public  TableDataInfo  list(AwLocaltoolEn awLocaltoolEn){
        startPage();
        List<AwLocaltoolEn>  list= awLocaltoolEnService.selectAwLocaltoolEnList(awLocaltoolEn);

        return  getDataTable(list);
    }

    /**
     * 导出刀具库存列表
     */
    @PreAuthorize("@ss.hasPermi('storage:LocalTool:export')")
    @Log(title = "刀具库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwLocaltoolEn awLocaltoolen)
    {
        List<AwLocaltoolEn>  list= awLocaltoolEnService.selectAwLocaltoolEnList(awLocaltoolen);
        ExcelUtil<AwLocaltoolEn> util = new ExcelUtil<AwLocaltoolEn>(AwLocaltoolEn.class);
        util.exportExcel(response, list, "刀具库存数据");
    }

    /**
     * 本地实时库存新增
     */

    @PreAuthorize("@ss.hasPermi('storage:LocalTool:addnumber')")
    @PostMapping("/ByNumbner/add")
    public AjaxResult addByNumber(@RequestBody() List<Map<String,String>> lmlist){

        return awLocaltoolService.addByNumber(lmlist)?success():error();
    }

    /***
     *  本地实时库存减少
     */
    @PreAuthorize("@ss.hasPermi('storage:LocalTool:reducenumber')")
    @PostMapping("/ByNumbner/reduce")
    public AjaxResult reduceByNumber(@RequestBody() List<Map<String,String>> lmlist){

        return awLocaltoolService.reduceByNumber(lmlist)?success():error();
    }


    /**
     * 获取刀具库存详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:LocalTool:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awLocaltoolService.selectAwLocaltoolById(id));
    }

    /**
     * 新增刀具库存
     */
    @PreAuthorize("@ss.hasPermi('storage:LocalTool:add')")
    @Log(title = "刀具库存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwLocaltool awLocaltool)
    {
        return toAjax(awLocaltoolService.insertAwLocaltool(awLocaltool));
    }

    /**
     * 修改刀具库存
     */
    @PreAuthorize("@ss.hasPermi('storage:LocalTool:edit')")
    @Log(title = "刀具库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwLocaltool awLocaltool)
    {
        return toAjax(awLocaltoolService.updateAwLocaltool(awLocaltool));
    }

    /**
     * 删除刀具库存
     */
    @PreAuthorize("@ss.hasPermi('storage:LocalTool:remove')")
    @Log(title = "刀具库存", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awLocaltoolService.deleteAwLocaltoolByIds(ids));
    }
}
