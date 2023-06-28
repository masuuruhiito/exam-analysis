package com.shijw.front.mapper;

import com.shijw.front.model.FrontPersonalStudent;
import java.util.List;

import com.shijw.front.model.example.FrontPersonalStudentExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface FrontPersonalStudentMapper {
    @SelectProvider(type=FrontPersonalStudentSqlProvider.class, method="countByExample")
    long countByExample(FrontPersonalStudentExample example);

    @DeleteProvider(type=FrontPersonalStudentSqlProvider.class, method="deleteByExample")
    int deleteByExample(FrontPersonalStudentExample example);

    @Delete({
        "delete from front_personal_student",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into front_personal_student (id, create_time, ",
        "update_time, student_id, ",
        "university_code, college_id, ",
        "class_id, student_name, ",
        "sex, birthday, phone_number, ",
        "email, address)",
        "values (#{id,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{studentId,jdbcType=VARCHAR}, ",
        "#{universityCode,jdbcType=CHAR}, #{collegeId,jdbcType=VARCHAR}, ",
        "#{classId,jdbcType=VARCHAR}, #{studentName,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=VARCHAR}, #{birthday,jdbcType=VARCHAR}, #{phoneNumber,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR})"
    })
    int insert(FrontPersonalStudent record);

    @InsertProvider(type=FrontPersonalStudentSqlProvider.class, method="insertSelective")
    int insertSelective(FrontPersonalStudent record);

    @SelectProvider(type=FrontPersonalStudentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="university_code", property="universityCode", jdbcType=JdbcType.CHAR),
        @Result(column="college_id", property="collegeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_name", property="studentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone_number", property="phoneNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR)
    })
    List<FrontPersonalStudent> selectByExample(FrontPersonalStudentExample example);

    @Select({
        "select",
        "id, create_time, update_time, student_id, university_code, college_id, class_id, ",
        "student_name, sex, birthday, phone_number, email, address",
        "from front_personal_student",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="university_code", property="universityCode", jdbcType=JdbcType.CHAR),
        @Result(column="college_id", property="collegeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_name", property="studentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone_number", property="phoneNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR)
    })
    FrontPersonalStudent selectByPrimaryKey(Integer id);

    @UpdateProvider(type=FrontPersonalStudentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") FrontPersonalStudent record, @Param("example") FrontPersonalStudentExample example);

    @UpdateProvider(type=FrontPersonalStudentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") FrontPersonalStudent record, @Param("example") FrontPersonalStudentExample example);

    @UpdateProvider(type=FrontPersonalStudentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FrontPersonalStudent record);

    @Update({
        "update front_personal_student",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "student_id = #{studentId,jdbcType=VARCHAR},",
          "university_code = #{universityCode,jdbcType=CHAR},",
          "college_id = #{collegeId,jdbcType=VARCHAR},",
          "class_id = #{classId,jdbcType=VARCHAR},",
          "student_name = #{studentName,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "birthday = #{birthday,jdbcType=VARCHAR},",
          "phone_number = #{phoneNumber,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(FrontPersonalStudent record);
}