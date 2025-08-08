package com.awise.comprehensive.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.awise.comprehensive.domain.AwCustomEn;
import com.awise.comprehensive.domain.AwPartnerEn;
import com.awise.comprehensive.service.IAwPartnerEnService;
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
import com.awise.comprehensive.domain.AwPartner;
import com.awise.comprehensive.service.IAwPartnerService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 合作方信息Controller
 * 
 * @author awise
 * @date 2023-08-02
 */
@RestController
@RequestMapping("/comprehensive/partner")
public class AwPartnerController extends BaseController
{
    @Autowired
    private IAwPartnerService awPartnerService;

    @Autowired
    private IAwPartnerEnService iAwPartnerEnService ;

    /**
     * 查询合作方信息列表
     */
    @PreAuthorize("@ss.hasPermi('comprehensive:partner:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwPartner awPartner)
    {
        startPage();
        List<AwPartner> list = awPartnerService.selectAwPartnerList(awPartner);
        return getDataTable(list);
    }


    /**
     * 查询合作方信息实体列表
     */
    @PreAuthorize("@ss.hasPermi('comprehensive:partner:enlist')")
    @GetMapping("/enlist")
    public TableDataInfo list(AwPartnerEn AwPartneren)
    {
        startPage();
        List<AwPartnerEn> list= iAwPartnerEnService.selectAwPartnerEnList(AwPartneren);
        return getDataTable(list);

    }

    /**
     * 导出合作方信息列表
     */
    @PreAuthorize("@ss.hasPermi('comprehensive:partner:export')")
    @Log(title = "合作方信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwPartner awPartner)
    {
        List<AwPartner> list = awPartnerService.selectAwPartnerList(awPartner);
        ExcelUtil<AwPartner> util = new ExcelUtil<AwPartner>(AwPartner.class);
        util.exportExcel(response, list, "合作方信息数据");
    }

    /**
     * 获取合作方信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('comprehensive:partner:query')")
    @GetMapping(value = "/{ID}")
    public AjaxResult getInfo(@PathVariable("ID") String ID)
    {
        return success(awPartnerService.selectAwPartnerByID(ID));
    }

    /**
     * 新增合作方信息
     */
    @PreAuthorize("@ss.hasPermi('comprehensive:partner:add')")
    @Log(title = "合作方信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwPartner awPartner)
    {
        return toAjax(awPartnerService.insertAwPartner(awPartner));
    }

    /**
     * 修改合作方信息
     */
    @PreAuthorize("@ss.hasPermi('comprehensive:partner:edit')")
    @Log(title = "合作方信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwPartner awPartner)
    {
        return toAjax(awPartnerService.updateAwPartner(awPartner));
    }

    /**
     * 删除合作方信息
     */
    @PreAuthorize("@ss.hasPermi('comprehensive:partner:remove')")
    @Log(title = "合作方信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{IDs}")
    public AjaxResult remove(@PathVariable String[] IDs)
    {
        return toAjax(awPartnerService.deleteAwPartnerByIDs(IDs));
    }
}
