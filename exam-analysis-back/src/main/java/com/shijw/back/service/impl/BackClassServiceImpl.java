package com.shijw.back.service.impl;

import com.shijw.back.constant.CommonConstant;
import com.shijw.back.enums.BackBusinessExceptionEnum;
import com.shijw.back.enums.BackExceptionEnum;
import com.shijw.back.exception.BackBusinessException;
import com.shijw.back.exception.BackException;
import com.shijw.back.mapper.BackClassMapper;
import com.shijw.back.model.*;
import com.shijw.back.service.IBackClassService;
import com.shijw.back.single.SnowflakeIdSingleton;
import com.shijw.back.web.params.BackClassQueryClassByCollegeIdParams;
import com.shijw.back.web.params.BackClassRegisterParams;
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
public class BackClassServiceImpl implements IBackClassService {

    @Autowired
    private BackClassMapper backClassMapper;


    @Override
    public List<BackClass> queryClassByCollegeId(BackClassQueryClassByCollegeIdParams params) {
        BackClassExample example = new BackClassExample();
        example.createCriteria().andCollegeIdEqualTo(params.getCollegeId());
        return backClassMapper.selectByExample(example);
    }

    @Override
    public void register(BackClassRegisterParams params) {
        // 检查当前班级是否在本平台注册过
        BackClassExample example = new BackClassExample();
        example.createCriteria()
                .andCollegeIdEqualTo(params.getCollegeId())
                .andMajorEqualTo(params.getMajor())
                .andGradeEqualTo(params.getGrade())
                .andClassNumberEqualTo(params.getClassNumber());

        List<BackClass> sameClassList = backClassMapper.selectByExample(example);
        // 注册过则抛出异常
        if (!CollectionUtils.isEmpty(sameClassList)) {
            throw new BackBusinessException(BackBusinessExceptionEnum.CUR_CLASS_EXISTED_EXCEPTION);
        }

        // 开始注册
        BackClass curClass = new BackClass();
        BeanUtils.copyProperties(params, curClass);

        String classId = CommonConstant.CLASS_ID_PREFIX + SnowflakeIdSingleton.getInstance().nextId();
        curClass.setClassId(classId);

        int res = backClassMapper.insertSelective(curClass);
        if (res != 1) {
            throw new BackException(BackExceptionEnum.DATA_INSERT_ERROR);
        }
    }
}
