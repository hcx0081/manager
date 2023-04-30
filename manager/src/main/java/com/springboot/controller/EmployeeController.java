package com.springboot.controller;

import com.springboot.dao.DepartmentDao;
import com.springboot.dao.EmployeeDao;
import com.springboot.pojo.Department;
import com.springboot.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * {@code @Description:}
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    
    @Autowired
    private DepartmentDao departmentDao;
    
    @RequestMapping("/toList")
    public String toList(Model model) {
        Collection<Employee> employeeList = employeeDao.getEmployees();
        model.addAttribute("employeeList", employeeList);
        return "emp/list";
    }
    
    @RequestMapping("/toAdd")
    public String toAdd(Model model) {
        // 查询所有部门信息
        Collection<Department> departmentList = departmentDao.getDepartments();
        model.addAttribute("departmentList", departmentList);
        return "emp/add";
    }
    
    @RequestMapping("/add")
    public String add(Employee employee) {
        employeeDao.save(employee);
        return "redirect:toList";
    }
    
    @RequestMapping("/toEdit")
    public String toEdit(Integer id, Model model) {
        Employee employee = employeeDao.getEmployeesById(id);
        model.addAttribute("employee", employee);
        // 查询所有部门信息
        Collection<Department> departmentList = departmentDao.getDepartments();
        model.addAttribute("departmentList", departmentList);
        return "emp/edit";
    }
    
    @RequestMapping("/edit")
    public String edit(Employee employee) {
        employeeDao.update(employee.getId(), employee);
        return "redirect:toList";
    }
    
    @RequestMapping("/del")
    public String del(Integer id) {
        employeeDao.delete(id);
        return "redirect:toList";
    }
}