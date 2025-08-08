package com.awise.produce.service;

import java.util.List;
import com.awise.produce.domain.AwProcessingtechnology;
import com.awise.produce.domain.Vo.AwProcessingtechnologyVo;

/**
 * 加工工艺信息Service接口
 * 
 * @author awise
 * @date 2023-09-26
 */
public interface IAwProcessingtechnologyService 
{
    /**
     * 查询加工工艺信息
     * 
     * @param id 加工工艺信息主键
     * @return 加工工艺信息
     */
    public AwProcessingtechnology selectAwProcessingtechnologyById(String id);

    /**
     * 查询加工工艺信息列表
     * 
     * @param awProcessingtechnology 加工工艺信息
     * @return 加工工艺信息集合
     */
    public List<AwProcessingtechnology> selectAwProcessingtechnologyList(AwProcessingtechnology awProcessingtechnology);

    /**
     * 新增加工工艺信息
     * 
     * @param awProcessingtechnology 加工工艺信息
     * @return 结果
     */
    public int insertAwProcessingtechnology(AwProcessingtechnology awProcessingtechnology);

    /**
     * 修改加工工艺信息
     * 
     * @param awProcessingtechnology 加工工艺信息
     * @return 结果
     */
    public int updateAwProcessingtechnology(AwProcessingtechnology awProcessingtechnology);

    /**
     * 批量删除加工工艺信息
     * 
     * @param ids 需要删除的加工工艺信息主键集合
     * @return 结果
     */
    public int deleteAwProcessingtechnologyByIds(String[] ids);

    /**
     * 删除加工工艺信息信息
     * 
     * @param id 加工工艺信息主键
     * @return 结果
     */
    public int deleteAwProcessingtechnologyById(String id);

}
