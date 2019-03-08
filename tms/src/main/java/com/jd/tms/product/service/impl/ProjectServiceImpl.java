package com.jd.tms.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.jd.tms.common.annotation.TargetDataSource;
import com.jd.tms.product.mapper.ProjectMapper;
import org.springframework.stereotype.Service;

import com.jd.tms.common.exception.ServiceException;
import com.jd.tms.common.web.PageObject;
import com.jd.tms.product.entity.Project;
import com.jd.tms.product.service.ProjectService;

/**
 * 业务层操作实现
 *
 * @author wangning113
 * @since 2017/12/9
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectMapper projectMapper;

    /**
     * 查询,获取项目信息
     */
    @Override
    public Map<String, Object> findObjects(
            String name,
            Integer valid,
            int pageCurrent) {
        //1.通过dao对象的方法获取当前页项目信息
        //1.1定义每页最多显示2条数据
        int pageSize = 2;
        //1.2计算当前页开始查找的位置
        int startIndex = (pageCurrent - 1) * pageSize;
        //1.3开始查询当前页的数据
        List<Project> list =
                projectMapper.findObjects(
                        name, valid, startIndex, pageSize);
        //2.获得总记录数,计算总页数,然后进行封装
        //2.1 查询总记录数
        int rowCount =
                projectMapper.getRowCount(name, valid);
        //2.3封装分页信息(自己定义PageObject)
        PageObject pageObject = new PageObject();
        pageObject.setRowCount(rowCount);
        pageObject.setPageSize(pageSize);
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setStartIndex(startIndex);
        //3.将数据封装到map(两个对象需要传回页面)
        Map<String, Object> map =
                new HashMap<String, Object>(50);
        //3.1封装当前页数据
        map.put("list", list);
        //3.2封装分页对象信息
        map.put("pageObject", pageObject);
        return map;
    }

    /**
     * 启用或禁用项目信息
     *
     * @param idStr 包含页面上选中的多个id值,
     *              具体格式:"11,12,13,15"
     * @param valid 具体启用和禁用的值
     */
    @Override
    public void validById(String idStr, Integer valid) {
        System.out.println("valid=" + valid);
        //1.对参数进行业务验证(提高系统的容错能力)
        if (idStr == null || idStr.trim().length() == 0) {
            throw new ServiceException("至少选择一项");
        }
        if (valid != 0 && valid != 1) {
            throw new ServiceException("valid值必须是0或者1");
        }
        //2.将字符串解析为数组(获得选中的所有id值)
        String[] ids = idStr.split(",");
        //3.执行启用或禁用的更新操作
        projectMapper.validById(ids, valid);
    }

    /**
     * 执行写入操作
     *
     * @param entity 封装了用户页面上输入的数据
     */
    @Override
    public void saveObject(Project entity) {
        //1.对参数进行业务验证
        if (entity == null) {
            throw new ServiceException("写入的数据不能为空");
        }
        //2.执行写入操作(返回值默认为写入的行数)
        int rows =
                projectMapper.insertObject(entity);
        //3.对结果进行业务判定
        if (rows == -1) {
            throw new ServiceException("insert error");
        }
    }

    /**
     * 根据id查找project对象
     */
    @Override
    public Project findObjectById(
            Integer id) {
        //1.判定id的有效性
        if (id == null || id <= 0) {
            throw new ServiceException(
                    "id值无效:id=" + id);
        }
        //2.根据id查找对应的对象
        Project project =
                projectMapper.findObjectById(id);
        //3.判定结果是否正确
        if (project == null) {
            throw new ServiceException(
                    "没有找到对应的记录");
        }
        //4.返回结果
        return project;
    }

    @Override
    @TargetDataSource(value = "primaryDataSource")
    public List<Project> findAll(int currentPage,int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        return projectMapper.findAll();
    }

    @Override
    @TargetDataSource(value = "secondaryDataSource")
    public List<Project> findAll2() {
        return projectMapper.findAll();
    }

    /**
     * 执行修改操作
     *
     * @param entity 指向的对象封装了页面上要 修改的数据.
     */
    @Override
    public void updateObject(Project entity) {
        //1.判定参数的有效性
        if (entity == null) {
            throw new ServiceException("被修改的记录不能空");
        }
        //2.执行修改操作
        int rows = projectMapper.updateObject(entity);
        //3.根据结果判定是否修改成功
        if (rows != 1) {
            throw new RuntimeException("修改失败");
        }
    }
}








