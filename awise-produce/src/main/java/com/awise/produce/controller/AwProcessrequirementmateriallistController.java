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
import com.awise.produce.domain.AwProcessrequirementmateriallist;
import com.awise.produce.service.IAwProcessrequirementmateriallistService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 工艺需求材料Controller
 * 
 * @author awise
 * @date 2023-10-15
 */
@RestController
@RequestMapping("/produce/processrequirementmateriallist")
public class AwProcessrequirementmateriallistController extends BaseController
{
    @Autowired
    private IAwProcessrequirementmateriallistService awProcessrequirementmateriallistService;

    /**
     * 查询工艺需求材料列表
     */
    @PreAuthorize("@ss.hasPermi('produce:processrequirementmateriallist:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwProcessrequirementmateriallist awProcessrequirementmateriallist)
    {
        startPage();
        List<AwProcessrequirementmateriallist> list = awProcessrequirementmateriallistService.selectAwProcessrequirementmateriallistList(awProcessrequirementmateriallist);
        return getDataTable(list);
    }

    /**
     * 导出工艺需求材料列表
     */
    @PreAuthorize("@ss.hasPermi('produce:processrequirementmateriallist:export')")
    @Log(title = "工艺需求材料", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwProcessrequirementmateriallist awProcessrequirementmateriallist)
    {
        List<AwProcessrequirementmateriallist> list = awProcessrequirementmateriallistService.selectAwProcessrequirementmateriallistList(awProcessrequirementmateriallist);
        ExcelUtil<AwProcessrequirementmateriallist> util = new ExcelUtil<AwProcessrequirementmateriallist>(AwProcessrequirementmateriallist.class);
        util.exportExcel(response, list, "工艺需求材料数据");
    }

    /**
     * 获取工艺需求材料详细信息
     */
    @PreAuthorize("@ss.hasPermi('produce:processrequirementmateriallist:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awProcessrequirementmateriallistService.selectAwProcessrequirementmateriallistById(id));
    }

    /**
     * 新增工艺需求材料
     */
    @PreAuthorize("@ss.hasPermi('produce:processrequirementmateriallist:add')")
    @Log(title = "工艺需求材料", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwProcessrequirementmateriallist awProcessrequirementmateriallist)
    {
        return toAjax(awProcessrequirementmateriallistService.insertAwProcessrequirementmateriallist(awProcessrequirementmateriallist));
    }

    /**
     * 修改工艺需求材料
     */
    @PreAuthorize("@ss.hasPermi('produce:processrequirementmateriallist:edit')")
    @Log(title = "工艺需求材料", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwProcessrequirementmateriallist awProcessrequirementmateriallist)
    {
        return toAjax(awProcessrequirementmateriallistService.updateAwProcessrequirementmateriallist(awProcessrequirementmateriallist));
    }

    /**
     * 删除工艺需求材料
     */
    @PreAuthorize("@ss.hasPermi('produce:processrequirementmateriallist:remove')")
    @Log(title = "工艺需求材料", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awProcessrequirementmateriallistService.deleteAwProcessrequirementmateriallistByIds(ids));
    }
}
