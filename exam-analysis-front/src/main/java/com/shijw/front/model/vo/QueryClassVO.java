package com.shijw.front.model.vo;

import com.shijw.front.exception.FrontBusinessException;
import com.shijw.front.model.BackClass;
import com.shijw.front.model.BackTeacherClass;
import com.shijw.front.model.FrontPersonalClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author SHI
 * @date 2023/4/12 21:30
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class QueryClassVO {

    private Integer id;

    private String classId;

    private String college;

    private String major;

    private Integer grade;

    private Integer classNumber;
//
//    private String semester;

    private String from;

    public static List<QueryClassVO> genFromBackClassListAndBackTeacherClassList(
            List<BackClass> backClasses,
            List<BackTeacherClass> backTeacherClasses) {

        List<QueryClassVO> resList = new ArrayList<>();
        if (CollectionUtils.isEmpty(backClasses)
                || CollectionUtils.isEmpty(backTeacherClasses)) {
            return resList;
        }

        Map<String, String> classSemesterMap = backTeacherClasses.stream().collect(Collectors.toMap(BackTeacherClass::getClassId, BackTeacherClass::getSemester));

        for (BackClass backClass : backClasses) {
            QueryClassVO queryClassVO = new QueryClassVO();
            BeanUtils.copyProperties(backClass, queryClassVO);
//            queryClassVO.setSemester(classSemesterMap.get(backClass.getClassId()));
            resList.add(queryClassVO);
        }
        return resList;
    }

    public static QueryClassVO genFromBackClassAndBackTeacherClass(
            BackClass backClass,
            BackTeacherClass backTeacherClass) {

        QueryClassVO res = new QueryClassVO();
        if (backClass == null || backTeacherClass == null
                || !backTeacherClass.getClassId().equals(backClass.getClassId())) {
            return res;
        }
        BeanUtils.copyProperties(backClass, res);
//        res.setSemester(backTeacherClass.getSemester());
        return res;
    }

    public static List<QueryClassVO> genFromFrontClassList(List<FrontPersonalClass> frontPersonalClasses) {
        return frontPersonalClasses.stream().map(FrontPersonalClass::toQueryClassVO).peek(e -> e.setFrom("个人")).collect(Collectors.toList());
    }
}
