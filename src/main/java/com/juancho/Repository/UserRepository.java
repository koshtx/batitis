package com.juancho.Repository;

import com.juancho.Model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    @Insert("INSERT INTO user (id, name, password, active) VALUES (#{id},#{name},#{password},#{active})")
    void addUser (User user);

    @Select("SELECT * FROM user")
    List<User> selectUsers();

    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectUser(@Param("id") String id);

    @Delete("DELETE FROM user where id = #{id}")
    int deleteUser(@Param("id") String id);
}
