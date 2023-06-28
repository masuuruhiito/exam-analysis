package com.shijw.back.mapper;

import com.shijw.back.model.BackUser;
import com.shijw.back.model.BackUserExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface BackUserMapper {
    @SelectProvider(type=BackUserSqlProvider.class, method="countByExample")
    long countByExample(BackUserExample example);

    @DeleteProvider(type=BackUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(BackUserExample example);

    @Delete({
        "delete from back_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into back_user (id, create_time, ",
        "update_time, username, ",
        "password, identity, ",
        "university_code)",
        "values (#{id,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{identity,jdbcType=INTEGER}, ",
        "#{universityCode,jdbcType=VARCHAR})"
    })
    int insert(BackUser record);

    @InsertProvider(type=BackUserSqlProvider.class, method="insertSelective")
    int insertSelective(BackUser record);

    @SelectProvider(type=BackUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="identity", property="identity", jdbcType=JdbcType.INTEGER),
        @Result(column="university_code", property="universityCode", jdbcType=JdbcType.VARCHAR)
    })
    List<BackUser> selectByExample(BackUserExample example);

    @Select({
        "select",
        "id, create_time, update_time, username, password, identity, university_code",
        "from back_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="identity", property="identity", jdbcType=JdbcType.INTEGER),
        @Result(column="university_code", property="universityCode", jdbcType=JdbcType.VARCHAR)
    })
    BackUser selectByPrimaryKey(Integer id);

    @UpdateProvider(type=BackUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BackUser record, @Param("example") BackUserExample example);

    @UpdateProvider(type=BackUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BackUser record, @Param("example") BackUserExample example);

    @UpdateProvider(type=BackUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BackUser record);

    @Update({
        "update back_user",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "identity = #{identity,jdbcType=INTEGER},",
          "university_code = #{universityCode,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BackUser record);
}