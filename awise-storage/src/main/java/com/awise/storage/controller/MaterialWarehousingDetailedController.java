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
import com.awise.storage.domain.MaterialWarehousingDetailed;
import com.awise.storage.service.IMaterialWarehousingDetailedService;
import com.away.common.utils.poi.ExcelUtil;
import com.away.common.core.page.TableDataInfo;

/**
 * 材料入库详细Controller
 * 
 * @author awise
 * @date 2023-10-19
 */
@RestController
@RequestMapping("/storage/materialWarehousingDetailed")
public class MaterialWarehousingDetailedController extends BaseController
{
    @Autowired
    private IMaterialWarehousingDetailedService materialWarehousingDetailedService;

    /**
     * 查询材料入库详细列表
     */
    @PreAuthorize("@ss.hasPermi('storage:materialWarehousingDetailed:list')")
    @GetMapping("/list")
    public TableDataInfo list(MaterialWarehousingDetailed materialWarehousingDetailed)
    {
        startPage();
        List<MaterialWarehousingDetailed> list = materialWarehousingDetailedService.selectMaterialWarehousingDetailedList(materialWarehousingDetailed);
        return getDataTable(list);
    }

    /**
     * 导出材料入库详细列表
     */
    @PreAuthorize("@ss.hasPermi('storage:materialWarehousingDetailed:export')")
    @Log(title = "材料入库详细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MaterialWarehousingDetailed materialWarehousingDetailed)
    {
        List<MaterialWarehousingDetailed> list = materialWarehousingDetailedService.selectMaterialWarehousingDetailedList(materialWarehousingDetailed);
        ExcelUtil<MaterialWarehousingDetailed> util = new ExcelUtil<MaterialWarehousingDetailed>(MaterialWarehousingDetailed.class);
        util.exportExcel(response, list, "材料入库详细数据");
    }

    /**
     * 获取材料入库详细详细信息
     */
    @PreAuthorize("@ss.hasPermi('storage:materialWarehousingDetailed:query')")
    @GetMapping(value = "/{warehouseEntryID}")
    public AjaxResult getInfo(@PathVariable("warehouseEntryID") String warehouseEntryID)
    {
        return success(materialWarehousingDetailedService.selectMaterialWarehousingDetailedByWarehouseEntryID(warehouseEntryID));
    }

    /**
     * 新增材料入库详细
     */
    @PreAuthorize("@ss.hasPermi('storage:materialWarehousingDetailed:add')")
    @Log(title = "材料入库详细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MaterialWarehousingDetailed materialWarehousingDetailed)
    {
        return toAjax(materialWarehousingDetailedService.insertMaterialWarehousingDetailed(materialWarehousingDetailed));
    }

    /**
     * 修改材料入库详细
     */
    @PreAuthorize("@ss.hasPermi('storage:materialWarehousingDetailed:edit')")
    @Log(title = "材料入库详细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MaterialWarehousingDetailed materialWarehousingDetailed)
    {
        return toAjax(materialWarehousingDetailedService.updateMaterialWarehousingDetailed(materialWarehousingDetailed));
    }

    /**
     * 删除材料入库详细
     */
    @PreAuthorize("@ss.hasPermi('storage:materialWarehousingDetailed:remove')")
    @Log(title = "材料入库详细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{warehouseEntryIDs}")
    public AjaxResult remove(@PathVariable String[] warehouseEntryIDs)
    {
        return toAjax(materialWarehousingDetailedService.deleteMaterialWarehousingDetailedByWarehouseEntryIDs(warehouseEntryIDs));
    }
}
