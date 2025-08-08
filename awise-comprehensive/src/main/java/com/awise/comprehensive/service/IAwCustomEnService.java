package com.awise.comprehensive.service;

import com.awise.comprehensive.domain.AwCustomEn;

import java.util.List;

/**
 * 客户信息Service接口
 * 
 * @author awise
 * @date 2023-08-02
 */
public interface IAwCustomEnService 
{


    /**
     * 查询客户信息列表
     * 
     * @param awCustomEn 客户信息
     * @return 客户信息集合
     */
    public List<AwCustomEn> selectAwCustomEnList(AwCustomEn awCustomEn);

    AwCustomEn selectAwCustomByID(String id);
}
