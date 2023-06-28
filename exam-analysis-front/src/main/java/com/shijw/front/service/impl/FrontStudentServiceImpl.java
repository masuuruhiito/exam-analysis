package com.shijw.front.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.write.handler.WriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.AbstractColumnWidthStyleStrategy;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.alibaba.excel.write.style.row.SimpleRowHeightStyleStrategy;
import com.shijw.front.enums.FrontBusinessExceptionEnum;
import com.shijw.front.enums.FrontExceptionEnum;
import com.shijw.front.excel.data.ExamPaperHandoverListData;
import com.shijw.front.excel.strategy.ExcelDefaultExportStyleStrategy;
import com.shijw.front.excel.strategy.ExcelRowSameValueCellMergeStrategy;
import com.shijw.front.exception.FrontBusinessException;
import com.shijw.front.exception.FrontException;
import com.shijw.front.mapper.FrontPersonalClassMapper;
import com.shijw.front.mapper.FrontPersonalStudentMapper;
import com.shijw.front.mapper.FrontPersonalTeachInfoMapper;
import com.shijw.front.model.FrontPersonalClass;
import com.shijw.front.model.example.FrontPersonalClassExample;
import com.shijw.front.model.FrontPersonalStudent;
import com.shijw.front.excel.vo.StudentListDataDTO;
import com.shijw.front.model.example.FrontPersonalStudentExample;
import com.shijw.front.model.example.FrontPersonalTeachInfoExample;
import com.shijw.front.model.vo.QueryStudentVO;
import com.shijw.front.service.IFrontStudentService;
import com.shijw.front.utils.ExcelMergeUtil;
import com.shijw.front.utils.ExcelUtils;
import com.shijw.front.web.params.FrontStudentQueryByTeachInfoIdParams;
import com.shijw.front.web.params.FrontStudentRegisterByExcelParams;
import com.shijw.front.web.params.FrontStudentRegisterParams;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author SHI
 * @date 2023/4/14 13:53
 */
@Service
public class FrontStudentServiceImpl implements IFrontStudentService {

    @Autowired
    private FrontPersonalStudentMapper frontPersonalStudentMapper;
    @Autowired
    private FrontPersonalClassMapper frontPersonalClassMapper;
    @Autowired
    private FrontPersonalTeachInfoMapper frontPersonalTeachInfoMapper;
    @Autowired
    private ExamPaperHandoverListData examPaperHandoverListData;


    @Override
    @SneakyThrows
    public void registerPersonalStudentsOfClassByExcel(FrontStudentRegisterByExcelParams params) {
        // 在前台查找是否存在该班级
        FrontPersonalClassExample frontPersonalClassExample = new FrontPersonalClassExample();
        frontPersonalClassExample.createCriteria().andClassIdEqualTo(params.getClassId());
        List<FrontPersonalClass> frontPersonalClasses = frontPersonalClassMapper.selectByExample(frontPersonalClassExample);
        if (CollectionUtils.isEmpty(frontPersonalClasses)) {
            throw new FrontBusinessException(FrontBusinessExceptionEnum.REGISTER_STUDENT_CLASS_IS_NOT_EXIST_EXCEPTION);
        }
        FrontPersonalClass classInfo = frontPersonalClasses.get(0);

        EasyExcel.read(params.getStudentInfoExcel().getInputStream(), StudentListDataDTO.class, new PageReadListener<StudentListDataDTO>(dataList -> {
            // todo 检查是否存在
            for (StudentListDataDTO studentListDataDto : dataList) {
                FrontPersonalStudent frontPersonalStudent = new FrontPersonalStudent();
                BeanUtils.copyProperties(classInfo, frontPersonalStudent);
                BeanUtils.copyProperties(studentListDataDto, frontPersonalStudent);

                frontPersonalStudent.setId(null);
                frontPersonalStudent.setCreateTime(null);
                frontPersonalStudent.setUpdateTime(null);
                int res = frontPersonalStudentMapper.insertSelective(frontPersonalStudent);
                if (res != 1) {
                    throw new FrontException(FrontExceptionEnum.DATA_INSERT_ERROR);
                }
            }
        })).sheet().headRowNumber(1).doRead();
    }

