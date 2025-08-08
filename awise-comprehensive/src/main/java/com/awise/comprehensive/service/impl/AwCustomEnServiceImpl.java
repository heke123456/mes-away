package com.awise.comprehensive.service.impl;

import com.awise.comprehensive.domain.AwCustomEn;
import com.awise.comprehensive.mapper.AwCustomEnMapper;
import com.awise.comprehensive.service.IAwCustomEnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户信息Service业务层处理
 * 
 * @author awise
 * @date 2023-08-02
 */
@Service
public class AwCustomEnServiceImpl implements IAwCustomEnService 
{
    @Autowired
    private AwCustomEnMapper awCustomEnMapper;

    /**
     * 查询客户信息列表
     * 
     * @param awCustomEn 客户信息
     * @return 客户信息
     */
    @Override
    public List<AwCustomEn> selectAwCustomEnList(AwCustomEn awCustomEn)
    {
        return awCustomEnMapper.selectAwCustomEnList(awCustomEn);
    }

    @Override
    public AwCustomEn selectAwCustomByID(String id) {
        return awCustomEnMapper.selectAwCustomByID(id);
    }

}
