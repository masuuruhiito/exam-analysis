package com.shijw.front.service;

import com.shijw.front.model.vo.QueryClassVO;
import com.shijw.front.model.vo.QueryStudentVO;
import com.shijw.front.web.params.FrontStudentQueryByTeachInfoIdParams;
import com.shijw.front.web.params.FrontStudentRegisterByExcelParams;
import com.shijw.front.web.params.FrontStudentRegisterParams;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author SHI
 * @date 2023/4/12 23:40
 */
public interface IFrontStudentService {

    void registerPersonalStudentsOfClassByExcel(FrontStudentRegisterByExcelParams params);

    void getStudentInfoExcelTemplate();

    List<QueryStudentVO> queryStudentsByClassId(String collegeId);

    void registerPersonalStudent(FrontStudentRegisterParams params);

    List<QueryStudentVO> queryStudentsByTeachInfoId(FrontStudentQueryByTeachInfoIdParams params);
}
