package com.codeya.springboot.testjdbc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by codeya on 2017/12/5.
 */
@Slf4j
@NoArgsConstructor
@ToString
@ApiModel(description="Staff VO")
public class Staff {

    @ApiModelProperty(value="员工id")
    @Getter
    String id;

    @ApiModelProperty(value="姓名")
    @Getter
    String name;

    @ApiModelProperty(value="登录名")
    @Getter
    @Setter(AccessLevel.PACKAGE)
    String loginName;

    @ApiModelProperty(value="haha")
    @Getter
    Integer haha=new Integer(2);

    public Staff(String id,String name,String loginName){
        this.id = id;
        this.name = name;
        this.loginName = loginName;
    }


}
