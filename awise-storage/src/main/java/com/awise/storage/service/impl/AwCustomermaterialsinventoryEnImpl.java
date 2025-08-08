package com.awise.storage.service.impl;

import com.awise.storage.domain.AwCustomermaterialsinventoryEn;
import com.awise.storage.mapper.AwCustomermaterialsinventoryEnMapper;
import com.awise.storage.mapper.AwCustomermaterialsinventoryMapper;
import com.awise.storage.service.IAwCustomermaterialsinventoryEnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwCustomermaterialsinventoryEnImpl implements IAwCustomermaterialsinventoryEnService {
    @Autowired
     private   AwCustomermaterialsinventoryEnMapper awCustomermaterialsinventoryEnMapper;
    @Override
    public List<AwCustomermaterialsinventoryEn> selectAwCustomermaterialsinventoryEnList(AwCustomermaterialsinventoryEn awCustomermaterialsinventoryEn) {

         return awCustomermaterialsinventoryEnMapper.selectAwCustomermaterialsinventoryEnList(awCustomermaterialsinventoryEn);
    }
}
