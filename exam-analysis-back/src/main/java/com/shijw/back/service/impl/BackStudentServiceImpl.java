package com.shijw.back.service.impl;

import com.shijw.back.constant.CommonConstant;
import com.shijw.back.enums.BackBusinessExceptionEnum;
import com.shijw.back.enums.BackExceptionEnum;
import com.shijw.back.exception.BackBusinessException;
import com.shijw.back.exception.BackException;
import com.shijw.back.mapper.BackClassMapper;
import com.shijw.back.mapper.BackCollegeMapper;
import com.shijw.back.mapper.BackStudentMapper;
import com.shijw.back.model.*;
import com.shijw.back.service.IBackCollegeService;
import com.shijw.back.service.IBackStudentService;
import com.shijw.back.single.SnowflakeIdSingleton;
import com.shijw.back.web.params.BackCollegeRegisterParams;
import com.shijw.back.web.params.BackStudentAddaStudentParams;
import com.shijw.back.web.params.BackStudentQueryByClassIdParams;
import com.shijw.back.web.params.BackUniversityQueryParams;
import org.hibernate.validator.internal.util.logging.formatter.CollectionOfClassesObjectFormatter;
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
public class BackStudentServiceImpl implements IBackStudentService {

    @Autowired
    private BackStudentMapper backStudentMapper;
    @Autowired
    private BackClassMapper backClassMapper;


    @Override
    public List<BackStudent> queryByClassId(BackStudentQueryByClassIdParams params) {
        BackStudentExample example = new BackStudentExample();
        example.createCriteria().andClassIdEqualTo(params.getClassId());
        return backStudentMapper.selectByExample(example);
    }

    @Override
    public void addaStudent(BackStudentAddaStudentParams params) {
        // 检查当前班级是否存在，并且当前班级是否与操作学校匹配
        BackClassExample backClassExample = new BackClassExample();
        backClassExample.createCriteria().andClassIdEqualTo(params.getClassId());
        List<BackClass> curClass = backClassMapper.selectByExample(backClassExample);
        if (CollectionUtils.isEmpty(curClass)
                || !curClass.get(0).getUniversityCode().equals(params.getUniversityCode())) {

            throw new BackBusinessException(BackBusinessExceptionEnum.OPERATE_CLASS_ERROR_EXCEPTION);
        }

        // 检查学号是否重复
        BackStudentExample backStudentExample = new BackStudentExample();
        backStudentExample.createCriteria().andStudentIdEqualTo(params.getStudentId());
        List<BackStudent> sameStudentIdList = backStudentMapper.selectByExample(backStudentExample);
        if (!CollectionUtils.isEmpty(sameStudentIdList)) {
            throw new BackBusinessException(BackBusinessExceptionEnum.CUR_STUDENT_ID_REGISTERED_EXCEPTION);
        }

        // 开始注册
        BackStudent student = new BackStudent();
        BeanUtils.copyProperties(params, student);
        student.setCollegeId(curClass.get(0).getCollegeId());

        int res = backStudentMapper.insertSelective(student);
        if (res != 1) {
            throw new BackException(BackExceptionEnum.DATA_INSERT_ERROR);
        }
    }
}
