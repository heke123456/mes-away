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
import com.awise.storage.domain.AwTooloutbound;
import com.awise.storage.service.IAwTooloutboundService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 刀具出库Controller
 * 
 * @author awise
 * @date 2023-12-08
 */
@RestController
@RequestMapping("/storage/ToolOutbound")
public class AwTooloutboundController extends BaseController
{
    @Autowired
    private IAwTooloutboundService awTooloutboundService;

    /**
     * 查询刀具出库列表
     */
    @PreAuthorize("@ss.hasPermi('storage:ToolOutbound:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwTooloutbound awTooloutbound)
    {
        startPage();
        List<AwTooloutbound> list = awTooloutboundService.selectAwTooloutboundList(awTooloutbound);
        return getDataTable(list);
    }

    /**
     * 导出刀具出库列表
     */
    @PreAuthorize("@ss.hasPermi('storage:ToolOutbound:export')")
    @Log(title = "刀具出库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwTooloutbound awTooloutbound)
    {
        List<AwTooloutbound> list = awTooloutboundService.selectAwTooloutboundList(awTooloutbound);
        ExcelUtil<AwTooloutbound> util = new ExcelUtil<AwTooloutbound>(AwTooloutbound.class);
        util.exportExcel(response, list, "刀具出库数据");
    }

    /**
     * 获取刀具出库详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:ToolOutbound:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awTooloutboundService.selectAwTooloutboundById(id));
    }

    /**
     * 新增刀具出库
     */
    @PreAuthorize("@ss.hasPermi('storage:ToolOutbound:add')")
    @Log(title = "刀具出库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwTooloutbound awTooloutbound)
    {
        return toAjax(awTooloutboundService.insertAwTooloutbound(awTooloutbound));
    }

    /**
     * 修改刀具出库
     */
    @PreAuthorize("@ss.hasPermi('storage:ToolOutbound:edit')")
    @Log(title = "刀具出库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwTooloutbound awTooloutbound)
    {
        return toAjax(awTooloutboundService.updateAwTooloutbound(awTooloutbound));
    }

    /**
     * 删除刀具出库
     */
    @PreAuthorize("@ss.hasPermi('storage:ToolOutbound:remove')")
    @Log(title = "刀具出库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awTooloutboundService.deleteAwTooloutboundByIds(ids));
    }
}
