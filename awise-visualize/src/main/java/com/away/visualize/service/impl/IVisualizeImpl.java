package com.away.visualize.service.impl;

import com.away.visualize.domain.productionVo;
import com.away.visualize.mapper.IVisualizeMapper;
import com.away.visualize.service.IVisualizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;


@Service
public class IVisualizeImpl  implements IVisualizeService {

    @Autowired
    IVisualizeMapper ivisualizeMapper;

    @Override
    public List<Map<String,Integer>> getSaleorderList() {
        return ivisualizeMapper.getSaleorderList();
    }

    @Override
    public List<Map<String, Integer>> getToolList() {
        return ivisualizeMapper.getToolList();

    }

    @Override
    public List<Map<String, Integer>> getProductList() {
        return ivisualizeMapper.getProductList();
    }

    @Override
    public List<Map<String, Integer>> getMaterialList() {
        return ivisualizeMapper.getMaterialList();
    }

    @Override
    public List<Map<String, Integer>> getDeptList() {
        return ivisualizeMapper.getDeptList();
    }

    @Override
    public List<List<productionVo>> getProductionList() {
        return ivisualizeMapper.getProductionList();
    }


}
