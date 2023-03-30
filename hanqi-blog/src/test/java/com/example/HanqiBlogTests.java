package com.example;

import com.example.entity.User;
import com.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HanqiBlogTests {

    @Autowired
    UserService userservice;

    @Test
    public void contextLoads(){
        User user = userservice.getById(1L);
        System.out.println(user.toString());
        ///dddddddd
    }

}
