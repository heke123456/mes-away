package com.awise.quality.controller;

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
import com.awise.quality.domain.AwFinishedproductinspection;
import com.awise.quality.service.IAwFinishedproductinspectionService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 成品检验Controller
 * 
 * @author awise
 * @date 2023-10-16
 */
@RestController
@RequestMapping("/quality/finishedproductinspection")
public class AwFinishedproductinspectionController extends BaseController
{
    @Autowired
    private IAwFinishedproductinspectionService awFinishedproductinspectionService;

    /**
     * 查询成品检验列表
     */
    @PreAuthorize("@ss.hasPermi('quality:finishedproductinspection:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwFinishedproductinspection awFinishedproductinspection)
    {
        startPage();
        List<AwFinishedproductinspection> list = awFinishedproductinspectionService.selectAwFinishedproductinspectionList(awFinishedproductinspection);
        return getDataTable(list);
    }

    /**
     * 导出成品检验列表
     */
    @PreAuthorize("@ss.hasPermi('quality:finishedproductinspection:export')")
    @Log(title = "成品检验", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwFinishedproductinspection awFinishedproductinspection)
    {
        List<AwFinishedproductinspection> list = awFinishedproductinspectionService.selectAwFinishedproductinspectionList(awFinishedproductinspection);
        ExcelUtil<AwFinishedproductinspection> util = new ExcelUtil<AwFinishedproductinspection>(AwFinishedproductinspection.class);
        util.exportExcel(response, list, "成品检验数据");
    }

    /**
     * 获取成品检验详细信息
     */
    @PreAuthorize("@ss.hasPermi('quality:finishedproductinspection:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(awFinishedproductinspectionService.selectAwFinishedproductinspectionById(id));
    }

    /**
     * 新增成品检验
     */
    @PreAuthorize("@ss.hasPermi('quality:finishedproductinspection:add')")
    @Log(title = "成品检验", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwFinishedproductinspection awFinishedproductinspection)
    {
        return toAjax(awFinishedproductinspectionService.insertAwFinishedproductinspection(awFinishedproductinspection));
    }

    /**
     * 修改成品检验
     */
    @PreAuthorize("@ss.hasPermi('quality:finishedproductinspection:edit')")
    @Log(title = "成品检验", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwFinishedproductinspection awFinishedproductinspection)
    {
        return toAjax(awFinishedproductinspectionService.updateAwFinishedproductinspection(awFinishedproductinspection));
    }

    /**
     * 删除成品检验
     */
    @PreAuthorize("@ss.hasPermi('quality:finishedproductinspection:remove')")
    @Log(title = "成品检验", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(awFinishedproductinspectionService.deleteAwFinishedproductinspectionByIds(ids));
    }
}
