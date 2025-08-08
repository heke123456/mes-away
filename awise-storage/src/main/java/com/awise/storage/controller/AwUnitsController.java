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
import com.awise.storage.domain.AwUnits;
import com.awise.storage.service.IAwUnitsService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 计量单位Controller
 * 
 * @author ruoyi
 * @date 2023-07-27
 */
@RestController
@RequestMapping("/storage/units")
public class AwUnitsController extends BaseController
{
    @Autowired
    private IAwUnitsService awUnitsService;

    /**
     * 查询计量单位列表
     */
    @PreAuthorize("@ss.hasPermi('storage:units:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwUnits awUnits)
    {
        startPage();
        List<AwUnits> list = awUnitsService.selectAwUnitsList(awUnits);
        return getDataTable(list);
    }

    /**
     * 导出计量单位列表
     */
    @PreAuthorize("@ss.hasPermi('storage:units:export')")
    @Log(title = "计量单位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwUnits awUnits)
    {
        List<AwUnits> list = awUnitsService.selectAwUnitsList(awUnits);
        ExcelUtil<AwUnits> util = new ExcelUtil<AwUnits>(AwUnits.class);
        util.exportExcel(response, list, "计量单位数据");
    }

    /**
     * 获取计量单位详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:units:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awUnitsService.selectAwUnitsById(id));
    }

    /**
     * 新增计量单位
     */
    @PreAuthorize("@ss.hasPermi('storage:units:add')")
    @Log(title = "计量单位", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwUnits awUnits)
    {
        return toAjax(awUnitsService.insertAwUnits(awUnits));
    }

    /**
     * 修改计量单位
     */
    @PreAuthorize("@ss.hasPermi('storage:units:edit')")
    @Log(title = "计量单位", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwUnits awUnits)
    {
        return toAjax(awUnitsService.updateAwUnits(awUnits));
    }

    /**
     * 删除计量单位
     */
    @PreAuthorize("@ss.hasPermi('storage:units:remove')")
    @Log(title = "计量单位", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awUnitsService.deleteAwUnitsByIds(ids));
    }
}
