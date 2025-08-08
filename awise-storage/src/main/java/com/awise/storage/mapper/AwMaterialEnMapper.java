package com.awise.storage.mapper;

import com.awise.storage.domain.AwMaterialEn;

import java.util.List;

/**
 * 材料基本信息Mapper接口
 * 
 * @author awise
 * @date 2023-08-02
 */
public interface AwMaterialEnMapper
{
    /**
     * 查询材料基本信息列表
     * 
     * @param awMaterialEn 材料基本信息
     * @return 材料基本信息集合
     */
    public List<AwMaterialEn> selectAwMaterialEnList(AwMaterialEn awMaterialEn);

}
