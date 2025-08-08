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
import com.awise.storage.domain.AwBasicinformationofmaterials;
import com.awise.storage.service.IAwBasicinformationofmaterialsService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 材料信息详细单Controller
 * 
 * @author awise
 * @date 2023-10-15
 */
@RestController
@RequestMapping("/storage/basicinformationofmaterials")
public class AwBasicinformationofmaterialsController extends BaseController
{
    @Autowired
    private IAwBasicinformationofmaterialsService awBasicinformationofmaterialsService;

    /**
     * 查询材料信息详细单列表
     */
    @PreAuthorize("@ss.hasPermi('storage:basicinformationofmaterials:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwBasicinformationofmaterials awBasicinformationofmaterials)
    {
        startPage();
        List<AwBasicinformationofmaterials> list = awBasicinformationofmaterialsService.selectAwBasicinformationofmaterialsList(awBasicinformationofmaterials);
        return getDataTable(list);
    }

    /**
     * 导出材料信息详细单列表
     */
    @PreAuthorize("@ss.hasPermi('storage:basicinformationofmaterials:export')")
    @Log(title = "材料信息详细单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwBasicinformationofmaterials awBasicinformationofmaterials)
    {
        List<AwBasicinformationofmaterials> list = awBasicinformationofmaterialsService.selectAwBasicinformationofmaterialsList(awBasicinformationofmaterials);
        ExcelUtil<AwBasicinformationofmaterials> util = new ExcelUtil<AwBasicinformationofmaterials>(AwBasicinformationofmaterials.class);
        util.exportExcel(response, list, "材料信息详细单数据");
    }

    /**
     * 获取材料信息详细单详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:basicinformationofmaterials:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(awBasicinformationofmaterialsService.selectAwBasicinformationofmaterialsById(id));
    }

    /**
     * 新增材料信息详细单
     */
    @PreAuthorize("@ss.hasPermi('storage:basicinformationofmaterials:add')")
    @Log(title = "材料信息详细单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwBasicinformationofmaterials awBasicinformationofmaterials)
    {
        return toAjax(awBasicinformationofmaterialsService.insertAwBasicinformationofmaterials(awBasicinformationofmaterials));
    }

    /**
     * 修改材料信息详细单
     */
    @PreAuthorize("@ss.hasPermi('storage:basicinformationofmaterials:edit')")
    @Log(title = "材料信息详细单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwBasicinformationofmaterials awBasicinformationofmaterials)
    {
        return toAjax(awBasicinformationofmaterialsService.updateAwBasicinformationofmaterials(awBasicinformationofmaterials));
    }

    /**
     * 删除材料信息详细单
     */
    @PreAuthorize("@ss.hasPermi('storage:basicinformationofmaterials:remove')")
    @Log(title = "材料信息详细单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(awBasicinformationofmaterialsService.deleteAwBasicinformationofmaterialsByIds(ids));
    }
}
