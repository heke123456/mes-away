package com.awise.produce.domain.Vo;

import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;
import com.awise.produce.domain.AwProductiontasks;

import java.util.List;

/**
 * 生产任务单对象 aw_productiontasklist
 *
 * @author awise
 * @date 2023-09-27
 */
public class AwProductiontasklistVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 生产任务单编号 */
    private Long id;

    /** 简称 */

    @Excel(name = "简称",needMerge=true)
    private String referred;

    /** 制单人 */
    @Excel(name = "制单人",needMerge=true)
    private String founder;

    /** 备注信息 */
    @Excel(name = "备注信息",needMerge=true)
    private String notes;

    /** 状态 */
    @Excel(name = "状态" ,dictType = "aw_produce_form_status",needMerge=true)
    private String status;

    @Excel(name = "生产任务列表")
    private List<AwProductiontasksVo> AwProductiontasksVolist;

    
    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setReferred(String referred)
    {
        this.referred = referred;
    }

    public String getReferred()
    {
        return referred;
    }
    public void setFounder(String founder)
    {
        this.founder = founder;
    }

    public String getFounder()
    {
        return founder;
    }
    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public String getNotes()
    {
        return notes;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    public List<AwProductiontasksVo> getAwProductiontasksVolist() {
        return AwProductiontasksVolist;
    }

    public void setAwProductiontasksVolist(List<AwProductiontasksVo> awProductiontasksVolist) {
        AwProductiontasksVolist = awProductiontasksVolist;
    }

    @Override
    public String toString() {
        return "AwProductiontasklistVo{" +
                "id=" + id +
                ", referred='" + referred + '\'' +
                ", founder='" + founder + '\'' +
                ", notes='" + notes + '\'' +
                ", status='" + status + '\'' +
                ", AwProductiontasksVolist=" + getAwProductiontasksVolist() +
                '}';
    }
}
