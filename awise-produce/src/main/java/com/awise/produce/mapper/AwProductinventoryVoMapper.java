package com.awise.produce.mapper;

import com.awise.produce.domain.AwProductinventory;
import com.awise.produce.domain.Vo.AwProductinventoryVo;

import java.util.List;

/**
 * 产品库存Mapper接口
 * 
 * @author awise
 * @date 2024-04-28
 */
public interface AwProductinventoryVoMapper
{



    public List<AwProductinventoryVo> selectAwProductinventoryList(AwProductinventoryVo awProductinventoryvo);


}
