package com.awise.produce.service;

import com.awise.produce.domain.AwProductinventory;
import com.awise.produce.domain.Vo.AwProductinventoryVo;

import java.util.List;
import java.util.Map;

/**
 * 产品库存Service接口
 * 
 * @author awise
 * @date 2024-04-28
 */
public interface IAwProductinventoryServiceVo
{

    public List<AwProductinventoryVo> selectAwProductinventoryList(AwProductinventoryVo awProductinventoryvo);



}
