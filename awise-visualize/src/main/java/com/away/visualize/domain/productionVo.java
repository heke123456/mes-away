package com.away.visualize.domain;

public class productionVo
{

//    订单id
    private String id;

    //任务简称

    private  String notes;

//    客户姓名

    private  String name;


    public productionVo(String id, String notes, String name) {
        this.id = id;
        this.notes = notes;
        this.name = name;
    }

    public productionVo() {
    }


    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
