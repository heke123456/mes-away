package com.awise.comprehensive.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.comprehensive.mapper.AwContactsMapper;
import com.awise.comprehensive.domain.AwContacts;
import com.awise.comprehensive.service.IAwContactsService;

/**
 * 联系人信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-10-15
 */
@Service
public class AwContactsServiceImpl implements IAwContactsService 
{
    @Autowired
    private AwContactsMapper awContactsMapper;

    /**
     * 查询联系人信息
     * 
     * @param id 联系人信息主键
     * @return 联系人信息
     */
    @Override
    public AwContacts selectAwContactsById(Long id)
    {
        return awContactsMapper.selectAwContactsById(id);
    }

    /**
     * 查询联系人信息列表
     * 
     * @param awContacts 联系人信息
     * @return 联系人信息
     */
    @Override
    public List<AwContacts> selectAwContactsList(AwContacts awContacts)
    {
        return awContactsMapper.selectAwContactsList(awContacts);
    }

    /**
     * 新增联系人信息
     * 
     * @param awContacts 联系人信息
     * @return 结果
     */
    @Override
    public int insertAwContacts(AwContacts awContacts)
    {
        return awContactsMapper.insertAwContacts(awContacts);
    }

    /**
     * 修改联系人信息
     * 
     * @param awContacts 联系人信息
     * @return 结果
     */
    @Override
    public int updateAwContacts(AwContacts awContacts)
    {
        return awContactsMapper.updateAwContacts(awContacts);
    }

    /**
     * 批量删除联系人信息
     * 
     * @param ids 需要删除的联系人信息主键
     * @return 结果
     */
    @Override
    public int deleteAwContactsByIds(Long[] ids)
    {
        return awContactsMapper.deleteAwContactsByIds(ids);
    }

    /**
     * 删除联系人信息信息
     * 
     * @param id 联系人信息主键
     * @return 结果
     */
    @Override
    public int deleteAwContactsById(Long id)
    {
        return awContactsMapper.deleteAwContactsById(id);
    }
}
