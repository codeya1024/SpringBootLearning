package com.codeya.springboot.testjdbc.controller;

import com.codeya.springboot.testjdbc.entity.Staff;
import com.codeya.springboot.testjdbc.service.StaffService;
import com.codeya.springboot.testjdbc.service.intf.StaffAPI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.TEXT_PLAIN;

/**
 * Created by codeya on 2017/12/5.
 */
@RestController
@RequestMapping("/staff")
@Slf4j
@Api(tags="Staff相关服务")
public class StaffController {
    @Autowired
    StaffAPI service;

    @ApiOperation(value = "查询员工信息，通过jdbctemplate")
    @RequestMapping(value = "/jdbc/{id}",method = RequestMethod.GET )
    @ApiImplicitParams({@ApiImplicitParam(value="员工id",name="id",paramType="path",dataType = "String",required = true)})
    Staff findOne_by_jdbctemplate(@PathVariable("id") String staffId)
    {
       log.debug("StaffController.findOne_by_jdbctemplate calling,staffId={}",staffId);
       return service.findOne_by_jdbctemplate(staffId);
    }

    @ApiOperation(value = "查询员工信息，通过MyBatis")
    @RequestMapping(value = "/mybatis/{id}",method = RequestMethod.GET)
    Staff findOne_by_mybatis(@PathVariable("id") String staffId)
    {
        log.debug("StaffController.findOne_by_mybatis calling,staffId={}",staffId);
        return service.findOne_by_mybatis(staffId);
    }

    @ApiOperation(value = "查询员工信息，通过MyBatis")
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    Staff test()
    {
        log.debug("StaffController.test calling");
        Staff staff = new Staff();
        return staff;
    }

}
