package com.mytests.springgraphqltest0;


import com.mytests.springgraphqltest0.model.Member;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


public class MembersDAO {


    private final List<Member> members;

    public MembersDAO(List<Member> members) {
        this.members = members;
    }

    public List<Member> getAllMembers(){
        return members;
    }
    public List<Member> getMembersByGroup(Integer groupId){
        List<Member> result = new ArrayList<>();
        for (Member member : members) {
            if (member.getGroupId() == groupId){result.add(member);}

        }
        return result;
    }

    public Member addMember(String name, String surName){
         int groupNumber = new Random().ints(1, 3).findFirst()
                 .getAsInt();
        Member member = new Member(members.size() + 1, name, surName, groupNumber);
        members.add(member);
         return member;
    }

    public Member getMemberById(Integer id){
        Member member = null;
        for (Member m : members) {
            if (Objects.equals(m.getId(), id)){member = m;}
        }
        return member;
    }
}
