package com.awise.produce.service.impl;

import com.away.common.utils.DateUtils;
import com.awise.produce.domain.AwProcessingtechnology;
import com.awise.produce.domain.Vo.AwProcessingtechnologyVo;
import com.awise.produce.mapper.AwProcessingtechnologyMapper;
import com.awise.produce.service.IAwProcessingtechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 加工工艺信息Service业务层处理
 * 
 * @author awise
 * @date 2023-09-26
 */
@Service
public class AwProcessingtechnologyServiceImpl implements IAwProcessingtechnologyService 
{
    @Autowired
    private AwProcessingtechnologyMapper awProcessingtechnologyMapper;

    /**
     * 查询加工工艺信息
     * 
     * @param id 加工工艺信息主键
     * @return 加工工艺信息
     */
    @Override
    public AwProcessingtechnology selectAwProcessingtechnologyById(String id)
    {
        return awProcessingtechnologyMapper.selectAwProcessingtechnologyById(id);
    }

    /**
     * 查询加工工艺信息列表
     * 
     * @param awProcessingtechnology 加工工艺信息
     * @return 加工工艺信息
     */
    @Override
    public List<AwProcessingtechnology> selectAwProcessingtechnologyList(AwProcessingtechnology awProcessingtechnology)
    {
        return awProcessingtechnologyMapper.selectAwProcessingtechnologyList(awProcessingtechnology);
    }

    /**
     * 新增加工工艺信息
     * 
     * @param awProcessingtechnology 加工工艺信息
     * @return 结果
     */
    @Override
    public int insertAwProcessingtechnology(AwProcessingtechnology awProcessingtechnology)
    {
        awProcessingtechnology.setCreateTime(DateUtils.getNowDate());
        return awProcessingtechnologyMapper.insertAwProcessingtechnology(awProcessingtechnology);
    }

    /**
     * 修改加工工艺信息
     * 
     * @param awProcessingtechnology 加工工艺信息
     * @return 结果
     */
    @Override
    public int updateAwProcessingtechnology(AwProcessingtechnology awProcessingtechnology)
    {
        return awProcessingtechnologyMapper.updateAwProcessingtechnology(awProcessingtechnology);
    }

    /**
     * 批量删除加工工艺信息
     * 
     * @param ids 需要删除的加工工艺信息主键
     * @return 结果
     */
    @Override
    public int deleteAwProcessingtechnologyByIds(String[] ids)
    {
        return awProcessingtechnologyMapper.deleteAwProcessingtechnologyByIds(ids);
    }

    /**
     * 删除加工工艺信息信息
     * 
     * @param id 加工工艺信息主键
     * @return 结果
     */
    @Override
    public int deleteAwProcessingtechnologyById(String id)
    {
        return awProcessingtechnologyMapper.deleteAwProcessingtechnologyById(id);
    }


}
