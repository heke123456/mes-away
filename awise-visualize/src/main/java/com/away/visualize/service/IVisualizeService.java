package com.away.visualize.service;



import com.away.visualize.domain.productionVo;

import java.util.List;
import java.util.Map;

public interface IVisualizeService {


    List<Map<String,Integer>> getSaleorderList();

    List<Map<String, Integer>> getToolList();

    List<Map<String, Integer>> getProductList();

    List<Map<String, Integer>> getMaterialList();

    List<Map<String, Integer>> getDeptList();

    List<List<productionVo>> getProductionList();

}
