package com.awise.finance.domain.Vo;

import java.util.Date;
import java.util.List;

import com.awise.finance.domain.AwDetailreconciliation;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 对账单对象 aw_StatementOfAccount
 * 
 * @author awise
 * @date 2023-12-22
 */
public class AwStatementofaccountVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 对账单Id */
    @Excel(name = "对账单Id",needMerge=true)
    private String statementOfAccountID;

    /** 制单人 */
    @Excel(name = "制单人",needMerge=true)
    private String creator;

    /** 对账人 */
    @Excel(name = "对账人",needMerge=true)
    private String reconciler;

    /** 对账时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "对账时间", width = 30, dateFormat = "yyyy-MM-dd",needMerge=true)
    private Date statementOfAccountDate;

    /** 备注 */
    @Excel(name = "备注",needMerge=true)
    private String notes;


    /** 状态 */
    @Excel(name = "状态",dictType = "aw_finance_statementofaccount_status",needMerge=true)
    private String status;

    @Excel(name = "对账单列表")

    private List<AwDetailreconciliation> detailreconciliationList;

    public List<AwDetailreconciliation> getDetailreconciliationList() {
        return detailreconciliationList;
    }

    public void setDetailreconciliationList(List<AwDetailreconciliation> detailreconciliationList) {
        this.detailreconciliationList = detailreconciliationList;
    }

    public void setStatementOfAccountID(String statementOfAccountID)
    {
        this.statementOfAccountID = statementOfAccountID;
    }

    public String getStatementOfAccountID() 
    {
        return statementOfAccountID;
    }
    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }
    public void setReconciler(String reconciler) 
    {
        this.reconciler = reconciler;
    }

    public String getReconciler() 
    {
        return reconciler;
    }
    public void setStatementOfAccountDate(Date statementOfAccountDate) 
    {
        this.statementOfAccountDate = statementOfAccountDate;
    }

    public Date getStatementOfAccountDate() 
    {
        return statementOfAccountDate;
    }
    public void setNotes(String notes) 
    {
        this.notes = notes;
    }

    public String getNotes() 
    {
        return notes;
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
            .append("statementOfAccountID", getStatementOfAccountID())
            .append("creator", getCreator())
            .append("reconciler", getReconciler())
            .append("statementOfAccountDate", getStatementOfAccountDate())
            .append("notes", getNotes())
            .append("status", getStatus())
            .toString();
    }
}
