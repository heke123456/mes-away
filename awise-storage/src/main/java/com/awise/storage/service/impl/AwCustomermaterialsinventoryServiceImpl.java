package com.awise.storage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.awise.storage.domain.AwLocalmaterials;
import com.awise.storage.domain.AwMaterial;
import com.awise.storage.mapper.AwMaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwCustomermaterialsinventoryMapper;
import com.awise.storage.domain.AwCustomermaterialsinventory;
import com.awise.storage.service.IAwCustomermaterialsinventoryService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 客供材料实时库存Service业务层处理
 * 
 * @author awise
 * @date 2024-04-22
 */
@Service
public class AwCustomermaterialsinventoryServiceImpl implements IAwCustomermaterialsinventoryService 
{
    @Autowired
    private AwCustomermaterialsinventoryMapper awCustomermaterialsinventoryMapper;


    @Autowired
    private AwMaterialMapper awMaterialMapper;



    /**
     * 查询客供材料实时库存
     * 
     * @param id 客供材料实时库存主键
     * @return 客供材料实时库存
     */
    @Override
    public AwCustomermaterialsinventory selectAwCustomermaterialsinventoryById(Long id)
    {
        return awCustomermaterialsinventoryMapper.selectAwCustomermaterialsinventoryById(id);
    }

    /**
     * 查询客供材料实时库存列表
     * 
     * @param awCustomermaterialsinventory 客供材料实时库存
     * @return 客供材料实时库存
     */
    @Override
    public List<AwCustomermaterialsinventory> selectAwCustomermaterialsinventoryList(AwCustomermaterialsinventory awCustomermaterialsinventory)
    {
        return awCustomermaterialsinventoryMapper.selectAwCustomermaterialsinventoryList(awCustomermaterialsinventory);
    }

    /**
     * 新增客供材料实时库存
     * 
     * @param awCustomermaterialsinventory 客供材料实时库存
     * @return 结果
     */
    @Override
    public int insertAwCustomermaterialsinventory(AwCustomermaterialsinventory awCustomermaterialsinventory)
    {
        return awCustomermaterialsinventoryMapper.insertAwCustomermaterialsinventory(awCustomermaterialsinventory);
    }

    /**
     * 修改客供材料实时库存
     * 
     * @param awCustomermaterialsinventory 客供材料实时库存
     * @return 结果
     */
    @Override
    public int updateAwCustomermaterialsinventory(AwCustomermaterialsinventory awCustomermaterialsinventory)
    {
        return awCustomermaterialsinventoryMapper.updateAwCustomermaterialsinventory(awCustomermaterialsinventory);
    }

    /**
     * 批量删除客供材料实时库存
     * 
     * @param ids 需要删除的客供材料实时库存主键
     * @return 结果
     */
    @Override
    public int deleteAwCustomermaterialsinventoryByIds(Long[] ids)
    {
        return awCustomermaterialsinventoryMapper.deleteAwCustomermaterialsinventoryByIds(ids);
    }

    /**
     * 删除客供材料实时库存信息
     * 
     * @param id 客供材料实时库存主键
     * @return 结果
     */
    @Override
    public int deleteAwCustomermaterialsinventoryById(Long id)
    {
        return awCustomermaterialsinventoryMapper.deleteAwCustomermaterialsinventoryById(id);
    }

//    入库

