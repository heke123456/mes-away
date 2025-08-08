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
import com.awise.produce.domain.AwProductiontasks;
import com.awise.produce.service.IAwProductiontasksService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 生产任务Controller
 * 
 * @author awise
 * @date 2023-08-15
 */
@RestController
@RequestMapping("/produce/productiontasks")
public class AwProductiontasksController extends BaseController
{
    @Autowired
    private IAwProductiontasksService awProductiontasksService;

    /**
     * 查询生产任务列表
     */
    @PreAuthorize("@ss.hasPermi('produce:productiontasks:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwProductiontasks awProductiontasks)
    {
        startPage();
        List<AwProductiontasks> list = awProductiontasksService.selectAwProductiontasksList(awProductiontasks);
        return getDataTable(list);
    }

    /**
     * 导出生产任务列表
     */
    @PreAuthorize("@ss.hasPermi('produce:productiontasks:export')")
    @Log(title = "生产任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwProductiontasks awProductiontasks)
    {
        List<AwProductiontasks> list = awProductiontasksService.selectAwProductiontasksList(awProductiontasks);
        ExcelUtil<AwProductiontasks> util = new ExcelUtil<AwProductiontasks>(AwProductiontasks.class);
        util.exportExcel(response, list, "生产任务数据");
    }

    /**
     * 获取生产任务详细信息
     */
    @PreAuthorize("@ss.hasPermi('produce:productiontasks:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awProductiontasksService.selectAwProductiontasksById(id));
    }

    /**
     * 新增生产任务
     */
    @PreAuthorize("@ss.hasPermi('produce:productiontasks:add')")
    @Log(title = "生产任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwProductiontasks awProductiontasks)
    {
        return toAjax(awProductiontasksService.insertAwProductiontasks(awProductiontasks));
    }

    /**
     * 修改生产任务
     */
    @PreAuthorize("@ss.hasPermi('produce:productiontasks:edit')")
    @Log(title = "生产任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwProductiontasks awProductiontasks)
    {
        return toAjax(awProductiontasksService.updateAwProductiontasks(awProductiontasks));
    }

    /**
     * 删除生产任务
     */
    @PreAuthorize("@ss.hasPermi('produce:productiontasks:remove')")
    @Log(title = "生产任务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awProductiontasksService.deleteAwProductiontasksByIds(ids));
    }

    /**
     * 删除生产任务下的所有任务
     */
    @PreAuthorize("@ss.hasPermi('produce:productiontasks:remove')")
    @Log(title = "生产任务", businessType = BusinessType.DELETE)
    @DeleteMapping("/remove/{productionTasksFormIDs}")
    public AjaxResult removeByProductionTasksFormIDs(@PathVariable Long[] productionTasksFormIDs)
    {
        // 这里采用返回成功信息的原因，是可以无视删除数量为0条的情况。因为有的生产任务单可能不存在生产任务。
        System.out.println(AjaxResult.success());
        awProductiontasksService.deleteAwProductiontasksByProductionTasksFormIDs(productionTasksFormIDs);
        return AjaxResult.success();
    }


}