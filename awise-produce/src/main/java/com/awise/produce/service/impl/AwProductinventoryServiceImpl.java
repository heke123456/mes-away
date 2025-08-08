package com.awise.produce.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.awise.order.domain.AwProduct;
import com.awise.produce.domain.AwProductmanhour;
import com.awise.produce.mapper.AwProductmanhourMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.produce.mapper.AwProductinventoryMapper;
import com.awise.produce.domain.AwProductinventory;
import com.awise.produce.service.IAwProductinventoryService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 产品库存Service业务层处理
 * 
 * @author awise
 * @date 2024-04-28
 */
@Service
public class AwProductinventoryServiceImpl implements IAwProductinventoryService 
{
    @Autowired
    private AwProductinventoryMapper awProductinventoryMapper;







    /**
     * 查询产品库存
     * 
     * @param id 产品库存主键
     * @return 产品库存
     */
    @Override
    public AwProductinventory selectAwProductinventoryById(Long id)
    {
        return awProductinventoryMapper.selectAwProductinventoryById(id);
    }

    /**
     * 查询产品库存列表
     * 
     * @param awProductinventory 产品库存
     * @return 产品库存
     */
    @Override
    public List<AwProductinventory> selectAwProductinventoryList(AwProductinventory awProductinventory)
    {
        return awProductinventoryMapper.selectAwProductinventoryList(awProductinventory);
    }

    /**
     * 新增产品库存
     * 
     * @param awProductinventory 产品库存
     * @return 结果
     */
    @Override
    public int insertAwProductinventory(AwProductinventory awProductinventory)
    {
        return awProductinventoryMapper.insertAwProductinventory(awProductinventory);
    }

    /**
     * 修改产品库存
     * 
     * @param awProductinventory 产品库存
     * @return 结果
     */
    @Override
    public int updateAwProductinventory(AwProductinventory awProductinventory)
    {
        return awProductinventoryMapper.updateAwProductinventory(awProductinventory);
    }

    /**
     * 批量删除产品库存
     * 
     * @param ids 需要删除的产品库存主键
     * @return 结果
     */
    @Override
    public int deleteAwProductinventoryByIds(Long[] ids)
    {
        return awProductinventoryMapper.deleteAwProductinventoryByIds(ids);
    }

    /**
     * 删除产品库存信息
     * 
     * @param id 产品库存主键
     * @return 结果
     */
    @Override
    public int deleteAwProductinventoryById(Long id)
    {
        return awProductinventoryMapper.deleteAwProductinventoryById(id);
    }

    @Override
    @Transactional
    public boolean addByNumber(List<Map<String, String>> lmlist) {

        ArrayList<AwProductinventory> cache_awProductinventoryList = new ArrayList<>();

        for(Map<String, String> line : lmlist) {
            String productID = line.get("key");
            Integer num = Integer.valueOf(line.get("value"));
            AwProductinventory awProductinventory = new AwProductinventory();
            awProductinventory.setProductID(productID);
            List<AwProductinventory> list = this.selectAwProductinventoryList(awProductinventory);
            if (!list.isEmpty()){
                awProductinventory = list.get(0);
                awProductinventory.setNumber(awProductinventory.getNumber()+num);
                cache_awProductinventoryList.add(awProductinventory);
            }else {
                try {
                    awProductinventory.setNumber(Long.valueOf(0));
                    insertAwProductinventory(awProductinventory);
                    list =this.selectAwProductinventoryList(awProductinventory);
                    awProductinventory  = list.get(0);
                    awProductinventory.setNumber(awProductinventory.getNumber()+num);
                    cache_awProductinventoryList.add(awProductinventory);
                }catch (Exception e){
                    return false;
                }
            }
        }
        for (AwProductinventory awProductinventory : cache_awProductinventoryList) {
            this.updateAwProductinventory(awProductinventory);
        }

        return true;
    }


    @Transactional
    @Override
    public boolean reduceByNumber(List<Map<String, String>> lmlist) {
        ArrayList<AwProductinventory> cache_awProductinventoryList = new ArrayList<>();
        for(Map<String, String> line : lmlist) {
            String productID = line.get("key");
            Integer num = Integer.valueOf(line.get("value"));
            AwProductinventory awProductinventory = new AwProductinventory();
            awProductinventory.setProductID(productID);
            List<AwProductinventory> list = selectAwProductinventoryList(awProductinventory);
            if (!list.isEmpty()) {
                awProductinventory = list.get(0);
                if (awProductinventory.getNumber()-num>=0){
                    awProductinventory.setNumber(awProductinventory.getNumber()-num);
                    cache_awProductinventoryList.add(awProductinventory);
                }else {
                    return false;
                }
            } else {
                return false;
            }
        }
        for (AwProductinventory awProductinventory : cache_awProductinventoryList) {
            this.updateAwProductinventory(awProductinventory);
        }
        return true;
    }
}
