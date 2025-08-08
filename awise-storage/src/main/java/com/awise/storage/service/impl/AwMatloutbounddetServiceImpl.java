package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwMatloutbounddetMapper;
import com.awise.storage.domain.AwMatloutbounddet;
import com.awise.storage.service.IAwMatloutbounddetService;

/**
 * 材料出库详细Service业务层处理
 * 
 * @author awise
 * @date 2023-10-25
 */
@Service
public class AwMatloutbounddetServiceImpl implements IAwMatloutbounddetService 
{
    @Autowired
    private AwMatloutbounddetMapper awMatloutbounddetMapper;

    /**
     * 查询材料出库详细
     * 
     * @param id 材料出库详细主键
     * @return 材料出库详细
     */
    @Override
    public AwMatloutbounddet selectAwMatloutbounddetById(Long id)
    {
        return awMatloutbounddetMapper.selectAwMatloutbounddetById(id);
    }

    /**
     * 查询材料出库详细列表
     * 
     * @param awMatloutbounddet 材料出库详细
     * @return 材料出库详细
     */
    @Override
    public List<AwMatloutbounddet> selectAwMatloutbounddetList(AwMatloutbounddet awMatloutbounddet)
    {
        return awMatloutbounddetMapper.selectAwMatloutbounddetList(awMatloutbounddet);
    }

    /**
     * 新增材料出库详细
     * 
     * @param awMatloutbounddet 材料出库详细
     * @return 结果
     */
    @Override
    public int insertAwMatloutbounddet(AwMatloutbounddet awMatloutbounddet)
    {
        return awMatloutbounddetMapper.insertAwMatloutbounddet(awMatloutbounddet);
    }

    /**
     * 修改材料出库详细
     * 
     * @param awMatloutbounddet 材料出库详细
     * @return 结果
     */
    @Override
    public int updateAwMatloutbounddet(AwMatloutbounddet awMatloutbounddet)
    {
        return awMatloutbounddetMapper.updateAwMatloutbounddet(awMatloutbounddet);
    }

    /**
     * 批量删除材料出库详细
     * 
     * @param ids 需要删除的材料出库详细主键
     * @return 结果
     */
    @Override
    public int deleteAwMatloutbounddetByIds(Long[] ids)
    {
        return awMatloutbounddetMapper.deleteAwMatloutbounddetByIds(ids);
    }

    /**
     * 删除材料出库详细信息
     * 
     * @param id 材料出库详细主键
     * @return 结果
     */
    @Override
    public int deleteAwMatloutbounddetById(Long id)
    {
        return awMatloutbounddetMapper.deleteAwMatloutbounddetById(id);
    }
}
