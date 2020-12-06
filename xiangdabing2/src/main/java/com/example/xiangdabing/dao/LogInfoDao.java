package com.example.xiangdabing.dao;


import com.example.xiangdabing.entity.LogInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xiangmin
 * @date 2020/11/5 14:16
 */
@Mapper
public interface LogInfoDao {
    int insertLog(LogInfo logInfo);
}
