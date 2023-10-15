package com.mytests.springgraphqltest0.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Groups {
    @Id @GeneratedValue
    Integer groupId;
    String name;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "lead_group_id")
    Member lead;
    @OneToMany(mappedBy = "groups", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Member> members = new ArrayList<>();

    public void addMember(Member member){
        members.add(member);
        member.setGroups(this);
    }
    public void removeMember(Member member) {
        members.remove(member);
        member.setGroups(null);
    }
    public Groups(String name) {
        this.name = name;

    }

    public Groups() {
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Member getLead() {
        return lead;
    }

    public void setLead(Member lead) {
        this.lead = lead;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", name='" + name + '\'' +
                ", lead=" + lead.lastName +
                '}';
    }
}
