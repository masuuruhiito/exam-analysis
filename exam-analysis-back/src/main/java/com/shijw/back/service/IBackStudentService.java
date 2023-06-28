package com.shijw.back.service;

import com.shijw.back.model.BackCollege;
import com.shijw.back.model.BackStudent;
import com.shijw.back.model.BackUniversity;
import com.shijw.back.model.BackUser;
import com.shijw.back.web.params.BackCollegeRegisterParams;
import com.shijw.back.web.params.BackStudentAddaStudentParams;
import com.shijw.back.web.params.BackStudentQueryByClassIdParams;
import com.shijw.back.web.params.BackUniversityQueryParams;

import java.util.List;

/**
 * @author SHI
 * @date 2023/4/6 23:39
 */
public interface IBackStudentService {

    /**
     * @param params
     * @return
     */
    List<BackStudent> queryByClassId(BackStudentQueryByClassIdParams params);

    void addaStudent(BackStudentAddaStudentParams params);
}
