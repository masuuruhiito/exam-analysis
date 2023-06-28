package com.shijw.back.mapper;

import com.shijw.back.model.BackUniversity;
import com.shijw.back.model.BackUniversityExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface BackUniversityMapper {
    @SelectProvider(type=BackUniversitySqlProvider.class, method="countByExample")
    long countByExample(BackUniversityExample example);

    @DeleteProvider(type=BackUniversitySqlProvider.class, method="deleteByExample")
    int deleteByExample(BackUniversityExample example);

    @Delete({
        "delete from back_university",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into back_university (id, create_time, ",
        "update_time, university_code, ",
        "university_name, university_address)",
        "values (#{id,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{universityCode,jdbcType=VARCHAR}, ",
        "#{universityName,jdbcType=VARCHAR}, #{universityAddress,jdbcType=VARCHAR})"
    })
    int insert(BackUniversity record);

    @InsertProvider(type=BackUniversitySqlProvider.class, method="insertSelective")
    int insertSelective(BackUniversity record);

    @SelectProvider(type=BackUniversitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="university_code", property="universityCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="university_name", property="universityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="university_address", property="universityAddress", jdbcType=JdbcType.VARCHAR)
    })
    List<BackUniversity> selectByExample(BackUniversityExample example);

    @Select({
        "select",
        "id, create_time, update_time, university_code, university_name, university_address",
        "from back_university",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="university_code", property="universityCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="university_name", property="universityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="university_address", property="universityAddress", jdbcType=JdbcType.VARCHAR)
    })
    BackUniversity selectByPrimaryKey(Integer id);

    @UpdateProvider(type=BackUniversitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BackUniversity record, @Param("example") BackUniversityExample example);

    @UpdateProvider(type=BackUniversitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BackUniversity record, @Param("example") BackUniversityExample example);

    @UpdateProvider(type=BackUniversitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BackUniversity record);

    @Update({
        "update back_university",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "university_code = #{universityCode,jdbcType=VARCHAR},",
          "university_name = #{universityName,jdbcType=VARCHAR},",
          "university_address = #{universityAddress,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BackUniversity record);
}