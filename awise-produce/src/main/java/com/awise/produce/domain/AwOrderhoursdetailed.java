package com.awise.produce.domain;

import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 工时统计对象 aw_orderhoursdetailed
 * 
 * @author awise
 * @date 2024-03-15
 */
public class AwOrderhoursdetailed extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单id#日期+编号# */
    private String id;

    @Excel(name = "订单状态")
    private String state;


    @Excel(name = "是否客供")
    private String iscustomersuppliedmaterials;


    /** 下单日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下单日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderDate;

    /** 需求数量#要求大于0# */
    @Excel(name = "需求数量#要求大于0#")
    private Long number;

    /** 实体姓名 */
    @Excel(name = "实体姓名")
    private String name;

    /** 社会统一信用代码 */
    @Excel(name = "社会统一信用代码")
    private String unifiedCreditCode;



    /** 产品图纸附件地址URL */
    @Excel(name = "产品编号")
    private String productID;


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
    public void setOrderDate(Date orderDate) 
    {
        this.orderDate = orderDate;
    }

    public Date getOrderDate() 
    {
        return orderDate;
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
    public void setUnifiedCreditCode(String unifiedCreditCode) 
    {
        this.unifiedCreditCode = unifiedCreditCode;
    }

    public String getUnifiedCreditCode() 
    {
        return unifiedCreditCode;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setProductID(String productID)
    {
        this.productID = productID;
    }

    public String getProductID()
    {
        return productID;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIscustomersuppliedmaterials() {
        return iscustomersuppliedmaterials;
    }

    public void setIscustomersuppliedmaterials(String iscustomersuppliedmaterials) {
        this.iscustomersuppliedmaterials = iscustomersuppliedmaterials;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("orderDate", getOrderDate())
            .append("number", getNumber())
            .append("name", getName())
            .append("state", getState())
            .append("iscustomersuppliedmaterials", getIscustomersuppliedmaterials())
            .append("unifiedCreditCode", getUnifiedCreditCode())
            .append("productName", getProductName())
            .append("productID", getProductID())
            .toString();
    }
}
