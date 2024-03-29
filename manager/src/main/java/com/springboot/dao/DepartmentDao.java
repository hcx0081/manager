package com.springboot.dao;

import com.springboot.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * {@code @Description:}
 */
@Repository
public class DepartmentDao {
    /*
     * 模拟数据库数据
     * */
    private static Map<Integer, Department> departments;
    
    static {
        departments = new HashMap<>();
        departments.put(101, new Department(101, "教学部"));
        departments.put(102, new Department(102, "教研部"));
        departments.put(103, new Department(103, "市场部"));
        departments.put(104, new Department(104, "运营部"));
        departments.put(105, new Department(105, "后勤部"));
    }
    
    // 获取所有部门信息
    public Collection<Department> getDepartments() {
        return departments.values();
    }
    
    // 通过id获取部门信息
    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }
    
}