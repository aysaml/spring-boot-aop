package com.jd.tms.product.controller;

import com.jd.tms.common.web.JsonResult;
import com.jd.tms.product.entity.Project;
import com.jd.tms.product.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * project项目功能的controler
 *
 * @author wangning113
 * @since 2017/12/10
 */
@Controller
public class ProjectController {
    @Resource
    private ProjectService projectService;

    @RequestMapping("/findAll")
    @ResponseBody
    public JsonResult findAll(int currentPage, int pageSize) {

        return new JsonResult(projectService.findAll(currentPage,pageSize));
    }

    @RequestMapping("/findAll2")
    @ResponseBody
    public JsonResult findAll2() {
        return new JsonResult(projectService.findAll2());
    }

}
