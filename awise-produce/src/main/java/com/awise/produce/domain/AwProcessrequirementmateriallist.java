package com.awise.produce.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 工艺需求材料对象 aw_processrequirementmateriallist
 * 
 * @author awise
 * @date 2023-10-15
 */
public class AwProcessrequirementmateriallist extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 材料基础信息编号 */
    @Excel(name = "材料基础信息编号")
    private String materialID;

    /** 工艺编号 */
    private String processingTechnologyID;

    /** 下料尺寸 */
    @Excel(name = "下料尺寸")
    private String cuttingSize;

    /** 可制件数 */
    @Excel(name = "可制件数")
    private String numberProducibleParts;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMaterialID(String materialID) 
    {
        this.materialID = materialID;
    }

    public String getMaterialID() 
    {
        return materialID;
    }
    public void setProcessingTechnologyID(String processingTechnologyID) 
    {
        this.processingTechnologyID = processingTechnologyID;
    }

    public String getProcessingTechnologyID() 
    {
        return processingTechnologyID;
    }
    public void setCuttingSize(String cuttingSize)
    {
        this.cuttingSize = cuttingSize;
    }

    public String getCuttingSize()
    {
        return cuttingSize;
    }
    public void setNumberProducibleParts(String numberProducibleParts) 
    {
        this.numberProducibleParts = numberProducibleParts;
    }

    public String getNumberProducibleParts() 
    {
        return numberProducibleParts;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("materialID", getMaterialID())
            .append("processingTechnologyID", getProcessingTechnologyID())
            .append("cuttingSize", getCuttingSize())
            .append("numberProducibleParts", getNumberProducibleParts())
            .toString();
    }
}
