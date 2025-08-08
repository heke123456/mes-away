package com.awise.produce.mapper;

import com.awise.produce.domain.AwProcessingtechnology;
import com.awise.produce.domain.Vo.AwProcessingtechnologyVo;

import java.util.List;

/**
 * 加工工艺信息Mapper接口
 * 
 * @author awise
 * @date 2023-09-26
 */
public interface AwProcessingtechnologyVoMapper
{

    AwProcessingtechnologyVo selectAwProcessingtechnologyByIdVo(String id);

    List<AwProcessingtechnologyVo> selectAwProcessingtechnologyListVo(AwProcessingtechnology awProcessingtechnology);
}
