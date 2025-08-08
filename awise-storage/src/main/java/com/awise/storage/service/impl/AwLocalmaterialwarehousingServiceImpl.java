package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwLocalmaterialwarehousingMapper;
import com.awise.storage.domain.AwLocalmaterialwarehousing;
import com.awise.storage.service.IAwLocalmaterialwarehousingService;

/**
 * 本地材料入库Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-10-14
 */
@Service
public class AwLocalmaterialwarehousingServiceImpl implements IAwLocalmaterialwarehousingService 
{
    @Autowired
    private AwLocalmaterialwarehousingMapper awLocalmaterialwarehousingMapper;

    /**
     * 查询本地材料入库
     * 
     * @param id 本地材料入库主键
     * @return 本地材料入库
     */
    @Override
    public AwLocalmaterialwarehousing selectAwLocalmaterialwarehousingById(Long id)
    {
        return awLocalmaterialwarehousingMapper.selectAwLocalmaterialwarehousingById(id);
    }

    /**
     * 查询本地材料入库列表
     * 
     * @param awLocalmaterialwarehousing 本地材料入库
     * @return 本地材料入库
     */
    @Override
    public List<AwLocalmaterialwarehousing> selectAwLocalmaterialwarehousingList(AwLocalmaterialwarehousing awLocalmaterialwarehousing)
    {
        return awLocalmaterialwarehousingMapper.selectAwLocalmaterialwarehousingList(awLocalmaterialwarehousing);
    }

    /**
     * 新增本地材料入库
     * 
     * @param awLocalmaterialwarehousing 本地材料入库
     * @return 结果
     */
    @Override
    public int insertAwLocalmaterialwarehousing(AwLocalmaterialwarehousing awLocalmaterialwarehousing)
    {
        return awLocalmaterialwarehousingMapper.insertAwLocalmaterialwarehousing(awLocalmaterialwarehousing);
    }

    /**
     * 修改本地材料入库
     * 
     * @param awLocalmaterialwarehousing 本地材料入库
     * @return 结果
     */
    @Override
    public int updateAwLocalmaterialwarehousing(AwLocalmaterialwarehousing awLocalmaterialwarehousing)
    {
        return awLocalmaterialwarehousingMapper.updateAwLocalmaterialwarehousing(awLocalmaterialwarehousing);
    }

    /**
     * 批量删除本地材料入库
     * 
     * @param ids 需要删除的本地材料入库主键
     * @return 结果
     */
    @Override
    public int deleteAwLocalmaterialwarehousingByIds(Long[] ids)
    {
        return awLocalmaterialwarehousingMapper.deleteAwLocalmaterialwarehousingByIds(ids);
    }

    /**
     * 删除本地材料入库信息
     * 
     * @param id 本地材料入库主键
     * @return 结果
     */
    @Override
    public int deleteAwLocalmaterialwarehousingById(Long id)
    {
        return awLocalmaterialwarehousingMapper.deleteAwLocalmaterialwarehousingById(id);
    }
}
