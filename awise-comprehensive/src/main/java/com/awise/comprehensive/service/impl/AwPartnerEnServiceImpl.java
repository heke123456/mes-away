package com.awise.comprehensive.service.impl;

import com.awise.comprehensive.domain.AwPartner;
import com.awise.comprehensive.domain.AwPartnerEn;
import com.awise.comprehensive.mapper.AwPartnerEnMapper;
import com.awise.comprehensive.mapper.AwPartnerMapper;
import com.awise.comprehensive.service.IAwPartnerEnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwPartnerEnServiceImpl implements IAwPartnerEnService {


    @Autowired
    private AwPartnerEnMapper awPartnerEnMapper;

    @Override
    public List<AwPartnerEn> selectAwPartnerEnList(AwPartnerEn awPartnerEn) {


        return  awPartnerEnMapper.selectAwPartnerEnList(awPartnerEn);
    }
}
