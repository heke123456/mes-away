package com.awise.storage.service;

import java.util.List;
import java.util.Map;

import com.awise.storage.domain.AwLocalmaterials;
import org.springframework.transaction.annotation.Transactional;

/**
 * 本地材料实时库存Service接口
 * 
 * @author awise
 * @date 2023-08-03
 */
public interface IAwLocalmaterialsService 
{
    /**
     * 查询本地材料实时库存
     * 
     * @param id 本地材料实时库存主键
     * @return 本地材料实时库存
     */
    public AwLocalmaterials selectAwLocalmaterialsById(Long id);

    /**
     * 查询本地材料实时库存列表
     * 
     * @param awLocalmaterials 本地材料实时库存
     * @return 本地材料实时库存集合
     */
    public List<AwLocalmaterials> selectAwLocalmaterialsList(AwLocalmaterials awLocalmaterials);

    /***
     *  本地实时库存新增
     * @param lmlist 需要新增库存的材料列表
     * @return 结果
     */
    @Transactional
    boolean addByNumber(List<Map<String,String>> lmlist);

    /***
     *  本地实时库存减少
     * @param lmlist 需要减少库存的材料列表
     * @return 结果
     */
    @Transactional
    boolean reduceByNumber(List<Map<String,String>> lmlist);

    /**
     * 新增本地材料实时库存
     * 
     * @param awLocalmaterials 本地材料实时库存
     * @return 结果
     */
    public int insertAwLocalmaterials(AwLocalmaterials awLocalmaterials);


    /**
     * 修改本地材料实时库存
     * 
     * @param awLocalmaterials 本地材料实时库存
     * @return 结果
     */
    public int updateAwLocalmaterials(AwLocalmaterials awLocalmaterials);

    /**
     * 批量删除本地材料实时库存
     * 
     * @param ids 需要删除的本地材料实时库存主键集合
     * @return 结果
     */
    public int deleteAwLocalmaterialsByIds(Long[] ids);

    /**
     * 删除本地材料实时库存信息
     * 
     * @param id 本地材料实时库存主键
     * @return 结果
     */
    public int deleteAwLocalmaterialsById(Long id);
}
