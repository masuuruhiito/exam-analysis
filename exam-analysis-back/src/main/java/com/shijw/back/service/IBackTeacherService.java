package com.shijw.back.service;

import com.shijw.back.web.params.BackBindingTeacherAndClassParams;
import com.shijw.back.web.params.BackTeacherAddaTeacherParams;

/**
 * @author SHI
 * @date 2023/4/11 19:22
 */
public interface IBackTeacherService {
    void addaTeacher(BackTeacherAddaTeacherParams params);

    void bindingTeacherAndClass(BackBindingTeacherAndClassParams params);
}
