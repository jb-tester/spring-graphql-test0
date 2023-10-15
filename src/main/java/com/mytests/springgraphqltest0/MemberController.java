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

  private final MembersDAO membersDAO;

  public MemberController(MembersDAO membersDAO) {
    this.membersDAO = membersDAO;
    membersDAO.populateDB();
  }

  // incorrect generated request: redundant `()` after query name
  @QueryMapping
  public List<Member> allMembers(){
    return membersDAO.getAllMembers();
  }
  // incorrect generated request: query itself uses var as parameter
  @QueryMapping
  public List<Member> membersByGroup(@Argument String name){
      return membersDAO.getGroupByName(name).getMembers();
  }

  @Transactional
  @MutationMapping
  public Member createMember(@Argument("name") String fn, @Argument("lastName") String ln){
      return membersDAO.addMemberToRandomGroup(fn, ln);
  }
  @SchemaMapping(typeName = "Member", field = "group")
  public Groups getGroup(Member member){
     return membersDAO.getMemberGroup(member);
  }

  @SchemaMapping(typeName = "Groups", field = "leadName")
  public String getLead(Groups groups){
     return groups.getLead().getFirstName()+" "+ groups.getLead().getLastName();
  }

}
