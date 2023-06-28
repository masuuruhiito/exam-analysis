package com.shijw.back.mapper;

import com.shijw.back.model.BackCollege;
import com.shijw.back.model.BackCollegeExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface BackCollegeMapper {
    @SelectProvider(type=BackCollegeSqlProvider.class, method="countByExample")
    long countByExample(BackCollegeExample example);

    @DeleteProvider(type=BackCollegeSqlProvider.class, method="deleteByExample")
    int deleteByExample(BackCollegeExample example);

    @Delete({
        "delete from back_college",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into back_college (id, create_time, ",
        "update_time, college_id, ",
        "university_code, college_name)",
        "values (#{id,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{collegeId,jdbcType=VARCHAR}, ",
        "#{universityCode,jdbcType=CHAR}, #{collegeName,jdbcType=VARCHAR})"
    })
    int insert(BackCollege record);

    @InsertProvider(type=BackCollegeSqlProvider.class, method="insertSelective")
    int insertSelective(BackCollege record);

    @SelectProvider(type=BackCollegeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="college_id", property="collegeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="university_code", property="universityCode", jdbcType=JdbcType.CHAR),
        @Result(column="college_name", property="collegeName", jdbcType=JdbcType.VARCHAR)
    })
    List<BackCollege> selectByExample(BackCollegeExample example);

    @Select({
        "select",
        "id, create_time, update_time, college_id, university_code, college_name",
        "from back_college",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="college_id", property="collegeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="university_code", property="universityCode", jdbcType=JdbcType.CHAR),
        @Result(column="college_name", property="collegeName", jdbcType=JdbcType.VARCHAR)
    })
    BackCollege selectByPrimaryKey(Integer id);

    @UpdateProvider(type=BackCollegeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BackCollege record, @Param("example") BackCollegeExample example);

    @UpdateProvider(type=BackCollegeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BackCollege record, @Param("example") BackCollegeExample example);

    @UpdateProvider(type=BackCollegeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BackCollege record);

    @Update({
        "update back_college",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "college_id = #{collegeId,jdbcType=VARCHAR},",
          "university_code = #{universityCode,jdbcType=CHAR},",
          "college_name = #{collegeName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BackCollege record);
}