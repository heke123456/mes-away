package com.awise.comprehensive.domain;

import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 合作方信息对象 aw_partner
 * 
 * @author awise
 * @date 2023-08-02
 */
public class AwPartnerEn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 合作方编号 */
    private String id;

    /** 合作方姓名 */
    @Excel(name = "合作方姓名")
    private String name;

    /** 合作方简称 */
    @Excel(name = "合作方简称")
    private String nameAbbrevation;

    /** 社会统一信用代码 */
    @Excel(name = "社会统一信用代码")
    private String unifiedCreditCode;

    /** 证照附件url地址 */
    @Excel(name = "证照附件url地址#多个附件地址用分号;分隔#")
    private String certificateURL;

    /** 城市地区id#省份、地市、区县# */
    @Excel(name = "城市地区")
    private String city;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 备注信息 */
    @Excel(name = "备注信息")
    private String notes;

    /** 实体类型 */
    @Excel(name = "实体类型",dictType = "aw_contract_location")
    private Long type;

    public Long getType() {
        return type;
    }

    public String getIsdel() {
        return isdel;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel;
    }

    /** 是否删除 */
    private String isdel;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameAbbrevation() {
        return nameAbbrevation;
    }

    public void setNameAbbrevation(String nameAbbrevation) {
        this.nameAbbrevation = nameAbbrevation;
    }

    public String getUnifiedCreditCode() {
        return unifiedCreditCode;
    }

    public void setUnifiedCreditCode(String unifiedCreditCode) {
        this.unifiedCreditCode = unifiedCreditCode;
    }

    public String getCertificateURL() {
        return certificateURL;
    }

    public void setCertificateURL(String certificateURL) {
        this.certificateURL = certificateURL;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
            .append("name", getName())
            .append("nameAbbrevation", getNameAbbrevation())
            .append("unifiedCreditCode", getUnifiedCreditCode())
            .append("certificateURL", getCertificateURL())
            .append("city", getCity())
            .append("address", getAddress())
            .append("notes", getNotes())
            .toString();
    }
}
