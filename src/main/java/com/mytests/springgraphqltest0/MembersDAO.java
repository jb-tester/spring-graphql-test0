package com.mytests.springgraphqltest0;


import com.mytests.springgraphqltest0.model.Groups;
import com.mytests.springgraphqltest0.model.GroupRepository;
import com.mytests.springgraphqltest0.model.Member;
import com.mytests.springgraphqltest0.model.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MembersDAO {
    private final MemberRepository memberRepository;
    private final GroupRepository groupRepository;

    public MembersDAO(MemberRepository memberRepository, GroupRepository groupRepository) {
        this.memberRepository = memberRepository;
        this.groupRepository = groupRepository;

    }

    public List<Member> getAllMembers(){
        return (List<Member>) memberRepository.findAll();
    }


    public Member addMemberToRandomGroup(String name, String surName){

        List<Groups> groupsList = groupRepository.getAll();
        System.out.println("**********************************");
        System.out.println(groupsList.size());
        System.out.println("**********************************");
        int groupNumber = new Random().ints(1, groupsList.size()+1).findFirst()
                 .getAsInt();
        Member member = new Member(name, surName);
        Groups mygroup = groupRepository.getByGroupId(groupNumber);
        mygroup.addMember(member);
        groupRepository.save(mygroup);
         return member;
    }

    public Optional<Member> getMemberById(Integer id){

        return memberRepository.findById(id);
    }



    public Groups getGroupByName(String name){

        return groupRepository.getFirstByName(name);
    }


    public Groups getMemberGroup(Member member) {

        return groupRepository.findByMembersContains(member);

    }

    public void populateDB() {

        Groups g1 = new Groups("first_group");
        Member lead1 = new Member("anya", "sidorova");
        g1.addMember(lead1);
        g1.addMember(new Member("vasya","pupkin"));
        g1.addMember(new Member("vanya","ivanov"));
        g1.addMember(new Member("valya","petrova"));
        g1.setLead(lead1);
        Groups g2 = new Groups("second_group");
        Member lead2 = new Member("sasha", "alexandrov");
        g2.addMember(lead2);
        g2.addMember(new Member("petya","pavlov"));
        g2.addMember(new Member("pasha","sidorov"));
        g2.addMember(new Member("sasha","bykov"));
        g2.addMember(new Member("masha","nikolaeva"));
        g2.setLead(lead2);
        Groups g3 = new Groups("third_group");
        Member lead3 = new Member("nadya", "alieva");
        g3.addMember(lead3);
        g3.addMember(new Member("dasha","vasina"));
        g3.addMember(new Member("dima","petin"));
        g3.setLead(lead3);
        List<Groups> groups = Arrays.asList(g1, g2, g3);
        groupRepository.saveAll(groups);
        for (Groups group : groupRepository.findAll()) {
            System.out.println(group);
        }
    }
}
