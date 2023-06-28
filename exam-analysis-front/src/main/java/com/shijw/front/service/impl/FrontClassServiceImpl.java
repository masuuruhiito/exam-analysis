package com.shijw.front.service.impl;

import com.alibaba.excel.util.StringUtils;
import com.shijw.front.constant.CommonConstant;
import com.shijw.front.enums.FrontBusinessExceptionEnum;
import com.shijw.front.enums.FrontExceptionEnum;
import com.shijw.front.exception.FrontBusinessException;
import com.shijw.front.exception.FrontException;
import com.shijw.front.mapper.*;
import com.shijw.front.model.*;
import com.shijw.front.model.example.*;
import com.shijw.front.model.vo.QueryClassVO;
import com.shijw.front.service.IFrontClassService;
import com.shijw.front.service.ITokenService;
import com.shijw.front.single.SnowflakeIdSingleton;
import com.shijw.front.web.params.FrontClassQueryClassByConditionsParams;
import com.shijw.front.web.params.FrontClassRegisterParams;
import com.shijw.front.web.params.FrontClassUpdateParams;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author SHI
 * @date 2023/4/12 23:41
 */
@Service
public class FrontClassServiceImpl implements IFrontClassService {

    @Autowired
    private ITokenService tokenService;
    @Autowired
    private BackClassMapper backClassMapper;
    @Autowired
    private FrontUserMapper frontUserMapper;
    @Autowired
    private FrontPersonalClassMapper frontPersonalClassMapper;
    @Autowired
    private BackTeacherClassMapper backTeacherClassMapper;
    @Autowired
    private FrontTeacherClassMapper frontTeacherClassMapper;


    @Override
    public List<QueryClassVO> queryClassByConditions(FrontClassQueryClassByConditionsParams params) {

        List<QueryClassVO> resList = new ArrayList<>();

        // 从 request head 获取 username
        String username = tokenService.getUsernameFromRequestHead();
        // 判断当前用户是否绑定了后台信息库中的教师信息
        FrontUserExample frontUserExample = new FrontUserExample();
        frontUserExample.createCriteria().andUsernameEqualTo(username);
        List<FrontUser> frontUsers = frontUserMapper.selectByExample(frontUserExample);
        String teacherId = frontUsers.get(0).getTeacherId();

//        if (StringUtils.isNotBlank(teacherId)
//                && (CommonConstant.INFO_FROM_ALL.equals(params.getFrom()))
//                || CommonConstant.INFO_FROM_BACKSTAGE.equals(params.getFrom())) {
//            List<QueryClassVO> classInfoFromBackstage = getClassInfoFromBackstage(params, teacherId);
//            if (!CollectionUtils.isEmpty(classInfoFromBackstage)) {
//                resList.addAll(classInfoFromBackstage);
//            }
//        }

        if (CommonConstant.INFO_FROM_ALL.equals(params.getFrom())
                || CommonConstant.INFO_FROM_PERSONAL.equals(params.getFrom())) {
            List<QueryClassVO> classInfoFromForestage = getClassInfoFromForestage(params, username);
            if (!CollectionUtils.isEmpty(classInfoFromForestage)) {
                resList.addAll(classInfoFromForestage);
            }
        }
        // 查询个人信息库中的班级信息
//        FrontTeacherClassExample frontTeacherClassExample = new FrontTeacherClassExample();
//        frontTeacherClassExample.createCriteria().andTeacherIdEqualTo(teacherId);
//        List<FrontTeacherClass> frontTeachClasses = frontTeacherClassMapper.selectByExample(frontTeacherClassExample);

        // todo 查询排序规则
        AtomicInteger i = new AtomicInteger(1);
        return resList.stream().peek(e -> e.setId(i.getAndIncrement())).collect(Collectors.toList());
    }

