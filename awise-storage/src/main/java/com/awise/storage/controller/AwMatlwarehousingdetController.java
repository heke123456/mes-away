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
import com.awise.storage.domain.AwMatlwarehousingdet;
import com.awise.storage.service.IAwMatlwarehousingdetService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 材料入库详细Controller
 * 
 * @author awise
 * @date 2023-10-25
 */
@RestController
@RequestMapping("/storage/matlwarehousingdet")
public class AwMatlwarehousingdetController extends BaseController
{
    @Autowired
    private IAwMatlwarehousingdetService awMatlwarehousingdetService;

    /**
     * 查询材料入库详细列表
     */
    @PreAuthorize("@ss.hasPermi('storage:matlwarehousingdet:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwMatlwarehousingdet awMatlwarehousingdet)
    {
        startPage();
        List<AwMatlwarehousingdet> list = awMatlwarehousingdetService.selectAwMatlwarehousingdetList(awMatlwarehousingdet);
        return getDataTable(list);
    }

    /**
     * 导出材料入库详细列表
     */
    @PreAuthorize("@ss.hasPermi('storage:matlwarehousingdet:export')")
    @Log(title = "材料入库详细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwMatlwarehousingdet awMatlwarehousingdet)
    {
        List<AwMatlwarehousingdet> list = awMatlwarehousingdetService.selectAwMatlwarehousingdetList(awMatlwarehousingdet);
        ExcelUtil<AwMatlwarehousingdet> util = new ExcelUtil<AwMatlwarehousingdet>(AwMatlwarehousingdet.class);
        util.exportExcel(response, list, "材料入库详细数据");
    }

    /**
     * 获取材料入库详细详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:matlwarehousingdet:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awMatlwarehousingdetService.selectAwMatlwarehousingdetById(id));
    }

    /**
     * 新增材料入库详细
     */
    @PreAuthorize("@ss.hasPermi('storage:matlwarehousingdet:add')")
    @Log(title = "材料入库详细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwMatlwarehousingdet awMatlwarehousingdet)
    {
        return toAjax(awMatlwarehousingdetService.insertAwMatlwarehousingdet(awMatlwarehousingdet));
    }

    /**
     * 修改材料入库详细
     */
    @PreAuthorize("@ss.hasPermi('storage:matlwarehousingdet:edit')")
    @Log(title = "材料入库详细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwMatlwarehousingdet awMatlwarehousingdet)
    {
        return toAjax(awMatlwarehousingdetService.updateAwMatlwarehousingdet(awMatlwarehousingdet));
    }

    /**
     * 删除材料入库详细
     */
    @PreAuthorize("@ss.hasPermi('storage:matlwarehousingdet:remove')")
    @Log(title = "材料入库详细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awMatlwarehousingdetService.deleteAwMatlwarehousingdetByIds(ids));
    }
}
