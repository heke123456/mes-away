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
import com.awise.storage.domain.AwMatloutbounddet;
import com.awise.storage.service.IAwMatloutbounddetService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 材料出库详细Controller
 * 
 * @author awise
 * @date 2023-10-25
 */
@RestController
@RequestMapping("/storage/matloutbounddet")
public class AwMatloutbounddetController extends BaseController
{
    @Autowired
    private IAwMatloutbounddetService awMatloutbounddetService;

    /**
     * 查询材料出库详细列表
     */
    @PreAuthorize("@ss.hasPermi('storage:matloutbounddet:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwMatloutbounddet awMatloutbounddet)
    {
        startPage();
        List<AwMatloutbounddet> list = awMatloutbounddetService.selectAwMatloutbounddetList(awMatloutbounddet);
        return getDataTable(list);
    }

    /**
     * 导出材料出库详细列表
     */
    @PreAuthorize("@ss.hasPermi('storage:matloutbounddet:export')")
    @Log(title = "材料出库详细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwMatloutbounddet awMatloutbounddet)
    {
        List<AwMatloutbounddet> list = awMatloutbounddetService.selectAwMatloutbounddetList(awMatloutbounddet);
        ExcelUtil<AwMatloutbounddet> util = new ExcelUtil<AwMatloutbounddet>(AwMatloutbounddet.class);
        util.exportExcel(response, list, "材料出库详细数据");
    }

    /**
     * 获取材料出库详细详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:matloutbounddet:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awMatloutbounddetService.selectAwMatloutbounddetById(id));
    }

    /**
     * 新增材料出库详细
     */
    @PreAuthorize("@ss.hasPermi('storage:matloutbounddet:add')")
    @Log(title = "材料出库详细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwMatloutbounddet awMatloutbounddet)
    {
        return toAjax(awMatloutbounddetService.insertAwMatloutbounddet(awMatloutbounddet));
    }

    /**
     * 修改材料出库详细
     */
    @PreAuthorize("@ss.hasPermi('storage:matloutbounddet:edit')")
    @Log(title = "材料出库详细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwMatloutbounddet awMatloutbounddet)
    {
        return toAjax(awMatloutbounddetService.updateAwMatloutbounddet(awMatloutbounddet));
    }

    /**
     * 删除材料出库详细
     */
    @PreAuthorize("@ss.hasPermi('storage:matloutbounddet:remove')")
    @Log(title = "材料出库详细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awMatloutbounddetService.deleteAwMatloutbounddetByIds(ids));
    }
}
