package com.awise.order.controller;

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
import com.awise.order.domain.AwOutsourcingorder;
import com.awise.order.service.IAwOutsourcingorderService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 外协Controller
 * 
 * @author awise
 * @date 2023-10-15
 */
@RestController
@RequestMapping("/order/outsourcingorder")
public class AwOutsourcingorderController extends BaseController
{
    @Autowired
    private IAwOutsourcingorderService awOutsourcingorderService;

    /**
     * 查询外协列表
     */
    @PreAuthorize("@ss.hasPermi('order:outsourcingorder:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwOutsourcingorder awOutsourcingorder)
    {
        startPage();
        List<AwOutsourcingorder> list = awOutsourcingorderService.selectAwOutsourcingorderList(awOutsourcingorder);
        return getDataTable(list);
    }

    /**
     * 导出外协列表
     */
    @PreAuthorize("@ss.hasPermi('order:outsourcingorder:export')")
    @Log(title = "外协", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwOutsourcingorder awOutsourcingorder)
    {
        List<AwOutsourcingorder> list = awOutsourcingorderService.selectAwOutsourcingorderList(awOutsourcingorder);
        ExcelUtil<AwOutsourcingorder> util = new ExcelUtil<AwOutsourcingorder>(AwOutsourcingorder.class);
        util.exportExcel(response, list, "外协数据");
    }

    /**
     * 获取外协详细信息
     */
    @PreAuthorize("@ss.hasPermi('order:outsourcingorder:query')")
    @GetMapping(value = "/{outsourcingOrderID}")
    public AjaxResult getInfo(@PathVariable("outsourcingOrderID") String outsourcingOrderID)
    {
        return success(awOutsourcingorderService.selectAwOutsourcingorderByOutsourcingOrderID(outsourcingOrderID));
    }

    /**
     * 新增外协
     */
    @PreAuthorize("@ss.hasPermi('order:outsourcingorder:add')")
    @Log(title = "外协", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwOutsourcingorder awOutsourcingorder)
    {
        return toAjax(awOutsourcingorderService.insertAwOutsourcingorder(awOutsourcingorder));
    }

    /**
     * 修改外协
     */
    @PreAuthorize("@ss.hasPermi('order:outsourcingorder:edit')")
    @Log(title = "外协", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwOutsourcingorder awOutsourcingorder)
    {
        return toAjax(awOutsourcingorderService.updateAwOutsourcingorder(awOutsourcingorder));
    }

    /**
     * 删除外协
     */
    @PreAuthorize("@ss.hasPermi('order:outsourcingorder:remove')")
    @Log(title = "外协", businessType = BusinessType.DELETE)
	@DeleteMapping("/{outsourcingOrderIDs}")
    public AjaxResult remove(@PathVariable String[] outsourcingOrderIDs)
    {
        return toAjax(awOutsourcingorderService.deleteAwOutsourcingorderByOutsourcingOrderIDs(outsourcingOrderIDs));
    }
}
