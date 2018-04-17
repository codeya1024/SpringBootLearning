package com.codeya.springboot.testjdbc.dao;

import com.codeya.springboot.testjdbc.entity.Staff;

/**
 * Created by codeya on 2017/12/5.
 */
public interface StaffDao2 {
    public Staff findOne(String id);
}
