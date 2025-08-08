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
import com.awise.storage.domain.AwDetailsoftoolstorage;
import com.awise.storage.service.IAwDetailsoftoolstorageService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * DetailsOfToolStorageController
 * 
 * @author awise
 * @date 2023-12-06
 */
@RestController
@RequestMapping("/storage/DetailsOfToolStorage")
public class AwDetailsoftoolstorageController extends BaseController
{
    @Autowired
    private IAwDetailsoftoolstorageService awDetailsoftoolstorageService;

    /**
     * 查询DetailsOfToolStorage列表
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailsOfToolStorage:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwDetailsoftoolstorage awDetailsoftoolstorage)
    {
        startPage();
        List<AwDetailsoftoolstorage> list = awDetailsoftoolstorageService.selectAwDetailsoftoolstorageList(awDetailsoftoolstorage);
        return getDataTable(list);
    }

    /**
     * 导出DetailsOfToolStorage列表
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailsOfToolStorage:export')")
    @Log(title = "DetailsOfToolStorage", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwDetailsoftoolstorage awDetailsoftoolstorage)
    {
        List<AwDetailsoftoolstorage> list = awDetailsoftoolstorageService.selectAwDetailsoftoolstorageList(awDetailsoftoolstorage);
        ExcelUtil<AwDetailsoftoolstorage> util = new ExcelUtil<AwDetailsoftoolstorage>(AwDetailsoftoolstorage.class);
        util.exportExcel(response, list, "DetailsOfToolStorage数据");
    }

    /**
     * 获取DetailsOfToolStorage详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailsOfToolStorage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awDetailsoftoolstorageService.selectAwDetailsoftoolstorageById(id));
    }

    /**
     * 新增DetailsOfToolStorage
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailsOfToolStorage:add')")
    @Log(title = "DetailsOfToolStorage", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwDetailsoftoolstorage awDetailsoftoolstorage)
    {
        return toAjax(awDetailsoftoolstorageService.insertAwDetailsoftoolstorage(awDetailsoftoolstorage));
    }

    /**
     * 修改DetailsOfToolStorage
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailsOfToolStorage:edit')")
    @Log(title = "DetailsOfToolStorage", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwDetailsoftoolstorage awDetailsoftoolstorage)
    {
        return toAjax(awDetailsoftoolstorageService.updateAwDetailsoftoolstorage(awDetailsoftoolstorage));
    }

    /**
     * 删除DetailsOfToolStorage
     */
    @PreAuthorize("@ss.hasPermi('storage:DetailsOfToolStorage:remove')")
    @Log(title = "DetailsOfToolStorage", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awDetailsoftoolstorageService.deleteAwDetailsoftoolstorageByIds(ids));
    }
}
