package com.awise.produce.domain.Vo;

import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;



public class AwProcessingtechnologyVo  extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 加工工艺编号 */
    @Excel(name = "加工工艺编号")
    private String id;

    /** 创建人 */
    @Excel(name = "创建人")
    private String founder;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    @Excel(name = "产品图号")
    private String productID;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String name;

    /** 产品图纸附件地址URL */
    @Excel(name = "产品图纸附件地址URL")
    private String drawingURL;

    @Excel(name = "订单编号")
    private  String orderID;


    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
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

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setFounder(String founder)
    {
        this.founder = founder;
    }


    public String getFounder()
    {
        return founder;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("founder", getFounder())
                .append("status", getStatus())
                .append("productID", getProductID())
                .append("name", getName())
                .append("drawingURL", getDrawingURL())
                .toString();
    }
}
