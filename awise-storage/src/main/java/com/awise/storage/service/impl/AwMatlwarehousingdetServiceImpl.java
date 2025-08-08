package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwMatlwarehousingdetMapper;
import com.awise.storage.domain.AwMatlwarehousingdet;
import com.awise.storage.service.IAwMatlwarehousingdetService;

/**
 * 材料入库详细Service业务层处理
 * 
 * @author awise
 * @date 2023-10-25
 */
@Service
public class AwMatlwarehousingdetServiceImpl implements IAwMatlwarehousingdetService 
{
    @Autowired
    private AwMatlwarehousingdetMapper awMatlwarehousingdetMapper;

    /**
     * 查询材料入库详细
     * 
     * @param id 材料入库详细主键
     * @return 材料入库详细
     */
    @Override
    public AwMatlwarehousingdet selectAwMatlwarehousingdetById(Long id)
    {
        return awMatlwarehousingdetMapper.selectAwMatlwarehousingdetById(id);
    }

    /**
     * 查询材料入库详细列表
     * 
     * @param awMatlwarehousingdet 材料入库详细
     * @return 材料入库详细
     */
    @Override
    public List<AwMatlwarehousingdet> selectAwMatlwarehousingdetList(AwMatlwarehousingdet awMatlwarehousingdet)
    {
        return awMatlwarehousingdetMapper.selectAwMatlwarehousingdetList(awMatlwarehousingdet);
    }

    /**
     * 新增材料入库详细
     * 
     * @param awMatlwarehousingdet 材料入库详细
     * @return 结果
     */
    @Override
    public int insertAwMatlwarehousingdet(AwMatlwarehousingdet awMatlwarehousingdet)
    {
        return awMatlwarehousingdetMapper.insertAwMatlwarehousingdet(awMatlwarehousingdet);
    }

    /**
     * 修改材料入库详细
     * 
     * @param awMatlwarehousingdet 材料入库详细
     * @return 结果
     */
    @Override
    public int updateAwMatlwarehousingdet(AwMatlwarehousingdet awMatlwarehousingdet)
    {
        return awMatlwarehousingdetMapper.updateAwMatlwarehousingdet(awMatlwarehousingdet);
    }

    /**
     * 批量删除材料入库详细
     * 
     * @param ids 需要删除的材料入库详细主键
     * @return 结果
     */
    @Override
    public int deleteAwMatlwarehousingdetByIds(Long[] ids)
    {
        return awMatlwarehousingdetMapper.deleteAwMatlwarehousingdetByIds(ids);
    }

    /**
     * 删除材料入库详细信息
     * 
     * @param id 材料入库详细主键
     * @return 结果
     */
    @Override
    public int deleteAwMatlwarehousingdetById(Long id)
    {
        return awMatlwarehousingdetMapper.deleteAwMatlwarehousingdetById(id);
    }
}
