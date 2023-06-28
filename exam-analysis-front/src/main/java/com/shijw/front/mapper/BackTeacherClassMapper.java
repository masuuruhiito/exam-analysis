package com.shijw.front.mapper;

import com.shijw.front.model.BackTeacherClass;
import com.shijw.front.model.example.BackTeacherClassExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface BackTeacherClassMapper {
    @SelectProvider(type=BackTeacherClassSqlProvider.class, method="countByExample")
    long countByExample(BackTeacherClassExample example);

    @DeleteProvider(type=BackTeacherClassSqlProvider.class, method="deleteByExample")
    int deleteByExample(BackTeacherClassExample example);

    @Delete({
        "delete from back_tea_class",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into back_tea_class (id, teacher_id, ",
        "course_id, class_id, ",
        "semester)",
        "values (#{id,jdbcType=INTEGER}, #{teacherId,jdbcType=VARCHAR}, ",
        "#{courseId,jdbcType=VARCHAR}, #{classId,jdbcType=VARCHAR}, ",
        "#{semester,jdbcType=VARCHAR})"
    })
    int insert(BackTeacherClass record);

    @InsertProvider(type=BackTeacherClassSqlProvider.class, method="insertSelective")
    int insertSelective(BackTeacherClass record);

    @SelectProvider(type=BackTeacherClassSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.VARCHAR),
        @Result(column="semester", property="semester", jdbcType=JdbcType.VARCHAR)
    })
    List<BackTeacherClass> selectByExample(BackTeacherClassExample example);

    @Select({
        "select",
        "id, teacher_id, course_id, class_id, semester",
        "from back_tea_class",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.VARCHAR),
        @Result(column="semester", property="semester", jdbcType=JdbcType.VARCHAR)
    })
    BackTeacherClass selectByPrimaryKey(Integer id);

    @UpdateProvider(type=BackTeacherClassSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BackTeacherClass record, @Param("example") BackTeacherClassExample example);

    @UpdateProvider(type=BackTeacherClassSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BackTeacherClass record, @Param("example") BackTeacherClassExample example);

    @UpdateProvider(type=BackTeacherClassSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BackTeacherClass record);

    @Update({
        "update back_tea_class",
        "set teacher_id = #{teacherId,jdbcType=VARCHAR},",
          "course_id = #{courseId,jdbcType=VARCHAR},",
          "class_id = #{classId,jdbcType=VARCHAR},",
          "semester = #{semester,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BackTeacherClass record);
}