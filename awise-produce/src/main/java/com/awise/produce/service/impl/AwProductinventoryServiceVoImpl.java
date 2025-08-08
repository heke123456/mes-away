package com.awise.produce.service.impl;

import com.awise.produce.domain.AwProductinventory;
import com.awise.produce.domain.Vo.AwProductinventoryVo;
import com.awise.produce.mapper.AwProductinventoryMapper;
import com.awise.produce.mapper.AwProductinventoryVoMapper;
import com.awise.produce.mapper.AwProductmanhourMapper;
import com.awise.produce.service.IAwProductinventoryService;
import com.awise.produce.service.IAwProductinventoryServiceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 产品库存Service业务层处理
 * 
 * @author awise
 * @date 2024-04-28
 */
@Service
public class AwProductinventoryServiceVoImpl implements IAwProductinventoryServiceVo
{
    @Autowired
    private AwProductinventoryVoMapper  awProductinventoryVoMapper;


    @Override
    public List<AwProductinventoryVo> selectAwProductinventoryList(AwProductinventoryVo awProductinventoryvo)
    {
        return awProductinventoryVoMapper.selectAwProductinventoryList(awProductinventoryvo);
    }


}
