package com.awise.quality.service;

import java.util.List;
import com.awise.quality.domain.AwFinishedproductinspection;

/**
 * 成品检验Service接口
 * 
 * @author awise
 * @date 2023-10-16
 */
public interface IAwFinishedproductinspectionService 
{
    /**
     * 查询成品检验
     * 
     * @param id 成品检验主键
     * @return 成品检验
     */
    public AwFinishedproductinspection selectAwFinishedproductinspectionById(String id);

    /**
     * 查询成品检验列表
     * 
     * @param awFinishedproductinspection 成品检验
     * @return 成品检验集合
     */
    public List<AwFinishedproductinspection> selectAwFinishedproductinspectionList(AwFinishedproductinspection awFinishedproductinspection);

    /**
     * 新增成品检验
     * 
     * @param awFinishedproductinspection 成品检验
     * @return 结果
     */
    public int insertAwFinishedproductinspection(AwFinishedproductinspection awFinishedproductinspection);

    /**
     * 修改成品检验
     * 
     * @param awFinishedproductinspection 成品检验
     * @return 结果
     */
    public int updateAwFinishedproductinspection(AwFinishedproductinspection awFinishedproductinspection);

    /**
     * 批量删除成品检验
     * 
     * @param ids 需要删除的成品检验主键集合
     * @return 结果
     */
    public int deleteAwFinishedproductinspectionByIds(String[] ids);

    /**
     * 删除成品检验信息
     * 
     * @param id 成品检验主键
     * @return 结果
     */
    public int deleteAwFinishedproductinspectionById(String id);
}
