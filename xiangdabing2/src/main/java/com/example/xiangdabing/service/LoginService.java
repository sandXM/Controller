package com.example.xiangdabing.service;


import com.example.xiangdabing.config.shiro.bean.User;

public interface LoginService{

    User getUserByName(String userName);
}
