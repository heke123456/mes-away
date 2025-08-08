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
import com.awise.storage.domain.AwDetailsoftooldelivery;
import com.awise.storage.service.IAwDetailsoftooldeliveryService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 刀具出库详细Controller
 * 
 * @author awise
 * @date 2023-12-08
 */
@RestController
@RequestMapping("/storage/DetailsOfToolDelivery")
public class AwDetailsoftooldeliveryController extends BaseController
{
    @Autowired
    private IAwDetailsoftooldeliveryService awDetailsoftooldeliveryService;

    /**
     * 查询刀具出库详细列表
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailsOfToolDelivery:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwDetailsoftooldelivery awDetailsoftooldelivery)
    {
        startPage();
        List<AwDetailsoftooldelivery> list = awDetailsoftooldeliveryService.selectAwDetailsoftooldeliveryList(awDetailsoftooldelivery);
        return getDataTable(list);
    }

    /**
     * 导出刀具出库详细列表
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailsOfToolDelivery:export')")
    @Log(title = "刀具出库详细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwDetailsoftooldelivery awDetailsoftooldelivery)
    {
        List<AwDetailsoftooldelivery> list = awDetailsoftooldeliveryService.selectAwDetailsoftooldeliveryList(awDetailsoftooldelivery);
        ExcelUtil<AwDetailsoftooldelivery> util = new ExcelUtil<AwDetailsoftooldelivery>(AwDetailsoftooldelivery.class);
        util.exportExcel(response, list, "刀具出库详细数据");
    }

    /**
     * 获取刀具出库详细详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailsOfToolDelivery:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awDetailsoftooldeliveryService.selectAwDetailsoftooldeliveryById(id));
    }

    /**
     * 新增刀具出库详细
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailsOfToolDelivery:add')")
    @Log(title = "刀具出库详细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwDetailsoftooldelivery awDetailsoftooldelivery)
    {
        return toAjax(awDetailsoftooldeliveryService.insertAwDetailsoftooldelivery(awDetailsoftooldelivery));
    }

    /**
     * 修改刀具出库详细
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailsOfToolDelivery:edit')")
    @Log(title = "刀具出库详细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwDetailsoftooldelivery awDetailsoftooldelivery)
    {
        return toAjax(awDetailsoftooldeliveryService.updateAwDetailsoftooldelivery(awDetailsoftooldelivery));
    }

    /**
     * 删除刀具出库详细
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailsOfToolDelivery:remove')")
    @Log(title = "刀具出库详细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awDetailsoftooldeliveryService.deleteAwDetailsoftooldeliveryByIds(ids));
    }
}
