package com.away.visualize.controller;

import com.away.common.core.domain.AjaxResult;
import com.away.common.core.page.TableDataInfo;

import com.away.visualize.domain.productionVo;
import com.away.visualize.service.IVisualizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/visualize")
public class visualizeController {

    @Autowired
    private IVisualizeService iVisualizeService;

    @GetMapping("/saleorder/list")
    public AjaxResult getSaleorderList( )

    {
        List<Map<String,Integer>> list = iVisualizeService.getSaleorderList();
        return  AjaxResult.success(list);
    }

    @GetMapping("/Tool/list")
    public AjaxResult getToolList( )
    {
        List<Map<String,Integer>> list = iVisualizeService.getToolList();
        return  AjaxResult.success(list);
    }

    @GetMapping("/Product/list")
    public AjaxResult getProductList( )
    {
        List<Map<String,Integer>> list = iVisualizeService.getProductList();
        return  AjaxResult.success(list);
    }


    @GetMapping("/Material/list")
    public AjaxResult getMaterialList( )
    {
        List<Map<String,Integer>> list = iVisualizeService.getMaterialList();
        return  AjaxResult.success(list);
    }


    @GetMapping("/Dept/list")
    public AjaxResult getDeptList( )
    {
        List<Map<String,Integer>> list = iVisualizeService.getDeptList();
        return  AjaxResult.success(list);
    }

    @GetMapping("/Production/list")
    public AjaxResult getProductionList( )
    {
        List<List<productionVo>> list = iVisualizeService.getProductionList();
        return  AjaxResult.success(list);
    }


}
