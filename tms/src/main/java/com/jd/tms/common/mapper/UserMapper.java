package com.jd.tms.common.mapper;

import com.jd.tms.common.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 数据访问或持久化
 *
 * @author wangning113
 * @since 2017/12/10
 */
@Mapper
public interface UserMapper {
    /**
     * 通过用户名查找
     *
     * @param name     用户名
     * @param password 密码
     * @return 用户实体类
     */
    @Select("SELECT id,name,password FROM tms_user WHERE name = #{name}")
    public User findByName(@Param("name") String name);

    /**
     * 添加用户
     *
     * @param name
     * @param password
     * @return 更新了多少行
     */
    @Insert("INSERT INTO tms_user(name,password) VALUES(#{name},#{password})")
    public int insert(@Param("name") String name, @Param("password") String password);

    /**
     * 修改密码操作
     *
     * @param name
     * @param password
     * @return
     */
    @Update("UPDATE tms_user SET password = #{password} WHERE name = #{name}")
    public int update(@Param("name") String name, @Param("password") String password);

    /**
     * 查看全部用户
     *
     * @return
     */
    @Select("SELECT * FROM tms_user")
    public List<User> findAllUser();

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @Delete("DELETE FROM tms_user WHERE id = #{id}")
    public int delete(int id);
}
