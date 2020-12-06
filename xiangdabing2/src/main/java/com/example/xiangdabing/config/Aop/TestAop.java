package com.example.xiangdabing.config.Aop;

import com.example.xiangdabing.entity.LogInfo;
import com.example.xiangdabing.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author xiangmin
 * @date 2020/11/5 9:55
 */
@Aspect
@Component
@Slf4j
public class TestAop {
    private Long minTime;
    private Long maxTime;
    @Resource
    private LogService logService;
    //配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
    @Pointcut("execution(public * com.example.xiangdabing.controller.*.*(..))")
    public void aspect(){	}
    /*
     * 配置前置通知,使用在方法aspect()上注册的切入点
     * 同时接受JoinPoint切入点对象,可以没有该参数
     */
    @Before("aspect()")
    public void before(JoinPoint jp){
        log.info("logger的beforelog方法开始记录日志");
        String name = jp.getSignature().getName();
        System.out.println(name);
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            System.out.println("参数：" + arg);
        }
        minTime = System.currentTimeMillis();

    }

    //配置后置通知,使用在方法aspect()上注册的切入点
    @After("aspect()")
    public void after(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println(name);
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("参数：" + arg);
        }
        LogInfo logInfo = new LogInfo();
        logInfo.setUid(UUID.randomUUID().toString().replace("-",""));
        logInfo.setOpter("系统管理员");
        logInfo.setMethod(name);
        logService.insertLog(logInfo);
        log.info("logger的Afterlog方法开始记录日志"+joinPoint.toString());
        maxTime = System.currentTimeMillis();
        log.info("该方法运行时间为------------------------------------"+(maxTime-minTime));
    }





    //异常通知
    @AfterReturning("aspect()")
    public void throwtlog(){
        log.info("logger的throwtlog方法开始记录日志");
    }
    //最终通知
    @AfterThrowing("aspect()")
    public void afterlog(){
        log.info("logger的afterlog方法开始记录日志");
    }
}
