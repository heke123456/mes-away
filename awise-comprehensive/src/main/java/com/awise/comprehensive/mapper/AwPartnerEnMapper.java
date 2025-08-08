package com.awise.comprehensive.mapper;

import com.awise.comprehensive.domain.AwPartnerEn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 客户信息Mapper接口
 *
 * @author awise
 * @date 2023-08-02
 */

public interface AwPartnerEnMapper {
    /**
     * 查询客户信息列表
     *
     * @param awPartnerEn 客户信息
     * @return 客户信息集合
     */
    List<AwPartnerEn> selectAwPartnerEnList(AwPartnerEn awPartnerEn);
}
