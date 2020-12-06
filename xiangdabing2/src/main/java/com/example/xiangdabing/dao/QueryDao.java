package com.example.xiangdabing.dao;

import com.example.xiangdabing.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xiangmin
 * @date 2020/11/4 18:48
 */
@Mapper
public interface QueryDao {

     List<User> queryAll();

     int insert(User user);

     int update(User user);

     int delete(User user);

}
