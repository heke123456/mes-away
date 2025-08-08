package com.awise.storage.mapper;

import com.awise.storage.domain.AwLocalmaterialsEn;

import java.util.List;

/**
 * 本地材料实时库存Mapper接口
 * 
 * @author awise
 * @date 2023-08-03
 */
public interface AwLocalmaterialsEnMapper 
{
    /**
     * 查询本地材料实时库存
     * 
     * @param id 本地材料实时库存主键
     * @return 本地材料实时库存
     */
    public AwLocalmaterialsEn selectAwLocalmaterialsEnById(Long id);

    /**
     * 查询本地材料实时库存列表
     * 
     * @param awLocalmaterialsEn 本地材料实时库存
     * @return 本地材料实时库存集合
     */
    public List<AwLocalmaterialsEn> selectAwLocalmaterialsEnList(AwLocalmaterialsEn awLocalmaterialsEn);

    /**
     * 新增本地材料实时库存
     * 
     * @param awLocalmaterialsEn 本地材料实时库存
     * @return 结果
     */
    public int insertAwLocalmaterialsEn(AwLocalmaterialsEn awLocalmaterialsEn);

    /**
     * 修改本地材料实时库存
     * 
     * @param awLocalmaterialsEn 本地材料实时库存
     * @return 结果
     */
    public int updateAwLocalmaterialsEn(AwLocalmaterialsEn awLocalmaterialsEn);

    /**
     * 删除本地材料实时库存
     * 
     * @param id 本地材料实时库存主键
     * @return 结果
     */
    public int deleteAwLocalmaterialsEnById(Long id);

    /**
     * 批量删除本地材料实时库存
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwLocalmaterialsEnByIds(Long[] ids);
}
