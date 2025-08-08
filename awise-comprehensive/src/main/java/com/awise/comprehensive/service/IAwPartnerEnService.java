package com.awise.comprehensive.service;

import com.awise.comprehensive.domain.AwPartnerEn;

import java.util.List;

public interface IAwPartnerEnService {


    /**
     * 查询供货商信息列表
     *
     * @param awPartnerEn 供货商信息
     * @return 供货商信息集合
     */
    List<AwPartnerEn> selectAwPartnerEnList(AwPartnerEn awPartnerEn);
}
