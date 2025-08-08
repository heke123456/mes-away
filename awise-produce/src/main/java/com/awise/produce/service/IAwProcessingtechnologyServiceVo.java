package com.awise.produce.service;

import com.awise.produce.domain.AwProcessingtechnology;
import com.awise.produce.domain.Vo.AwProcessingtechnologyVo;

import java.util.List;

/**
 * 加工工艺信息Service接口
 * 
 * @author awise
 * @date 2023-09-26
 */
public interface IAwProcessingtechnologyServiceVo
{

    public AwProcessingtechnologyVo selectAwProcessingtechnologyByIdVO(String id);

    public List<AwProcessingtechnologyVo> selectAwProcessingtechnologyListVO(AwProcessingtechnology awProcessingtechnology);
}
