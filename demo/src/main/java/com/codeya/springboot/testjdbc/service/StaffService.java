package com.codeya.springboot.testjdbc.service;

import com.codeya.springboot.testjdbc.dao.StaffDao;
import com.codeya.springboot.testjdbc.entity.Staff;
import com.codeya.springboot.testjdbc.service.intf.StaffAPI;
import com.codeya.springboot.testjdbc.dao.StaffDao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by codeya on 2017/12/5.
 */
@Service
public class StaffService implements StaffAPI {

    @Autowired
    StaffDao dao;
    public Staff findOne_by_jdbctemplate(String staffId){
        return dao.findOne(staffId);
    }

    @Autowired
    StaffDao2 dao2;
    public Staff findOne_by_mybatis(String staffId){
        return dao2.findOne(staffId);
    }

}
