package com.awise.produce.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 产品出库对象 aw_productoutbound
 * 
 * @author awise
 * @date 2023-10-16
 */
public class AwProductoutbound extends BaseEntity
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


    /** 出库数量 */
    @Excel(name = "出库数量")
    private Long receiptQuantity;

    /** 客户编号 */
    @Excel(name = "客户编号")
    private String contractID;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;


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
            .append("receiptQuantity", getReceiptQuantity())
            .append("contractID", getContractID())
            .append("notes", getNotes())
            .toString();
    }
}
