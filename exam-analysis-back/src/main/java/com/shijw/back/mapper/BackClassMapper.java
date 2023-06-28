package com.shijw.back.mapper;

import com.shijw.back.model.BackClass;
import com.shijw.back.model.BackClassExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface BackClassMapper {
    @SelectProvider(type=BackClassSqlProvider.class, method="countByExample")
    long countByExample(BackClassExample example);

    @DeleteProvider(type=BackClassSqlProvider.class, method="deleteByExample")
    int deleteByExample(BackClassExample example);

    @Delete({
        "delete from back_class",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into back_class (id, create_time, ",
        "update_time, class_id, ",
        "university_code, college_id, ",
        "major, grade, class_number)",
        "values (#{id,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{classId,jdbcType=VARCHAR}, ",
        "#{universityCode,jdbcType=CHAR}, #{collegeId,jdbcType=VARCHAR}, ",
        "#{major,jdbcType=VARCHAR}, #{grade,jdbcType=INTEGER}, #{classNumber,jdbcType=INTEGER})"
    })
    int insert(BackClass record);

    @InsertProvider(type=BackClassSqlProvider.class, method="insertSelective")
    int insertSelective(BackClass record);

    @SelectProvider(type=BackClassSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.VARCHAR),
        @Result(column="university_code", property="universityCode", jdbcType=JdbcType.CHAR),
        @Result(column="college_id", property="collegeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="major", property="major", jdbcType=JdbcType.VARCHAR),
        @Result(column="grade", property="grade", jdbcType=JdbcType.INTEGER),
        @Result(column="class_number", property="classNumber", jdbcType=JdbcType.INTEGER)
    })
    List<BackClass> selectByExample(BackClassExample example);

    @Select({
        "select",
        "id, create_time, update_time, class_id, university_code, college_id, major, ",
        "grade, class_number",
        "from back_class",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.VARCHAR),
        @Result(column="university_code", property="universityCode", jdbcType=JdbcType.CHAR),
        @Result(column="college_id", property="collegeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="major", property="major", jdbcType=JdbcType.VARCHAR),
        @Result(column="grade", property="grade", jdbcType=JdbcType.INTEGER),
        @Result(column="class_number", property="classNumber", jdbcType=JdbcType.INTEGER)
    })
    BackClass selectByPrimaryKey(Integer id);

    @UpdateProvider(type=BackClassSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BackClass record, @Param("example") BackClassExample example);

    @UpdateProvider(type=BackClassSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BackClass record, @Param("example") BackClassExample example);

    @UpdateProvider(type=BackClassSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BackClass record);

    @Update({
        "update back_class",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "class_id = #{classId,jdbcType=VARCHAR},",
          "university_code = #{universityCode,jdbcType=CHAR},",
          "college_id = #{collegeId,jdbcType=VARCHAR},",
          "major = #{major,jdbcType=VARCHAR},",
          "grade = #{grade,jdbcType=INTEGER},",
          "class_number = #{classNumber,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BackClass record);
}