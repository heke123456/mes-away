package com.away.visualize.mapper;


import com.away.visualize.domain.productionVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

public interface IVisualizeMapper {
    List<Map<String,Integer>>getSaleorderList();

    List<Map<String, Integer>> getToolList();

    List<Map<String, Integer>> getProductList();

    List<Map<String, Integer>> getMaterialList();

    List<Map<String, Integer>> getDeptList();

    List<List<productionVo>> getProductionList();

}
