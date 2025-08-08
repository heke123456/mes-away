package com.awise.storage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.awise.storage.domain.AwMaterial;
import com.awise.storage.mapper.AwMaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwLocalmaterialsMapper;
import com.awise.storage.domain.AwLocalmaterials;
import com.awise.storage.service.IAwLocalmaterialsService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 本地材料实时库存Service业务层处理
 *
 * @author awise
 * @date 2023-08-03
 */
@Service
public class AwLocalmaterialsServiceImpl implements IAwLocalmaterialsService
{
    @Autowired
    private AwLocalmaterialsMapper awLocalmaterialsMapper;

    @Autowired
    private AwMaterialMapper awMaterialMapper;

    /**
     * 查询本地材料实时库存
     *
     * @param id 本地材料实时库存主键
     * @return 本地材料实时库存
     */
    @Override
    public AwLocalmaterials selectAwLocalmaterialsById(Long id)
    {
        return awLocalmaterialsMapper.selectAwLocalmaterialsById(id);
    }

    /**
     * 查询本地材料实时库存列表
     *
     * @param awLocalmaterials 本地材料实时库存
     * @return 本地材料实时库存
     */
    @Override
    public List<AwLocalmaterials> selectAwLocalmaterialsList(AwLocalmaterials awLocalmaterials)
    {
        return awLocalmaterialsMapper.selectAwLocalmaterialsList(awLocalmaterials);
    }

    /***
     *  本地实时库存新增
     * @param lmlist 需要新增库存的材料列表
     * @return 结果
     */
    @Override
    @Transactional
    public boolean addByNumber(List<Map<String,String>> lmlist){
        for(Map<String, String> line : lmlist) {
            String materialID = line.get("key");
            Integer num = Integer.valueOf(line.get("value"));
            //拿到材料
            AwMaterial awMaterial = awMaterialMapper.selectAwMaterialById(materialID);
            Map<AwMaterial, AwLocalmaterials> getmap = getmap();
            if (getmap.size()!=0){
                int flag=0;
                AwLocalmaterials awLocalmaterials = new AwLocalmaterials();
                for (Map.Entry<AwMaterial, AwLocalmaterials> entry : getmap.entrySet()) {
                    AwMaterial key = entry.getKey();
                    AwLocalmaterials value = entry.getValue();

                    if (key.equals(awMaterial)) {//重写equals方法
                        // 如果找到就累加
                        flag = 1;
                        awLocalmaterials=value;
                        awLocalmaterials.setNumber(value.getNumber()+num);
                        break;
                    }
                }
                if (flag>0){
                    this.updateAwLocalmaterials(awLocalmaterials);
                }else {
                    awLocalmaterials.setNumber(Long.valueOf(num));
                    awLocalmaterials.setMaterialID(awMaterial.getId());
                    this.insertAwLocalmaterials(awLocalmaterials);
                }
            }else {
                AwLocalmaterials awLocalmaterials1 = new AwLocalmaterials();
                awLocalmaterials1.setNumber(Long.valueOf(num));
                awLocalmaterials1.setMaterialID(materialID);
                awLocalmaterialsMapper.insertAwLocalmaterials(awLocalmaterials1);
            }
        }
        return true;
    }
//    拿到本地的库存对应的材料
//拿到本地库存的材料
public  Map<AwMaterial,AwLocalmaterials> getmap(){
    Map<AwMaterial,AwLocalmaterials> Map_AwMaterial_AwLocalmaterials=new HashMap<>();
    //查出所有的本地库存
    List<AwLocalmaterials> awLocalmaterialsList = awLocalmaterialsMapper.selectAwLocalmaterialsList(new AwLocalmaterials());
    List<AwMaterial> awMaterialsList=new ArrayList<>();//本地库存中所有的材料，上面这个集合对应着
    for (AwLocalmaterials awLocalmaterial : awLocalmaterialsList) {
        AwMaterial awMaterial1 = awMaterialMapper.selectAwMaterialById(awLocalmaterial.getMaterialID());
        awMaterialsList.add(awMaterial1);
    }
    //给map集合赋值
    for (int i = 0; i < awLocalmaterialsList.size(); i++) {
        Map_AwMaterial_AwLocalmaterials.put(awMaterialsList.get(i),awLocalmaterialsList.get(i));
    }
    return   Map_AwMaterial_AwLocalmaterials;
}


    /***
     *  本地实时库存减少
     * @param lmlist 需要减少库存的材料列表
     * @return 结果
     */
    @Override
    @Transactional
    public boolean reduceByNumber(List<Map<String,String>> lmlist){
        for(Map<String, String> line : lmlist) {
            String materialID = line.get("key");
            Integer num = Integer.valueOf(line.get("value"));
            //拿到材料
            AwMaterial awMaterial = awMaterialMapper.selectAwMaterialById(materialID);
            Map<AwMaterial, AwLocalmaterials> getmap = getmap();
            if (getmap.size()!=0){
                int flag=0;
                AwLocalmaterials awLocalmaterials = new AwLocalmaterials();
                for (Map.Entry<AwMaterial, AwLocalmaterials> entry : getmap.entrySet()) {
                    AwMaterial key = entry.getKey();
                    AwLocalmaterials value = entry.getValue();

                    if (key.equals(awMaterial)) {//重写equals方法
                        // 如果找到就减
                        flag = 1;
                        awLocalmaterials=value;

                        if (value.getNumber()<num){
                            throw  new RuntimeException("库存不足，出库失败");
                        }
                        awLocalmaterials.setNumber(value.getNumber()-num);
                        break;
                    }
                }
                if (flag>0){
                    this.updateAwLocalmaterials(awLocalmaterials);
                }else {
                    throw  new RuntimeException("出库失败");//抛出异常回滚，不能return false;

                }
            }else {
                return false;
            }
        }
        return true;
    }

    /**
     * 新增本地材料实时库存
     *
     * @param awLocalmaterials 本地材料实时库存
     * @return 结果
     */
    @Override
    public int insertAwLocalmaterials(AwLocalmaterials awLocalmaterials)
    {
        return awLocalmaterialsMapper.insertAwLocalmaterials(awLocalmaterials);
    }

    /**
     * 修改本地材料实时库存
     *
     * @param awLocalmaterials 本地材料实时库存
     * @return 结果
     */
    @Override
    public int updateAwLocalmaterials(AwLocalmaterials awLocalmaterials)
    {
        return awLocalmaterialsMapper.updateAwLocalmaterials(awLocalmaterials);
    }

    /**
     * 批量删除本地材料实时库存
     *
     * @param ids 需要删除的本地材料实时库存主键
     * @return 结果
     */
    @Override
    public int deleteAwLocalmaterialsByIds(Long[] ids)
    {
        return awLocalmaterialsMapper.deleteAwLocalmaterialsByIds(ids);
    }

    /**
     * 删除本地材料实时库存信息
     *
     * @param id 本地材料实时库存主键
     * @return 结果
     */
    @Override
    public int deleteAwLocalmaterialsById(Long id)
    {
        return awLocalmaterialsMapper.deleteAwLocalmaterialsById(id);
    }
}
