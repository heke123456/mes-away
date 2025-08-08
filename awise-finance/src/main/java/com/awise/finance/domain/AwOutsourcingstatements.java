package com.awise.finance.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 外协对账对象 aw_OutsourcingStatements
 * 
 * @author awise
 * @date 2023-12-26
 */
public class AwOutsourcingstatements extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 外协对账单编号 */
    @Excel(name = "外协对账单编号")
    private String outsourcingStatementsID;

    /** 制单人 */
    @Excel(name = "制单人")
    private String creator;

    /** 对账人 */
    @Excel(name = "对账人")
    private String reconciler;

    /** 对账时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "对账时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date statementOfAccountDate;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

    /** 状态 */
    @Excel(name = "状态" ,dictType = "aw_finance_statementofaccount_status")
    private String status;

    public void setOutsourcingStatementsID(String outsourcingStatementsID) 
    {
        this.outsourcingStatementsID = outsourcingStatementsID;
    }

    public String getOutsourcingStatementsID() 
    {
        return outsourcingStatementsID;
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
            .append("outsourcingStatementsID", getOutsourcingStatementsID())
            .append("creator", getCreator())
            .append("reconciler", getReconciler())
            .append("statementOfAccountDate", getStatementOfAccountDate())
            .append("notes", getNotes())
            .append("status", getStatus())
            .toString();
    }
}
