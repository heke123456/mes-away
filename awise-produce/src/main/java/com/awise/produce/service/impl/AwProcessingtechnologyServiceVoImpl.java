package com.awise.produce.service.impl;

import com.away.common.utils.DateUtils;
import com.awise.produce.domain.AwProcessingtechnology;
import com.awise.produce.domain.Vo.AwProcessingtechnologyVo;
import com.awise.produce.mapper.AwProcessingtechnologyMapper;
import com.awise.produce.mapper.AwProcessingtechnologyVoMapper;
import com.awise.produce.service.IAwProcessingtechnologyService;
import com.awise.produce.service.IAwProcessingtechnologyServiceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 加工工艺信息Service业务层处理
 * 
 * @author awise
 * @date 2023-09-26
 */
@Service
public class AwProcessingtechnologyServiceVoImpl implements IAwProcessingtechnologyServiceVo
{
    @Autowired
    private AwProcessingtechnologyVoMapper awProcessingtechnologyvoMapper;


    @Override
    public AwProcessingtechnologyVo selectAwProcessingtechnologyByIdVO(String id) {
        return awProcessingtechnologyvoMapper.selectAwProcessingtechnologyByIdVo(id);
    }

    @Override
    public List<AwProcessingtechnologyVo> selectAwProcessingtechnologyListVO(AwProcessingtechnology awProcessingtechnology) {
        return awProcessingtechnologyvoMapper.selectAwProcessingtechnologyListVo(awProcessingtechnology);
    }


}
