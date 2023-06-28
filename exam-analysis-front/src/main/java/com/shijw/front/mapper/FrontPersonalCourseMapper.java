package com.shijw.front.mapper;

import com.shijw.front.model.FrontPersonalCourse;

import java.util.List;

import com.shijw.front.model.example.FrontPersonalCourseExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface FrontPersonalCourseMapper {
    @SelectProvider(type = FrontPersonalCourseSqlProvider.class, method = "countByExample")
    long countByExample(FrontPersonalCourseExample example);

    @DeleteProvider(type = FrontPersonalCourseSqlProvider.class, method = "deleteByExample")
    int deleteByExample(FrontPersonalCourseExample example);

    @Delete({
            "delete from front_personal_course",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into front_personal_course (id, create_time, ",
            "update_time, course_id, ",
            "course_name, course_objectives, ",
            "course_objectives_info, credits, ",
            "course_code, exam_way, ",
            "proportion, class_hour, ",
            "create_username)",
            "values (#{id,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
            "#{updateTime,jdbcType=TIMESTAMP}, #{courseId,jdbcType=VARCHAR}, ",
            "#{courseName,jdbcType=VARCHAR}, #{courseObjectives,jdbcType=VARCHAR}, ",
            "#{courseObjectivesInfo,jdbcType=VARCHAR}, #{credits,jdbcType=DOUBLE}, ",
            "#{courseCode,jdbcType=VARCHAR}, #{examWay,jdbcType=VARCHAR}, ",
            "#{proportion,jdbcType=VARCHAR}, #{classHour,jdbcType=VARCHAR}, ",
            "#{createUsername,jdbcType=VARCHAR})"
    })
    int insert(FrontPersonalCourse record);

    @InsertProvider(type = FrontPersonalCourseSqlProvider.class, method = "insertSelective")
    int insertSelective(FrontPersonalCourse record);

    @SelectProvider(type = FrontPersonalCourseSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "course_id", property = "courseId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "course_name", property = "courseName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "course_objectives", property = "courseObjectives", jdbcType = JdbcType.VARCHAR),
            @Result(column = "course_objectives_info", property = "courseObjectivesInfo", jdbcType = JdbcType.VARCHAR),
            @Result(column = "credits", property = "credits", jdbcType = JdbcType.DOUBLE),
            @Result(column = "course_code", property = "courseCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "exam_way", property = "examWay", jdbcType = JdbcType.VARCHAR),
            @Result(column = "proportion", property = "proportion", jdbcType = JdbcType.VARCHAR),
            @Result(column = "class_hour", property = "classHour", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_username", property = "createUsername", jdbcType = JdbcType.VARCHAR)
    })
    List<FrontPersonalCourse> selectByExample(FrontPersonalCourseExample example);

    @Select({
            "select",
            "id, create_time, update_time, course_id, course_name, course_objectives, course_objectives_info, ",
            "credits, course_code, exam_way, proportion, class_hour, create_username",
            "from front_personal_course",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "course_id", property = "courseId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "course_name", property = "courseName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "course_objectives", property = "courseObjectives", jdbcType = JdbcType.VARCHAR),
            @Result(column = "course_objectives_info", property = "courseObjectivesInfo", jdbcType = JdbcType.VARCHAR),
            @Result(column = "credits", property = "credits", jdbcType = JdbcType.DOUBLE),
            @Result(column = "course_code", property = "courseCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "exam_way", property = "examWay", jdbcType = JdbcType.VARCHAR),
            @Result(column = "proportion", property = "proportion", jdbcType = JdbcType.VARCHAR),
            @Result(column = "class_hour", property = "classHour", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_username", property = "createUsername", jdbcType = JdbcType.VARCHAR)
    })
    FrontPersonalCourse selectByPrimaryKey(Integer id);

    @UpdateProvider(type = FrontPersonalCourseSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") FrontPersonalCourse record, @Param("example") FrontPersonalCourseExample example);

    @UpdateProvider(type = FrontPersonalCourseSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") FrontPersonalCourse record, @Param("example") FrontPersonalCourseExample example);

    @UpdateProvider(type = FrontPersonalCourseSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FrontPersonalCourse record);

    @Update({
            "update front_personal_course",
            "set create_time = #{createTime,jdbcType=TIMESTAMP},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP},",
            "course_id = #{courseId,jdbcType=VARCHAR},",
            "course_name = #{courseName,jdbcType=VARCHAR},",
            "course_objectives = #{courseObjectives,jdbcType=VARCHAR},",
            "course_objectives_info = #{courseObjectivesInfo,jdbcType=VARCHAR},",
            "credits = #{credits,jdbcType=DOUBLE},",
            "course_code = #{courseCode,jdbcType=VARCHAR},",
            "exam_way = #{examWay,jdbcType=VARCHAR},",
            "proportion = #{proportion,jdbcType=VARCHAR},",
            "class_hour = #{classHour,jdbcType=VARCHAR},",
            "create_username = #{createUsername,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(FrontPersonalCourse record);

    @Select({
            "select",
            "id, create_time, update_time, course_id, course_name, course_objectives, course_objectives_info, ",
            "credits, course_code, exam_way, proportion, class_hour, create_username",
            "from front_personal_course",
            "where course_id = #{courseId,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "course_id", property = "courseId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "course_name", property = "courseName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "course_objectives", property = "courseObjectives", jdbcType = JdbcType.VARCHAR),
            @Result(column = "course_objectives_info", property = "courseObjectivesInfo", jdbcType = JdbcType.VARCHAR),
            @Result(column = "credits", property = "credits", jdbcType = JdbcType.DOUBLE),
            @Result(column = "course_code", property = "courseCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "exam_way", property = "examWay", jdbcType = JdbcType.VARCHAR),
            @Result(column = "proportion", property = "proportion", jdbcType = JdbcType.VARCHAR),
            @Result(column = "class_hour", property = "classHour", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_username", property = "createUsername", jdbcType = JdbcType.VARCHAR)
    })
    FrontPersonalCourse selectByCourseId(String courseId);

    @Update({
            "update front_personal_course",
            "set course_objectives = #{courseObjectives,jdbcType=VARCHAR},",
            "course_objectives_info = #{courseObjectivesInfo,jdbcType=VARCHAR}",
            "where course_id = #{courseId,jdbcType=VARCHAR}"
    })
    int updateCourseObjectivesAndInfoByCourseId(String courseId, String courseObjectives, String courseObjectivesInfo);

}