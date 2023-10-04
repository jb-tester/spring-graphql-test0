package com.mytests.springgraphqltest0;

import com.mytests.springgraphqltest0.model.Group;
import com.mytests.springgraphqltest0.model.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class ModelConfiguration {

    @Bean
    public MembersDAO membersDAO() {

        List<Member> members = Arrays.asList(new Member(1,"vasya","pupkin",1)
                , new Member(2,"vanya","ivanov",1)
                , new Member(3,"valya","petrova",1)
                , new Member(4,"petya","pavlov",2)
                , new Member(5,"pasha","sidorov",2)
                , new Member(6,"sasha","bykov",2)
                , new Member(7,"masha","nikolaeva",2)
                , new Member(8,"dasha","vasina",3)
                , new Member(9,"dima","petin",3)

        );
        return new MembersDAO(members);
    }

    @Bean
    public GroupDAO groupDAO() {
        List<Group> groups = Arrays.asList(
                  new Group(1,"first_group", 1)
                , new Group(2,"second_group", 7)
                , new Group(3,"third_group", 8)
        );
        return new GroupDAO(groups);
    }
}
