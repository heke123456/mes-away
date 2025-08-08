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
import com.awise.produce.domain.AwProcessingprocess;
import com.awise.produce.service.IAwProcessingprocessService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 加工工序信息Controller
 * 
 * @author awise
 * @date 2023-08-21
 */
@RestController
@RequestMapping("/produce/processingprocess")
public class AwProcessingprocessController extends BaseController
{
    @Autowired
    private IAwProcessingprocessService awProcessingprocessService;

    /**
     * 查询加工工序信息列表
     */
    @PreAuthorize("@ss.hasPermi('produce:processingprocess:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwProcessingprocess awProcessingprocess)
    {
        startPage();
        List<AwProcessingprocess> list = awProcessingprocessService.selectAwProcessingprocessList(awProcessingprocess);
        return getDataTable(list);
    }

    /**
     * 导出加工工序信息列表
     */
    @PreAuthorize("@ss.hasPermi('produce:processingprocess:export')")
    @Log(title = "加工工序信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwProcessingprocess awProcessingprocess)
    {
        List<AwProcessingprocess> list = awProcessingprocessService.selectAwProcessingprocessList(awProcessingprocess);
        ExcelUtil<AwProcessingprocess> util = new ExcelUtil<AwProcessingprocess>(AwProcessingprocess.class);
        util.exportExcel(response, list, "加工工序信息数据");
    }

    /**
     * 获取加工工序信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('produce:processingprocess:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awProcessingprocessService.selectAwProcessingprocessById(id));
    }

    /**
     * 新增加工工序信息
     */
    @PreAuthorize("@ss.hasPermi('produce:processingprocess:add')")
    @Log(title = "加工工序信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwProcessingprocess awProcessingprocess)
    {
        return toAjax(awProcessingprocessService.insertAwProcessingprocess(awProcessingprocess));
    }

    /**
     * 修改加工工序信息
     */
    @PreAuthorize("@ss.hasPermi('produce:processingprocess:edit')")
    @Log(title = "加工工序信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwProcessingprocess awProcessingprocess)
    {
        return toAjax(awProcessingprocessService.updateAwProcessingprocess(awProcessingprocess));
    }

    /**
     * 删除加工工序信息
     */
    @PreAuthorize("@ss.hasPermi('produce:processingprocess:remove')")
    @Log(title = "加工工序信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awProcessingprocessService.deleteAwProcessingprocessByIds(ids));
    }
}
