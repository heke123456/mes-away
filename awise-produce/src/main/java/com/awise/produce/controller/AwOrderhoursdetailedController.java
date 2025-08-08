package com.awise.produce.controller;

import com.away.common.annotation.Log;
import com.away.common.core.controller.BaseController;
import com.away.common.core.domain.AjaxResult;
import com.away.common.core.domain.BaseEntity;
import com.away.common.core.page.TableDataInfo;
import com.away.common.enums.BusinessType;
import com.away.common.utils.bean.BeanCopyUtils;
import com.away.common.utils.poi.ExcelUtil;
import com.awise.produce.domain.AwOrderhoursdetailed;
import com.awise.produce.domain.AwProductmanhour;
import com.awise.produce.domain.Vo.AwOrderhoursdetailedVo;
import com.awise.produce.service.IAwOrderhoursdetailedService;
import com.awise.produce.service.IAwProductmanhourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 工时统计Controller
 * 
 * @author awise
 * @date 2024-03-15
 */
@RestController
@RequestMapping("/produce/orderhoursdetailed")
public class AwOrderhoursdetailedController extends BaseController
{
    @Autowired
    private IAwOrderhoursdetailedService awOrderhoursdetailedService;

    @Autowired
    private IAwProductmanhourService awProductmanhourService;

    /**
     * 查询工时统计列表
     */
    @PreAuthorize("@ss.hasPermi('produce:orderhoursdetailed:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwOrderhoursdetailed awOrderhoursdetailed)
    {
        startPage();
        List<AwOrderhoursdetailed> list = awOrderhoursdetailedService.selectAwOrderhoursdetailedList(awOrderhoursdetailed);
        return getDataTable(list);
    }

    /**
     * 导出工时统计列表
     */
    @PreAuthorize("@ss.hasPermi('produce:orderhoursdetailed:export')")
    @Log(title = "工时统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwOrderhoursdetailed awOrderhoursdetailed)
    {
        List<AwOrderhoursdetailed> list = awOrderhoursdetailedService.selectAwOrderhoursdetailedList(awOrderhoursdetailed);
        List<AwOrderhoursdetailedVo> awOrderhoursdetailedVos = BeanCopyUtils.copyBeanList(list, AwOrderhoursdetailedVo.class);
        for (AwOrderhoursdetailedVo awOrderhoursdetailedVo : awOrderhoursdetailedVos) {
            AwProductmanhour awProductmanhour = new AwProductmanhour();
            awProductmanhour.setSaleorderID(awOrderhoursdetailedVo.getId());
            List<AwProductmanhour> awProductmanhours = awProductmanhourService.selectAwProductmanhourList(awProductmanhour);
            awOrderhoursdetailedVo.setAwProductmanhourList(awProductmanhours);
        }
        ExcelUtil<AwOrderhoursdetailedVo> util = new ExcelUtil<AwOrderhoursdetailedVo>(AwOrderhoursdetailedVo.class);
        util.exportExcel(response, awOrderhoursdetailedVos, "工时统计数据");
    }

    /**
     * 获取工时统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('produce:orderhoursdetailed:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(awOrderhoursdetailedService.selectAwOrderhoursdetailedById(id));
    }

    /**
     * 新增工时统计
     */
    @PreAuthorize("@ss.hasPermi('produce:orderhoursdetailed:add')")
    @Log(title = "工时统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwOrderhoursdetailed awOrderhoursdetailed)
    {
        return toAjax(awOrderhoursdetailedService.insertAwOrderhoursdetailed(awOrderhoursdetailed));
    }

    /**
     * 修改工时统计
     */
    @PreAuthorize("@ss.hasPermi('produce:orderhoursdetailed:edit')")
    @Log(title = "工时统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwOrderhoursdetailed awOrderhoursdetailed)
    {
        return toAjax(awOrderhoursdetailedService.updateAwOrderhoursdetailed(awOrderhoursdetailed));
    }

    /**
     * 删除工时统计
     */
    @PreAuthorize("@ss.hasPermi('produce:orderhoursdetailed:remove')")
    @Log(title = "工时统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(awOrderhoursdetailedService.deleteAwOrderhoursdetailedByIds(ids));
    }
}
