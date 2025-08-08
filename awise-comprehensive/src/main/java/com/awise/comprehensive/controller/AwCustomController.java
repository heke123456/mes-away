package com.awise.comprehensive.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.awise.comprehensive.domain.AwCustomEn;
import com.awise.comprehensive.service.IAwCustomEnService;
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
import com.awise.comprehensive.domain.AwCustom;
import com.awise.comprehensive.service.IAwCustomService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 客户信息Controller
 * 
 * @author awise
 * @date 2023-08-02
 */
@RestController
@RequestMapping("/comprehensive/custom")
public class AwCustomController extends BaseController
{
    @Autowired
    private IAwCustomService awCustomService;

    @Autowired
    private IAwCustomEnService awCustomEnService;

    /**
     * 查询客户信息列表
     */
    @PreAuthorize("@ss.hasPermi('comprehensive:custom:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwCustom awCustom)
    {
        startPage();
        List<AwCustom> list = awCustomService.selectAwCustomList(awCustom);
        return getDataTable(list);
    }

    /**
     * 查询客户信息实体列表
     */
    @PreAuthorize("@ss.hasPermi('comprehensive:custom:enlist')")
    @GetMapping("/enlist")
    public TableDataInfo list(AwCustomEn awCustomEn)
    {
        startPage();
        List<AwCustomEn> list = awCustomEnService.selectAwCustomEnList(awCustomEn);
        return getDataTable(list);
    }

    /**
     * 导出客户信息列表
     */
    @PreAuthorize("@ss.hasPermi('comprehensive:custom:export')")
    @Log(title = "客户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwCustom awCustom)
    {
        List<AwCustom> list = awCustomService.selectAwCustomList(awCustom);
        ExcelUtil<AwCustom> util = new ExcelUtil<AwCustom>(AwCustom.class);
        util.exportExcel(response, list, "客户信息数据");
    }

    /**
     * 获取客户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('comprehensive:custom:query')")
    @GetMapping(value = "/{ID}")
    public AjaxResult getInfo(@PathVariable("ID") String ID)
    {
        return success(awCustomService.selectAwCustomByID(ID));
    }

    /**
     * 新增客户信息
     */
    @PreAuthorize("@ss.hasPermi('comprehensive:custom:add')")
    @Log(title = "客户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwCustom awCustom)
    {
        System.out.println(awCustom);
        return toAjax(awCustomService.insertAwCustom(awCustom));
    }

    /**
     * 修改客户信息
     */
    @PreAuthorize("@ss.hasPermi('comprehensive:custom:edit')")
    @Log(title = "客户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwCustom awCustom)
    {
        return toAjax(awCustomService.updateAwCustom(awCustom));
    }

    /**
     * 删除客户信息
     */
    @PreAuthorize("@ss.hasPermi('comprehensive:custom:remove')")
    @Log(title = "客户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{IDs}")
    public AjaxResult remove(@PathVariable String[] IDs)
    {
        return toAjax(awCustomService.deleteAwCustomByIDs(IDs));
    }
}
