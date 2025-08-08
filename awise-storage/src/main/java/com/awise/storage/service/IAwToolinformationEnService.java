package com.awise.storage.service;

import com.awise.storage.domain.AwToolinformation;
import com.awise.storage.domain.AwToolinformationEn;

import java.util.List;

/**
 * 刀具信息Service接口
 * 
 * @author awise
 * @date 2023-07-27
 */
public interface IAwToolinformationEnService
{
    /**
     * 查询刀具信息列表实体
     *
     * @param awToolinformation 刀具信息
     * @return 刀具信息集合
     */
    public List<AwToolinformationEn> selectAwToolinformationEnList(AwToolinformationEn awToolinformationEn);
}
