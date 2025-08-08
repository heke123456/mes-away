package com.awise.storage.service;

import java.util.List;
import com.awise.storage.domain.AwBasictoolinformation;

/**
 * BasicToolInformationService接口
 * 
 * @author awise
 * @date 2023-12-06
 */
public interface IAwBasictoolinformationService 
{
    /**
     * 查询BasicToolInformation
     * 
     * @param id BasicToolInformation主键
     * @return BasicToolInformation
     */
    public AwBasictoolinformation selectAwBasictoolinformationById(String id);

    /**
     * 查询BasicToolInformation列表
     * 
     * @param awBasictoolinformation BasicToolInformation
     * @return BasicToolInformation集合
     */
    public List<AwBasictoolinformation> selectAwBasictoolinformationList(AwBasictoolinformation awBasictoolinformation);

    /**
     * 新增BasicToolInformation
     * 
     * @param awBasictoolinformation BasicToolInformation
     * @return 结果
     */
    public int insertAwBasictoolinformation(AwBasictoolinformation awBasictoolinformation);

    /**
     * 修改BasicToolInformation
     * 
     * @param awBasictoolinformation BasicToolInformation
     * @return 结果
     */
    public int updateAwBasictoolinformation(AwBasictoolinformation awBasictoolinformation);

    /**
     * 批量删除BasicToolInformation
     * 
     * @param ids 需要删除的BasicToolInformation主键集合
     * @return 结果
     */
    public int deleteAwBasictoolinformationByIds(String[] ids);

    /**
     * 删除BasicToolInformation信息
     * 
     * @param id BasicToolInformation主键
     * @return 结果
     */
    public int deleteAwBasictoolinformationById(String id);
}
