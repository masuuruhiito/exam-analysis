package com.shijw.front.mapper;

import com.shijw.front.model.FrontPersonalClass;
import com.shijw.front.model.example.FrontPersonalClassExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface FrontPersonalClassMapper {
    @SelectProvider(type=FrontPersonalClassSqlProvider.class, method="countByExample")
    long countByExample(FrontPersonalClassExample example);

    @DeleteProvider(type=FrontPersonalClassSqlProvider.class, method="deleteByExample")
    int deleteByExample(FrontPersonalClassExample example);

    @Delete({
        "delete from front_personal_class",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into front_personal_class (id, create_time, ",
        "update_time, class_id, ",
        "university_code, college_id, ",
        "major, grade, class_number, ",
        "create_username)",
        "values (#{id,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{classId,jdbcType=VARCHAR}, ",
        "#{universityCode,jdbcType=CHAR}, #{collegeId,jdbcType=VARCHAR}, ",
        "#{major,jdbcType=VARCHAR}, #{grade,jdbcType=INTEGER}, #{classNumber,jdbcType=INTEGER}, ",
        "#{createUsername,jdbcType=VARCHAR})"
    })
    int insert(FrontPersonalClass record);

    @InsertProvider(type=FrontPersonalClassSqlProvider.class, method="insertSelective")
    int insertSelective(FrontPersonalClass record);

    @SelectProvider(type=FrontPersonalClassSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.VARCHAR),
        @Result(column="university_code", property="universityCode", jdbcType=JdbcType.CHAR),
        @Result(column="college_id", property="collegeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="major", property="major", jdbcType=JdbcType.VARCHAR),
        @Result(column="grade", property="grade", jdbcType=JdbcType.INTEGER),
        @Result(column="class_number", property="classNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="create_username", property="createUsername", jdbcType=JdbcType.VARCHAR)
    })
    List<FrontPersonalClass> selectByExample(FrontPersonalClassExample example);

    @Select({
        "select",
        "id, create_time, update_time, class_id, university_code, college_id, major, ",
        "grade, class_number, create_username",
        "from front_personal_class",
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
        @Result(column="class_number", property="classNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="create_username", property="createUsername", jdbcType=JdbcType.VARCHAR)
    })
    FrontPersonalClass selectByPrimaryKey(Integer id);

    @UpdateProvider(type=FrontPersonalClassSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") FrontPersonalClass record, @Param("example") FrontPersonalClassExample example);

    @UpdateProvider(type=FrontPersonalClassSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") FrontPersonalClass record, @Param("example") FrontPersonalClassExample example);

    @UpdateProvider(type=FrontPersonalClassSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FrontPersonalClass record);

    @Update({
        "update front_personal_class",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "class_id = #{classId,jdbcType=VARCHAR},",
          "university_code = #{universityCode,jdbcType=CHAR},",
          "college_id = #{collegeId,jdbcType=VARCHAR},",
          "major = #{major,jdbcType=VARCHAR},",
          "grade = #{grade,jdbcType=INTEGER},",
          "class_number = #{classNumber,jdbcType=INTEGER},",
          "create_username = #{createUsername,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(FrontPersonalClass record);
}