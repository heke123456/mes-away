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
import com.awise.produce.domain.AwMateriallistoftechnology;
import com.awise.produce.service.IAwMateriallistoftechnologyService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 需求材料Controller
 * 
 * @author awise
 * @date 2023-10-15
 */
@RestController
@RequestMapping("/produce/MaterialListOfTechnology")
public class AwMateriallistoftechnologyController extends BaseController
{
    @Autowired
    private IAwMateriallistoftechnologyService awMateriallistoftechnologyService;

    /**
     * 查询需求材料列表
     */
    @PreAuthorize("@ss.hasPermi('produce:MaterialListOfTechnology:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwMateriallistoftechnology awMateriallistoftechnology)
    {
        startPage();
        List<AwMateriallistoftechnology> list = awMateriallistoftechnologyService.selectAwMateriallistoftechnologyList(awMateriallistoftechnology);
        return getDataTable(list);
    }

    /**
     * 导出需求材料列表
     */
    @PreAuthorize("@ss.hasPermi('produce:MaterialListOfTechnology:export')")
    @Log(title = "需求材料", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwMateriallistoftechnology awMateriallistoftechnology)
    {
        List<AwMateriallistoftechnology> list = awMateriallistoftechnologyService.selectAwMateriallistoftechnologyList(awMateriallistoftechnology);
        ExcelUtil<AwMateriallistoftechnology> util = new ExcelUtil<AwMateriallistoftechnology>(AwMateriallistoftechnology.class);
        util.exportExcel(response, list, "需求材料数据");
    }

    /**
     * 获取需求材料详细信息
     */
    @PreAuthorize("@ss.hasPermi('produce:MaterialListOfTechnology:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awMateriallistoftechnologyService.selectAwMateriallistoftechnologyById(id));
    }

    /**
     * 新增需求材料
     */
    @PreAuthorize("@ss.hasPermi('produce:MaterialListOfTechnology:add')")
    @Log(title = "需求材料", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwMateriallistoftechnology awMateriallistoftechnology)
    {
        return toAjax(awMateriallistoftechnologyService.insertAwMateriallistoftechnology(awMateriallistoftechnology));
    }

    /**
     * 修改需求材料
     */
    @PreAuthorize("@ss.hasPermi('produce:MaterialListOfTechnology:edit')")
    @Log(title = "需求材料", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwMateriallistoftechnology awMateriallistoftechnology)
    {
        return toAjax(awMateriallistoftechnologyService.updateAwMateriallistoftechnology(awMateriallistoftechnology));
    }

    /**
     * 删除需求材料
     */
    @PreAuthorize("@ss.hasPermi('produce:MaterialListOfTechnology:remove')")
    @Log(title = "需求材料", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awMateriallistoftechnologyService.deleteAwMateriallistoftechnologyByIds(ids));
    }
}
