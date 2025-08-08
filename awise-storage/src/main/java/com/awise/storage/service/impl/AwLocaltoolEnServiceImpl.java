package com.awise.storage.service.impl;

import com.awise.storage.domain.AwLocaltoolEn;
import com.awise.storage.mapper.AwLocaltoolEnMapper;
import com.awise.storage.service.IAwLocaltoolEnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwLocaltoolEnServiceImpl  implements IAwLocaltoolEnService {

    @Autowired
    private  AwLocaltoolEnMapper awLocaltoolEnMapper;

    @Override
    public List<AwLocaltoolEn> selectAwLocaltoolEnList(AwLocaltoolEn awLocaltoolEn) {
        return awLocaltoolEnMapper.selectAwLocaltoolEnList(awLocaltoolEn);
    }
}
