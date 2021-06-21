package com.cg.trg.service;

import java.util.List;

import com.cg.trg.entity.Employee;
import com.cg.trg.exception.EmployeeException;

public interface EmployeeService {
	public abstract Employee getEmployeeById(Integer empno) throws EmployeeException;
	public abstract List<Employee> getAllEmployees() throws EmployeeException;
	public abstract Employee addEmployee(Employee employee) throws EmployeeException;
	public abstract Employee updateEmployee(Employee employee) throws EmployeeException;
	public abstract String deleteEmployee(Integer empno) throws EmployeeException;
	public abstract List<Employee> findByJobAndSalaryGreaterThan(String job, Double sal) throws EmployeeException;
	public List<Employee> findByEname(String ename) throws EmployeeException;
	public abstract List<Employee> findByDeptnoAndJob(Integer deptno,String job) throws EmployeeException;
}
