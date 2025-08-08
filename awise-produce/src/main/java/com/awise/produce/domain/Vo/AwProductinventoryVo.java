package com.awise.produce.domain.Vo;

import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 产品库存对象 aw_ProductInventory
 * 
 * @author awise
 * @date 2024-04-28
 */
public class AwProductinventoryVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品库存编号 */
    private Long id;

    /** 产品编号 */
    @Excel(name = "产品编号")
    private String productID;

    /** 产品数量 */
    @Excel(name = "产品库存")
    private Long number;

    /** 产品库存 */
    @Excel(name = "产品重量")
    private Long weight;


    @Excel(name = "产品名称")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProductID(String productID) 
    {
        this.productID = productID;
    }

    public String getProductID() 
    {
        return productID;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }
    public void setWeight(Long weight) 
    {
        this.weight = weight;
    }

    public Long getWeight() 
    {
        return weight;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productID", getProductID())
            .append("number", getNumber())
            .append("name", getName())
            .append("weight", getWeight())
            .toString();
    }
}
