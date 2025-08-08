package com.awise.comprehensive.mapper;

import java.util.List;
import com.awise.comprehensive.domain.AwPartner;
import com.awise.comprehensive.domain.AwPartnerEn;

/**
 * 合作方信息Mapper接口
 * 
 * @author awise
 * @date 2023-08-02
 */
public interface AwPartnerMapper 
{
    /**
     * 查询合作方信息
     * 
     * @param ID 合作方信息主键
     * @return 合作方信息
     */
    public AwPartner selectAwPartnerByID(String ID);

    /**
     * 查询合作方信息列表
     * 
     * @param awPartner 合作方信息
     * @return 合作方信息集合
     */
    public List<AwPartner> selectAwPartnerList(AwPartner awPartner);

    /**
     * 新增合作方信息
     * 
     * @param awPartner 合作方信息
     * @return 结果
     */
    public int insertAwPartner(AwPartner awPartner);

    /**
     * 修改合作方信息
     * 
     * @param awPartner 合作方信息
     * @return 结果
     */
    public int updateAwPartner(AwPartner awPartner);

    /**
     * 删除合作方信息
     * 
     * @param ID 合作方信息主键
     * @return 结果
     */
    public int deleteAwPartnerByID(String ID);

    /**
     * 批量删除合作方信息
     * 
     * @param IDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwPartnerByIDs(String[] IDs);

}
