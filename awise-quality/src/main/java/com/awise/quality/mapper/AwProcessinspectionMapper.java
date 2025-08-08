package com.awise.quality.mapper;

import java.util.List;
import com.awise.quality.domain.AwProcessinspection;
import com.awise.quality.domain.Vo.AwProcessinspectionVo;

/**
 * 过程检验Mapper接口
 * 
 * @author awise
 * @date 2023-09-27
 */
public interface AwProcessinspectionMapper 
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
     * 删除过程检验
     * 
     * @param id 过程检验主键
     * @return 结果
     */
    public int deleteAwProcessinspectionById(Long id);

    /**
     * 批量删除过程检验
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwProcessinspectionByIds(Long[] ids);

   public List<AwProcessinspectionVo> selectAwProcessinspectionVoList(AwProcessinspectionVo awProcessinspectionVo);
}
