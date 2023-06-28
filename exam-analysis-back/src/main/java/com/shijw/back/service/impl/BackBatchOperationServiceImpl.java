package com.shijw.back.service.impl;

import com.shijw.back.constant.CommonConstant;
import com.shijw.back.enums.BackBusinessExceptionEnum;
import com.shijw.back.enums.BackExceptionEnum;
import com.shijw.back.exception.BackBusinessException;
import com.shijw.back.exception.BackException;
import com.shijw.back.mapper.BackClassMapper;
import com.shijw.back.model.BackClass;
import com.shijw.back.model.BackClassExample;
import com.shijw.back.service.IBackBatchOperationService;
import com.shijw.back.service.IBackClassService;
import com.shijw.back.service.IBackStudentService;
import com.shijw.back.single.SnowflakeIdSingleton;
import com.shijw.back.web.params.BackClassQueryClassByCollegeIdParams;
import com.shijw.back.web.params.BackClassRegisterParams;
import com.shijw.back.web.params.BackStudentAddaStudentParams;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author SHI
 * @date 2023/4/10 10:18
 */
@Service
public class BackBatchOperationServiceImpl implements IBackBatchOperationService {

    @Autowired
    private IBackStudentService backStudentService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchAddStudentByInput(List<BackStudentAddaStudentParams> paramsList) {
        // 批量操作的对象也会被 valid 校验拦截
        for (BackStudentAddaStudentParams params : paramsList) {
            backStudentService.addaStudent(params);
        }
    }
}
