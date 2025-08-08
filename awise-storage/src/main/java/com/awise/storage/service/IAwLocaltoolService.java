package com.awise.storage.service;

import java.util.List;
import java.util.Map;

import com.awise.storage.domain.AwLocaltool;
import org.springframework.transaction.annotation.Transactional;

/**
 * 刀具库存Service接口
 *
 * @author awise
 * @date 2023-12-18
 */
public interface IAwLocaltoolService
{
    /**
     * 查询刀具库存
     *
     * @param id 刀具库存主键
     * @return 刀具库存
     */
    public AwLocaltool selectAwLocaltoolById(Long id);

    /**
     * 查询刀具库存列表
     *
     * @param awLocaltool 刀具库存
     * @return 刀具库存集合
     */
    public List<AwLocaltool> selectAwLocaltoolList(AwLocaltool awLocaltool);

    /**
     * 新增刀具库存
     *
     * @param awLocaltool 刀具库存
     * @return 结果
     */
    public int insertAwLocaltool(AwLocaltool awLocaltool);

    /**
     * 修改刀具库存
     *
     * @param awLocaltool 刀具库存
     * @return 结果
     */
    public int updateAwLocaltool(AwLocaltool awLocaltool);

    /**
     * 批量删除刀具库存
     *
     * @param ids 需要删除的刀具库存主键集合
     * @return 结果
     */
    public int deleteAwLocaltoolByIds(Long[] ids);

    /**
     * 删除刀具库存信息
     *
     * @param id 刀具库存主键
     * @return 结果
     */
    public int deleteAwLocaltoolById(Long id);



    //    本地刀具新增
    @Transactional
    boolean addByNumber(List<Map<String, String>> lmlist);


    @Transactional
    boolean reduceByNumber(List<Map<String, String>> lmlist);

//    本地刀具减少
}
