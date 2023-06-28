package com.shijw.front.mapper;

import com.shijw.front.model.FrontTeacherClass;
import com.shijw.front.model.example.FrontTeacherClassExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface FrontTeacherClassMapper {
    @SelectProvider(type=FrontTeacherClassSqlProvider.class, method="countByExample")
    long countByExample(FrontTeacherClassExample example);

    @DeleteProvider(type=FrontTeacherClassSqlProvider.class, method="deleteByExample")
    int deleteByExample(FrontTeacherClassExample example);

    @Delete({
        "delete from front_tea_class",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into front_tea_class (id, teacher_id, ",
        "course_id, class_id, ",
        "semester)",
        "values (#{id,jdbcType=INTEGER}, #{teacherId,jdbcType=VARCHAR}, ",
        "#{courseId,jdbcType=VARCHAR}, #{classId,jdbcType=VARCHAR}, ",
        "#{semester,jdbcType=VARCHAR})"
    })
    int insert(FrontTeacherClass record);

    @InsertProvider(type=FrontTeacherClassSqlProvider.class, method="insertSelective")
    int insertSelective(FrontTeacherClass record);

    @SelectProvider(type=FrontTeacherClassSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.VARCHAR),
        @Result(column="semester", property="semester", jdbcType=JdbcType.VARCHAR)
    })
    List<FrontTeacherClass> selectByExample(FrontTeacherClassExample example);

    @Select({
        "select",
        "id, teacher_id, course_id, class_id, semester",
        "from front_tea_class",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.VARCHAR),
        @Result(column="semester", property="semester", jdbcType=JdbcType.VARCHAR)
    })
    FrontTeacherClass selectByPrimaryKey(Integer id);

    @UpdateProvider(type=FrontTeacherClassSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") FrontTeacherClass record, @Param("example") FrontTeacherClassExample example);

    @UpdateProvider(type=FrontTeacherClassSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") FrontTeacherClass record, @Param("example") FrontTeacherClassExample example);

    @UpdateProvider(type=FrontTeacherClassSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FrontTeacherClass record);

    @Update({
        "update front_tea_class",
        "set teacher_id = #{teacherId,jdbcType=VARCHAR},",
          "course_id = #{courseId,jdbcType=VARCHAR},",
          "class_id = #{classId,jdbcType=VARCHAR},",
          "semester = #{semester,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(FrontTeacherClass record);
}