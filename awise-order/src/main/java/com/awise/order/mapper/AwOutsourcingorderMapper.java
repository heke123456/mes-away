package com.awise.order.mapper;

import java.util.List;
import com.awise.order.domain.AwOutsourcingorder;

/**
 * 外协Mapper接口
 * 
 * @author awise
 * @date 2023-10-15
 */
public interface AwOutsourcingorderMapper 
{
    /**
     * 查询外协
     * 
     * @param outsourcingOrderID 外协主键
     * @return 外协
     */
    public AwOutsourcingorder selectAwOutsourcingorderByOutsourcingOrderID(String outsourcingOrderID);

    /**
     * 查询外协列表
     * 
     * @param awOutsourcingorder 外协
     * @return 外协集合
     */
    public List<AwOutsourcingorder> selectAwOutsourcingorderList(AwOutsourcingorder awOutsourcingorder);

    /**
     * 新增外协
     * 
     * @param awOutsourcingorder 外协
     * @return 结果
     */
    public int insertAwOutsourcingorder(AwOutsourcingorder awOutsourcingorder);

    /**
     * 修改外协
     * 
     * @param awOutsourcingorder 外协
     * @return 结果
     */
    public int updateAwOutsourcingorder(AwOutsourcingorder awOutsourcingorder);

    /**
     * 删除外协
     * 
     * @param outsourcingOrderID 外协主键
     * @return 结果
     */
    public int deleteAwOutsourcingorderByOutsourcingOrderID(String outsourcingOrderID);

    /**
     * 批量删除外协
     * 
     * @param outsourcingOrderIDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwOutsourcingorderByOutsourcingOrderIDs(String[] outsourcingOrderIDs);
}
