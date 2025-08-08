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
import com.awise.storage.domain.AwDetailcustomermaterialoutbound;
import com.awise.storage.service.IAwDetailcustomermaterialoutboundService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 客供材料出库详细Controller
 * 
 * @author awise
 * @date 2024-04-23
 */
@RestController
@RequestMapping("/storage/DetailCustomerMaterialOutbound")
public class AwDetailcustomermaterialoutboundController extends BaseController
{
    @Autowired
    private IAwDetailcustomermaterialoutboundService awDetailcustomermaterialoutboundService;

    /**
     * 查询客供材料出库详细列表
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailCustomerMaterialOutbound:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwDetailcustomermaterialoutbound awDetailcustomermaterialoutbound)
    {
        startPage();
        List<AwDetailcustomermaterialoutbound> list = awDetailcustomermaterialoutboundService.selectAwDetailcustomermaterialoutboundList(awDetailcustomermaterialoutbound);
        return getDataTable(list);
    }

    /**
     * 导出客供材料出库详细列表
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailCustomerMaterialOutbound:export')")
    @Log(title = "客供材料出库详细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwDetailcustomermaterialoutbound awDetailcustomermaterialoutbound)
    {
        List<AwDetailcustomermaterialoutbound> list = awDetailcustomermaterialoutboundService.selectAwDetailcustomermaterialoutboundList(awDetailcustomermaterialoutbound);
        ExcelUtil<AwDetailcustomermaterialoutbound> util = new ExcelUtil<AwDetailcustomermaterialoutbound>(AwDetailcustomermaterialoutbound.class);
        util.exportExcel(response, list, "客供材料出库详细数据");
    }

    /**
     * 获取客供材料出库详细详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailCustomerMaterialOutbound:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awDetailcustomermaterialoutboundService.selectAwDetailcustomermaterialoutboundById(id));
    }

    /**
     * 新增客供材料出库详细
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailCustomerMaterialOutbound:add')")
    @Log(title = "客供材料出库详细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwDetailcustomermaterialoutbound awDetailcustomermaterialoutbound)
    {
        return toAjax(awDetailcustomermaterialoutboundService.insertAwDetailcustomermaterialoutbound(awDetailcustomermaterialoutbound));
    }

    /**
     * 修改客供材料出库详细
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailCustomerMaterialOutbound:edit')")
    @Log(title = "客供材料出库详细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwDetailcustomermaterialoutbound awDetailcustomermaterialoutbound)
    {
        return toAjax(awDetailcustomermaterialoutboundService.updateAwDetailcustomermaterialoutbound(awDetailcustomermaterialoutbound));
    }

    /**
     * 删除客供材料出库详细
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailCustomerMaterialOutbound:remove')")
    @Log(title = "客供材料出库详细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awDetailcustomermaterialoutboundService.deleteAwDetailcustomermaterialoutboundByIds(ids));
    }
}
