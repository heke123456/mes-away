package com.awise.order.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 订单附加信息对象 aw_additional
 * 
 * @author awise
 * @date 2023-08-14
 */
public class AwAdditional extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 附加信息id */
    private Long id;

    /** 关联订单 */
    @Excel(name = "关联订单")
    private String saleorderID;

    /** 附加属性 */
    @Excel(name = "附加属性")
    private String key;

    /** 附加内容 */
    @Excel(name = "附加内容")
    private String value;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSaleorderID(String saleorderID) 
    {
        this.saleorderID = saleorderID;
    }

    public String getSaleorderID() 
    {
        return saleorderID;
    }
    public void setKey(String key) 
    {
        this.key = key;
    }

    public String getKey() 
    {
        return key;
    }
    public void setValue(String value) 
    {
        this.value = value;
    }

    public String getValue() 
    {
        return value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("saleorderID", getSaleorderID())
            .append("key", getKey())
            .append("value", getValue())
            .toString();
    }
}
