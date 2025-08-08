package com.awise.storage.mapper;

import java.util.List;
import com.awise.storage.domain.AwToolinformation;
import com.awise.storage.domain.AwToolinformationEn;
import org.springframework.security.access.prepost.PostAuthorize;

/**
 * 刀具信息Mapper接口
 * 
 * @author awise
 * @date 2023-07-27
 */
public interface AwToolinformationMapper 
{
    /**
     * 查询刀具信息
     * 
     * @param id 刀具信息主键
     * @return 刀具信息
     */
    public AwToolinformation selectAwToolinformationById(String id);

    /**
     * 查询刀具信息列表实体
     *
     * @param awToolinformation 刀具信息
     * @return 刀具信息集合
     */
    public List<AwToolinformationEn> selectAwToolinformationEnList(AwToolinformationEn awToolinformationEn);

    /**
     * 查询刀具信息列表
     * 
     * @param awToolinformation 刀具信息
     * @return 刀具信息集合
     */
    public List<AwToolinformation> selectAwToolinformationList(AwToolinformation awToolinformation);

    /**
     * 新增刀具信息
     * 
     * @param awToolinformation 刀具信息
     * @return 结果
     */
    public int insertAwToolinformation(AwToolinformation awToolinformation);

    /**
     * 修改刀具信息
     * 
     * @param awToolinformation 刀具信息
     * @return 结果
     */
    public int updateAwToolinformation(AwToolinformation awToolinformation);

    /**
     * 删除刀具信息
     * 
     * @param id 刀具信息主键
     * @return 结果
     */
    public int deleteAwToolinformationById(String id);

    /**
     * 批量删除刀具信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwToolinformationByIds(String[] ids);
}
