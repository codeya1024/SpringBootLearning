package com.codeya.springboot.testjdbc.service.intf;

import com.codeya.springboot.testjdbc.entity.Staff;

/**
 * Created by codeya on 2017/12/5.
 */
public interface StaffAPI {
    public Staff findOne_by_jdbctemplate(String staffId);
    public Staff findOne_by_mybatis(String staffId);
}
