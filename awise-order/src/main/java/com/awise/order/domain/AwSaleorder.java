package com.awise.order.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 订单对象 aw_saleorder
 * 
 * @author awise
 * @date 2023-08-03
 */
public class AwSaleorder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单id#日期+编号# */
    private String id;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUserName;

    /** 下单日期 */
    @Excel(name = "下单日期")
    private String orderDate;

    /** 需求数量 */
    @Excel(name = "需求数量")
    private Long number;

    @Excel(name = "批次号")

    private String lotNumber;

    /** 要求交期 */
    @Excel(name = "要求交期")
    private String requiredDeliveryTime;

    /** 客户信息 */
    @Excel(name = "客户信息")
    private String customerID;

    /** 产品信息 */
    @Excel(name = "产品信息")
    private String productID;

    /** 合同信息 */
    @Excel(name = "合同信息")
    private String contractID;

    /** 发票信息 */
    @Excel(name = "发票信息")
    private String invoiceID;

    /** 客供材料否 */
    @Excel(name = "客供材料否",dictType = "aw_oder_customer_status")
    private String iscustomersuppliedmaterials;

    /** 当前订单状态 */
    @Excel(name = "当前订单状态",dictType = "aw_order_saleoder_options")
    private String state;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 删除否 */
    @Excel(name = "删除否")
    private String isDel;

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getRequiredDeliveryTime() {
        return requiredDeliveryTime;
    }

    public void setRequiredDeliveryTime(String requiredDeliveryTime) {
        this.requiredDeliveryTime = requiredDeliveryTime;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getIscustomersuppliedmaterials() {
        return iscustomersuppliedmaterials;
    }

    public void setIscustomersuppliedmaterials(String iscustomersuppliedmaterials) {
        this.iscustomersuppliedmaterials = iscustomersuppliedmaterials;
    }




    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("createUserName", getCreateUserName())
            .append("orderDate", getOrderDate())
            .append("number", getNumber())
            .append("lotNumber", getLotNumber())
            .append("requiredDeliveryTime", getRequiredDeliveryTime())
            .append("customerID", getCustomerID())
            .append("productID", getProductID())
            .append("contractID", getContractID())
            .append("invoiceID", getInvoiceID())
            .append("iscustomersuppliedmaterials", getIscustomersuppliedmaterials())
            .append("state", getState())
            .append("note", getNote())
            .append("isDel", getIsDel())
            .toString();
    }
}
