package com.awise.produce.domain;

import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 产品出库详单对象 detailproductoutbound
 * 
 * @author awise
 * @date 2023-10-16
 */
public class Detailproductoutbound extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;
    /** 出库单编号 */
    @Excel(name = "出库单编号")
    private String deliveryNoteID;
    /** 产品图号 */
    @Excel(name = "产品图号")
    private String productID;
    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productname;
    /** 出库数量 */
    @Excel(name = "出库数量")
    private Long receiptQuantity;
    /** 客户编号 */
    @Excel(name = "客户编号")
    private String contractID;
    /** 实体姓名 */
    @Excel(name = "实体姓名")
    private String customname;

    @Excel(name="备注")
    private  String notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliveryNoteID() {
        return deliveryNoteID;
    }

    public void setDeliveryNoteID(String deliveryNoteID) {
        this.deliveryNoteID = deliveryNoteID;
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

    public Long getReceiptQuantity() {
        return receiptQuantity;
    }

    public void setReceiptQuantity(Long receiptQuantity) {
        this.receiptQuantity = receiptQuantity;
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public String getCustomname() {
        return customname;
    }

    public void setCustomname(String customname) {
        this.customname = customname;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deliveryNoteID", getDeliveryNoteID())
            .append("productID", getProductID())
            .append("productname", getProductname())
            .append("receiptQuantity", getReceiptQuantity())
            .append("contractID", getContractID())
            .append("customname", getCustomname())
                .append("notes", getNotes())
            .toString();
    }
}
