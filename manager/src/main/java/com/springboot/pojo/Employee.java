package com.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@code @Description:} 员工表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private Integer gender;// 1：男    0：女
    private Department department;
}