package com.awise.quality.service;

import java.util.List;
import com.awise.quality.domain.AwShippinginspection;

/**
 * 成品出货检验Service接口
 * 
 * @author awise
 * @date 2023-10-16
 */
public interface IAwShippinginspectionService 
{
    /**
     * 查询成品出货检验
     * 
     * @param id 成品出货检验主键
     * @return 成品出货检验
     */
    public AwShippinginspection selectAwShippinginspectionById(String id);

    /**
     * 查询成品出货检验列表
     * 
     * @param awShippinginspection 成品出货检验
     * @return 成品出货检验集合
     */
    public List<AwShippinginspection> selectAwShippinginspectionList(AwShippinginspection awShippinginspection);

    /**
     * 新增成品出货检验
     * 
     * @param awShippinginspection 成品出货检验
     * @return 结果
     */
    public int insertAwShippinginspection(AwShippinginspection awShippinginspection);

    /**
     * 修改成品出货检验
     * 
     * @param awShippinginspection 成品出货检验
     * @return 结果
     */
    public int updateAwShippinginspection(AwShippinginspection awShippinginspection);

    /**
     * 批量删除成品出货检验
     * 
     * @param ids 需要删除的成品出货检验主键集合
     * @return 结果
     */
    public int deleteAwShippinginspectionByIds(String[] ids);

    /**
     * 删除成品出货检验信息
     * 
     * @param id 成品出货检验主键
     * @return 结果
     */
    public int deleteAwShippinginspectionById(String id);
}
