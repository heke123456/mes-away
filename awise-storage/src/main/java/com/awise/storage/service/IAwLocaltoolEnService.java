package com.awise.storage.service;

import com.awise.storage.domain.AwLocaltool;
import com.awise.storage.domain.AwLocaltoolEn;

import java.util.List;

public interface IAwLocaltoolEnService {

    public List<AwLocaltoolEn> selectAwLocaltoolEnList(AwLocaltoolEn awLocaltoolEn);
}
