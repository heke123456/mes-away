package com.awise.storage.service.impl;

import java.awt.geom.FlatteningPathIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.awise.storage.domain.AwLocalmaterials;
import com.awise.storage.domain.AwMaterial;
import com.awise.storage.domain.AwToolinformation;
import com.awise.storage.mapper.AwLocalmaterialsMapper;
import com.awise.storage.mapper.AwToolinformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwLocaltoolMapper;
import com.awise.storage.domain.AwLocaltool;
import com.awise.storage.service.IAwLocaltoolService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 刀具库存Service业务层处理
 *
 * @author awise
 * @date 2023-12-18
 */
@Service
public class AwLocaltoolServiceImpl implements IAwLocaltoolService {
    @Autowired
    private AwLocaltoolMapper awLocaltoolMapper;

    @Autowired
    private AwToolinformationMapper awToolinformationMapper;

    /**
     * 查询刀具库存
     *
     * @param id 刀具库存主键
     * @return 刀具库存
     */
    @Override
    public AwLocaltool selectAwLocaltoolById(Long id) {
        return awLocaltoolMapper.selectAwLocaltoolById(id);
    }

    /**
     * 查询刀具库存列表
     *
     * @param awLocaltool 刀具库存
     * @return 刀具库存
     */
    @Override
    public List<AwLocaltool> selectAwLocaltoolList(AwLocaltool awLocaltool) {
        return awLocaltoolMapper.selectAwLocaltoolList(awLocaltool);
    }

    /**
     * 新增刀具库存
     *
     * @param awLocaltool 刀具库存
     * @return 结果
     */
    @Override
    public int insertAwLocaltool(AwLocaltool awLocaltool) {
        return awLocaltoolMapper.insertAwLocaltool(awLocaltool);
    }

    /**
     * 修改刀具库存
     *
     * @param awLocaltool 刀具库存
     * @return 结果
     */
    @Override
    public int updateAwLocaltool(AwLocaltool awLocaltool) {
        return awLocaltoolMapper.updateAwLocaltool(awLocaltool);
    }

    /**
     * 批量删除刀具库存
     *
     * @param ids 需要删除的刀具库存主键
     * @return 结果
     */
    @Override
    public int deleteAwLocaltoolByIds(Long[] ids) {
        return awLocaltoolMapper.deleteAwLocaltoolByIds(ids);
    }

    /**
     * 删除刀具库存信息
     *
     * @param id 刀具库存主键
     * @return 结果
     */
    @Override
    public int deleteAwLocaltoolById(Long id) {
        return awLocaltoolMapper.deleteAwLocaltoolById(id);
    }


    /**
     * 刀具库存入库
     */

    @Override
    @Transactional
    public boolean addByNumber(List<Map<String, String>> lmlist) {
        for (Map<String, String> line : lmlist) {
            String toolInformationID = line.get("key");
            Integer num = Integer.valueOf(line.get("value"));
            //拿到要入库刀具
            AwToolinformation awToolinformation = awToolinformationMapper.selectAwToolinformationById(toolInformationID);
            Map<AwToolinformation, AwLocaltool> getmap = getmap();
            if (getmap.size() != 0) {
                int flag = 0;
                AwLocaltool awLocaltool = new AwLocaltool();
                for (Map.Entry<AwToolinformation, AwLocaltool> entry : getmap.entrySet()) {
                    AwLocaltool value = entry.getValue();
                    AwToolinformation key = entry.getKey();
                    if (awToolinformation.equals(key)) {
                        flag = 1;
                        //更新刀具
                        awLocaltool = value;
                        awLocaltool.setNumber(awLocaltool.getNumber() + num);
                        break;
                    }
                }
                if (flag > 0) {
                    this.updateAwLocaltool(awLocaltool);
                } else {
                    awLocaltool.setNumber(Long.valueOf(num));
                    awLocaltool.setToolInformationID(awToolinformation.getId());
                    this.insertAwLocaltool(awLocaltool);
                }
            } else {
                AwLocaltool awLocaltool = new AwLocaltool();
                awLocaltool.setNumber(Long.valueOf(num));
                awLocaltool.setToolInformationID(awToolinformation.getId());
                this.insertAwLocaltool(awLocaltool);
            }
        }
        return true;
    }

    public Map<AwToolinformation, AwLocaltool> getmap() {
        Map<AwToolinformation, AwLocaltool> Map_AwToolinformation_AwLocaltool = new HashMap<>();
        //查出所有的本地库存
        List<AwLocaltool> awLocalmaterialsList = awLocaltoolMapper.selectAwLocaltoolList(new AwLocaltool());
        List<AwToolinformation> AwToolinformationList = new ArrayList<>();//本地库存中所有的材料，上面这个集合对应着
        for (AwLocaltool awLocaltool : awLocalmaterialsList) {

            AwToolinformation awToolinformation = awToolinformationMapper.selectAwToolinformationById(awLocaltool.getToolInformationID());
            AwToolinformationList.add(awToolinformation);
        }
        //给map集合赋值
        for (int i = 0; i < awLocalmaterialsList.size(); i++) {
            Map_AwToolinformation_AwLocaltool.put(AwToolinformationList.get(i), awLocalmaterialsList.get(i));
        }
        return Map_AwToolinformation_AwLocaltool;
    }


    /**
     * 刀具库存出库
     */
    @Override
    @Transactional
    public boolean reduceByNumber(List<Map<String, String>> lmlist) {
        for (Map<String, String> line : lmlist) {
            String toolInformationID = line.get("key");
            Integer num = Integer.valueOf(line.get("value"));
            //拿到要入库刀具
            AwToolinformation awToolinformation = awToolinformationMapper.selectAwToolinformationById(toolInformationID);
            Map<AwToolinformation, AwLocaltool> getmap = getmap();
            if (getmap.size() != 0) {
                int flag = 0;
                AwLocaltool awLocaltool = new AwLocaltool();
                for (Map.Entry<AwToolinformation, AwLocaltool> entry : getmap.entrySet()) {
                    AwLocaltool value = entry.getValue();
                    AwToolinformation key = entry.getKey();
                    if (awToolinformation.equals(key)) {
                        // 如果找到就减
                        flag = 1;
                        awLocaltool = value;
                        if (value.getNumber()<num){
                            throw  new RuntimeException("库存不足，出库失败");
                        }
                        awLocaltool.setNumber(value.getNumber() - num);
                        break;
                    }
                }
                if (flag>0){
                    this.updateAwLocaltool(awLocaltool);
                }else {
                    throw  new RuntimeException("出库失败");//抛出异常回滚，不能return false;
                }
            } else {
               return false;
            }
        }
        return true;
    }
}
