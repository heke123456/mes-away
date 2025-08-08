package com.awise.order.mapper;

import java.util.List;
import com.awise.order.domain.AwBasicorderinformation;

/**
 * VIEWMapper接口
 * 
 * @author awise
 * @date 2023-12-22
 */
public interface AwBasicorderinformationMapper 
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
     * 删除VIEW
     * 
     * @param id VIEW主键
     * @return 结果
     */
    public int deleteAwBasicorderinformationById(String id);

    /**
     * 批量删除VIEW
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwBasicorderinformationByIds(String[] ids);
}
