package com.awise.storage.service;

import java.util.List;
import com.awise.storage.domain.AwSpecifications;

/**
 * 规格类型Service接口
 * 
 * @author awise
 * @date 2023-08-01
 */
public interface IAwSpecificationsService 
{
    /**
     * 查询规格类型
     * 
     * @param id 规格类型主键
     * @return 规格类型
     */
    public AwSpecifications selectAwSpecificationsById(Long id);

    /**
     * 查询规格类型列表
     * 
     * @param awSpecifications 规格类型
     * @return 规格类型集合
     */
    public List<AwSpecifications> selectAwSpecificationsList(AwSpecifications awSpecifications);

    /**
     * 新增规格类型
     * 
     * @param awSpecifications 规格类型
     * @return 结果
     */
    public int insertAwSpecifications(AwSpecifications awSpecifications);

    /**
     * 修改规格类型
     * 
     * @param awSpecifications 规格类型
     * @return 结果
     */
    public int updateAwSpecifications(AwSpecifications awSpecifications);

    /**
     * 批量删除规格类型
     * 
     * @param ids 需要删除的规格类型主键集合
     * @return 结果
     */
    public int deleteAwSpecificationsByIds(Long[] ids);

    /**
     * 删除规格类型信息
     * 
     * @param id 规格类型主键
     * @return 结果
     */
    public int deleteAwSpecificationsById(Long id);
}
