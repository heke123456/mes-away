package com.awise.order.service;

import java.util.List;
import com.awise.order.domain.AwBasicorderinformation;

/**
 * VIEWService接口
 * 
 * @author awise
 * @date 2023-12-22
 */
public interface IAwBasicorderinformationService 
{
    /**
     * 查询VIEW
     * 
     * @param id VIEW主键
     * @return VIEW
     */
    public AwBasicorderinformation selectAwBasicorderinformationById(String id);

    /**
     * 查询VIEW列表
     * 
     * @param awBasicorderinformation VIEW
     * @return VIEW集合
     */
    public List<AwBasicorderinformation> selectAwBasicorderinformationList(AwBasicorderinformation awBasicorderinformation);

    /**
     * 新增VIEW
     * 
     * @param awBasicorderinformation VIEW
     * @return 结果
     */
    public int insertAwBasicorderinformation(AwBasicorderinformation awBasicorderinformation);

    /**
     * 修改VIEW
     * 
     * @param awBasicorderinformation VIEW
     * @return 结果
     */
    public int updateAwBasicorderinformation(AwBasicorderinformation awBasicorderinformation);

    /**
     * 批量删除VIEW
     * 
     * @param ids 需要删除的VIEW主键集合
     * @return 结果
     */
    public int deleteAwBasicorderinformationByIds(String[] ids);

    /**
     * 删除VIEW信息
     * 
     * @param id VIEW主键
     * @return 结果
     */
    public int deleteAwBasicorderinformationById(String id);
}
