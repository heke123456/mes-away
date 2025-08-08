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
import com.awise.storage.domain.AwCsmtinvtdetls;
import com.awise.storage.service.IAwCsmtinvtdetlsService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 客供实时库存Controller
 * 
 * @author awise
 * @date 2023-12-27
 */
@RestController
@RequestMapping("/storage/CsmtInvtDetls")
public class AwCsmtinvtdetlsController extends BaseController
{
    @Autowired
    private IAwCsmtinvtdetlsService awCsmtinvtdetlsService;

    /**
     * 查询客供实时库存列表
     */
    @PreAuthorize("@ss.hasPermi('storage:CsmtInvtDetls:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwCsmtinvtdetls awCsmtinvtdetls)
    {
        startPage();
        List<AwCsmtinvtdetls> list = awCsmtinvtdetlsService.selectAwCsmtinvtdetlsList(awCsmtinvtdetls);
        return getDataTable(list);
    }

    /**
     * 导出客供实时库存列表
     */
    @PreAuthorize("@ss.hasPermi('storage:CsmtInvtDetls:export')")
    @Log(title = "客供实时库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwCsmtinvtdetls awCsmtinvtdetls)
    {
        List<AwCsmtinvtdetls> list = awCsmtinvtdetlsService.selectAwCsmtinvtdetlsList(awCsmtinvtdetls);
        ExcelUtil<AwCsmtinvtdetls> util = new ExcelUtil<AwCsmtinvtdetls>(AwCsmtinvtdetls.class);
        util.exportExcel(response, list, "客供实时库存数据");
    }

    /**
     * 获取客供实时库存详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:CsmtInvtDetls:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awCsmtinvtdetlsService.selectAwCsmtinvtdetlsById(id));
    }

    /**
     * 新增客供实时库存
     */
    @PreAuthorize("@ss.hasPermi('storage:CsmtInvtDetls:add')")
    @Log(title = "客供实时库存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwCsmtinvtdetls awCsmtinvtdetls)
    {
        return toAjax(awCsmtinvtdetlsService.insertAwCsmtinvtdetls(awCsmtinvtdetls));
    }

    /**
     * 修改客供实时库存
     */
    @PreAuthorize("@ss.hasPermi('storage:CsmtInvtDetls:edit')")
    @Log(title = "客供实时库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwCsmtinvtdetls awCsmtinvtdetls)
    {
        return toAjax(awCsmtinvtdetlsService.updateAwCsmtinvtdetls(awCsmtinvtdetls));
    }

    /**
     * 删除客供实时库存
     */
    @PreAuthorize("@ss.hasPermi('storage:CsmtInvtDetls:remove')")
    @Log(title = "客供实时库存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awCsmtinvtdetlsService.deleteAwCsmtinvtdetlsByIds(ids));
    }
}
