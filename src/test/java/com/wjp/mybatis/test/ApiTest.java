package com.wjp.mybatis.test;

import com.wjp.mybatis.binding.MapperProxyFactory;
import com.wjp.mybatis.test.dao.UserInterface;

import java.util.HashMap;
import java.util.Map;

public class ApiTest {
    public static void main(String[] args) {
        MapperProxyFactory<UserInterface> factory = new MapperProxyFactory<>(UserInterface.class);
        Map<String, String> map = new HashMap<>();
        map.put(UserInterface.class.getName(), "userdao");
        UserInterface userInterface = factory.newInstance(map);
        System.out.println(userInterface.toString());
        userInterface.call();
    }
}
