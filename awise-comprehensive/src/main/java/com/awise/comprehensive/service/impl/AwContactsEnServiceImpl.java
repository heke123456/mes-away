package com.awise.comprehensive.service.impl;

import com.awise.comprehensive.domain.AwContactsEn;
import com.awise.comprehensive.mapper.AwContactsEnMapper;
import com.awise.comprehensive.service.IAwContactsEnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwContactsEnServiceImpl implements IAwContactsEnService {
   @Autowired
    private  AwContactsEnMapper awContactsEnMapper;
    @Override
    public List<AwContactsEn> selectAwContactsEnList(AwContactsEn awContactsEn) {

        return  awContactsEnMapper.selectAwContactsEnList(awContactsEn);
    }
}
