package com.example.xiangdabing.service;

import com.example.xiangdabing.entity.User;

import java.util.List;

/**
 * @author xiangmin
 * @date 2020/11/4 18:49
 */
public interface QueryService {
    List<User> queryAll();
    int insert(User user);
    int update(User user);
    int delete(User user);
    int login(User user);
}
