package com.mytests.springgraphqltest0;

import com.mytests.springgraphqltest0.model.Groups;
import com.mytests.springgraphqltest0.model.Member;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
public class MemberController {

  private final MemberDAO memberDAO;

  public MemberController(MemberDAO memberDAO) {
    this.memberDAO = memberDAO;
    memberDAO.populateDB();
  }

  // incorrect generated request: redundant `()` after query name https://youtrack.jetbrains.com/issue/IDEA-334940
  @QueryMapping("allMembersQuery")
  public List<Member> getAllMembersFromBD() {
    return memberDAO.getAllMembers();
  }

  // incorrect generated request: the parameter variable is not declared https://youtrack.jetbrains.com/issue/IDEA-334945
  @QueryMapping
  public List<Member> membersByGroup(@Argument String name){
      return memberDAO.getGroupByName(name).getMembers();
  }

  // doubled Generate HTTP Request action here - https://youtrack.jetbrains.com/issue/IDEA-334974
  @Transactional
  @MutationMapping
  public Member createMember(@Argument("name") String fn, @Argument("lastName") String ln){
      return memberDAO.addMemberToRandomGroup(fn, ln);
  }
  @Transactional
  @MutationMapping
  public Groups addGroup(@Argument("name") String name){
    return memberDAO.addGroup(name);
  }

  //@SchemaMapping(typeName = "Member", field = "group")
  @SchemaMapping // should get the typeName and field automatically - ok; rename doesn't work as expected however
  public Groups group(Member member){
     return memberDAO.getMemberGroup(member);
  }

  // rename for @*Mapping#field works incorrectly https://youtrack.jetbrains.com/issue/IDEA-334970
  @SchemaMapping(typeName = "Groups", field = "leadName")
  //@SchemaMapping(field = "leadName") // should get the typeName automatically - ok
  public String getLead(Groups groups){
     return groups.getLead().getFirstName()+" "+ groups.getLead().getLastName();
  }

}
