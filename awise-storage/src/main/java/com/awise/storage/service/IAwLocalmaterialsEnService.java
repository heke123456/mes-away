package com.awise.storage.service;

import com.awise.storage.domain.AwLocalmaterialsEn;

import java.util.List;

/**
 * 本地材料实时库存Service接口
 * 
 * @author awise
 * @date 2023-08-03
 */
public interface IAwLocalmaterialsEnService 
{

    /**
     * 查询本地材料实时库存列表
     * 
     * @param awLocalmaterialsEn 本地材料实时库存
     * @return 本地材料实时库存集合
     */
    public List<AwLocalmaterialsEn> selectAwLocalmaterialsEnList(AwLocalmaterialsEn awLocalmaterialsEn);


}
