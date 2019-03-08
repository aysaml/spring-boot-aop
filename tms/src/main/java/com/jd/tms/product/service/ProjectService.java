package com.jd.tms.product.service;

import java.util.List;
import java.util.Map;

import com.jd.tms.common.exception.ServiceException;
import com.jd.tms.product.entity.Project;
import org.springframework.transaction.annotation.Transactional;

/**
 * 项目管理模块的业务层对象:
 * 负责具体项目信息的业务处理
 *
 * @author wangning113
 * @since 2017/12/9
 */
public interface ProjectService {
    /**
     * 获得当前页项目信息以及分页信息
     * 1)项目信息封装到List<Project>
     * 2)分页信息封装到PageObject
     * 将项目信息和分页信息再次封装,
     * 封装map,然后做统一返回
     *
     * @param name
     * @param valid
     * @param pageCurrent
     * @return
     */
    Map<String, Object> findObjects(
            String name,
            Integer valid,
            int pageCurrent);

    /**
     * 启用禁用项目信息
     *
     * @param idStr
     * @param valid
     */
    void validById(
            String idStr,
            Integer valid);

    /**
     * 向表中写入数据
     *
     * @param entity
     */
    void saveObject(Project entity);

    /**
     * 修改表中数据
     *
     * @param entity
     */
    void updateObject(Project entity);

    /**
     * 根据id查找具体对象
     *
     * @param id
     * @return
     */
    Project findObjectById(Integer id);

    /**
     * 使用PageHelper实现分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Transactional(rollbackFor = ServiceException.class)
    public List<Project> findAll(int currentPage,int pageSize);

    /**
     * 测试不同的数据源
     * @return
     */
    @Transactional(rollbackFor = ServiceException.class)
    public List<Project> findAll2();
}






