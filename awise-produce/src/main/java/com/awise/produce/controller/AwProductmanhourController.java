package com.awise.produce.controller;

import com.away.common.annotation.Log;
import com.away.common.core.controller.BaseController;
import com.away.common.core.domain.AjaxResult;
import com.away.common.core.page.TableDataInfo;
import com.away.common.enums.BusinessType;
import com.away.common.utils.poi.ExcelUtil;
import com.awise.produce.domain.AwProductmanhour;
import com.awise.produce.service.IAwProductmanhourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 生产工时Controller
 * 
 * @author awise
 * @date 2024-03-19
 */
@RestController
@RequestMapping("/produce/productmanhour")
public class AwProductmanhourController extends BaseController
{
    @Autowired
    private IAwProductmanhourService awProductmanhourService;

    /**
     * 查询生产工时列表
     */
    @PreAuthorize("@ss.hasPermi('produce:productmanhour:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwProductmanhour awProductmanhour)
    {
        startPage();
        List<AwProductmanhour> list = awProductmanhourService.selectAwProductmanhourList(awProductmanhour);
        return getDataTable(list);
    }

    /**
     * 导出生产工时列表
     */
    @PreAuthorize("@ss.hasPermi('produce:productmanhour:export')")
    @Log(title = "生产工时", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwProductmanhour awProductmanhour)
    {
        List<AwProductmanhour> list = awProductmanhourService.selectAwProductmanhourList(awProductmanhour);
        ExcelUtil<AwProductmanhour> util = new ExcelUtil<AwProductmanhour>(AwProductmanhour.class);
        util.exportExcel(response, list, "生产工时数据");
    }





    /**
     * 获取生产工时详细信息
     */
    @PreAuthorize("@ss.hasPermi('produce:productmanhour:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awProductmanhourService.selectAwProductmanhourById(id));
    }

    /**
     * 新增生产工时
     */
    @PreAuthorize("@ss.hasPermi('produce:productmanhour:add')")
    @Log(title = "生产工时", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwProductmanhour awProductmanhour)
    {
        return toAjax(awProductmanhourService.insertAwProductmanhour(awProductmanhour));
    }

    /**
     * 修改生产工时
     */
    @PreAuthorize("@ss.hasPermi('produce:productmanhour:edit')")
    @Log(title = "生产工时", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwProductmanhour awProductmanhour)
    {
        return toAjax(awProductmanhourService.updateAwProductmanhour(awProductmanhour));
    }

    /**
     * 删除生产工时
     */
    @PreAuthorize("@ss.hasPermi('produce:productmanhour:remove')")
    @Log(title = "生产工时", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awProductmanhourService.deleteAwProductmanhourByIds(ids));
    }
}
