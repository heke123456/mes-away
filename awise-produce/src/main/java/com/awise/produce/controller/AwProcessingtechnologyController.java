package com.awise.produce.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.awise.produce.domain.Vo.AwProcessingtechnologyVo;
import com.awise.produce.service.IAwProcessingtechnologyServiceVo;
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
import com.awise.produce.domain.AwProcessingtechnology;
import com.awise.produce.service.IAwProcessingtechnologyService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 加工工艺信息Controller
 * 
 * @author awise
 * @date 2023-09-26
 */
@RestController
@RequestMapping("/produce/processingtechnology")
public class AwProcessingtechnologyController extends BaseController
{
    @Autowired
    private IAwProcessingtechnologyService awProcessingtechnologyService;

    @Autowired
    private IAwProcessingtechnologyServiceVo  awProcessingtechnologyServiceVo;

    /**
     * 查询加工工艺信息列表
     */
    @PreAuthorize("@ss.hasPermi('produce:processingtechnology:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwProcessingtechnology awProcessingtechnology)
    {
        startPage();
        List<AwProcessingtechnology> list = awProcessingtechnologyService.selectAwProcessingtechnologyList(awProcessingtechnology);
        return getDataTable(list);
    }

    /**
     * 导出加工工艺信息列表
     */
    @PreAuthorize("@ss.hasPermi('produce:processingtechnology:export')")
    @Log(title = "加工工艺信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwProcessingtechnology awProcessingtechnology)
    {
        List<AwProcessingtechnologyVo> list = awProcessingtechnologyServiceVo.selectAwProcessingtechnologyListVO(awProcessingtechnology);
        ExcelUtil<AwProcessingtechnologyVo> util = new ExcelUtil<AwProcessingtechnologyVo>(AwProcessingtechnologyVo.class);
        util.exportExcel(response, list, "加工工艺信息数据");
    }

    /**
     * 获取加工工艺信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('produce:processingtechnology:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {


        AwProcessingtechnology awProcessingtechnology = awProcessingtechnologyService.selectAwProcessingtechnologyById(id);
        return success(awProcessingtechnology);
    }

    /**
     * 新增加工工艺信息
     */
    @PreAuthorize("@ss.hasPermi('produce:processingtechnology:add')")
    @Log(title = "加工工艺信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwProcessingtechnology awProcessingtechnology)
    {
        return toAjax(awProcessingtechnologyService.insertAwProcessingtechnology(awProcessingtechnology));
    }

    /**
     * 修改加工工艺信息
     */
    @PreAuthorize("@ss.hasPermi('produce:processingtechnology:edit')")
    @Log(title = "加工工艺信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwProcessingtechnology awProcessingtechnology)
    {
        return toAjax(awProcessingtechnologyService.updateAwProcessingtechnology(awProcessingtechnology));
    }

    /**
     * 删除加工工艺信息
     */
    @PreAuthorize("@ss.hasPermi('produce:processingtechnology:remove')")
    @Log(title = "加工工艺信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(awProcessingtechnologyService.deleteAwProcessingtechnologyByIds(ids));
    }



    /**
     * 获取加工工艺信息扩展详细信息
     */
    @PreAuthorize("@ss.hasPermi('produce:processingtechnology:query')")
    @GetMapping(value = "/vo/{id}")
    public AjaxResult getInfoVo(@PathVariable("id") String id)
    {



        AwProcessingtechnologyVo awProcessingtechnologyVo = awProcessingtechnologyServiceVo.selectAwProcessingtechnologyByIdVO(id);
        return success(awProcessingtechnologyVo);
    }


    /**
     * 查询加工工艺信息列表
     */
    @PreAuthorize("@ss.hasPermi('produce:processingtechnology:list')")
    @GetMapping("/vo/list")
    public TableDataInfo listVo(AwProcessingtechnology awProcessingtechnology)
    {
        startPage();
        List<AwProcessingtechnologyVo> list = awProcessingtechnologyServiceVo.selectAwProcessingtechnologyListVO(awProcessingtechnology);
        return getDataTable(list);
    }


}