    @Override
    public void registerPersonalClass(FrontClassRegisterParams params) {
        // 检查当前班级是否已存在于后台信息库
        BackClassExample backClassExample = new BackClassExample();
        backClassExample.createCriteria()
                .andCollegeIdEqualTo(params.getCollegeId())
                .andMajorEqualTo(params.getMajor())
                .andGradeEqualTo(params.getGrade())
                .andClassNumberEqualTo(params.getClassNumber());
        List<BackClass> backClasses = backClassMapper.selectByExample(backClassExample);
        if (!CollectionUtils.isEmpty(backClasses)) {
            throw new FrontBusinessException(FrontBusinessExceptionEnum.CLASS_EXIST_IN_BACKSTAGE_CLASS_DATABASE_EXCEPTION);
        }

        String operationUserName = tokenService.getUsernameFromRequestHead();

        // 检查当前课程是否在前台个人课程库中存在
        FrontPersonalClassExample frontPersonalClassExample = new FrontPersonalClassExample();
        frontPersonalClassExample.createCriteria()
                .andCollegeIdEqualTo(params.getCollegeId())
                .andMajorEqualTo(params.getMajor())
                .andGradeEqualTo(params.getGrade())
                .andClassNumberEqualTo(params.getClassNumber())
                .andCreateUsernameEqualTo(operationUserName);
        List<FrontPersonalClass> frontPersonalClasses = frontPersonalClassMapper.selectByExample(frontPersonalClassExample);
        if (!CollectionUtils.isEmpty(frontPersonalClasses)) {
            throw new FrontBusinessException(FrontBusinessExceptionEnum.COURSE_NAME_EXIST_IN_PERSONAL_COURSE_DATABASE_EXCEPTION);
        }

        // 都不存在则可以插入当前用户个人班级库中
        FrontPersonalClass frontPersonalClass = new FrontPersonalClass();
        BeanUtils.copyProperties(params, frontPersonalClass);
        frontPersonalClass.setCreateUsername(operationUserName);
        frontPersonalClass.setClassId(CommonConstant.CLASS_ID_PREFIX + SnowflakeIdSingleton.getInstance().nextId());

        // todo 设置学校信息
        frontPersonalClass.setUniversityCode("temp-university-code");

        int res = frontPersonalClassMapper.insertSelective(frontPersonalClass);
        if (res != 1) {
            throw new FrontException(FrontExceptionEnum.DATA_INSERT_ERROR);
        }
    }

//    private List<QueryClassVO> getClassInfoFromBackstage(FrontClassQueryClassByConditionsParams params, String teacherId) {
//        List<QueryClassVO> resList = new ArrayList<>();
//
//        // 找出
//        List<BackTeacherClass> backTeacherClasses = backTeacherClassMapper.selectByExample(backTeacherClassExample);
//        List<String> classIdList = backTeacherClasses.stream().map(BackTeacherClass::getClassId).collect(Collectors.toList());
//        if (!CollectionUtils.isEmpty(classIdList)) {
//            BackClassExample backClassExample = new BackClassExample();
//            // 结果 classId 需要在 classIdList 当中
//            backClassExample.createCriteria().andClassIdIn(classIdList);
//            if (StringUtils.isNotBlank(params.getCollegeId())) {
//                backClassExample.createCriteria().andCollegeIdEqualTo(params.getCollegeId());
//            }
//            if (StringUtils.isNotBlank(params.getMajor())) {
//                backClassExample.createCriteria().andMajorEqualTo(params.getMajor());
//            }
//            if (null != params.getGrade()) {
//                backClassExample.createCriteria().andGradeEqualTo(params.getGrade());
//            }
//            if (null != params.getClassNumber()) {
//                backClassExample.createCriteria().andClassNumberEqualTo(params.getClassNumber());
//            }
//
//            List<BackClass> backTeachClasses = backClassMapper.selectByExample(backClassExample);
//            resList.addAll(QueryClassVO.genFromBackClassListAndBackTeacherClassList(backTeachClasses, backTeacherClasses));
//        }
//        return resList;
//    }

    private List<QueryClassVO> getClassInfoFromForestage(FrontClassQueryClassByConditionsParams params, String username) {
        FrontPersonalClassExample frontPersonalClassExample = new FrontPersonalClassExample();
        FrontPersonalClassExample.Criteria criteria = frontPersonalClassExample.createCriteria();
        // 查询所有自己创建的班级
        criteria.andCreateUsernameEqualTo(username);
        if (StringUtils.isNotBlank(params.getCollegeId())) {
            criteria.andCollegeIdLike("%" + params.getCollegeId() + "%");
        }
        if (StringUtils.isNotBlank(params.getMajor())) {
            criteria.andMajorLike("%" + params.getMajor() + "%");
        }
        if (null != params.getGrade()) {
            criteria.andGradeEqualTo(params.getGrade());
        }
        if (null != params.getClassNumber()) {
            criteria.andClassNumberEqualTo(params.getClassNumber());
        }
        List<FrontPersonalClass> frontPersonalClasses = frontPersonalClassMapper.selectByExample(frontPersonalClassExample);
        return QueryClassVO.genFromFrontClassList(frontPersonalClasses);
    }

    @Override
    public String getClassName(FrontPersonalClass classInfo) {
        return classInfo.getMajor()
                + classInfo.getGrade()
                + "-"
                + classInfo.getClassNumber()
                + "班";
    }

    @Override
    public void updatePersonalClass(FrontClassUpdateParams params) {
        FrontPersonalClassExample frontPersonalClassExample = new FrontPersonalClassExample();
        frontPersonalClassExample.createCriteria().andClassIdEqualTo(params.getClassId());
        // todo 校验没查到的情况
        FrontPersonalClass frontPersonalClass = frontPersonalClassMapper.selectByExample(frontPersonalClassExample).get(0);
        // 修改修改了的属性
        frontPersonalClass = FrontClassUpdateParams.updateToFrontPersonalClass(params, frontPersonalClass);

        frontPersonalClassMapper.updateByExample(frontPersonalClass, frontPersonalClassExample);
    }
}
