package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.MaterialWarehousingDetailedMapper;
import com.awise.storage.domain.MaterialWarehousingDetailed;
import com.awise.storage.service.IMaterialWarehousingDetailedService;

/**
 * 材料入库详细Service业务层处理
 * 
 * @author awise
 * @date 2023-10-19
 */
@Service
public class MaterialWarehousingDetailedServiceImpl implements IMaterialWarehousingDetailedService 
{
    @Autowired
    private MaterialWarehousingDetailedMapper materialWarehousingDetailedMapper;

    /**
     * 查询材料入库详细
     * 
     * @param warehouseEntryID 材料入库详细主键
     * @return 材料入库详细
     */
    @Override
    public MaterialWarehousingDetailed selectMaterialWarehousingDetailedByWarehouseEntryID(String warehouseEntryID)
    {
        return materialWarehousingDetailedMapper.selectMaterialWarehousingDetailedByWarehouseEntryID(warehouseEntryID);
    }

    /**
     * 查询材料入库详细列表
     * 
     * @param materialWarehousingDetailed 材料入库详细
     * @return 材料入库详细
     */
    @Override
    public List<MaterialWarehousingDetailed> selectMaterialWarehousingDetailedList(MaterialWarehousingDetailed materialWarehousingDetailed)
    {
        return materialWarehousingDetailedMapper.selectMaterialWarehousingDetailedList(materialWarehousingDetailed);
    }

    /**
     * 新增材料入库详细
     * 
     * @param materialWarehousingDetailed 材料入库详细
     * @return 结果
     */
    @Override
    public int insertMaterialWarehousingDetailed(MaterialWarehousingDetailed materialWarehousingDetailed)
    {
        return materialWarehousingDetailedMapper.insertMaterialWarehousingDetailed(materialWarehousingDetailed);
    }

    /**
     * 修改材料入库详细
     * 
     * @param materialWarehousingDetailed 材料入库详细
     * @return 结果
     */
    @Override
    public int updateMaterialWarehousingDetailed(MaterialWarehousingDetailed materialWarehousingDetailed)
    {
        return materialWarehousingDetailedMapper.updateMaterialWarehousingDetailed(materialWarehousingDetailed);
    }

    /**
     * 批量删除材料入库详细
     * 
     * @param warehouseEntryIDs 需要删除的材料入库详细主键
     * @return 结果
     */
    @Override
    public int deleteMaterialWarehousingDetailedByWarehouseEntryIDs(String[] warehouseEntryIDs)
    {
        return materialWarehousingDetailedMapper.deleteMaterialWarehousingDetailedByWarehouseEntryIDs(warehouseEntryIDs);
    }

    /**
     * 删除材料入库详细信息
     * 
     * @param warehouseEntryID 材料入库详细主键
     * @return 结果
     */
    @Override
    public int deleteMaterialWarehousingDetailedByWarehouseEntryID(String warehouseEntryID)
    {
        return materialWarehousingDetailedMapper.deleteMaterialWarehousingDetailedByWarehouseEntryID(warehouseEntryID);
    }
}
