package com.awise.order.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.order.mapper.AwMaterialsubscriptionMapper;
import com.awise.order.domain.AwMaterialsubscription;
import com.awise.order.service.IAwMaterialsubscriptionService;

/**
 * 申购材料Service业务层处理
 * 
 * @author awise
 * @date 2023-10-17
 */
@Service
public class AwMaterialsubscriptionServiceImpl implements IAwMaterialsubscriptionService 
{
    @Autowired
    private AwMaterialsubscriptionMapper awMaterialsubscriptionMapper;

    /**
     * 查询申购材料
     * 
     * @param materialSubscription 申购材料主键
     * @return 申购材料
     */
    @Override
    public AwMaterialsubscription selectAwMaterialsubscriptionByMaterialSubscription(String materialSubscription)
    {
        return awMaterialsubscriptionMapper.selectAwMaterialsubscriptionByMaterialSubscription(materialSubscription);
    }

    /**
     * 查询申购材料列表
     * 
     * @param awMaterialsubscription 申购材料
     * @return 申购材料
     */
    @Override
    public List<AwMaterialsubscription> selectAwMaterialsubscriptionList(AwMaterialsubscription awMaterialsubscription)
    {
        return awMaterialsubscriptionMapper.selectAwMaterialsubscriptionList(awMaterialsubscription);
    }

    /**
     * 新增申购材料
     * 
     * @param awMaterialsubscription 申购材料
     * @return 结果
     */
    @Override
    public int insertAwMaterialsubscription(AwMaterialsubscription awMaterialsubscription)
    {
        return awMaterialsubscriptionMapper.insertAwMaterialsubscription(awMaterialsubscription);
    }

    /**
     * 修改申购材料
     * 
     * @param awMaterialsubscription 申购材料
     * @return 结果
     */
    @Override
    public int updateAwMaterialsubscription(AwMaterialsubscription awMaterialsubscription)
    {
        return awMaterialsubscriptionMapper.updateAwMaterialsubscription(awMaterialsubscription);
    }

    /**
     * 批量删除申购材料
     * 
     * @param materialSubscriptions 需要删除的申购材料主键
     * @return 结果
     */
    @Override
    public int deleteAwMaterialsubscriptionByMaterialSubscriptions(String[] materialSubscriptions)
    {
        return awMaterialsubscriptionMapper.deleteAwMaterialsubscriptionByMaterialSubscriptions(materialSubscriptions);
    }

    /**
     * 删除申购材料信息
     * 
     * @param materialSubscription 申购材料主键
     * @return 结果
     */
    @Override
    public int deleteAwMaterialsubscriptionByMaterialSubscription(String materialSubscription)
    {
        return awMaterialsubscriptionMapper.deleteAwMaterialsubscriptionByMaterialSubscription(materialSubscription);
    }
}
