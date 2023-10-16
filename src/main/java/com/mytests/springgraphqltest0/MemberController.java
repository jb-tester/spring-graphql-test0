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

  // incorrect generated request: redundant `()` after query name https://youtrack.jetbrains.com/issue/IDEA-334940
  @QueryMapping("allMembersQuery")
  public List<Member> getAllMembersFromBD() {
    return membersDAO.getAllMembers();
  }

  // incorrect generated request: the parameter variable is not declared https://youtrack.jetbrains.com/issue/IDEA-334945
  @QueryMapping
  public List<Member> membersByGroup(@Argument String name){
      return membersDAO.getGroupByName(name).getMembers();
  }

  @Transactional
  @MutationMapping
  public Member createMember(@Argument("name") String fn, @Argument("lastName") String ln){
      return membersDAO.addMemberToRandomGroup(fn, ln);
  }


  //@SchemaMapping(typeName = "Member", field = "group")
  @SchemaMapping // should get the typeName and field automatically - ok; rename doesn't work as expected however
  public Groups group(Member member){
     return membersDAO.getMemberGroup(member);
  }

  // rename for @*Mapping#field works incorrectly https://youtrack.jetbrains.com/issue/IDEA-334970
  @SchemaMapping(typeName = "Groups", field = "leadName")
  //@SchemaMapping(field = "leadName") // should get the typeName automatically - ok
  public String getLead(Groups groups){
     return groups.getLead().getFirstName()+" "+ groups.getLead().getLastName();
  }

}
