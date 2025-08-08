package com.awise.quality.service;

import java.util.List;
import com.awise.quality.domain.AwProcessinspection;
import com.awise.quality.domain.Vo.AwProcessinspectionVo;

/**
 * 过程检验Service接口
 * 
 * @author awise
 * @date 2023-09-27
 */
public interface IAwProcessinspectionService 
{
    /**
     * 查询过程检验
     * 
     * @param id 过程检验主键
     * @return 过程检验
     */
    public AwProcessinspection selectAwProcessinspectionById(Long id);

    /**
     * 查询过程检验列表
     * 
     * @param awProcessinspection 过程检验
     * @return 过程检验集合
     */
    public List<AwProcessinspection> selectAwProcessinspectionList(AwProcessinspection awProcessinspection);

    /**
     * 新增过程检验
     * 
     * @param awProcessinspection 过程检验
     * @return 结果
     */
    public int insertAwProcessinspection(AwProcessinspection awProcessinspection);

    /**
     * 修改过程检验
     * 
     * @param awProcessinspection 过程检验
     * @return 结果
     */
    public int updateAwProcessinspection(AwProcessinspection awProcessinspection);

    /**
     * 批量删除过程检验
     * 
     * @param ids 需要删除的过程检验主键集合
     * @return 结果
     */
    public int deleteAwProcessinspectionByIds(Long[] ids);

    /**
     * 删除过程检验信息
     * 
     * @param id 过程检验主键
     * @return 结果
     */
    public int deleteAwProcessinspectionById(Long id);


    //导出顺便获取到订单相关信息

    public  List<AwProcessinspectionVo>  selectAwProcessinspectionVoList(AwProcessinspectionVo awProcessinspectionVo);
}