    @Transactional
    @Override
    public boolean addByNumber(List<Map<String, String>> lmlist) {
        for(Map<String, String> line : lmlist) {
            String materialID = line.get("key");
            Integer num = Integer.valueOf(line.get("value"));
            //拿到材料
            AwMaterial awMaterial = awMaterialMapper.selectAwMaterialById(materialID);
            Map<AwMaterial, AwCustomermaterialsinventory> getmap = getmap();
            if (getmap.size()!=0){
                int flag=0;
                AwCustomermaterialsinventory awCustomermaterialsinventory = new AwCustomermaterialsinventory();
                for (Map.Entry<AwMaterial, AwCustomermaterialsinventory> entry : getmap.entrySet()) {
                    AwMaterial key = entry.getKey();
                    AwCustomermaterialsinventory value = entry.getValue();

                    if (key.equals(awMaterial)) {//重写equals方法
                        // 如果找到就累加
                        flag = 1;
                        awCustomermaterialsinventory=value;
                        awCustomermaterialsinventory.setNumber(value.getNumber()+num);
                        break;
                    }
                }
                if (flag>0){
                    this.updateAwCustomermaterialsinventory(awCustomermaterialsinventory);
                }else {
                    awCustomermaterialsinventory.setNumber(Long.valueOf(num));
                    awCustomermaterialsinventory.setMaterialID(awMaterial.getId());
                    this.insertAwCustomermaterialsinventory(awCustomermaterialsinventory);
                }
            }else {
                AwCustomermaterialsinventory awCustomermaterialsinventory1 = new AwCustomermaterialsinventory();
                awCustomermaterialsinventory1.setNumber(Long.valueOf(num));
                awCustomermaterialsinventory1.setMaterialID(materialID);
                awCustomermaterialsinventoryMapper.insertAwCustomermaterialsinventory(awCustomermaterialsinventory1);
            }
        }
        return true;
    }


    //出库
    @Transactional
    @Override
    public boolean reduceByNumber(List<Map<String, String>> lmlist) {
        for(Map<String, String> line : lmlist) {
            String materialID = line.get("key");
            Integer num = Integer.valueOf(line.get("value"));
            //拿到材料
            AwMaterial awMaterial = awMaterialMapper.selectAwMaterialById(materialID);
            Map<AwMaterial, AwCustomermaterialsinventory> getmap = getmap();
            if (getmap.size()!=0){
                int flag=0;
                AwCustomermaterialsinventory awCustomermaterialsinventory = new AwCustomermaterialsinventory();
                for (Map.Entry<AwMaterial, AwCustomermaterialsinventory> entry : getmap.entrySet()) {
                    AwMaterial key = entry.getKey();
                    AwCustomermaterialsinventory value = entry.getValue();

                    if (key.equals(awMaterial)) {//重写equals方法
                        // 如果找到就减
                        flag = 1;
                        awCustomermaterialsinventory=value;

                        if (value.getNumber()<num){
                            throw  new RuntimeException("库存不足，出库失败");
                        }
                        awCustomermaterialsinventory.setNumber(value.getNumber()-num);
                        break;
                    }
                }
                if (flag>0){
                    this.updateAwCustomermaterialsinventory(awCustomermaterialsinventory);
                }else {
                    throw  new RuntimeException("出库失败");//抛出异常回滚，不能return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }


    //    拿到本地的库存对应的材料
//拿到本地库存的材料
    public  Map<AwMaterial, AwCustomermaterialsinventory> getmap(){   //AwCustomermaterialsinventory
        Map<AwMaterial,AwCustomermaterialsinventory> Map_AwMaterial_AwCustomermaterialsinventory=new HashMap<>();
        //查出所有的本地库存
        List<AwCustomermaterialsinventory> awCustomermaterialsinventory = awCustomermaterialsinventoryMapper.selectAwCustomermaterialsinventoryList(new AwCustomermaterialsinventory());
        List<AwMaterial> awMaterialsList=new ArrayList<>();//本地库存中所有的材料，上面这个集合对应着
        for (AwCustomermaterialsinventory awLocalmaterial : awCustomermaterialsinventory) {
            AwMaterial awMaterial1 = awMaterialMapper.selectAwMaterialById(awLocalmaterial.getMaterialID());
            awMaterialsList.add(awMaterial1);
        }
        //给map集合赋值
        for (int i = 0; i < awCustomermaterialsinventory.size(); i++) {
            Map_AwMaterial_AwCustomermaterialsinventory.put(awMaterialsList.get(i),awCustomermaterialsinventory.get(i));
        }
        return   Map_AwMaterial_AwCustomermaterialsinventory;
    }
}
