package com.awise.storage.service.impl;

import com.awise.storage.domain.AwMaterialEn;
import com.awise.storage.mapper.AwMaterialEnMapper;
import com.awise.storage.service.IAwMaterialEnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 材料基本信息Service业务层处理
 * 
 * @author awise
 * @date 2023-08-02
 */
@Service
public class AwMaterialEnServiceImpl implements IAwMaterialEnService 
{
    @Autowired
    private AwMaterialEnMapper awMaterialEnMapper;

    /**
     * 查询材料基本信息列表
     * 
     * @param awMaterialEn 材料基本信息
     * @return 材料基本信息
     */
    @Override
    public List<AwMaterialEn> selectAwMaterialEnList(AwMaterialEn awMaterialEn)
    {
        return awMaterialEnMapper.selectAwMaterialEnList(awMaterialEn);
    }
}
