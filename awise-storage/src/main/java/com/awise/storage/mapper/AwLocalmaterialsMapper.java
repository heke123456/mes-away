package com.awise.storage.mapper;

import java.util.List;
import com.awise.storage.domain.AwLocalmaterials;

/**
 * 本地材料实时库存Mapper接口
 * 
 * @author awise
 * @date 2023-08-03
 */
public interface AwLocalmaterialsMapper 
{
    /**
     * 查询本地材料实时库存
     * 
     * @param id 本地材料实时库存主键
     * @return 本地材料实时库存
     */
    public AwLocalmaterials selectAwLocalmaterialsById(Long id);

    /**
     * 查询本地材料实时库存列表
     * 
     * @param awLocalmaterials 本地材料实时库存
     * @return 本地材料实时库存集合
     */
    public List<AwLocalmaterials> selectAwLocalmaterialsList(AwLocalmaterials awLocalmaterials);

    /**
     * 新增本地材料实时库存
     * 
     * @param awLocalmaterials 本地材料实时库存
     * @return 结果
     */
    public int insertAwLocalmaterials(AwLocalmaterials awLocalmaterials);

    /**
     * 修改本地材料实时库存
     * 
     * @param awLocalmaterials 本地材料实时库存
     * @return 结果
     */
    public int updateAwLocalmaterials(AwLocalmaterials awLocalmaterials);

    /**
     * 删除本地材料实时库存
     * 
     * @param id 本地材料实时库存主键
     * @return 结果
     */
    public int deleteAwLocalmaterialsById(Long id);

    /**
     * 批量删除本地材料实时库存
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwLocalmaterialsByIds(Long[] ids);
}
