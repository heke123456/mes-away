package com.awise.storage.service.impl;

import com.awise.storage.domain.AwLocalmaterialsEn;
import com.awise.storage.mapper.AwLocalmaterialsEnMapper;
import com.awise.storage.service.IAwLocalmaterialsEnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 本地材料实时库存Service业务层处理
 * 
 * @author awise
 * @date 2023-08-03
 */
@Service
public class AwLocalmaterialsEnServiceImpl implements IAwLocalmaterialsEnService 
{
    @Autowired
    private AwLocalmaterialsEnMapper awLocalmaterialsEnMapper;

    /**
     * 查询本地材料实时库存列表
     * 
     * @param awLocalmaterialsEn 本地材料实时库存
     * @return 本地材料实时库存
     */
    @Override
    public List<AwLocalmaterialsEn> selectAwLocalmaterialsEnList(AwLocalmaterialsEn awLocalmaterialsEn)
    {
        return awLocalmaterialsEnMapper.selectAwLocalmaterialsEnList(awLocalmaterialsEn);
    }
}
