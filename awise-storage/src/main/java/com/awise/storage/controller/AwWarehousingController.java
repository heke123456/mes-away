package com.awise.storage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.away.common.utils.bean.BeanCopyUtils;
import com.awise.storage.domain.AwMatlwarehousingdet;
import com.awise.storage.domain.MaterialWarehousingDetailed;
import com.awise.storage.domain.Vo.AwWarehousingVo;
import com.awise.storage.service.IAwMatlwarehousingdetService;
import com.awise.storage.service.IMaterialWarehousingDetailedService;
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
import com.awise.storage.domain.AwWarehousing;
import com.awise.storage.service.IAwWarehousingService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 入库单Controller
 * 
 * @author ruoyi
 * @date 2023-10-14
 */
@RestController
@RequestMapping("/system/warehousing")
public class AwWarehousingController extends BaseController
{
    @Autowired
    private IAwWarehousingService awWarehousingService;

    @Autowired
    private IAwMatlwarehousingdetService awMatlwarehousingdetService;

    /**
     * 查询入库单列表
     */
    @PreAuthorize("@ss.hasPermi('storage:warehousing:list')")
    @GetMapping("/list")
    public TableDataInfo list(AwWarehousing awWarehousing)
    {
        startPage();
        List<AwWarehousing> list = awWarehousingService.selectAwWarehousingList(awWarehousing);
        return getDataTable(list);
    }

    /**
     * 导出入库单列表
     */
    @PreAuthorize("@ss.hasPermi('storage:warehousing:export')")
    @Log(title = "入库单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AwWarehousing awWarehousing)
    {
        List<AwWarehousing> list = awWarehousingService.selectAwWarehousingList(awWarehousing);
        ExcelUtil<AwWarehousing> util = new ExcelUtil<AwWarehousing>(AwWarehousing.class);
        util.exportExcel(response, list, "入库单数据");
    }


    /**
     * 导出全部入库单列表
     */
    @PreAuthorize("@ss.hasPermi('storage:warehousing:export')")
    @Log(title = "入库单", businessType = BusinessType.EXPORT)
    @PostMapping("/export/all")
    public void exportAll(HttpServletResponse response, AwWarehousing awWarehousing)
    {
        List<AwWarehousing> list = awWarehousingService.selectAwWarehousingList(awWarehousing);
        List<AwWarehousingVo> awWarehousingVos = BeanCopyUtils.copyBeanList(list, AwWarehousingVo.class);
        for (AwWarehousingVo awWarehousingVo : awWarehousingVos) {
            AwMatlwarehousingdet awMatlwarehousingdet = new AwMatlwarehousingdet();
            awMatlwarehousingdet.setWarehouseEntryID(awWarehousingVo.getWarehouseEntryID());
            List<AwMatlwarehousingdet> awMatlwarehousingdets = awMatlwarehousingdetService.selectAwMatlwarehousingdetList(awMatlwarehousingdet);
            awWarehousingVo.setAwMatlwarehousingdetList(awMatlwarehousingdets);
        }
        ExcelUtil<AwWarehousingVo> util = new ExcelUtil<AwWarehousingVo>(AwWarehousingVo.class);
        util.exportExcel(response, awWarehousingVos, "入库单数据");
    }

    /**
     * 获取入库单详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:warehousing:query')")
    @GetMapping(value = "/{warehouseEntryID}")
    public AjaxResult getInfo(@PathVariable("warehouseEntryID") String warehouseEntryID)
    {
        return success(awWarehousingService.selectAwWarehousingByWarehouseEntryID(warehouseEntryID));
    }

    /**
     * 新增入库单
     */
    @PreAuthorize("@ss.hasPermi('storage:warehousing:add')")
    @Log(title = "入库单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AwWarehousing awWarehousing)
    {
        return toAjax(awWarehousingService.insertAwWarehousing(awWarehousing));
    }

    /**
     * 修改入库单
     */
    @PreAuthorize("@ss.hasPermi('storage:warehousing:edit')")
    @Log(title = "入库单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AwWarehousing awWarehousing)
    {
        return toAjax(awWarehousingService.updateAwWarehousing(awWarehousing));
    }

    /**
     * 删除入库单
     */
    @PreAuthorize("@ss.hasPermi('storage:warehousing:remove')")
    @Log(title = "入库单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{warehouseEntryIDs}")
    public AjaxResult remove(@PathVariable String[] warehouseEntryIDs)
    {
        return toAjax(awWarehousingService.deleteAwWarehousingByWarehouseEntryIDs(warehouseEntryIDs));
    }
}
