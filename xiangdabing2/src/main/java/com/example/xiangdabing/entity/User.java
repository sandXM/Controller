package com.example.xiangdabing.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiangmin
 * @date 2020/11/4 18:47
 */
@Data
public class User implements Serializable {
    @JsonProperty("id")
    private String id;


    @JsonProperty("name")
    private String name;


    @JsonProperty("pass_word")
    private String passWord;


    @JsonProperty("memo")
    private String memo;


    @JsonProperty("cret_time")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date cretTime;

    @JsonProperty("upde_time")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date updeTime;
}
