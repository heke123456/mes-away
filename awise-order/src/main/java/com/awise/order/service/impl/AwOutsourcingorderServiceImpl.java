package com.awise.order.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.order.mapper.AwOutsourcingorderMapper;
import com.awise.order.domain.AwOutsourcingorder;
import com.awise.order.service.IAwOutsourcingorderService;

/**
 * 外协Service业务层处理
 * 
 * @author awise
 * @date 2023-10-15
 */
@Service
public class AwOutsourcingorderServiceImpl implements IAwOutsourcingorderService 
{
    @Autowired
    private AwOutsourcingorderMapper awOutsourcingorderMapper;

    /**
     * 查询外协
     * 
     * @param outsourcingOrderID 外协主键
     * @return 外协
     */
    @Override
    public AwOutsourcingorder selectAwOutsourcingorderByOutsourcingOrderID(String outsourcingOrderID)
    {
        return awOutsourcingorderMapper.selectAwOutsourcingorderByOutsourcingOrderID(outsourcingOrderID);
    }

    /**
     * 查询外协列表
     * 
     * @param awOutsourcingorder 外协
     * @return 外协
     */
    @Override
    public List<AwOutsourcingorder> selectAwOutsourcingorderList(AwOutsourcingorder awOutsourcingorder)
    {
        return awOutsourcingorderMapper.selectAwOutsourcingorderList(awOutsourcingorder);
    }

    /**
     * 新增外协
     * 
     * @param awOutsourcingorder 外协
     * @return 结果
     */
    @Override
    public int insertAwOutsourcingorder(AwOutsourcingorder awOutsourcingorder)
    {
        return awOutsourcingorderMapper.insertAwOutsourcingorder(awOutsourcingorder);
    }

    /**
     * 修改外协
     * 
     * @param awOutsourcingorder 外协
     * @return 结果
     */
    @Override
    public int updateAwOutsourcingorder(AwOutsourcingorder awOutsourcingorder)
    {
        return awOutsourcingorderMapper.updateAwOutsourcingorder(awOutsourcingorder);
    }

    /**
     * 批量删除外协
     * 
     * @param outsourcingOrderIDs 需要删除的外协主键
     * @return 结果
     */
    @Override
    public int deleteAwOutsourcingorderByOutsourcingOrderIDs(String[] outsourcingOrderIDs)
    {
        return awOutsourcingorderMapper.deleteAwOutsourcingorderByOutsourcingOrderIDs(outsourcingOrderIDs);
    }

    /**
     * 删除外协信息
     * 
     * @param outsourcingOrderID 外协主键
     * @return 结果
     */
    @Override
    public int deleteAwOutsourcingorderByOutsourcingOrderID(String outsourcingOrderID)
    {
        return awOutsourcingorderMapper.deleteAwOutsourcingorderByOutsourcingOrderID(outsourcingOrderID);
    }
}
