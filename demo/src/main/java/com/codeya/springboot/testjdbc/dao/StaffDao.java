package com.codeya.springboot.testjdbc.dao;

import com.codeya.springboot.testjdbc.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by codeya on 2017/12/5.
 */
@Repository
public class StaffDao {

    @Autowired
    JdbcTemplate template;

    public Staff findOne(String id) {
        return template.queryForObject("select staff_id,name,login_name from staff s where s.staff_id=?",new Object[]{id},new RowMapper<Staff>() {
            @Override
            public Staff mapRow(ResultSet resultSet, int i) throws SQLException {
                System.out.println("result:" + resultSet.getString("staff_id"));
                Staff staff = new Staff(resultSet.getString("staff_id"), resultSet.getString("name"), resultSet.getString("login_name"));
                return staff;
            }
        });
    }

  /*  public void insertOne() {
        String sql = "insert into STAFF (staff_id, name, title, station, password, department, workgroup_id, site_id, dept_level_id, eff_date, exp_date, state, state_date, ip_limit, ip_subnet, ip_netmask, ip_hostname, pc_limit, pc_id, invoice_serial_nbr, last_date, email, phone_no, delete_state, delete_time, remark, staff_alias, login_name, pwd_mod_date, lan_id, loginuid, staff_code, staff_state, last_login_date, erro_times, captcha, validate_time, his_pwd, safe_strategy, identity_id, hr_code, res_type_id)\n" +
                "values (1111, 'testqll', 0, '1', 'k', null, 1, 300000670, 0, to_date('01-01-2001', 'dd-mm-yyyy'), to_date('01-06-2030 12:00:00', 'dd-mm-yyyy hh24:mi:ss'), 'K0A', to_date('05-05-2010 12:00:00', 'dd-mm-yyyy hh24:mi:ss'), ' ', '                ', '                ', null, 0, null, null, null, null, '18974888808', '0', null, null, null, 'testqll', to_date('07-09-2017 14:10:00', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, 1, to_date('09-11-2017 18:31:41', 'dd-mm-yyyy hh24:mi:ss'), 0, '258503', to_date('26-11-2013 11:11:37', 'dd-mm-yyyy hh24:mi:ss'), 'nmPWD:kjg2PO5UF', 1680, null, null, null)";
        template.execute(sql);
    }
*/
}
