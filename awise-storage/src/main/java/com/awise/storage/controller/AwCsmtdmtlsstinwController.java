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
import com.awise.storage.domain.AwCsmtdmtlsstinw;
import com.awise.storage.service.IAwCsmtdmtlsstinwService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 客供材料入库Controller
 * 
 * @author awise
 * @date 2023-12-26
 */
@RestController
@RequestMapping("/storage/csmtdmtlsstinw")
public class AwCsmtdmtlsstinwController extends BaseController
{
    @Autowired
    private IAwCsmtdmtlsstinwService awCsmtdmtlsstinwService;

    /**
     * 查询客供材料入库列表
     */
    @PreAuthorize("@ss.hasPermi('storage:csmtdmtlsstinw:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwCsmtdmtlsstinw awCsmtdmtlsstinw)
    {
        startPage();
        List<AwCsmtdmtlsstinw> list = awCsmtdmtlsstinwService.selectAwCsmtdmtlsstinwList(awCsmtdmtlsstinw);
        return getDataTable(list);
    }

    /**
     * 导出客供材料入库列表
     */
    @PreAuthorize("@ss.hasPermi('storage:csmtdmtlsstinw:export')")
    @Log(title = "客供材料入库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwCsmtdmtlsstinw awCsmtdmtlsstinw)
    {
        List<AwCsmtdmtlsstinw> list = awCsmtdmtlsstinwService.selectAwCsmtdmtlsstinwList(awCsmtdmtlsstinw);
        ExcelUtil<AwCsmtdmtlsstinw> util = new ExcelUtil<AwCsmtdmtlsstinw>(AwCsmtdmtlsstinw.class);
        util.exportExcel(response, list, "客供材料入库数据");
    }

    /**
     * 获取客供材料入库详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:csmtdmtlsstinw:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awCsmtdmtlsstinwService.selectAwCsmtdmtlsstinwById(id));
    }

    /**
     * 新增客供材料入库
     */
    @PreAuthorize("@ss.hasPermi('storage:csmtdmtlsstinw:add')")
    @Log(title = "客供材料入库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwCsmtdmtlsstinw awCsmtdmtlsstinw)
    {
        return toAjax(awCsmtdmtlsstinwService.insertAwCsmtdmtlsstinw(awCsmtdmtlsstinw));
    }

    /**
     * 修改客供材料入库
     */
    @PreAuthorize("@ss.hasPermi('storage:csmtdmtlsstinw:edit')")
    @Log(title = "客供材料入库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwCsmtdmtlsstinw awCsmtdmtlsstinw)
    {
        return toAjax(awCsmtdmtlsstinwService.updateAwCsmtdmtlsstinw(awCsmtdmtlsstinw));
    }

    /**
     * 删除客供材料入库
     */
    @PreAuthorize("@ss.hasPermi('storage:csmtdmtlsstinw:remove')")
    @Log(title = "客供材料入库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awCsmtdmtlsstinwService.deleteAwCsmtdmtlsstinwByIds(ids));
    }
}
