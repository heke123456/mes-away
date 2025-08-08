package com.awise.qrcode.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 二维码对象 aw_qrcode
 *
 * @author awise
 * @date 2023-11-09
 */
public class AwQrcode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 二维码唯一标识符 */
    @Excel(name = "二维码唯一标识符")
    private Long id;

    /** 文件地址 */
    @Excel(name = "文件地址")
    private String fileurl;

    /** 任务单编号 */
    @Excel(name = "任务单编号")
    private Long productionTasksFormID;

    /** 任务编号 */
    @Excel(name = "任务编号")
    private Long productionTasksID;

    /** 工序编号 */
    @Excel(name = "工序编号")
    private Long processingprocessID;

    /** 有效时长 */
    @Excel(name = "有效时长")
    private String effectiveDuration;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setFileurl(String fileurl)
    {
        this.fileurl = fileurl;
    }

    public String getFileurl()
    {
        return fileurl;
    }
    public void setProductionTasksFormID(Long productionTasksFormID)
    {
        this.productionTasksFormID = productionTasksFormID;
    }

    public Long getProductionTasksFormID()
    {
        return productionTasksFormID;
    }
    public void setProductionTasksID(Long productionTasksID)
    {
        this.productionTasksID = productionTasksID;
    }

    public Long getProductionTasksID()
    {
        return productionTasksID;
    }
    public void setProcessingprocessID(Long processingprocessID)
    {
        this.processingprocessID = processingprocessID;
    }

    public Long getProcessingprocessID()
    {
        return processingprocessID;
    }
    public void setEffectiveDuration(String effectiveDuration)
    {
        this.effectiveDuration = effectiveDuration;
    }

    public String getEffectiveDuration()
    {
        return effectiveDuration;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("fileurl", getFileurl())
                .append("productionTasksFormID", getProductionTasksFormID())
                .append("productionTasksID", getProductionTasksID())
                .append("processingprocessID", getProcessingprocessID())
                .append("createTime", getCreateTime())
                .append("effectiveDuration", getEffectiveDuration())
                .toString();
    }
}
