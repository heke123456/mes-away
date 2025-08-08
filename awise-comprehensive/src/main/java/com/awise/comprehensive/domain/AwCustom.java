package com.awise.comprehensive.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 客户信息对象 aw_partner
 * 
 * @author awise
 * @date 2023-08-02
 */
public class AwCustom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 客户编号 */
    private String id;

    /** 客户姓名 */
    @Excel(name = "客户姓名")
    private String name;

    /** 客户简称 */
    @Excel(name = "客户简称")
    private String nameAbbrevation;

    /** 社会统一信用代码 */
    @Excel(name = "社会统一信用代码")
    private String unifiedCreditCode;

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
    @Excel(name = "实体类型")
    private Long type;

    /** 是否删除 */
    private String isdel;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
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
    public void setNameAbbrevation(String nameAbbrevation) 
    {
        this.nameAbbrevation = nameAbbrevation;
    }

    public String getNameAbbrevation() 
    {
        return nameAbbrevation;
    }
    public void setUnifiedCreditCode(String unifiedCreditCode) 
    {
        this.unifiedCreditCode = unifiedCreditCode;
    }

    public String getUnifiedCreditCode() 
    {
        return unifiedCreditCode;
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
            .append("id", getId())
            .append("name", getName())
            .append("nameAbbrevation", getNameAbbrevation())
            .append("unifiedCreditCode", getUnifiedCreditCode())
            .append("certificateURL", getCertificateURL())
            .append("cityid", getCityid())
            .append("address", getAddress())
            .append("notes", getNotes())
            .append("type", getType())
            .append("isdel", getIsdel())
            .toString();
    }
}
