package com.awise.comprehensive.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.awise.comprehensive.domain.AwContactsEn;
import com.awise.comprehensive.service.IAwContactsEnService;
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
import com.awise.comprehensive.domain.AwContacts;
import com.awise.comprehensive.service.IAwContactsService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 联系人信息Controller
 * 
 * @author ruoyi
 * @date 2023-10-15
 */
@RestController
@RequestMapping("/comprehensive/contacts")
public class AwContactsController extends BaseController
{
    @Autowired
    private IAwContactsService awContactsService;

    @Autowired
    private IAwContactsEnService awContactsEnService;

    /**
     * 查询联系人信息列表
     */
    @PreAuthorize("@ss.hasPermi('comprehensive:contacts:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwContacts awContacts)
    {
        startPage();
        List<AwContacts> list = awContactsService.selectAwContactsList(awContacts);
        return getDataTable(list);
    }


//    扩展
    @PreAuthorize("@ss.hasPermi('comprehensive:contacts:enlist')")
    @GetMapping("/enlist")
    public TableDataInfo list(AwContactsEn awContactsEn)
    {
        startPage();
        List<AwContactsEn> list = awContactsEnService.selectAwContactsEnList(awContactsEn);
        return getDataTable(list);
    }

    /**
     * 导出联系人信息列表
     */
    @PreAuthorize("@ss.hasPermi('comprehensive:contacts:export')")
    @Log(title = "联系人信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwContacts awContacts)
    {
        List<AwContacts> list = awContactsService.selectAwContactsList(awContacts);
        ExcelUtil<AwContacts> util = new ExcelUtil<AwContacts>(AwContacts.class);
        util.exportExcel(response, list, "联系人信息数据");
    }

    /**
     * 获取联系人信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('comprehensive:contacts:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awContactsService.selectAwContactsById(id));
    }

    /**
     * 新增联系人信息
     */
    @PreAuthorize("@ss.hasPermi('comprehensive:contacts:add')")
    @Log(title = "联系人信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwContacts awContacts)
    {
        awContacts.setIsDel("0");
        return toAjax(awContactsService.insertAwContacts(awContacts));
    }

    /**
     * 修改联系人信息
     */
    @PreAuthorize("@ss.hasPermi('comprehensive:contacts:edit')")
    @Log(title = "联系人信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwContacts awContacts)
    {
        return toAjax(awContactsService.updateAwContacts(awContacts));
    }

    /**
     * 删除联系人信息
     */
    @PreAuthorize("@ss.hasPermi('comprehensive:contacts:remove')")
    @Log(title = "联系人信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awContactsService.deleteAwContactsByIds(ids));
    }
}
