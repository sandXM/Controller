package com.example.xiangdabing.config.redis;


import com.example.xiangdabing.entity.User;
import com.example.xiangdabing.service.QueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiangmin
 * @date 2020/11/27 14:51
 */
@Component
@Slf4j
public class RedisCacheUtils {

    private static RedisTemplate<String, Object> redisTemplate;

    @Resource
    private QueryService sysConfigMapper;

    /**
     *
     * @param redisTemplate
     */
    @Resource
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        if (null == redisTemplate) {
            log.info("Redis初始化配置失败，请检查配置项");
        } else {
            log.info("开始加载缓存。。。。。！");
            List<User> sysConfigs = sysConfigMapper.queryAll();
            redisTemplate.opsForValue().set("ALL_USER",sysConfigs);
            log.info(" ALL_USER ---------------------------------------------------加载缓存成功。。。。。！");
        }
    }

}
