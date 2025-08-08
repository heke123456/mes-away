package com.awise.order.mapper;

import java.util.List;
import com.awise.order.domain.AwDetailmaterialsubscription;

/**
 * 申购材料详细Mapper接口
 * 
 * @author awise
 * @date 2023-10-17
 */
public interface AwDetailmaterialsubscriptionMapper 
{
    /**
     * 查询申购材料详细
     * 
     * @param materialSubscription 申购材料详细主键
     * @return 申购材料详细
     */
    public AwDetailmaterialsubscription selectAwDetailmaterialsubscriptionByMaterialSubscription(String materialSubscription);

    /**
     * 查询申购材料详细列表
     * 
     * @param awDetailmaterialsubscription 申购材料详细
     * @return 申购材料详细集合
     */
    public List<AwDetailmaterialsubscription> selectAwDetailmaterialsubscriptionList(AwDetailmaterialsubscription awDetailmaterialsubscription);

    /**
     * 新增申购材料详细
     * 
     * @param awDetailmaterialsubscription 申购材料详细
     * @return 结果
     */
    public int insertAwDetailmaterialsubscription(AwDetailmaterialsubscription awDetailmaterialsubscription);

    /**
     * 修改申购材料详细
     * 
     * @param awDetailmaterialsubscription 申购材料详细
     * @return 结果
     */
    public int updateAwDetailmaterialsubscription(AwDetailmaterialsubscription awDetailmaterialsubscription);

    /**
     * 删除申购材料详细
     * 
     * @param materialSubscription 申购材料详细主键
     * @return 结果
     */
    public int deleteAwDetailmaterialsubscriptionByMaterialSubscription(String materialSubscription);

    /**
     * 批量删除申购材料详细
     * 
     * @param materialSubscriptions 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwDetailmaterialsubscriptionByMaterialSubscriptions(String[] materialSubscriptions);
}
