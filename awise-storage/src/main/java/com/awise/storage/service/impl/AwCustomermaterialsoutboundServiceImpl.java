package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwCustomermaterialsoutboundMapper;
import com.awise.storage.domain.AwCustomermaterialsoutbound;
import com.awise.storage.service.IAwCustomermaterialsoutboundService;

/**
 * 客供材料材料出库Service业务层处理
 * 
 * @author awise
 * @date 2024-04-23
 */
@Service
public class AwCustomermaterialsoutboundServiceImpl implements IAwCustomermaterialsoutboundService 
{
    @Autowired
    private AwCustomermaterialsoutboundMapper awCustomermaterialsoutboundMapper;

    /**
     * 查询客供材料材料出库
     * 
     * @param id 客供材料材料出库主键
     * @return 客供材料材料出库
     */
    @Override
    public AwCustomermaterialsoutbound selectAwCustomermaterialsoutboundById(Long id)
    {
        return awCustomermaterialsoutboundMapper.selectAwCustomermaterialsoutboundById(id);
    }

    /**
     * 查询客供材料材料出库列表
     * 
     * @param awCustomermaterialsoutbound 客供材料材料出库
     * @return 客供材料材料出库
     */
    @Override
    public List<AwCustomermaterialsoutbound> selectAwCustomermaterialsoutboundList(AwCustomermaterialsoutbound awCustomermaterialsoutbound)
    {
        return awCustomermaterialsoutboundMapper.selectAwCustomermaterialsoutboundList(awCustomermaterialsoutbound);
    }

    /**
     * 新增客供材料材料出库
     * 
     * @param awCustomermaterialsoutbound 客供材料材料出库
     * @return 结果
     */
    @Override
    public int insertAwCustomermaterialsoutbound(AwCustomermaterialsoutbound awCustomermaterialsoutbound)
    {
        return awCustomermaterialsoutboundMapper.insertAwCustomermaterialsoutbound(awCustomermaterialsoutbound);
    }

    /**
     * 修改客供材料材料出库
     * 
     * @param awCustomermaterialsoutbound 客供材料材料出库
     * @return 结果
     */
    @Override
    public int updateAwCustomermaterialsoutbound(AwCustomermaterialsoutbound awCustomermaterialsoutbound)
    {
        return awCustomermaterialsoutboundMapper.updateAwCustomermaterialsoutbound(awCustomermaterialsoutbound);
    }

    /**
     * 批量删除客供材料材料出库
     * 
     * @param ids 需要删除的客供材料材料出库主键
     * @return 结果
     */
    @Override
    public int deleteAwCustomermaterialsoutboundByIds(Long[] ids)
    {
        return awCustomermaterialsoutboundMapper.deleteAwCustomermaterialsoutboundByIds(ids);
    }

    /**
     * 删除客供材料材料出库信息
     * 
     * @param id 客供材料材料出库主键
     * @return 结果
     */
    @Override
    public int deleteAwCustomermaterialsoutboundById(Long id)
    {
        return awCustomermaterialsoutboundMapper.deleteAwCustomermaterialsoutboundById(id);
    }
}
