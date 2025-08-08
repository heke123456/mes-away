package com.away.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 城市存储   省，市，县区对象 aw_city
 * 
 * @author ruoyi
 * @date 2023-07-26
 */
public class AwCity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 城市地区id */
    private Long id;

    /** 省 */
    @Excel(name = "省")
    private String economize;

    /** 市 */
    @Excel(name = "市")
    private String city;

    /** 区县 */
    @Excel(name = "区县")
    private String county;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setEconomize(String economize) 
    {
        this.economize = economize;
    }

    public String getEconomize() 
    {
        return economize;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setCounty(String county) 
    {
        this.county = county;
    }

    public String getCounty() 
    {
        return county;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("economize", getEconomize())
            .append("city", getCity())
            .append("county", getCounty())
            .toString();
    }
}
