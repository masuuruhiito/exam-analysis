package com.shijw.back.service.impl;

import com.shijw.back.constant.UniversityInfoConstant;
import com.shijw.back.enums.BackBusinessExceptionEnum;
import com.shijw.back.enums.BackExceptionEnum;
import com.shijw.back.exception.BackBusinessException;
import com.shijw.back.exception.BackException;
import com.shijw.back.mapper.BackUniversityMapper;
import com.shijw.back.model.BackUniversity;
import com.shijw.back.model.BackUniversityExample;
import com.shijw.back.service.IBackUniversityService;
import com.shijw.back.web.params.BackUniversityQueryParams;
import com.shijw.back.web.params.BackUniversityRegisterParams;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author SHI
 * @date 2023/4/6 23:40
 */
@Service
public class BackUniversityServiceImpl implements IBackUniversityService {

    @Autowired
    private BackUniversityMapper backUniversityMapper;


    @Override
    public BackUniversity query(BackUniversityQueryParams params) {
        BackUniversityExample example = new BackUniversityExample();

        if (StringUtils.isNotBlank(params.getUniversityCode())) {
            example.createCriteria().andUniversityCodeEqualTo(params.getUniversityCode());
        } else if (StringUtils.isNotBlank(params.getUniversityName())) {
            example.createCriteria().andUniversityNameEqualTo(params.getUniversityName());
        }else {
            throw new BackBusinessException(BackBusinessExceptionEnum.QUERY_UNIVERSITY_NEED_LEAST_ONE_IS_NOT_EMPTY_PARAMS_EXCEPTION);
        }

        List<BackUniversity> universities = backUniversityMapper.selectByExample(example);
        return CollectionUtils.isEmpty(universities) ? new BackUniversity() : universities.get(0);
    }

    @Override
    public List<BackUniversity> queryAll() {
        return backUniversityMapper.selectByExample(new BackUniversityExample());
    }

    @Override
    public void register(BackUniversityRegisterParams params) {
        // 校验学校名称，学校标识码
        validUniversityIdAndNameIsCorrect(params);
        // 检查当前学校是否在本平台注册过
        BackUniversityExample example = new BackUniversityExample();
        example.createCriteria().andUniversityNameEqualTo(params.getUniversityName());
        List<BackUniversity> sameUniversityNameList = backUniversityMapper.selectByExample(example);
        // 注册过则抛出异常
        if (!CollectionUtils.isEmpty(sameUniversityNameList)) {
            throw new BackBusinessException(BackBusinessExceptionEnum.CUR_UNIVERSITY_EXISTED_EXCEPTION);
        }
        // 没注册过则开始注册
        BackUniversity university = new BackUniversity();
        BeanUtils.copyProperties(params, university);
        int res = backUniversityMapper.insertSelective(university);
        if (res != 1) {
            throw new BackException(BackExceptionEnum.DATA_INSERT_ERROR);
        }
    }

    /**
     * 校验学校id与学校名称是否与 教育部文件一致
     */
    private void validUniversityIdAndNameIsCorrect(BackUniversityRegisterParams params) {
        // 验证 id 是否存在
        if (!UniversityInfoConstant.UNIVERSITY_INFO_MAP.containsKey(params.getUniversityCode())) {
            throw new BackBusinessException(BackBusinessExceptionEnum.REGISTER_UNIVERSITY_CODE_ERROR_EXCEPTION);
        }
        String correctUniversityName = UniversityInfoConstant.UNIVERSITY_INFO_MAP.get(params.getUniversityCode()).getName();
        if (!correctUniversityName.equals(params.getUniversityName())) {
            throw new BackBusinessException(BackBusinessExceptionEnum.REGISTER_UNIVERSITY_NAME_ERROR_EXCEPTION);
        }
    }
}
