package com.away.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.away.system.service.IAwCityService;
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
import com.away.system.domain.AwCity;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 城市存储   省，市，县区Controller
 * 
 * @author ruoyi
 * @date 2023-07-26
 */
@RestController
@RequestMapping("/city/city")
public class AwCityController extends BaseController
{
    @Autowired
    private IAwCityService awCityService;

    /**
     * 查询城市存储   省，市，县区列表
     */
    @PreAuthorize("@ss.hasPermi('city:city:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwCity awCity)
    {
        startPage();
        List<AwCity> list = awCityService.selectAwCityList(awCity);
        return getDataTable(list);
    }

    /**
     * 查询城市存储json
     */
    @PreAuthorize("@ss.hasPermi('city:city:json')")
    @GetMapping("/json")
    public String awCityJson(AwCity awCity)
    {
        String aw_city_json = awCityService.selectAwCityJson(awCity);
        return aw_city_json;
    }

    /**
     * 导出城市存储   省，市，县区列表
     */
    @PreAuthorize("@ss.hasPermi('city:city:export')")
    @Log(title = "城市存储   省，市，县区", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwCity awCity)
    {
        List<AwCity> list = awCityService.selectAwCityList(awCity);
        ExcelUtil<AwCity> util = new ExcelUtil<AwCity>(AwCity.class);
        util.exportExcel(response, list, "城市存储   省，市，县区数据");
    }


    /**
     * 获取城市存储   省，市，县区详细信息
     */
    @PreAuthorize("@ss.hasPermi('city:city:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awCityService.selectAwCityById(id));
    }

    /**
     * 新增城市存储   省，市，县区
     */
    @PreAuthorize("@ss.hasPermi('city:city:add')")
    @Log(title = "城市存储   省，市，县区", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwCity awCity)
    {
        return toAjax(awCityService.insertAwCity(awCity));
    }

    /**
     * 修改城市存储   省，市，县区
     */
    @PreAuthorize("@ss.hasPermi('city:city:edit')")
    @Log(title = "城市存储   省，市，县区", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwCity awCity)
    {
        return toAjax(awCityService.updateAwCity(awCity));
    }

    /**
     * 删除城市存储   省，市，县区
     */
    @PreAuthorize("@ss.hasPermi('city:city:remove')")
    @Log(title = "城市存储   省，市，县区", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awCityService.deleteAwCityByIds(ids));
    }
}
