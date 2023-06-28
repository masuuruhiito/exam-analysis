package com.shijw.front.service;

import com.alibaba.fastjson.JSONArray;
import com.shijw.front.web.params.FrontAddStudentScoreParams;
import com.shijw.front.web.params.FrontDeleteStudentScoreParams;
import com.shijw.front.web.params.FrontQueryTeachInfoScoreParams;
import com.shijw.front.web.params.FrontScoreUploadScoreByExcelParams;

/**
 * @author SHI
 * @date 2023/4/14 22:06
 */
public interface IFrontScoreService{

    void uploadScoreByExcel(FrontScoreUploadScoreByExcelParams params);

    void downloadScoreExcelTemplate(String teachInfoId);

    JSONArray queryTeachInfoScores(FrontQueryTeachInfoScoreParams params);

    void addStudentScores(FrontAddStudentScoreParams params);

    void updateStudentScores(FrontAddStudentScoreParams params);

    void deleteStudentScores(FrontDeleteStudentScoreParams params);
}
