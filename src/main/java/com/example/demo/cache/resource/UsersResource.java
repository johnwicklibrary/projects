package com.example.demo.cache.resource;


import com.example.demo.cache.cache.UsersCache;
import com.example.demo.cache.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/users")
public class UsersResource {

    @Autowired
    UsersCache usersCache;

    @GetMapping(value = "/{name}")
    public Users getUser(@PathVariable final String name) {

        for(int i = 0; i < 3; i ++){
            System.out.println("----------------- " + i);
            usersCache.getUser(name);
        }
        System.out.println("-----------------------");
        return usersCache.getUser(name);
    }
}
