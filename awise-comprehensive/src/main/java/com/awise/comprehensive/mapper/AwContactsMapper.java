package com.awise.comprehensive.mapper;

import java.util.List;
import com.awise.comprehensive.domain.AwContacts;

/**
 * 联系人信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-10-15
 */
public interface AwContactsMapper 
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
     * 删除联系人信息
     * 
     * @param id 联系人信息主键
     * @return 结果
     */
    public int deleteAwContactsById(Long id);

    /**
     * 批量删除联系人信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwContactsByIds(Long[] ids);
}
