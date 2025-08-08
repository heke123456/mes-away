package com.awise.order.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 合同存储对象 aw_contract
 * 
 * @author awise
 * @date 2023-08-03
 */
public class AwContract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 合同编号 */

    @Excel(name = "合同编号")
    private String id;

    /** 合同金额 */
    @Excel(name = "合同金额")
    private String money;

    /** 合同附件地址URL */
    @Excel(name = "合同附件地址URL")
    private String contractURL;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setMoney(String money) 
    {
        this.money = money;
    }

    public String getMoney() 
    {
        return money;
    }
    public void setContractURL(String contractURL) 
    {
        this.contractURL = contractURL;
    }

    public String getContractURL() 
    {
        return contractURL;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("money", getMoney())
            .append("contractURL", getContractURL())
            .toString();
    }
}
