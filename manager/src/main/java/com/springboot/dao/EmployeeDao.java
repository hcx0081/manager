package com.springboot.dao;

import com.springboot.pojo.Department;
import com.springboot.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 */
@Repository
public class EmployeeDao {
    /*
     * 模拟数据库数据
     * */
    private static Map<Integer, Employee> employees;
    
    static {
        employees = new HashMap<>();
        employees.put(101, new Employee(101, "zs", 1, new Department(101, "教学部")));
        employees.put(102, new Employee(102, "zs", 1, new Department(102, "教研部")));
        employees.put(103, new Employee(103, "zs", 1, new Department(103, "市场部")));
        employees.put(104, new Employee(104, "zs", 1, new Department(104, "运营部")));
        employees.put(105, new Employee(105, "zs", 1, new Department(105, "后勤部")));
        
    }
    
    @Autowired
    private DepartmentDao departmentDao;
    
    // 获取所有员工信息
    public Collection<Employee> getEmployees() {
        return employees.values();
    }
    
    // 通过id获取员工信息
    public Employee getEmployeesById(Integer id) {
        return employees.get(id);
    }
    
    // 主键自增
    private static Integer initId = 106;
    
    // 增加一个员工
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }
    
    // 删除一个员工
    public void delete(Integer id) {
        employees.remove(id);
    }
    
    // 修改一个员工
    public void update(Integer id, Employee emp) {
        emp.setDepartment(departmentDao.getDepartmentById(emp.getDepartment().getId()));
        employees.put(id, emp);
    }
}
