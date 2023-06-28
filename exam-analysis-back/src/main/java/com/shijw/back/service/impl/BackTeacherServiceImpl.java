package com.shijw.back.service.impl;

import com.shijw.back.constant.CommonConstant;
import com.shijw.back.enums.BackBusinessExceptionEnum;
import com.shijw.back.enums.BackExceptionEnum;
import com.shijw.back.exception.BackBusinessException;
import com.shijw.back.exception.BackException;
import com.shijw.back.mapper.BackClassMapper;
import com.shijw.back.mapper.BackCollegeMapper;
import com.shijw.back.mapper.BackTeacherClassMapper;
import com.shijw.back.mapper.BackTeacherMapper;
import com.shijw.back.model.*;
import com.shijw.back.service.IBackTeacherService;
import com.shijw.back.single.SnowflakeIdSingleton;
import com.shijw.back.web.params.BackBindingTeacherAndClassParams;
import com.shijw.back.web.params.BackTeacherAddaTeacherParams;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author SHI
 * @date 2023/4/11 19:23
 */
@Service
public class BackTeacherServiceImpl implements IBackTeacherService {

    @Autowired
    private BackCollegeMapper backCollegeMapper;
    @Autowired
    private BackTeacherMapper backTeacherMapper;
    @Autowired
    private BackClassMapper backClassMapper;
    @Autowired
    private BackTeacherClassMapper backTeacherClassMapper;


    @Override
    public void addaTeacher(BackTeacherAddaTeacherParams params) {
        // 检查学院是否存在，是否与操作学校相匹配
        BackCollegeExample example = new BackCollegeExample();
        example.createCriteria().andCollegeIdEqualTo(params.getCollegeId());
        List<BackCollege> curCollegeList = backCollegeMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(curCollegeList)
                || curCollegeList.get(0).getUniversityCode().equals(params.getUniversityCode())) {
            throw new BackBusinessException(BackBusinessExceptionEnum.OPERATE_CLASS_ERROR_EXCEPTION);
        }

        BackTeacher teacher = new BackTeacher();
        BeanUtils.copyProperties(params, teacher);
        String teacherId = CommonConstant.TEACHER_ID_PREFIX + SnowflakeIdSingleton.getInstance().nextId();
        teacher.setTeacherId(teacherId);

        int res = backTeacherMapper.insertSelective(teacher);
        if (res != 1) {
            throw new BackException(BackExceptionEnum.DATA_INSERT_ERROR);
        }
    }

    @Override
    public void bindingTeacherAndClass(BackBindingTeacherAndClassParams params) {
        // 校验教师是否存在
        BackTeacherExample teacherExample = new BackTeacherExample();
        teacherExample.createCriteria().andTeacherIdEqualTo(params.getTeacherId());
        List<BackTeacher> sameTeacherIdList = backTeacherMapper.selectByExample(teacherExample);
        if (CollectionUtils.isEmpty(sameTeacherIdList)) {
            throw new BackBusinessException(BackBusinessExceptionEnum.BINDING_TEACHER_NOT_EXIST_EXCEPTION);
        }

        // 校验班级是否存在
        BackClassExample classExample = new BackClassExample();
        classExample.createCriteria().andClassIdEqualTo(params.getClassId());
        List<BackClass> sameClassIdList = backClassMapper.selectByExample(classExample);
        if (CollectionUtils.isEmpty(sameClassIdList)) {
            throw new BackBusinessException(BackBusinessExceptionEnum.BINDING_CLASS_NOT_EXIST_EXCEPTION);
        }

        // 都存在的话，可以绑定任职信息
        BackTeacherClass bindingInfo = new BackTeacherClass();
        BeanUtils.copyProperties(params, bindingInfo);

        int res = backTeacherClassMapper.insertSelective(bindingInfo);
        if (res != 1) {
            throw new BackException(BackExceptionEnum.DATA_INSERT_ERROR);
        }
    }
}
