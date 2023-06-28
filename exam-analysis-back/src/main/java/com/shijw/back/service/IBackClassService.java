package com.shijw.back.service;

import com.shijw.back.model.BackClass;
import com.shijw.back.web.params.BackClassQueryClassByCollegeIdParams;
import com.shijw.back.web.params.BackClassRegisterParams;

import java.util.List;

/**
 * @author SHI
 * @date 2023/4/6 23:39
 */
public interface IBackClassService {

    List<BackClass> queryClassByCollegeId(BackClassQueryClassByCollegeIdParams params);

    void register(BackClassRegisterParams params);
}
