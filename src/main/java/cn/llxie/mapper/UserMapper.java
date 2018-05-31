package cn.llxie.mapper;

import cn.llxie.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 注解模式
 */
@Mapper
public interface UserMapper {


    @Insert("INSERT INTO USER(ID, USERNAME, AGE) VALUES(#{id}, #{username}, #{age})")
    int insert(@Param("id") Long id, @Param("username") String username, @Param("age") Integer age);

    @Insert("INSERT INTO USER(ID, " +
            "USERNAME, AGE) VALUES(" +
            "#{id, jdbcType=BIGINT},#{username, jdbcType=VARCHAR}, #{age, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("INSERT INTO USER(ID， USERNAME, AGE) VALUES(#{id},#{username}, #{age})")
    int addUser(User user);

    @Update("UPDATE USER SET AGE = #{age} WHERE  USERNAME= #{username}")
    void update(User user);

    @Delete("DELETE FROM USER WHERE ID = #{id}")
    void delete(Long id);

    @Select("SELECT * FROM USER WHERE USERNAME = #{username}")
    User findUserByName(@Param("username") String username);

    @Select("SELECT * FROM USER WHERE ID = #{id}")
    User findUserById(@Param("id") Long  id);

    @Results({
            @Result(property = "username", column = "USERNAME"),
            @Result(property = "age", column = "AGE"),
    })
    @Select("SELECT ID,USERNAME, AGE FROM USER")
    List<User> findAllUser();

}
