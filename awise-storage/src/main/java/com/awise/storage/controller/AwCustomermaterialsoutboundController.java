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
import com.awise.storage.domain.AwCustomermaterialsoutbound;
import com.awise.storage.service.IAwCustomermaterialsoutboundService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 客供材料材料出库Controller
 * 
 * @author awise
 * @date 2024-04-23
 */
@RestController
@RequestMapping("/storage/CustomerMaterialsOutbound")
public class AwCustomermaterialsoutboundController extends BaseController
{
    @Autowired
    private IAwCustomermaterialsoutboundService awCustomermaterialsoutboundService;

    /**
     * 查询客供材料材料出库列表
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsOutbound:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwCustomermaterialsoutbound awCustomermaterialsoutbound)
    {
        startPage();
        List<AwCustomermaterialsoutbound> list = awCustomermaterialsoutboundService.selectAwCustomermaterialsoutboundList(awCustomermaterialsoutbound);
        return getDataTable(list);
    }

    /**
     * 导出客供材料材料出库列表
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsOutbound:export')")
    @Log(title = "客供材料材料出库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwCustomermaterialsoutbound awCustomermaterialsoutbound)
    {
        List<AwCustomermaterialsoutbound> list = awCustomermaterialsoutboundService.selectAwCustomermaterialsoutboundList(awCustomermaterialsoutbound);
        ExcelUtil<AwCustomermaterialsoutbound> util = new ExcelUtil<AwCustomermaterialsoutbound>(AwCustomermaterialsoutbound.class);
        util.exportExcel(response, list, "客供材料材料出库数据");
    }

    /**
     * 获取客供材料材料出库详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsOutbound:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awCustomermaterialsoutboundService.selectAwCustomermaterialsoutboundById(id));
    }

    /**
     * 新增客供材料材料出库
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsOutbound:add')")
    @Log(title = "客供材料材料出库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwCustomermaterialsoutbound awCustomermaterialsoutbound)
    {
        return toAjax(awCustomermaterialsoutboundService.insertAwCustomermaterialsoutbound(awCustomermaterialsoutbound));
    }

    /**
     * 修改客供材料材料出库
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsOutbound:edit')")
    @Log(title = "客供材料材料出库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwCustomermaterialsoutbound awCustomermaterialsoutbound)
    {
        return toAjax(awCustomermaterialsoutboundService.updateAwCustomermaterialsoutbound(awCustomermaterialsoutbound));
    }

    /**
     * 删除客供材料材料出库
     */
    @PreAuthorize("@ss.hasPermi('storage:CustomerMaterialsOutbound:remove')")
    @Log(title = "客供材料材料出库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awCustomermaterialsoutboundService.deleteAwCustomermaterialsoutboundByIds(ids));
    }
}
