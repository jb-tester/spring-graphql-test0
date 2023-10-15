package com.mytests.springgraphqltest0.model;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepository extends CrudRepository<Groups,Integer> {

    Groups getFirstByName(String name);
    Groups getByGroupId(Integer groupId);
    @Query("select g from Groups  g")
    List<Groups> getAll();
    Groups findByMembersContains(Member member);

}
