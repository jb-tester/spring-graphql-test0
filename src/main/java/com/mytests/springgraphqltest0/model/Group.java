package com.mytests.springgraphqltest0.model;

import java.util.List;


public class Group {

    int id;
    String name;
    Integer leadId;

    public Group(int id, String name, Integer leadId) {
        this.id = id;
        this.name = name;
        this.leadId = leadId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLeadId() {
        return leadId;
    }

    public void setLeadId(Integer leadId) {
        this.leadId = leadId;
    }
}