    @Override
    @SneakyThrows
    public void getStudentInfoExcelTemplate() {

        String fileName = "UploadStudentInfoDemo.xlsx";

        List<List<String>> header = new ArrayList<List<String>>() {{
            add(Collections.singletonList("序号"));
            add(Collections.singletonList("学号"));
            add(Collections.singletonList("学生姓名"));
            add(Collections.singletonList("性别"));
            add(Collections.singletonList("出生日期"));
            add(Collections.singletonList("电话"));
            add(Collections.singletonList("邮箱"));
            add(Collections.singletonList("地址"));
        }};

        List<List<String>> data = new ArrayList<List<String>>() {{
            add(Arrays.asList("1", "1904010501", "张三", "男", "2002-01-01", "15776289762", "1502899983@qq.com", "黑龙江省哈尔滨市南岗区学府路52号"));
            add(Arrays.asList("2", "1904010502", "李四", "女", "2001-02-03", "15776289762", "shijw01@qq.com", "黑龙江省哈尔滨市南岗区学府路52号"));
        }};

        HttpServletResponse response = ExcelUtils.setFileResponse(fileName);

        EasyExcel.write(response.getOutputStream(), StudentListDataDTO.class)
                .sheet(0)
                .head(header)
                .registerWriteHandler(new AbstractColumnWidthStyleStrategy() {
                    @Override
                    protected void setColumnWidth(WriteSheetHolder writeSheetHolder, List<WriteCellData<?>> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
                        Sheet sheet = writeSheetHolder.getSheet();
                        sheet.setColumnWidth(cell.getColumnIndex(), 7000);
                    }
                })
                .doWrite(data);
    }

    @Override
    public List<QueryStudentVO> queryStudentsByClassId(String collegeId) {
        FrontPersonalStudentExample frontPersonalStudentExample = new FrontPersonalStudentExample();
        frontPersonalStudentExample.createCriteria().andClassIdEqualTo(collegeId);
        List<FrontPersonalStudent> frontPersonalStudents = frontPersonalStudentMapper.selectByExample(frontPersonalStudentExample);
        AtomicInteger i = new AtomicInteger(1);
        return frontPersonalStudents.stream()
                .map(FrontPersonalStudent::toQueryStudentVO)
                .peek(e -> e.setId(i.getAndIncrement()))
                .collect(Collectors.toList());
    }

    @Override
    public void registerPersonalStudent(FrontStudentRegisterParams params) {
        // todo 检查当前班级是否存在
        FrontPersonalClassExample frontPersonalClassExample = new FrontPersonalClassExample();
        frontPersonalClassExample.createCriteria().andClassIdEqualTo(params.getClassId());
        List<FrontPersonalClass> frontPersonalClasses = frontPersonalClassMapper.selectByExample(frontPersonalClassExample);
        if (frontPersonalClasses.isEmpty()) {
            throw new FrontBusinessException(10000, "当前班级不存在");
        }

        FrontPersonalClass frontPersonalClass = frontPersonalClasses.get(0);

        // 查询出当前
        FrontPersonalStudent frontPersonalStudent = new FrontPersonalStudent();
        frontPersonalStudent.setUniversityCode(frontPersonalClass.getUniversityCode());
        frontPersonalStudent.setCollegeId(frontPersonalClass.getCollegeId());

        // 插入学生信息
        BeanUtils.copyProperties(params, frontPersonalStudent);
        frontPersonalStudentMapper.insertSelective(frontPersonalStudent);
    }

    @Override
    public List<QueryStudentVO> queryStudentsByTeachInfoId(FrontStudentQueryByTeachInfoIdParams params) {
        FrontPersonalTeachInfoExample frontPersonalTeachInfoExample = new FrontPersonalTeachInfoExample();
        frontPersonalTeachInfoExample.createCriteria().andTeachInfoIdEqualTo(params.getTeachInfoId());
        String classId = frontPersonalTeachInfoMapper.selectByExample(frontPersonalTeachInfoExample).get(0).getClassId();
        return queryStudentsByClassId(classId);
    }
}
