package com.awise.produce.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.away.common.utils.bean.BeanCopyUtils;
import com.awise.produce.domain.AwProductiontasks;
import com.awise.produce.domain.Vo.AwProductiontasklistVo;
import com.awise.produce.domain.Vo.AwProductiontasksVo;
import com.awise.produce.service.IAwProductiontasksService;
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
import com.awise.produce.domain.AwProductiontasklist;
import com.awise.produce.service.IAwProductiontasklistService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 生产任务单Controller
 * 
 * @author awise
 * @date 2023-08-15
 */
@RestController
@RequestMapping("/produce/productiontasklist")
public class AwProductiontasklistController extends BaseController
{
    @Autowired
    private IAwProductiontasklistService awProductiontasklistService;

    @Autowired
    private IAwProductiontasksService awProductiontasksService;

    /**
     * 查询生产任务单列表
     */
    @PreAuthorize("@ss.hasPermi('produce:productiontasklist:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwProductiontasklist awProductiontasklist)
    {
        startPage();
        List<AwProductiontasklist> list = awProductiontasklistService.selectAwProductiontasklistList(awProductiontasklist);
        return getDataTable(list);
    }

    /**
     * 导出生产任务单列表
     */
    @PreAuthorize("@ss.hasPermi('produce:productiontasklist:export')")
    @Log(title = "生产任务单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwProductiontasklist  awProductiontasklist)
    {
        List<AwProductiontasklist> list = awProductiontasklistService.selectAwProductiontasklistList(awProductiontasklist);
        List<AwProductiontasklistVo>  listvo = BeanCopyUtils.copyBeanList(list,AwProductiontasklistVo.class);
        for (AwProductiontasklistVo awProductiontasklistVo : listvo) {

            AwProductiontasksVo awProductiontasksVo = new AwProductiontasksVo();
            awProductiontasksVo.setProductionTasksFormID(awProductiontasklistVo.getId());

            List<AwProductiontasksVo> awProductiontasksVos = awProductiontasksService.selectAwProductiontasksVo(awProductiontasksVo);

            awProductiontasklistVo.setAwProductiontasksVolist(awProductiontasksVos);
        }

        ExcelUtil<AwProductiontasklistVo> util = new ExcelUtil<AwProductiontasklistVo>(AwProductiontasklistVo.class);
        util.exportExcel(response, listvo, "生产任务单数据");
    }

    /**
     * 获取生产任务单详细信息
     */
    @PreAuthorize("@ss.hasPermi('produce:productiontasklist:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(awProductiontasklistService.selectAwProductiontasklistById(id));
    }

    /**
     * 新增生产任务单
     */
    @PreAuthorize("@ss.hasPermi('produce:productiontasklist:add')")
    @Log(title = "生产任务单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwProductiontasklist awProductiontasklist)
    {
        AjaxResult ajaxResult = toAjax(awProductiontasklistService.insertAwProductiontasklist(awProductiontasklist));
        ajaxResult.put("id",awProductiontasklist.getId());
        return ajaxResult;
    }

    /**
     * 修改生产任务单
     */
    @PreAuthorize("@ss.hasPermi('produce:productiontasklist:edit')")
    @Log(title = "生产任务单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwProductiontasklist awProductiontasklist)
    {
        AjaxResult ajaxResult = toAjax(awProductiontasklistService.updateAwProductiontasklist(awProductiontasklist));
        ajaxResult.put("id",awProductiontasklist.getId());
        return ajaxResult;
    }

    /**
     * 删除生产任务单
     */
    @PreAuthorize("@ss.hasPermi('produce:productiontasklist:remove')")
    @Log(title = "生产任务单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(awProductiontasklistService.deleteAwProductiontasklistByIds(ids));
    }
}
