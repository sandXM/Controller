package com.example.xiangdabing.service.impl;

import com.example.xiangdabing.dao.LogInfoDao;
import com.example.xiangdabing.entity.LogInfo;
import com.example.xiangdabing.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xiangmin
 * @date 2020/11/5 14:21
 */
@Service
public class LogServiceImp implements LogService {
    @Resource
    private LogInfoDao logInfoDao;
    @Override
    public int insertLog(LogInfo logInfo) {
        return logInfoDao.insertLog(logInfo);
    }
}
