package com.shijw.front.mapper;

import com.shijw.front.model.BackCourse;
import com.shijw.front.model.example.BackCourseExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface BackCourseMapper {
    @SelectProvider(type=BackCourseSqlProvider.class, method="countByExample")
    long countByExample(BackCourseExample example);

    @DeleteProvider(type=BackCourseSqlProvider.class, method="deleteByExample")
    int deleteByExample(BackCourseExample example);

    @Insert({
        "insert into back_course (id, course_id, ",
        "course_name)",
        "values (#{id,jdbcType=INTEGER}, #{courseId,jdbcType=VARCHAR}, ",
        "#{courseName,jdbcType=VARCHAR})"
    })
    int insert(BackCourse record);

    @InsertProvider(type=BackCourseSqlProvider.class, method="insertSelective")
    int insertSelective(BackCourse record);

    @SelectProvider(type=BackCourseSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_name", property="courseName", jdbcType=JdbcType.VARCHAR)
    })
    List<BackCourse> selectByExample(BackCourseExample example);

    @UpdateProvider(type=BackCourseSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BackCourse record, @Param("example") BackCourseExample example);

    @UpdateProvider(type=BackCourseSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BackCourse record, @Param("example") BackCourseExample example);
}