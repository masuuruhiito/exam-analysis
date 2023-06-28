package com.shijw.back.service.impl;

import com.shijw.back.constant.CommonConstant;
import com.shijw.back.enums.BackBusinessExceptionEnum;
import com.shijw.back.enums.BackExceptionEnum;
import com.shijw.back.exception.BackBusinessException;
import com.shijw.back.exception.BackException;
import com.shijw.back.mapper.BackCollegeMapper;
import com.shijw.back.mapper.BackUniversityMapper;
import com.shijw.back.model.*;
import com.shijw.back.service.IBackCollegeService;
import com.shijw.back.single.SnowflakeIdSingleton;
import com.shijw.back.web.params.BackCollegeRegisterParams;
import com.shijw.back.web.params.BackStudentQueryByClassIdParams;
import com.shijw.back.web.params.BackUniversityQueryParams;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author SHI
 * @date 2023/4/10 10:18
 */
@Service
public class BackCollegeServiceImpl implements IBackCollegeService {

    @Autowired
    private BackCollegeMapper backCollegeMapper;


    @Override
    public List<BackCollege> queryAll(String universityCode) {
        BackCollegeExample example = new BackCollegeExample();
        example.createCriteria().andUniversityCodeEqualTo(universityCode);
        return backCollegeMapper.selectByExample(example);
    }

    @Override
    public void register(BackCollegeRegisterParams params) {
        // 检查当前学院是否在本平台注册过
        BackCollegeExample example = new BackCollegeExample();
        example.createCriteria().andCollegeNameEqualTo(params.getCollegeName());
        List<BackCollege> sameCollegeNameList = backCollegeMapper.selectByExample(example);
        // 注册过则抛出异常
        if (!CollectionUtils.isEmpty(sameCollegeNameList)) {
            throw new BackBusinessException(BackBusinessExceptionEnum.CUR_COLLEGE_EXISTED_EXCEPTION);
        }
        // 开始注册
        BackCollege college = new BackCollege();
        BeanUtils.copyProperties(params, college);

        String collegeId = CommonConstant.COLLEGE_ID_PREFIX + SnowflakeIdSingleton.getInstance().nextId();
        college.setCollegeId(collegeId);

        int res = backCollegeMapper.insertSelective(college);
        if (res != 1) {
            throw new BackException(BackExceptionEnum.DATA_INSERT_ERROR);
        }
    }

    @Override
    public BackUniversity query(BackUniversityQueryParams params) {
        return null;
    }
}
