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
import com.awise.produce.domain.AwDetailproductmanhour;
import com.awise.produce.service.IAwDetailproductmanhourService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 工时统计详细Controller
 * 
 * @author awise
 * @date 2024-04-14
 */
@RestController
@RequestMapping("/produce/detailproductmanhour")
public class AwDetailproductmanhourController extends BaseController
{
    @Autowired
    private IAwDetailproductmanhourService awDetailproductmanhourService;

    /**
     * 查询工时统计详细列表
     */
    @PreAuthorize("@ss.hasPermi('produce:detailproductmanhour:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwDetailproductmanhour awDetailproductmanhour)
    {
        startPage();
        List<AwDetailproductmanhour> list = awDetailproductmanhourService.selectAwDetailproductmanhourList(awDetailproductmanhour);
        return getDataTable(list);
    }

    /**
     * 导出工时统计详细列表
     */
    @PreAuthorize("@ss.hasPermi('produce:detailproductmanhour:export')")
    @Log(title = "工时统计详细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwDetailproductmanhour awDetailproductmanhour)
    {
        List<AwDetailproductmanhour> list = awDetailproductmanhourService.selectAwDetailproductmanhourList(awDetailproductmanhour);
        ExcelUtil<AwDetailproductmanhour> util = new ExcelUtil<AwDetailproductmanhour>(AwDetailproductmanhour.class);
        util.exportExcel(response, list, "工时统计详细数据");
    }

    /**
     * 获取工时统计详细详细信息
     */
    @PreAuthorize("@ss.hasPermi('produce:detailproductmanhour:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awDetailproductmanhourService.selectAwDetailproductmanhourById(id));
    }

    /**
     * 新增工时统计详细
     */
    @PreAuthorize("@ss.hasPermi('produce:detailproductmanhour:add')")
    @Log(title = "工时统计详细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwDetailproductmanhour awDetailproductmanhour)
    {
        return toAjax(awDetailproductmanhourService.insertAwDetailproductmanhour(awDetailproductmanhour));
    }

    /**
     * 修改工时统计详细
     */
    @PreAuthorize("@ss.hasPermi('produce:detailproductmanhour:edit')")
    @Log(title = "工时统计详细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwDetailproductmanhour awDetailproductmanhour)
    {
        return toAjax(awDetailproductmanhourService.updateAwDetailproductmanhour(awDetailproductmanhour));
    }

    /**
     * 删除工时统计详细
     */
    @PreAuthorize("@ss.hasPermi('produce:detailproductmanhour:remove')")
    @Log(title = "工时统计详细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awDetailproductmanhourService.deleteAwDetailproductmanhourByIds(ids));
    }
}
