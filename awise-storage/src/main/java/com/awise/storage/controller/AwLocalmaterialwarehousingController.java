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
import com.awise.storage.domain.AwLocalmaterialwarehousing;
import com.awise.storage.service.IAwLocalmaterialwarehousingService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 本地材料入库Controller
 * 
 * @author ruoyi
 * @date 2023-10-14
 */
@RestController
@RequestMapping("/storage/localmaterialwarehousing")
public class AwLocalmaterialwarehousingController extends BaseController
{
    @Autowired
    private IAwLocalmaterialwarehousingService awLocalmaterialwarehousingService;

    /**
     * 查询本地材料入库列表
     */
    @PreAuthorize("@ss.hasPermi('storage:localmaterialwarehousing:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwLocalmaterialwarehousing awLocalmaterialwarehousing)
    {
        startPage();
        List<AwLocalmaterialwarehousing> list = awLocalmaterialwarehousingService.selectAwLocalmaterialwarehousingList(awLocalmaterialwarehousing);
        return getDataTable(list);
    }

    /**
     * 导出本地材料入库列表
     */
    @PreAuthorize("@ss.hasPermi('storage:localmaterialwarehousing:export')")
    @Log(title = "本地材料入库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwLocalmaterialwarehousing awLocalmaterialwarehousing)
    {
        List<AwLocalmaterialwarehousing> list = awLocalmaterialwarehousingService.selectAwLocalmaterialwarehousingList(awLocalmaterialwarehousing);
        ExcelUtil<AwLocalmaterialwarehousing> util = new ExcelUtil<AwLocalmaterialwarehousing>(AwLocalmaterialwarehousing.class);
        util.exportExcel(response, list, "本地材料入库数据");
    }

    /**
     * 获取本地材料入库详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:localmaterialwarehousing:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awLocalmaterialwarehousingService.selectAwLocalmaterialwarehousingById(id));
    }

    /**
     * 新增本地材料入库
     */
    @PreAuthorize("@ss.hasPermi('storage:localmaterialwarehousing:add')")
    @Log(title = "本地材料入库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwLocalmaterialwarehousing awLocalmaterialwarehousing)
    {
        return toAjax(awLocalmaterialwarehousingService.insertAwLocalmaterialwarehousing(awLocalmaterialwarehousing));
    }

    /**
     * 修改本地材料入库
     */
    @PreAuthorize("@ss.hasPermi('storage:localmaterialwarehousing:edit')")
    @Log(title = "本地材料入库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwLocalmaterialwarehousing awLocalmaterialwarehousing)
    {
        return toAjax(awLocalmaterialwarehousingService.updateAwLocalmaterialwarehousing(awLocalmaterialwarehousing));
    }

    /**
     * 删除本地材料入库
     */
    @PreAuthorize("@ss.hasPermi('storage:localmaterialwarehousing:remove')")
    @Log(title = "本地材料入库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awLocalmaterialwarehousingService.deleteAwLocalmaterialwarehousingByIds(ids));
    }
}
