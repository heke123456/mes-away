package com.awise.order.domain;

import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 订单对象 aw_saleorder
 * 
 * @author awise
 * @date 2023-08-03
 */
public class AwSaleorderEn extends BaseEntity
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

    /** 要求交期 */
    @Excel(name = "要求交期")
    private String requiredDeliveryTime;

    /** 客户信息 */
    @Excel(name = "客户信息")
    private String customerID;
//    批次号

    @Excel(name = "批次号")
    private  String lotNumber;

    /** 客户姓名 */
    @Excel(name = "客户姓名")
    private String customername;

    /** 客户简称 */
    @Excel(name = "客户简称")
    private String customernameAbbrevation;

    /** 社会统一信用代码 */
    @Excel(name = "社会统一信用代码")
    private String unifiedCreditCode;

    /** 产品编号 */
    @Excel(name = "产品编号")
    private String productID;

    /** 产品信息 */
    @Excel(name = "产品名称")
    private String productname;

    /** 产品图纸附件地址URL */
    @Excel(name = "产品图纸附件地址URL")
    private String productdrawingURL;

    /** 合同编号 */
    private String contractID;

    /** 合同金额 */
    @Excel(name = "合同金额")
    private String contractmoney;

    /** 合同附件地址URL */
    @Excel(name = "合同附件地址URL")
    private String contractURL;

    /** 发票信息 */
    @Excel(name = "发票信息")
    private String invoiceID;

    /** 开票类型 */
    @Excel(name = "开票类型")
    private String invoiceType;

    /** 开票日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开票日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date invoiceCreateTime;

    /** 开票数量 */
    @Excel(name = "开票数量")
    private String invoiceNumer;

    /** 税率 */
    @Excel(name = "税率")
    private String taxRate;

    /** 税费 */
    @Excel(name = "税费")
    private String taxation;

    /** 销售单价(不含税) */
    @Excel(name = "销售单价(不含税)")
    private String salesUnitPriceExcludingTax;

    /** 销售单价(含税) */
    @Excel(name = "销售单价(含税)")
    private String salesUnitPriceIncludingTax;

    /** 销售金额(不含税) */
    @Excel(name = "销售金额(不含税)")
    private String consumptionAmountExcludingTax;

    /** 销售金额(含税) */
    @Excel(name = "销售金额(含税)")
    private String consumptionAmountIncludingTax;

    /** 对账日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "对账日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reconciliationDate;

    /** 客户对账人员 */
    @Excel(name = "客户对账人员")
    private String customerReconciliationPersonnel;

    /** 客供材料否 */
    @Excel(name = "客供材料否",dictType = "aw_oder_customer_status")
    private String iscustomersuppliedmaterials;

    /** 当前订单状态 */
    @Excel(name = "当前订单状态")
    private String state;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 删除否 */
    @Excel(name = "删除否")
    private String isDel;


    public String getIscustomersuppliedmaterials() {
        return iscustomersuppliedmaterials;
    }

    public void setIscustomersuppliedmaterials(String iscustomersuppliedmaterials) {
        this.iscustomersuppliedmaterials = iscustomersuppliedmaterials;
    }

    public String getLotNumber(){
        return lotNumber;
    }

    public void setLotNumber( String lotNumber){
        this.lotNumber=lotNumber;
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

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomernameAbbrevation() {
        return customernameAbbrevation;
    }

    public void setCustomernameAbbrevation(String customernameAbbrevation) {
        this.customernameAbbrevation = customernameAbbrevation;
    }

    public String getUnifiedCreditCode() {
        return unifiedCreditCode;
    }

    public void setUnifiedCreditCode(String unifiedCreditCode) {
        this.unifiedCreditCode = unifiedCreditCode;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdrawingURL() {
        return productdrawingURL;
    }

    public void setProductdrawingURL(String productdrawingURL) {
        this.productdrawingURL = productdrawingURL;
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public String getContractmoney() {
        return contractmoney;
    }

    public void setContractmoney(String contractmoney) {
        this.contractmoney = contractmoney;
    }

    public String getContractURL() {
        return contractURL;
    }

    public void setContractURL(String contractURL) {
        this.contractURL = contractURL;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Date getInvoiceCreateTime() {
        return invoiceCreateTime;
    }

    public void setInvoiceCreateTime(Date invoiceCreateTime) {
        this.invoiceCreateTime = invoiceCreateTime;
    }

    public String getInvoiceNumer() {
        return invoiceNumer;
    }

    public void setInvoiceNumer(String invoiceNumer) {
        this.invoiceNumer = invoiceNumer;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public String getTaxation() {
        return taxation;
    }

    public void setTaxation(String taxation) {
        this.taxation = taxation;
    }

    public String getSalesUnitPriceExcludingTax() {
        return salesUnitPriceExcludingTax;
    }

    public void setSalesUnitPriceExcludingTax(String salesUnitPriceExcludingTax) {
        this.salesUnitPriceExcludingTax = salesUnitPriceExcludingTax;
    }

    public String getSalesUnitPriceIncludingTax() {
        return salesUnitPriceIncludingTax;
    }

    public void setSalesUnitPriceIncludingTax(String salesUnitPriceIncludingTax) {
        this.salesUnitPriceIncludingTax = salesUnitPriceIncludingTax;
    }

    public String getConsumptionAmountExcludingTax() {
        return consumptionAmountExcludingTax;
    }

    public void setConsumptionAmountExcludingTax(String consumptionAmountExcludingTax) {
        this.consumptionAmountExcludingTax = consumptionAmountExcludingTax;
    }

    public String getConsumptionAmountIncludingTax() {
        return consumptionAmountIncludingTax;
    }

    public void setConsumptionAmountIncludingTax(String consumptionAmountIncludingTax) {
        this.consumptionAmountIncludingTax = consumptionAmountIncludingTax;
    }

    public Date getReconciliationDate() {
        return reconciliationDate;
    }

    public void setReconciliationDate(Date reconciliationDate) {
        this.reconciliationDate = reconciliationDate;
    }

    public String getCustomerReconciliationPersonnel() {
        return customerReconciliationPersonnel;
    }

    public void setCustomerReconciliationPersonnel(String customerReconciliationPersonnel) {
        this.customerReconciliationPersonnel = customerReconciliationPersonnel;
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
        return "AwSaleorderEn{" +
                "id='" + id + '\'' +
                ", createUserName='" + createUserName + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", number=" + number +
                ", lotNumber=" + lotNumber +
                ", requiredDeliveryTime='" + requiredDeliveryTime + '\'' +
                ", customerID='" + customerID + '\'' +
                ", customername='" + customername + '\'' +
                ", customernameAbbrevation='" + customernameAbbrevation + '\'' +
                ", unifiedCreditCode='" + unifiedCreditCode + '\'' +
                ", productID='" + productID + '\'' +
                ", productname='" + productname + '\'' +
                ", productdrawingURL='" + productdrawingURL + '\'' +
                ", contractID='" + contractID + '\'' +
                ", contractmoney='" + contractmoney + '\'' +
                ", contractURL='" + contractURL + '\'' +
                ", invoiceID='" + invoiceID + '\'' +
                ", invoiceType='" + invoiceType + '\'' +
                ", invoiceCreateTime=" + invoiceCreateTime +
                ", invoiceNumer='" + invoiceNumer + '\'' +
                ", taxRate='" + taxRate + '\'' +
                ", taxation='" + taxation + '\'' +
                ", salesUnitPriceExcludingTax='" + salesUnitPriceExcludingTax + '\'' +
                ", salesUnitPriceIncludingTax='" + salesUnitPriceIncludingTax + '\'' +
                ", consumptionAmountExcludingTax='" + consumptionAmountExcludingTax + '\'' +
                ", consumptionAmountIncludingTax='" + consumptionAmountIncludingTax + '\'' +
                ", reconciliationDate=" + reconciliationDate +
                ", customerReconciliationPersonnel='" + customerReconciliationPersonnel + '\'' +
                ", iscustomersuppliedmaterials=" + iscustomersuppliedmaterials +
                ", state='" + state + '\'' +
                ", note='" + note + '\'' +
                ", isDel='" + isDel + '\'' +
                '}';
    }
}
