package com.example.xiangdabing.service.impl;

import com.example.xiangdabing.config.redis.RedisUtil;
import com.example.xiangdabing.dao.QueryDao;
import com.example.xiangdabing.entity.User;
import com.example.xiangdabing.service.QueryService;
import com.github.pagehelper.PageHelper;
import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * @author xiangmin
 * @date 2020/11/4 18:51
 */
@Service
@Slf4j
public class QuerySericeImp implements QueryService {
    @Resource
    private QueryDao queryDao;
    @Autowired
    private RedisUtil redisTemplate;
    @Override
    public List<User> queryAll() {
        List<User> users = (List<User>) redisTemplate.get("ALL_USER");
        log.info("从缓存拿数据 花费时间为");
        if(users==null){
            //PageHelper.startPage(1,2);
            users = queryDao.queryAll();
            redisTemplate.set("ALL_USER",users);
        }

        return users;
    }

    @Override
    public int insert(User user) {
        String id = UUID.randomUUID().toString().replace("-","");
        user.setId(id);
        return queryDao.insert(user);
    }

    @Override
    public int update(User user) {
        return queryDao.update(user);
    }

    @Override
    public int delete(User user) {
        return queryDao.delete(user);
    }

    @Override
    public int login(User user) {
        return 0;
    }
}
