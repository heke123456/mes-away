package com.awise.comprehensive.domain;

import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 联系人信息对象 aw_contacts
 * 
 * @author ruoyi
 * @date 2023-10-15
 */
public class AwContactsEn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 联系人信息id */
    private Long id;

    /** 联系人姓名 */
    @Excel(name = "联系人姓名")
    private String name;

    /** 联系人电话 */
    @Excel(name = "联系人电话")
    private String phone;

    /** 联系人部门 */
    @Excel(name = "联系人部门")
    private String department;

    /** 联系人职位 */
    @Excel(name = "联系人职位")
    private String position;

    /** 联系人所属的定位是什么客户还是供应商 0为客户 1 为供应商 2 为其他 */
    @Excel(name = "联系人所属的定位是什么客户还是供应商 0为客户 1 为供应商 2 为其他")
    private Long location;

    /** 联系人所属公司id */
    @Excel(name = "联系人所属公司id")
    private String companyID;

    @Excel(name = "合作方姓名")
    private String companyName;

    /** 备注信息 */
    @Excel(name = "备注信息")
    private String notes;

    /** 删除否 0为存在 1为删除 */
    private String isDel;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }
    public void setLocation(Long location) 
    {
        this.location = location;
    }

    public Long getLocation() 
    {
        return location;
    }
    public void setCompanyID(String companyID) 
    {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getCompanyID() 
    {
        return companyID;
    }
    public void setNotes(String notes) 
    {
        this.notes = notes;
    }

    public String getNotes() 
    {
        return notes;
    }
    public void setIsDel(String isDel) 
    {
        this.isDel = isDel;
    }

    public String getIsDel() 
    {
        return isDel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("phone", getPhone())
            .append("department", getDepartment())
            .append("position", getPosition())
            .append("location", getLocation())
            .append("companyID", getCompanyID())
            .append("notes", getNotes())
            .append("isDel", getIsDel())
            .toString();
    }
}
