package com.example.xiangdabing.controller;

import com.example.xiangdabing.entity.User;
import com.example.xiangdabing.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiangmin
 * @date 2020/11/4 18:59
 */
@RestController
@RequestMapping("test")
public class QueryController {
    @Resource
    private QueryService queryService;

    @RequestMapping(value ="queryAll" )
    public List<User> queryAll(){
        return queryService.queryAll();
    }
    @RequestMapping(value ="insert" )
    public int insert(@RequestBody User u){
        return queryService.insert(u);
    }
    @RequestMapping(value ="update" )
    public int update(@RequestBody User u){
        return queryService.update(u);
    }
    @RequestMapping(value ="delete" )
    public int delete(@RequestBody User u){
        return queryService.delete(u);
    }
}
