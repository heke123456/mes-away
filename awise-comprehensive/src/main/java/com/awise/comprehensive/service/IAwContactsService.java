package com.awise.comprehensive.service;

import java.util.List;
import com.awise.comprehensive.domain.AwContacts;
import com.awise.comprehensive.domain.AwContactsEn;

/**
 * 联系人信息Service接口
 * 
 * @author ruoyi
 * @date 2023-10-15
 */
public interface IAwContactsService 
{
    /**
     * 查询联系人信息
     * 
     * @param id 联系人信息主键
     * @return 联系人信息
     */
    public AwContacts selectAwContactsById(Long id);

    /**
     * 查询联系人信息列表
     * 
     * @param awContacts 联系人信息
     * @return 联系人信息集合
     */
    public List<AwContacts> selectAwContactsList(AwContacts awContacts);



    /**
     * 新增联系人信息
     * 
     * @param awContacts 联系人信息
     * @return 结果
     */
    public int insertAwContacts(AwContacts awContacts);

    /**
     * 修改联系人信息
     * 
     * @param awContacts 联系人信息
     * @return 结果
     */
    public int updateAwContacts(AwContacts awContacts);

    /**
     * 批量删除联系人信息
     * 
     * @param ids 需要删除的联系人信息主键集合
     * @return 结果
     */
    public int deleteAwContactsByIds(Long[] ids);

    /**
     * 删除联系人信息信息
     * 
     * @param id 联系人信息主键
     * @return 结果
     */
    public int deleteAwContactsById(Long id);
}
