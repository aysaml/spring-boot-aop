package com.jd.tms.product.mapper;

import com.jd.tms.product.entity.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * project项目的持久化操作
 *
 * @author wangning113
 * @since 2017/12/10
 */
@Mapper
public interface ProjectMapper {
    /**
     * 获得表中所有记录
     *
     * @param name       模糊查询时输入的项目
     * @param valid      项目启用、禁用状态值(1,0)
     * @param startIndex 表示从哪条记录开始取数据
     * @param pageSize   表示每页显示多少条记录
     * @return 表示查询到的当前页的所有记录
     * 当方法中的参数个数多于1个时需要使用
     */

    @Select("select * from tms_projects where name like concat('%',#{name},'%') and valid=#{valid} order by createdTime desc limit #{startIndex},#{pageSize}")
    List<Project> findObjects(
            @Param("name") String name,
            @Param("valid") Integer valid,
            @Param("startIndex") int startIndex,
            @Param("pageSize") int pageSize);

    /**
     * 获得总记录数
     *
     * @param name  模糊查询时输入的项目
     * @param valid 项目启用、禁用状态值(1,0)
     * @return 总记录数
     */
    @Select("select count(*) from tms_projects where name like concat('%',#{name},'%') and valid=#{valid}")
    int getRowCount(
            @Param("name") String name,
            @Param("valid") Integer valid);


    /**修改表中记录信息*/
    //int updateObject(Project entity);

    /**
     * 禁用或启动项目信息
     * String idStr=1,2,3;
     * String ids[]=ids.split(",");[1,2,3];
     *
     * @param ids   要修改的 id 的值
     * @param valid 将valid具体修改为什么值?(1,0)
     * @return 为被修改的记录的行数
     */
    @Update(" update tms_projects" +
            " set valid=#{valid},modifiedTime=now()" +
            "where id in #{ids}")
    int validById(
            @Param("ids") String[] ids,
            @Param("valid") int valid);

    /**根据id执行查询操作
     * @param id 来自页面上的某条记录的id值
     * */
    //Project findObjectById(Integer id);

    /**
     * 查询所有启用项目的id以及名字
     *
     * @return
     */
    @Select("select id,name from tms_projects where valid=1")
    List<Map<String, Object>> findPrjIdAndNames();

    /**
     * 通过id查找
     *
     * @param id
     * @return
     */
    @Select("select * " +
            "from tms_projects" +
            "where id=#{id} ")
    Project findObjectById(Integer id);

    /**
     * 插入一条记录
     *
     * @param entity
     * @return
     */
    @Insert("insert into tms_projects(id,name,code, beginDate,endDate, valid, note,createdTime,modifiedTime,createdUser,modifiedUser) values (#{id},#{name},#{code},#{beginDate},#{endDate},#{valid},  #{note},NOW(),NOW(),#{createdUser},#{modifiedUser})")
    int insertObject(Project entity);

    /**
     * 更新
     *
     * @param entity
     * @return
     */
    @Update("update tms_projects" +
            "      set" +
            "      name=#{name}," +
            "      code=#{code}," +
            "      beginDate=#{beginDate}," +
            "      endDate=#{endDate}," +
            "      valid=#{valid}," +
            "      note=#{note}," +
            "      modifiedTime=now()," +
            "      modifiedUser=#{modifiedUser}" +
            "      where id=#{id}")
    int updateObject(Project entity);

    /**
     * 查询所有项目
     * @return
     */
    @Select("SELECT id,proname,state,note FROM tms_pro")
    List<Project> findAll();
}
