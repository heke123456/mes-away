package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwLocalmaterialoutboundMapper;
import com.awise.storage.domain.AwLocalmaterialoutbound;
import com.awise.storage.service.IAwLocalmaterialoutboundService;

/**
 * 本地材料出库Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-10-14
 */
@Service
public class AwLocalmaterialoutboundServiceImpl implements IAwLocalmaterialoutboundService 
{
    @Autowired
    private AwLocalmaterialoutboundMapper awLocalmaterialoutboundMapper;

    /**
     * 查询本地材料出库
     * 
     * @param id 本地材料出库主键
     * @return 本地材料出库
     */
    @Override
    public AwLocalmaterialoutbound selectAwLocalmaterialoutboundById(Long id)
    {
        return awLocalmaterialoutboundMapper.selectAwLocalmaterialoutboundById(id);
    }

    /**
     * 查询本地材料出库列表
     * 
     * @param awLocalmaterialoutbound 本地材料出库
     * @return 本地材料出库
     */
    @Override
    public List<AwLocalmaterialoutbound> selectAwLocalmaterialoutboundList(AwLocalmaterialoutbound awLocalmaterialoutbound)
    {
        return awLocalmaterialoutboundMapper.selectAwLocalmaterialoutboundList(awLocalmaterialoutbound);
    }

    /**
     * 新增本地材料出库
     * 
     * @param awLocalmaterialoutbound 本地材料出库
     * @return 结果
     */
    @Override
    public int insertAwLocalmaterialoutbound(AwLocalmaterialoutbound awLocalmaterialoutbound)
    {
        return awLocalmaterialoutboundMapper.insertAwLocalmaterialoutbound(awLocalmaterialoutbound);
    }

    /**
     * 修改本地材料出库
     * 
     * @param awLocalmaterialoutbound 本地材料出库
     * @return 结果
     */
    @Override
    public int updateAwLocalmaterialoutbound(AwLocalmaterialoutbound awLocalmaterialoutbound)
    {
        return awLocalmaterialoutboundMapper.updateAwLocalmaterialoutbound(awLocalmaterialoutbound);
    }

    /**
     * 批量删除本地材料出库
     * 
     * @param ids 需要删除的本地材料出库主键
     * @return 结果
     */
    @Override
    public int deleteAwLocalmaterialoutboundByIds(Long[] ids)
    {
        return awLocalmaterialoutboundMapper.deleteAwLocalmaterialoutboundByIds(ids);
    }

    /**
     * 删除本地材料出库信息
     * 
     * @param id 本地材料出库主键
     * @return 结果
     */
    @Override
    public int deleteAwLocalmaterialoutboundById(Long id)
    {
        return awLocalmaterialoutboundMapper.deleteAwLocalmaterialoutboundById(id);
    }
}
