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
import com.awise.produce.domain.AwProcesstemplate;
import com.awise.produce.service.IAwProcesstemplateService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 工序模板Controller
 * 
 * @author awise
 * @date 2023-09-07
 */
@RestController
@RequestMapping("/produce/processtemplate")
public class AwProcesstemplateController extends BaseController
{
    @Autowired
    private IAwProcesstemplateService awProcesstemplateService;

    /**
     * 查询工序模板列表
     */
    @PreAuthorize("@ss.hasPermi('produce:processtemplate:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwProcesstemplate awProcesstemplate)
    {
        startPage();
        List<AwProcesstemplate> list = awProcesstemplateService.selectAwProcesstemplateList(awProcesstemplate);
        return getDataTable(list);
    }

    /**
     * 导出工序模板列表
     */
    @PreAuthorize("@ss.hasPermi('produce:processtemplate:export')")
    @Log(title = "工序模板", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwProcesstemplate awProcesstemplate)
    {
        List<AwProcesstemplate> list = awProcesstemplateService.selectAwProcesstemplateList(awProcesstemplate);
        ExcelUtil<AwProcesstemplate> util = new ExcelUtil<AwProcesstemplate>(AwProcesstemplate.class);
        util.exportExcel(response, list, "工序模板数据");
    }

    /**
     * 获取工序模板详细信息
     */
    @PreAuthorize("@ss.hasPermi('produce:processtemplate:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        AwProcesstemplate awProcesstemplate = awProcesstemplateService.selectAwProcesstemplateById(id);
        return success(awProcesstemplate);
    }

    /**
     * 新增工序模板
     */
    @PreAuthorize("@ss.hasPermi('produce:processtemplate:add')")
    @Log(title = "工序模板", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwProcesstemplate awProcesstemplate)
    {
        return toAjax(awProcesstemplateService.insertAwProcesstemplate(awProcesstemplate));
    }

    /**
     * 修改工序模板
     */
    @PreAuthorize("@ss.hasPermi('produce:processtemplate:edit')")
    @Log(title = "工序模板", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwProcesstemplate awProcesstemplate)
    {
        return toAjax(awProcesstemplateService.updateAwProcesstemplate(awProcesstemplate));
    }

    /**
     * 删除工序模板
     */
    @PreAuthorize("@ss.hasPermi('produce:processtemplate:remove')")
    @Log(title = "工序模板", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awProcesstemplateService.deleteAwProcesstemplateByIds(ids));
    }
}
