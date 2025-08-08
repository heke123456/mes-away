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
import com.awise.storage.domain.AwLocalmaterialoutbound;
import com.awise.storage.service.IAwLocalmaterialoutboundService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 本地材料出库Controller
 * 
 * @author ruoyi
 * @date 2023-10-14
 */
@RestController
@RequestMapping("/storage/localmaterialoutbound")
public class AwLocalmaterialoutboundController extends BaseController
{
    @Autowired
    private IAwLocalmaterialoutboundService awLocalmaterialoutboundService;

    /**
     * 查询本地材料出库列表
     */
    @PreAuthorize("@ss.hasPermi('storage:localmaterialoutbound:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwLocalmaterialoutbound awLocalmaterialoutbound)
    {
        startPage();
        List<AwLocalmaterialoutbound> list = awLocalmaterialoutboundService.selectAwLocalmaterialoutboundList(awLocalmaterialoutbound);
        return getDataTable(list);
    }

    /**
     * 导出本地材料出库列表
     */
    @PreAuthorize("@ss.hasPermi('storage:localmaterialoutbound:export')")
    @Log(title = "本地材料出库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwLocalmaterialoutbound awLocalmaterialoutbound)
    {
        List<AwLocalmaterialoutbound> list = awLocalmaterialoutboundService.selectAwLocalmaterialoutboundList(awLocalmaterialoutbound);
        ExcelUtil<AwLocalmaterialoutbound> util = new ExcelUtil<AwLocalmaterialoutbound>(AwLocalmaterialoutbound.class);
        util.exportExcel(response, list, "本地材料出库数据");
    }

    /**
     * 获取本地材料出库详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:localmaterialoutbound:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awLocalmaterialoutboundService.selectAwLocalmaterialoutboundById(id));
    }

    /**
     * 新增本地材料出库
     */
    @PreAuthorize("@ss.hasPermi('storage:localmaterialoutbound:add')")
    @Log(title = "本地材料出库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwLocalmaterialoutbound awLocalmaterialoutbound)
    {
        return toAjax(awLocalmaterialoutboundService.insertAwLocalmaterialoutbound(awLocalmaterialoutbound));
    }

    /**
     * 修改本地材料出库
     */
    @PreAuthorize("@ss.hasPermi('storage:localmaterialoutbound:edit')")
    @Log(title = "本地材料出库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwLocalmaterialoutbound awLocalmaterialoutbound)
    {
        return toAjax(awLocalmaterialoutboundService.updateAwLocalmaterialoutbound(awLocalmaterialoutbound));
    }

    /**
     * 删除本地材料出库
     */
    @PreAuthorize("@ss.hasPermi('storage:localmaterialoutbound:remove')")
    @Log(title = "本地材料出库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awLocalmaterialoutboundService.deleteAwLocalmaterialoutboundByIds(ids));
    }
}
