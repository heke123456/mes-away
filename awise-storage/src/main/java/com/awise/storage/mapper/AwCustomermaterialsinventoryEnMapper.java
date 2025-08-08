package com.awise.storage.mapper;


import com.awise.storage.domain.AwCustomermaterialsinventoryEn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface AwCustomermaterialsinventoryEnMapper {

    List<AwCustomermaterialsinventoryEn> selectAwCustomermaterialsinventoryEnList(AwCustomermaterialsinventoryEn awCustomermaterialsinventoryEn);

}
