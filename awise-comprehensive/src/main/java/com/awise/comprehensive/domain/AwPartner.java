package com.awise.comprehensive.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 合作方信息对象 aw_partner
 * 
 * @author awise
 * @date 2023-08-02
 */
public class AwPartner extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 合作方编号 */
    private String ID;

    /** 合作方姓名 */
    @Excel(name = "合作方姓名")
    private String Name;

    /** 实体简称 */
    @Excel(name = "合作方简称")
    private String NameAbbrevation;

    /** 社会统一信用代码 */
    @Excel(name = "社会统一信用代码")
    private String UnifiedCreditCode;

    /** 证照附件url地址#多个附件地址用分号;分隔# */
    @Excel(name = "证照附件url地址#多个附件地址用分号;分隔#")
    private String certificateURL;

    /** 城市地区id#省份、地市、区县# */
    @Excel(name = "城市地区id#省份、地市、区县#")
    private Long cityid;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 备注信息 */
    @Excel(name = "备注信息")
    private String notes;

    /** 实体类型 */
    @Excel(name = "实体类型" ,dictType = "aw_contract_location")
    private Long type;

    /** 是否删除 */
    private String isdel;

    public void setID(String ID) 
    {
        this.ID = ID;
    }

    public String getID() 
    {
        return ID;
    }
    public void setName(String Name) 
    {
        this.Name = Name;
    }

    public String getName() 
    {
        return Name;
    }
    public void setNameAbbrevation(String NameAbbrevation) 
    {
        this.NameAbbrevation = NameAbbrevation;
    }

    public String getNameAbbrevation() 
    {
        return NameAbbrevation;
    }
    public void setUnifiedCreditCode(String UnifiedCreditCode) 
    {
        this.UnifiedCreditCode = UnifiedCreditCode;
    }

    public String getUnifiedCreditCode() 
    {
        return UnifiedCreditCode;
    }
    public void setCertificateURL(String certificateURL) 
    {
        this.certificateURL = certificateURL;
    }

    public String getCertificateURL() 
    {
        return certificateURL;
    }
    public void setCityid(Long cityid) 
    {
        this.cityid = cityid;
    }

    public Long getCityid() 
    {
        return cityid;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setNotes(String notes) 
    {
        this.notes = notes;
    }

    public String getNotes() 
    {
        return notes;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setIsdel(String isdel) 
    {
        this.isdel = isdel;
    }

    public String getIsdel() 
    {
        return isdel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ID", getID())
            .append("Name", getName())
            .append("NameAbbrevation", getNameAbbrevation())
            .append("UnifiedCreditCode", getUnifiedCreditCode())
            .append("certificateURL", getCertificateURL())
            .append("cityid", getCityid())
            .append("address", getAddress())
            .append("notes", getNotes())
            .append("type", getType())
            .append("isdel", getIsdel())
            .toString();
    }
}
