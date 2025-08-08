package com.awise.storage.service;

import java.util.List;
import com.awise.storage.domain.AwLocalmaterialwarehousing;

/**
 * 本地材料入库Service接口
 * 
 * @author ruoyi
 * @date 2023-10-14
 */
public interface IAwLocalmaterialwarehousingService 
{
    /**
     * 查询本地材料入库
     * 
     * @param id 本地材料入库主键
     * @return 本地材料入库
     */
    public AwLocalmaterialwarehousing selectAwLocalmaterialwarehousingById(Long id);

    /**
     * 查询本地材料入库列表
     * 
     * @param awLocalmaterialwarehousing 本地材料入库
     * @return 本地材料入库集合
     */
    public List<AwLocalmaterialwarehousing> selectAwLocalmaterialwarehousingList(AwLocalmaterialwarehousing awLocalmaterialwarehousing);

    /**
     * 新增本地材料入库
     * 
     * @param awLocalmaterialwarehousing 本地材料入库
     * @return 结果
     */
    public int insertAwLocalmaterialwarehousing(AwLocalmaterialwarehousing awLocalmaterialwarehousing);

    /**
     * 修改本地材料入库
     * 
     * @param awLocalmaterialwarehousing 本地材料入库
     * @return 结果
     */
    public int updateAwLocalmaterialwarehousing(AwLocalmaterialwarehousing awLocalmaterialwarehousing);

    /**
     * 批量删除本地材料入库
     * 
     * @param ids 需要删除的本地材料入库主键集合
     * @return 结果
     */
    public int deleteAwLocalmaterialwarehousingByIds(Long[] ids);

    /**
     * 删除本地材料入库信息
     * 
     * @param id 本地材料入库主键
     * @return 结果
     */
    public int deleteAwLocalmaterialwarehousingById(Long id);
}
