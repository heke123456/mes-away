package com.awise.order.mapper;

import java.util.List;
import com.awise.order.domain.AwMaterialsubscription;

/**
 * 申购材料Mapper接口
 * 
 * @author awise
 * @date 2023-10-17
 */
public interface AwMaterialsubscriptionMapper 
{
    /**
     * 查询申购材料
     * 
     * @param materialSubscription 申购材料主键
     * @return 申购材料
     */
    public AwMaterialsubscription selectAwMaterialsubscriptionByMaterialSubscription(String materialSubscription);

    /**
     * 查询申购材料列表
     * 
     * @param awMaterialsubscription 申购材料
     * @return 申购材料集合
     */
    public List<AwMaterialsubscription> selectAwMaterialsubscriptionList(AwMaterialsubscription awMaterialsubscription);

    /**
     * 新增申购材料
     * 
     * @param awMaterialsubscription 申购材料
     * @return 结果
     */
    public int insertAwMaterialsubscription(AwMaterialsubscription awMaterialsubscription);

    /**
     * 修改申购材料
     * 
     * @param awMaterialsubscription 申购材料
     * @return 结果
     */
    public int updateAwMaterialsubscription(AwMaterialsubscription awMaterialsubscription);

    /**
     * 删除申购材料
     * 
     * @param materialSubscription 申购材料主键
     * @return 结果
     */
    public int deleteAwMaterialsubscriptionByMaterialSubscription(String materialSubscription);

    /**
     * 批量删除申购材料
     * 
     * @param materialSubscriptions 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwMaterialsubscriptionByMaterialSubscriptions(String[] materialSubscriptions);
}
