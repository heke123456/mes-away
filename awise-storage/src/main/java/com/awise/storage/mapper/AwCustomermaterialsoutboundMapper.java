package com.awise.storage.mapper;

import java.util.List;
import com.awise.storage.domain.AwCustomermaterialsoutbound;

/**
 * 客供材料材料出库Mapper接口
 * 
 * @author awise
 * @date 2024-04-23
 */
public interface AwCustomermaterialsoutboundMapper 
{
    /**
     * 查询客供材料材料出库
     * 
     * @param id 客供材料材料出库主键
     * @return 客供材料材料出库
     */
    public AwCustomermaterialsoutbound selectAwCustomermaterialsoutboundById(Long id);

    /**
     * 查询客供材料材料出库列表
     * 
     * @param awCustomermaterialsoutbound 客供材料材料出库
     * @return 客供材料材料出库集合
     */
    public List<AwCustomermaterialsoutbound> selectAwCustomermaterialsoutboundList(AwCustomermaterialsoutbound awCustomermaterialsoutbound);

    /**
     * 新增客供材料材料出库
     * 
     * @param awCustomermaterialsoutbound 客供材料材料出库
     * @return 结果
     */
    public int insertAwCustomermaterialsoutbound(AwCustomermaterialsoutbound awCustomermaterialsoutbound);

    /**
     * 修改客供材料材料出库
     * 
     * @param awCustomermaterialsoutbound 客供材料材料出库
     * @return 结果
     */
    public int updateAwCustomermaterialsoutbound(AwCustomermaterialsoutbound awCustomermaterialsoutbound);

    /**
     * 删除客供材料材料出库
     * 
     * @param id 客供材料材料出库主键
     * @return 结果
     */
    public int deleteAwCustomermaterialsoutboundById(Long id);

    /**
     * 批量删除客供材料材料出库
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwCustomermaterialsoutboundByIds(Long[] ids);
}
