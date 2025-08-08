package com.awise.storage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.awise.storage.domain.AwToolinformationEn;
import com.awise.storage.service.IAwToolinformationEnService;
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
import com.awise.storage.domain.AwToolinformation;
import com.awise.storage.service.IAwToolinformationService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 刀具信息Controller
 * 
 * @author awise
 * @date 2023-07-27
 */
@RestController
@RequestMapping("/storage/toolinformation")
public class AwToolinformationController extends BaseController
{
    @Autowired
    private IAwToolinformationService awToolinformationService;

    @Autowired
    private IAwToolinformationEnService awToolinformationEnService;
    /**
     * 查询刀具信息列表
     */
    @PreAuthorize("@ss.hasPermi('storage:toolinformation:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwToolinformation awToolinformation)
    {
        startPage();
        List<AwToolinformation> list = awToolinformationService.selectAwToolinformationList(awToolinformation);
        return getDataTable(list);
    }

    /**
     * 查询刀具信息列表实体
     */
    @PreAuthorize("@ss.hasPermi('storage:toolinformation:list')")
    @GetMapping("/enlist")
    public TableDataInfo Enlist(AwToolinformationEn awToolinformationEn)
    {
        startPage();
        List<AwToolinformationEn> list = awToolinformationEnService.selectAwToolinformationEnList(awToolinformationEn);
        return getDataTable(list);
    }

    /**
     * 导出刀具信息列表
     */
    @PreAuthorize("@ss.hasPermi('storage:toolinformation:export')")
    @Log(title = "刀具信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwToolinformationEn awToolinformationEn)
    {
        List<AwToolinformationEn> list = awToolinformationEnService.selectAwToolinformationEnList(awToolinformationEn);
        ExcelUtil<AwToolinformationEn> util = new ExcelUtil<AwToolinformationEn>(AwToolinformationEn.class);
        util.exportExcel(response, list, "刀具信息数据");
    }

    /**
     * 获取刀具信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:toolinformation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(awToolinformationService.selectAwToolinformationById(id));
    }

    /**
     * 新增刀具信息
     */
    @PreAuthorize("@ss.hasPermi('storage:toolinformation:add')")
    @Log(title = "刀具信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwToolinformation awToolinformation)
    {
        return toAjax(awToolinformationService.insertAwToolinformation(awToolinformation));
    }

    /**
     * 修改刀具信息
     */
    @PreAuthorize("@ss.hasPermi('storage:toolinformation:edit')")
    @Log(title = "刀具信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwToolinformation awToolinformation)
    {
        return toAjax(awToolinformationService.updateAwToolinformation(awToolinformation));
    }

    /**
     * 删除刀具信息
     */
    @PreAuthorize("@ss.hasPermi('storage:toolinformation:remove')")
    @Log(title = "刀具信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(awToolinformationService.deleteAwToolinformationByIds(ids));
    }
}
