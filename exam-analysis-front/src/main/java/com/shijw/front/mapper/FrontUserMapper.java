package com.shijw.front.mapper;

import com.shijw.front.model.FrontUser;

import java.util.List;

import com.shijw.front.model.example.FrontUserExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface FrontUserMapper {
    @SelectProvider(type = FrontUserSqlProvider.class, method = "countByExample")
    long countByExample(FrontUserExample example);

    @DeleteProvider(type = FrontUserSqlProvider.class, method = "deleteByExample")
    int deleteByExample(FrontUserExample example);

    @Delete({
            "delete from front_user",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into front_user (id, create_time, ",
            "updatetime, username, ",
            "password, teacher_id, ",
            "teacher_name, teacher_rank, ",
            "college_name)",
            "values (#{id,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
            "#{updatetime,jdbcType=TIMESTAMP}, #{username,jdbcType=VARCHAR}, ",
            "#{password,jdbcType=VARCHAR}, #{teacherId,jdbcType=VARCHAR}, ",
            "#{teacherName,jdbcType=VARCHAR}, #{teacherRank,jdbcType=VARCHAR}, ",
            "#{collegeName,jdbcType=VARCHAR})"
    })
    int insert(FrontUser record);

    @InsertProvider(type = FrontUserSqlProvider.class, method = "insertSelective")
    int insertSelective(FrontUser record);

    @SelectProvider(type = FrontUserSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "updatetime", property = "updatetime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR),
            @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
            @Result(column = "teacher_id", property = "teacherId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "teacher_name", property = "teacherName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "teacher_rank", property = "teacherRank", jdbcType = JdbcType.VARCHAR),
            @Result(column = "college_name", property = "collegeName", jdbcType = JdbcType.VARCHAR)
    })
    List<FrontUser> selectByExample(FrontUserExample example);

    @Select({
            "select",
            "id, create_time, updatetime, username, password, teacher_id, teacher_name, teacher_rank, ",
            "college_name",
            "from front_user",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "updatetime", property = "updatetime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR),
            @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
            @Result(column = "teacher_id", property = "teacherId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "teacher_name", property = "teacherName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "teacher_rank", property = "teacherRank", jdbcType = JdbcType.VARCHAR),
            @Result(column = "college_name", property = "collegeName", jdbcType = JdbcType.VARCHAR)
    })
    FrontUser selectByPrimaryKey(Integer id);

    @UpdateProvider(type = FrontUserSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") FrontUser record, @Param("example") FrontUserExample example);

    @UpdateProvider(type = FrontUserSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") FrontUser record, @Param("example") FrontUserExample example);

    @UpdateProvider(type = FrontUserSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FrontUser record);

    @Update({
            "update front_user",
            "set create_time = #{createTime,jdbcType=TIMESTAMP},",
            "updatetime = #{updatetime,jdbcType=TIMESTAMP},",
            "username = #{username,jdbcType=VARCHAR},",
            "password = #{password,jdbcType=VARCHAR},",
            "teacher_id = #{teacherId,jdbcType=VARCHAR},",
            "teacher_name = #{teacherName,jdbcType=VARCHAR},",
            "teacher_rank = #{teacherRank,jdbcType=VARCHAR},",
            "college_name = #{collegeName,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(FrontUser record);

    @Select({
            "select",
            "id, create_time, updatetime, username, password, teacher_id, teacher_name, teacher_rank,college_name",
            "from front_user",
            "where username = #{username,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "updatetime", property = "updatetime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR),
            @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
            @Result(column = "teacher_id", property = "teacherId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "teacher_name", property = "teacherName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "teacher_rank", property = "teacherRank", jdbcType = JdbcType.VARCHAR),
            @Result(column = "college_name", property = "collegeName", jdbcType = JdbcType.VARCHAR)
    })
    FrontUser selectByUsername(String username);
}