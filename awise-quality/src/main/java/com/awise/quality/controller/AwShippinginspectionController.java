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
import com.awise.quality.domain.AwShippinginspection;
import com.awise.quality.service.IAwShippinginspectionService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 成品出货检验Controller
 * 
 * @author awise
 * @date 2023-10-16
 */
@RestController
@RequestMapping("/quality/shippinginspection")
public class AwShippinginspectionController extends BaseController
{
    @Autowired
    private IAwShippinginspectionService awShippinginspectionService;

    /**
     * 查询成品出货检验列表
     */
    @PreAuthorize("@ss.hasPermi('quality:shippinginspection:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwShippinginspection awShippinginspection)
    {
        startPage();
        List<AwShippinginspection> list = awShippinginspectionService.selectAwShippinginspectionList(awShippinginspection);
        return getDataTable(list);
    }

    /**
     * 导出成品出货检验列表
     */
    @PreAuthorize("@ss.hasPermi('quality:shippinginspection:export')")
    @Log(title = "成品出货检验", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwShippinginspection awShippinginspection)
    {
        List<AwShippinginspection> list = awShippinginspectionService.selectAwShippinginspectionList(awShippinginspection);
        ExcelUtil<AwShippinginspection> util = new ExcelUtil<AwShippinginspection>(AwShippinginspection.class);
        util.exportExcel(response, list, "成品出货检验数据");
    }

    /**
     * 获取成品出货检验详细信息
     */
    @PreAuthorize("@ss.hasPermi('quality:shippinginspection:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(awShippinginspectionService.selectAwShippinginspectionById(id));
    }

    /**
     * 新增成品出货检验
     */
    @PreAuthorize("@ss.hasPermi('quality:shippinginspection:add')")
    @Log(title = "成品出货检验", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwShippinginspection awShippinginspection)
    {
        return toAjax(awShippinginspectionService.insertAwShippinginspection(awShippinginspection));
    }

    /**
     * 修改成品出货检验
     */
    @PreAuthorize("@ss.hasPermi('quality:shippinginspection:edit')")
    @Log(title = "成品出货检验", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwShippinginspection awShippinginspection)
    {
        return toAjax(awShippinginspectionService.updateAwShippinginspection(awShippinginspection));
    }

    /**
     * 删除成品出货检验
     */
    @PreAuthorize("@ss.hasPermi('quality:shippinginspection:remove')")
    @Log(title = "成品出货检验", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(awShippinginspectionService.deleteAwShippinginspectionByIds(ids));
    }
}
