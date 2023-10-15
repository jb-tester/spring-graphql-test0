package com.mytests.springgraphqltest0.model;

import jakarta.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue
    Integer id;
    String firstName;
    String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Groups groups;

    public Member() {
    }

    public Member(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }
}
