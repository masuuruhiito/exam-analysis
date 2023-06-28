package com.shijw.front;

import com.alibaba.excel.util.FileUtils;
import com.alibaba.fastjson.JSONObject;
import com.shijw.front.mapper.FrontPersonalTeachInfoMapper;
import com.shijw.front.model.FrontPersonalTeachInfo;
import com.shijw.front.service.IFrontCourseService;
import com.shijw.front.service.ITokenService;
import com.shijw.front.single.SnowflakeIdSingleton;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SpringBootTest
class ExamAnalysisFrontApplicationTests {

    @Autowired
    private FrontPersonalTeachInfoMapper frontPersonalTeachInfoMapper;

//
//    @Test
//    void contextLoads() {
//        String token = tokenService.getToken("12345678", "12345678");
//        System.out.println(token);
//
//        System.out.println(tokenService.getUserName(token));
//
//        frontCourseService.registerPersonalCourse("Test1数据");
//
//        String ss = "Bearer@" + token;
//        System.out.println(tokenService.getRemoveTokenHeadToken(ss));
//    }

    @Test
    void contextLoads1() {
        String classId = "CL_1096546661385109504";
        String courseId = "1095851792186474496";
        String userId = "12345678";

        FrontPersonalTeachInfo frontPersonalTeachInfo = new FrontPersonalTeachInfo(){{
            setClassId(classId);
            setCourseId(courseId);
            setTeacherId(userId);
            setTeachInfoId("TI_" + SnowflakeIdSingleton.getInstance().nextId());
            setSemester("2019-2020(二)");
        }};
        frontPersonalTeachInfoMapper.insertSelective(frontPersonalTeachInfo);
    }
}
