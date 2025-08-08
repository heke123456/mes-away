package com.awise.storage.service;

import java.util.List;
import com.awise.storage.domain.AwLocalmaterialoutbound;

/**
 * 本地材料出库Service接口
 * 
 * @author ruoyi
 * @date 2023-10-14
 */
public interface IAwLocalmaterialoutboundService 
{
    /**
     * 查询本地材料出库
     * 
     * @param id 本地材料出库主键
     * @return 本地材料出库
     */
    public AwLocalmaterialoutbound selectAwLocalmaterialoutboundById(Long id);

    /**
     * 查询本地材料出库列表
     * 
     * @param awLocalmaterialoutbound 本地材料出库
     * @return 本地材料出库集合
     */
    public List<AwLocalmaterialoutbound> selectAwLocalmaterialoutboundList(AwLocalmaterialoutbound awLocalmaterialoutbound);

    /**
     * 新增本地材料出库
     * 
     * @param awLocalmaterialoutbound 本地材料出库
     * @return 结果
     */
    public int insertAwLocalmaterialoutbound(AwLocalmaterialoutbound awLocalmaterialoutbound);

    /**
     * 修改本地材料出库
     * 
     * @param awLocalmaterialoutbound 本地材料出库
     * @return 结果
     */
    public int updateAwLocalmaterialoutbound(AwLocalmaterialoutbound awLocalmaterialoutbound);

    /**
     * 批量删除本地材料出库
     * 
     * @param ids 需要删除的本地材料出库主键集合
     * @return 结果
     */
    public int deleteAwLocalmaterialoutboundByIds(Long[] ids);

    /**
     * 删除本地材料出库信息
     * 
     * @param id 本地材料出库主键
     * @return 结果
     */
    public int deleteAwLocalmaterialoutboundById(Long id);
}
