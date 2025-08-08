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
import com.awise.storage.domain.AwMaterialclassification;
import com.awise.storage.service.IAwMaterialclassificationService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 材料分类Controller
 * 
 * @author awise
 * @date 2023-08-02
 */
@RestController
@RequestMapping("/storage/materialclassification")
public class AwMaterialclassificationController extends BaseController
{
    @Autowired
    private IAwMaterialclassificationService awMaterialclassificationService;

    /**
     * 查询材料分类列表
     */
    @PreAuthorize("@ss.hasPermi('storage:materialclassification:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwMaterialclassification awMaterialclassification)
    {
        startPage();
        List<AwMaterialclassification> list = awMaterialclassificationService.selectAwMaterialclassificationList(awMaterialclassification);
        return getDataTable(list);
    }

    /**
     * 导出材料分类列表
     */
    @PreAuthorize("@ss.hasPermi('storage:materialclassification:export')")
    @Log(title = "材料分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwMaterialclassification awMaterialclassification)
    {
        List<AwMaterialclassification> list = awMaterialclassificationService.selectAwMaterialclassificationList(awMaterialclassification);
        ExcelUtil<AwMaterialclassification> util = new ExcelUtil<AwMaterialclassification>(AwMaterialclassification.class);
        util.exportExcel(response, list, "材料分类数据");
    }

    /**
     * 获取材料分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:materialclassification:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awMaterialclassificationService.selectAwMaterialclassificationById(id));
    }

    /**
     * 新增材料分类
     */
    @PreAuthorize("@ss.hasPermi('storage:materialclassification:add')")
    @Log(title = "材料分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwMaterialclassification awMaterialclassification)
    {
        return toAjax(awMaterialclassificationService.insertAwMaterialclassification(awMaterialclassification));
    }

    /**
     * 修改材料分类
     */
    @PreAuthorize("@ss.hasPermi('storage:materialclassification:edit')")
    @Log(title = "材料分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwMaterialclassification awMaterialclassification)
    {
        return toAjax(awMaterialclassificationService.updateAwMaterialclassification(awMaterialclassification));
    }

    /**
     * 删除材料分类
     */
    @PreAuthorize("@ss.hasPermi('storage:materialclassification:remove')")
    @Log(title = "材料分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awMaterialclassificationService.deleteAwMaterialclassificationByIds(ids));
    }
}
