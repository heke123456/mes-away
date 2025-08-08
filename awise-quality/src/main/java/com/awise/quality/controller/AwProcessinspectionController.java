package com.awise.quality.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.away.common.utils.bean.BeanCopyUtils;

import com.awise.quality.domain.Vo.AwProcessinspectionVo;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
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
import com.awise.quality.domain.AwProcessinspection;
import com.awise.quality.service.IAwProcessinspectionService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 过程检验Controller
 * 
 * @author awise
 * @date 2023-09-27
 */
@RestController
@RequestMapping("/quality/processinspection")
public class AwProcessinspectionController extends BaseController
{
    @Autowired
    private IAwProcessinspectionService awProcessinspectionService;




    /**
     * 查询过程检验列表
     */
    @PreAuthorize("@ss.hasPermi('quality:processinspection:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwProcessinspection awProcessinspection)
    {
        startPage();
        List<AwProcessinspection> list = awProcessinspectionService.selectAwProcessinspectionList(awProcessinspection);
        return getDataTable(list);
    }

    /**
     * 导出过程检验列表
     */
    @PreAuthorize("@ss.hasPermi('quality:processinspection:export')")
    @Log(title = "过程检验", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwProcessinspectionVo awProcessinspectionVo)
    {
        List<AwProcessinspectionVo> list = awProcessinspectionService.selectAwProcessinspectionVoList(awProcessinspectionVo);
        ExcelUtil<AwProcessinspectionVo> util = new ExcelUtil<AwProcessinspectionVo>(AwProcessinspectionVo.class);
        util.exportExcel(response, list, "过程检验数据");
    }

    /**
     * 获取过程检验详细信息
     */
    @PreAuthorize("@ss.hasPermi('quality:processinspection:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awProcessinspectionService.selectAwProcessinspectionById(id));
    }

    /**
     * 新增过程检验
     */
    @PreAuthorize("@ss.hasPermi('quality:processinspection:add')")
    @Log(title = "过程检验", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwProcessinspection awProcessinspection)
    {
        System.out.println(awProcessinspection);
        return toAjax(awProcessinspectionService.insertAwProcessinspection(awProcessinspection));
    }

    /**
     * 修改过程检验
     */
    @PreAuthorize("@ss.hasPermi('quality:processinspection:edit')")
    @Log(title = "过程检验", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwProcessinspection awProcessinspection)
    {
        return toAjax(awProcessinspectionService.updateAwProcessinspection(awProcessinspection));
    }

    /**
     * 删除过程检验
     */
    @PreAuthorize("@ss.hasPermi('quality:processinspection:remove')")
    @Log(title = "过程检验", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awProcessinspectionService.deleteAwProcessinspectionByIds(ids));
    }
}
