package com.awise.storage.mapper;

import com.awise.storage.domain.AwToolinformationEn;

import java.util.List;

/**
 * 刀具信息Mapper接口
 * 
 * @author awise
 * @date 2023-07-27
 */
public interface AwToolinformationEnMapper
{
    /**
     * 查询刀具信息列表
     * 
     * @param AwToolinformationEn 刀具信息
     * @return 刀具信息集合
     */
    public List<AwToolinformationEn> selectAwToolinformationEnList(AwToolinformationEn awToolinformationEn);
}
