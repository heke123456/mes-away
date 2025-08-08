package com.awise.order.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.order.mapper.AwDetailmaterialsubscriptionMapper;
import com.awise.order.domain.AwDetailmaterialsubscription;
import com.awise.order.service.IAwDetailmaterialsubscriptionService;

/**
 * 申购材料详细Service业务层处理
 * 
 * @author awise
 * @date 2023-10-17
 */
@Service
public class AwDetailmaterialsubscriptionServiceImpl implements IAwDetailmaterialsubscriptionService 
{
    @Autowired
    private AwDetailmaterialsubscriptionMapper awDetailmaterialsubscriptionMapper;

    /**
     * 查询申购材料详细
     * 
     * @param materialSubscription 申购材料详细主键
     * @return 申购材料详细
     */
    @Override
    public AwDetailmaterialsubscription selectAwDetailmaterialsubscriptionByMaterialSubscription(String materialSubscription)
    {
        return awDetailmaterialsubscriptionMapper.selectAwDetailmaterialsubscriptionByMaterialSubscription(materialSubscription);
    }

    /**
     * 查询申购材料详细列表
     * 
     * @param awDetailmaterialsubscription 申购材料详细
     * @return 申购材料详细
     */
    @Override
    public List<AwDetailmaterialsubscription> selectAwDetailmaterialsubscriptionList(AwDetailmaterialsubscription awDetailmaterialsubscription)
    {
        return awDetailmaterialsubscriptionMapper.selectAwDetailmaterialsubscriptionList(awDetailmaterialsubscription);
    }

    /**
     * 新增申购材料详细
     * 
     * @param awDetailmaterialsubscription 申购材料详细
     * @return 结果
     */
    @Override
    public int insertAwDetailmaterialsubscription(AwDetailmaterialsubscription awDetailmaterialsubscription)
    {
        return awDetailmaterialsubscriptionMapper.insertAwDetailmaterialsubscription(awDetailmaterialsubscription);
    }

    /**
     * 修改申购材料详细
     * 
     * @param awDetailmaterialsubscription 申购材料详细
     * @return 结果
     */
    @Override
    public int updateAwDetailmaterialsubscription(AwDetailmaterialsubscription awDetailmaterialsubscription)
    {
        return awDetailmaterialsubscriptionMapper.updateAwDetailmaterialsubscription(awDetailmaterialsubscription);
    }

    /**
     * 批量删除申购材料详细
     * 
     * @param materialSubscriptions 需要删除的申购材料详细主键
     * @return 结果
     */
    @Override
    public int deleteAwDetailmaterialsubscriptionByMaterialSubscriptions(String[] materialSubscriptions)
    {
        return awDetailmaterialsubscriptionMapper.deleteAwDetailmaterialsubscriptionByMaterialSubscriptions(materialSubscriptions);
    }

    /**
     * 删除申购材料详细信息
     * 
     * @param materialSubscription 申购材料详细主键
     * @return 结果
     */
    @Override
    public int deleteAwDetailmaterialsubscriptionByMaterialSubscription(String materialSubscription)
    {
        return awDetailmaterialsubscriptionMapper.deleteAwDetailmaterialsubscriptionByMaterialSubscription(materialSubscription);
    }
}
