package com.awise.storage.mapper;

import java.util.List;
import com.awise.storage.domain.AwMatlwarehousingdet;

/**
 * 材料入库详细Mapper接口
 * 
 * @author awise
 * @date 2023-10-25
 */
public interface AwMatlwarehousingdetMapper 
{
    /**
     * 查询材料入库详细
     * 
     * @param id 材料入库详细主键
     * @return 材料入库详细
     */
    public AwMatlwarehousingdet selectAwMatlwarehousingdetById(Long id);

    /**
     * 查询材料入库详细列表
     * 
     * @param awMatlwarehousingdet 材料入库详细
     * @return 材料入库详细集合
     */
    public List<AwMatlwarehousingdet> selectAwMatlwarehousingdetList(AwMatlwarehousingdet awMatlwarehousingdet);

    /**
     * 新增材料入库详细
     * 
     * @param awMatlwarehousingdet 材料入库详细
     * @return 结果
     */
    public int insertAwMatlwarehousingdet(AwMatlwarehousingdet awMatlwarehousingdet);

    /**
     * 修改材料入库详细
     * 
     * @param awMatlwarehousingdet 材料入库详细
     * @return 结果
     */
    public int updateAwMatlwarehousingdet(AwMatlwarehousingdet awMatlwarehousingdet);

    /**
     * 删除材料入库详细
     * 
     * @param id 材料入库详细主键
     * @return 结果
     */
    public int deleteAwMatlwarehousingdetById(Long id);

    /**
     * 批量删除材料入库详细
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwMatlwarehousingdetByIds(Long[] ids);
}
