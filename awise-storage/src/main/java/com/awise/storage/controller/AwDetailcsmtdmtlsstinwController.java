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
import com.awise.storage.domain.AwDetailcsmtdmtlsstinw;
import com.awise.storage.service.IAwDetailcsmtdmtlsstinwService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 客供入库详细Controller
 * 
 * @author awise
 * @date 2023-12-26
 */
@RestController
@RequestMapping("/storage/detailcsmtdmtlsstinw")
public class AwDetailcsmtdmtlsstinwController extends BaseController
{
    @Autowired
    private IAwDetailcsmtdmtlsstinwService awDetailcsmtdmtlsstinwService;

    /**
     * 查询客供入库详细列表
     */
    @PreAuthorize("@ss.hasPermi('storage:detailcsmtdmtlsstinw:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwDetailcsmtdmtlsstinw awDetailcsmtdmtlsstinw)
    {
        startPage();
        List<AwDetailcsmtdmtlsstinw> list = awDetailcsmtdmtlsstinwService.selectAwDetailcsmtdmtlsstinwList(awDetailcsmtdmtlsstinw);
        return getDataTable(list);
    }

    /**
     * 导出客供入库详细列表
     */
    @PreAuthorize("@ss.hasPermi('storage:detailcsmtdmtlsstinw:export')")
    @Log(title = "客供入库详细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwDetailcsmtdmtlsstinw awDetailcsmtdmtlsstinw)
    {
        List<AwDetailcsmtdmtlsstinw> list = awDetailcsmtdmtlsstinwService.selectAwDetailcsmtdmtlsstinwList(awDetailcsmtdmtlsstinw);
        ExcelUtil<AwDetailcsmtdmtlsstinw> util = new ExcelUtil<AwDetailcsmtdmtlsstinw>(AwDetailcsmtdmtlsstinw.class);
        util.exportExcel(response, list, "客供入库详细数据");
    }

    /**
     * 获取客供入库详细详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:detailcsmtdmtlsstinw:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awDetailcsmtdmtlsstinwService.selectAwDetailcsmtdmtlsstinwById(id));
    }

    /**
     * 新增客供入库详细
     */
    @PreAuthorize("@ss.hasPermi('storage:detailcsmtdmtlsstinw:add')")
    @Log(title = "客供入库详细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwDetailcsmtdmtlsstinw awDetailcsmtdmtlsstinw)
    {
        return toAjax(awDetailcsmtdmtlsstinwService.insertAwDetailcsmtdmtlsstinw(awDetailcsmtdmtlsstinw));
    }

    /**
     * 修改客供入库详细
     */
    @PreAuthorize("@ss.hasPermi('storage:detailcsmtdmtlsstinw:edit')")
    @Log(title = "客供入库详细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwDetailcsmtdmtlsstinw awDetailcsmtdmtlsstinw)
    {
        return toAjax(awDetailcsmtdmtlsstinwService.updateAwDetailcsmtdmtlsstinw(awDetailcsmtdmtlsstinw));
    }

    /**
     * 删除客供入库详细
     */
    @PreAuthorize("@ss.hasPermi('storage:detailcsmtdmtlsstinw:remove')")
    @Log(title = "客供入库详细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awDetailcsmtdmtlsstinwService.deleteAwDetailcsmtdmtlsstinwByIds(ids));
    }
}
