package com.awise.storage.service;

import java.util.List;
import com.awise.storage.domain.MaterialWarehousingDetailed;

/**
 * 材料入库详细Service接口
 * 
 * @author awise
 * @date 2023-10-19
 */
public interface IMaterialWarehousingDetailedService 
{
    /**
     * 查询材料入库详细
     * 
     * @param warehouseEntryID 材料入库详细主键
     * @return 材料入库详细
     */
    public MaterialWarehousingDetailed selectMaterialWarehousingDetailedByWarehouseEntryID(String warehouseEntryID);

    /**
     * 查询材料入库详细列表
     * 
     * @param materialWarehousingDetailed 材料入库详细
     * @return 材料入库详细集合
     */
    public List<MaterialWarehousingDetailed> selectMaterialWarehousingDetailedList(MaterialWarehousingDetailed materialWarehousingDetailed);

    /**
     * 新增材料入库详细
     * 
     * @param materialWarehousingDetailed 材料入库详细
     * @return 结果
     */
    public int insertMaterialWarehousingDetailed(MaterialWarehousingDetailed materialWarehousingDetailed);

    /**
     * 修改材料入库详细
     * 
     * @param materialWarehousingDetailed 材料入库详细
     * @return 结果
     */
    public int updateMaterialWarehousingDetailed(MaterialWarehousingDetailed materialWarehousingDetailed);

    /**
     * 批量删除材料入库详细
     * 
     * @param warehouseEntryIDs 需要删除的材料入库详细主键集合
     * @return 结果
     */
    public int deleteMaterialWarehousingDetailedByWarehouseEntryIDs(String[] warehouseEntryIDs);

    /**
     * 删除材料入库详细信息
     * 
     * @param warehouseEntryID 材料入库详细主键
     * @return 结果
     */
    public int deleteMaterialWarehousingDetailedByWarehouseEntryID(String warehouseEntryID);
}
