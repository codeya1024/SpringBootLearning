package com.codeya.springboot.testjdbc.controller;

import com.codeya.springboot.test.vo.ProcessResult;
import com.codeya.springboot.testjdbc.entity.Staff;
import com.codeya.springboot.testjdbc.service.intf.StaffAPI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping(value="/test_path_variable/{id}")
    public ProcessResult test_path_variable(@PathVariable("id")String id) {
        log.info(id.toString());
        ProcessResult result = new  ProcessResult(ProcessResult.SUCCESS,"OK","id="+id);
        return result;
    }
    @Value("${server.port}")
    String port;
    @RequestMapping(value="/test_path_and_param/{id}")
    public ProcessResult test_path_and_param(@PathVariable("id")String id,@RequestParam("name")String name ) {
        log.info(id.toString());
        ProcessResult result = new  ProcessResult(ProcessResult.SUCCESS,"OK","id="+id+",name="+name+",port:="+port);
        return result;
    }
    @RequestMapping(value="/test_request_param")
    public ProcessResult test_request_param(@RequestParam ("id")String id,@RequestParam("name")String name) {
        log.info("id:{},name:{}",id.toString(),name.toString());
        ProcessResult result = new  ProcessResult(ProcessResult.SUCCESS,"OK","id="+id+"name="+name);
        return result;
    }
    /**
     * post方式传递自定义对象。。ajax调用时需要json写法
     * @return
     */
    @PostMapping("test_questbody")
    public ProcessResult test_questbody(@RequestBody Staff staff) {
        log.info(staff.toString());
        //staff.setBirthday(null);
        ProcessResult result = new  ProcessResult(ProcessResult.SUCCESS,"OK",staff);
        return result;
    }
    @PostMapping("test_path_body/{id}")
    public ProcessResult test_path_body(@PathVariable("id") String id,@RequestBody Staff staff) {
        log.info("id"+id+",staff:"+staff.toString());
        //staff.setBirthday(null);
        ProcessResult result = new  ProcessResult(ProcessResult.SUCCESS,"OK",staff);
        return result;
    }

}
