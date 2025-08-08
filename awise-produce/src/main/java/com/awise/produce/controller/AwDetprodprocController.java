package com.awise.produce.controller;

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
import com.awise.produce.domain.AwDetprodproc;
import com.awise.produce.service.IAwDetprodprocService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 生产工艺工序详细Controller
 * 
 * @author awise
 * @date 2023-11-02
 */
@RestController
@RequestMapping("/produce/detprodproc")
public class AwDetprodprocController extends BaseController
{
    @Autowired
    private IAwDetprodprocService awDetprodprocService;

    /**
     * 查询生产工艺工序详细列表
     */
    @PreAuthorize("@ss.hasPermi('produce:detprodproc:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwDetprodproc awDetprodproc)
    {
        startPage();
        List<AwDetprodproc> list = awDetprodprocService.selectAwDetprodprocList(awDetprodproc);
        return getDataTable(list);
    }

    /**
     * 导出生产工艺工序详细列表
     */
    @PreAuthorize("@ss.hasPermi('produce:detprodproc:export')")
    @Log(title = "生产工艺工序详细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwDetprodproc awDetprodproc)
    {
        List<AwDetprodproc> list = awDetprodprocService.selectAwDetprodprocList(awDetprodproc);
        ExcelUtil<AwDetprodproc> util = new ExcelUtil<AwDetprodproc>(AwDetprodproc.class);
        util.exportExcel(response, list, "生产工艺工序详细数据");
    }

    /**
     * 获取生产工艺工序详细详细信息
     */
    @PreAuthorize("@ss.hasPermi('produce:detprodproc:query')")
    @GetMapping(value = "/get")
    public AjaxResult getInfo(AwDetprodproc awDetprodproc)
    {
        System.out.println(">>>>>>>>>>>>>>>>>");
        System.out.println(">>>>>>>>>>>>>>>>>");
        System.out.println(">>>>>>>>>>>>>>>>>");
        System.out.println(">>>>>>>>>>>>>>>>>");
        System.out.println(awDetprodproc);
        System.out.println(awDetprodprocService.selectAwDetprodproc(awDetprodproc));
        System.out.println(">>>>>>>>>>>>>>>>>");
        System.out.println(">>>>>>>>>>>>>>>>>");
        System.out.println(">>>>>>>>>>>>>>>>>");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        return success(awDetprodprocService.selectAwDetprodproc(awDetprodproc));
    }

    /**
     * 新增生产工艺工序详细
     */
    @PreAuthorize("@ss.hasPermi('produce:detprodproc:add')")
    @Log(title = "生产工艺工序详细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwDetprodproc awDetprodproc)
    {
        return toAjax(awDetprodprocService.insertAwDetprodproc(awDetprodproc));
    }

    /**
     * 修改生产工艺工序详细
     */
    @PreAuthorize("@ss.hasPermi('produce:detprodproc:edit')")
    @Log(title = "生产工艺工序详细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwDetprodproc awDetprodproc)
    {
        return toAjax(awDetprodprocService.updateAwDetprodproc(awDetprodproc));
    }

    /**
     * 删除生产工艺工序详细
     */
    @PreAuthorize("@ss.hasPermi('produce:detprodproc:remove')")
    @Log(title = "生产工艺工序详细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{productionTasksFormIDs}")
    public AjaxResult remove(@PathVariable Long[] productionTasksFormIDs)
    {
        return toAjax(awDetprodprocService.deleteAwDetprodprocByProductionTasksFormIDs(productionTasksFormIDs));
    }
}
