package com.awise.produce.domain.Vo;

import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;
import com.awise.produce.domain.AwProductmanhour;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

public class AwOrderhoursdetailedVo extends BaseEntity {


    private static final long serialVersionUID = 1L;

    /** 订单id#日期+编号# */
    private String id;

    @Excel(name = "订单状态",needMerge=true,dictType = "aw_order_saleoder_options")
    private String state;


    @Excel(name = "是否客供" ,needMerge=true,dictType = "aw_oder_customer_status")
    private String iscustomersuppliedmaterials;


    /** 下单日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下单日期", width = 30, dateFormat = "yyyy-MM-dd",needMerge=true)
    private Date orderDate;

    /** 需求数量#要求大于0# */
    @Excel(name = "需求数量#要求大于0#",needMerge=true)
    private Long number;

    /** 实体姓名 */
    @Excel(name = "实体姓名",needMerge=true)
    private String name;

    /** 社会统一信用代码 */
    @Excel(name = "社会统一信用代码",needMerge=true)
    private String unifiedCreditCode;

    /** 产品名称 */
    @Excel(name = "产品名称",needMerge=true)
    private String productName;

    /** 产品图纸附件地址URL */
    @Excel(name = "产品编号",needMerge=true)
    private String productID;

    @Excel(name = "工时对账列表")
   private List<AwProductmanhour> awProductmanhourList;


    public List<AwProductmanhour> getAwProductmanhourList() {
        return awProductmanhourList;
    }

    public void setAwProductmanhourList(List<AwProductmanhour> awProductmanhourList) {
        this.awProductmanhourList = awProductmanhourList;
    }

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
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
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
