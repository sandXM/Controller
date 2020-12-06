package com.example.xiangdabing.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author xiangmin
 * @date 2020/11/5 14:14
 */
@Data
public class LogInfo {
    private String uid;
    private String opter;
    private Date crettime;
    private String method;
}
