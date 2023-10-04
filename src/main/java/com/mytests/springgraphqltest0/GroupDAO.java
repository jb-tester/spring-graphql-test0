package com.mytests.springgraphqltest0;

import com.mytests.springgraphqltest0.model.Group;
import com.mytests.springgraphqltest0.model.Member;

import java.util.*;


public class GroupDAO {

   List<Group> groups;



    public GroupDAO(List<Group> groups) {
        this.groups = groups;
    }

    public List<Group> getGroups() {
        return groups;
    }

     public Group getGroupById(Integer id){
        Group gr = null;
         for (Group group : groups) {
             if (group.getId() == id){gr = group;}
         }
         return gr;
     }
     public Group getGroupByName(String name){
        Group gr = null;
         for (Group group : groups) {
             if (Objects.equals(group.getName(), name)){gr = group;}
         }
         return gr;
     }
}
