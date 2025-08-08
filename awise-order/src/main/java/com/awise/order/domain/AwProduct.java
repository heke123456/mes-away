package com.awise.order.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 产品存储对象 aw_product
 * 
 * @author awise
 * @date 2023-08-03
 */
public class AwProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品图号 */
    @Excel(name = "产品图号")
    private String id;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String name;

    /** 产品图纸附件地址URL */
    @Excel(name = "产品图纸附件地址URL")
    private String drawingURL;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDrawingURL(String drawingURL) 
    {
        this.drawingURL = drawingURL;
    }

    public String getDrawingURL() 
    {
        return drawingURL;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("drawingURL", getDrawingURL())
            .toString();
    }
}
