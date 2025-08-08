package com.awise.storage.mapper;

import com.awise.storage.domain.AwLocaltoolEn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AwLocaltoolEnMapper {

    List<AwLocaltoolEn> selectAwLocaltoolEnList(AwLocaltoolEn awLocaltoolEn);
}
