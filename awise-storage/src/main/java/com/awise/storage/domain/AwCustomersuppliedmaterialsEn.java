package com.awise.storage.domain;

import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 客供材料实时库存对象 aw_customersuppliedmaterials
 * 
 * @author awise
 * @date 2023-08-03
 */
public class AwCustomersuppliedmaterialsEn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 材料库存id */
    private Long id;

    /** 材料基本信息 */
    @Excel(name = "材料基本信息")
    private String material;

    /** 客户信息 */
    @Excel(name = "客户信息")
    private String customer;

    /** 材料库存数量 */
    @Excel(name = "材料库存数量")
    private Long number;

    /** 材料库存重量 */
    @Excel(name = "材料库存重量")
    private Long weight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("material", getMaterial())
            .append("number", getNumber())
            .append("weight", getWeight())
            .append("customer", getCustomer())
            .toString();
    }
}
