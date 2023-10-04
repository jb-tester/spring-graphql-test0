package com.mytests.springgraphqltest0;

import com.mytests.springgraphqltest0.model.Group;
import com.mytests.springgraphqltest0.model.Member;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MemberController {

  private final GroupDAO groupDAO;
  private final MembersDAO membersDAO;

  public MemberController(GroupDAO groupDAO, MembersDAO membersDAO) {
    this.groupDAO = groupDAO;
    this.membersDAO = membersDAO;
  }

  @QueryMapping
  public List<Member> allMembers(){
    return membersDAO.getAllMembers();
  }
  @QueryMapping
  public List<Member> membersByGroup(@Argument String name){
    int groupId = 0;
    for (Group group : groupDAO.getGroups()) {
      if (group.getName().equals(name)){groupId = group.getId();}
    }
    List<Member> results = membersDAO.getMembersByGroup(groupId);
    return results;
  }

  @SchemaMapping(typeName = "Member", field = "group")
  public Group getGroup(Member member){
     return groupDAO.getGroupById(member.getGroupId());
  }

  @SchemaMapping(typeName = "Group", field = "lead")
  public Member getLead(Group group){
     return membersDAO.getMemberById(group.getLeadId());
  }

}
