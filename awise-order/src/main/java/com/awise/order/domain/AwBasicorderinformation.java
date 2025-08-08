package com.awise.order.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * VIEW对象 aw_BasicOrderInformation
 * 
 * @author awise
 * @date 2023-12-22
 */
public class AwBasicorderinformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单 */
    private String id;

    /** 需求数量 */
    @Excel(name = "需求数量")
    private Long number;

    /** 客户姓名 */
    @Excel(name = "客户姓名")
    private String name;

    /** 合同金额 */
    @Excel(name = "合同金额")
    private String money;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setMoney(String money) 
    {
        this.money = money;
    }

    public String getMoney() 
    {
        return money;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("number", getNumber())
            .append("name", getName())
            .append("money", getMoney())
            .append("productName", getProductName())
            .toString();
    }
}
