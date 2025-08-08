package com.awise.comprehensive.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.comprehensive.mapper.AwPartnerMapper;
import com.awise.comprehensive.domain.AwPartner;
import com.awise.comprehensive.service.IAwPartnerService;

/**
 * 合作方信息Service业务层处理
 * 
 * @author awise
 * @date 2023-08-02
 */
@Service
public class AwPartnerServiceImpl implements IAwPartnerService 
{
    @Autowired
    private AwPartnerMapper awPartnerMapper;

    /**
     * 查询合作方信息
     * 
     * @param ID 合作方信息主键
     * @return 合作方信息
     */
    @Override
    public AwPartner selectAwPartnerByID(String ID)
    {
        return awPartnerMapper.selectAwPartnerByID(ID);
    }

    /**
     * 查询合作方信息列表
     * 
     * @param awPartner 合作方信息
     * @return 合作方信息
     */
    @Override
    public List<AwPartner> selectAwPartnerList(AwPartner awPartner)
    {
        return awPartnerMapper.selectAwPartnerList(awPartner);
    }

    /**
     * 新增合作方信息
     * 
     * @param awPartner 合作方信息
     * @return 结果
     */
    @Override
    public int insertAwPartner(AwPartner awPartner)
    {
        return awPartnerMapper.insertAwPartner(awPartner);
    }

    /**
     * 修改合作方信息
     * 
     * @param awPartner 合作方信息
     * @return 结果
     */
    @Override
    public int updateAwPartner(AwPartner awPartner)
    {
        return awPartnerMapper.updateAwPartner(awPartner);
    }

    /**
     * 批量删除合作方信息
     * 
     * @param IDs 需要删除的合作方信息主键
     * @return 结果
     */
    @Override
    public int deleteAwPartnerByIDs(String[] IDs)
    {
        return awPartnerMapper.deleteAwPartnerByIDs(IDs);
    }

    /**
     * 删除合作方信息信息
     * 
     * @param ID 合作方信息主键
     * @return 结果
     */
    @Override
    public int deleteAwPartnerByID(String ID)
    {
        return awPartnerMapper.deleteAwPartnerByID(ID);
    }
}
