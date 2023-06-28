package com.shijw.back.service;

import com.shijw.back.web.params.BackStudentAddaStudentParams;

import java.util.List;

/**
 * @author SHI
 * @date 2023/4/11 19:41
 */
public interface IBackBatchOperationService {

    void batchAddStudentByInput(List<BackStudentAddaStudentParams> params);

}
