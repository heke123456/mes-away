package com.awise.storage.service.impl;

import com.awise.storage.domain.AwToolinformationEn;
import com.awise.storage.mapper.AwToolinformationEnMapper;
import com.awise.storage.service.IAwToolinformationEnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 刀具信息Service业务层处理
 * 
 * @author awise
 * @date 2023-07-27
 */
@Service
public class AwToolinformationEnServiceImpl implements IAwToolinformationEnService
{
    @Autowired
    private AwToolinformationEnMapper awToolinformationEnMapper;


    /**
     * 查询刀具信息列表实体
     *
     * @param AwToolinformationEn 刀具信息
     * @return 刀具信息
     */
    @Override
    public List<AwToolinformationEn> selectAwToolinformationEnList(AwToolinformationEn awToolinformationEn)
    {
        return awToolinformationEnMapper.selectAwToolinformationEnList(awToolinformationEn);
    }

}
