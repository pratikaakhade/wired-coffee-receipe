package com.cg.trg.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.trg.dao.EmployeeRepository;
import com.cg.trg.entity.Employee;
import com.cg.trg.exception.EmployeeException;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee getEmployeeById(Integer empno) throws EmployeeException {
		try {
			Optional<Employee> optional= repository.findById(empno);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new EmployeeException("Invalid Empno");
			}			
		}catch(DataAccessException e) {
			throw new EmployeeException(e.getMessage(),e);
		}
		
	}

	@Override
	public List<Employee> getAllEmployees() throws EmployeeException {
		try {
			List<Employee> employeeList=repository.findAll();
			return employeeList;
		}catch(DataAccessException e) {
			throw new EmployeeException(e.getMessage(),e);
		}
	}

	//addEmployee() of Service layer is invoking addEmployee()of DAO layer
//	@Transactional
	@Override
	public Employee addEmployee(Employee employee) throws EmployeeException {
		try {
			employee.setEmpno(null);
			Employee savedEmployee= repository.save(employee);
			return savedEmployee;
		}catch(DataAccessException e) {
			throw new EmployeeException(e.getMessage(),e);
		}
	}

//	@Transactional
	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeException {
		try {
			Employee savedEmployee= repository.save(employee);
			return savedEmployee;
		}catch(DataAccessException e) {
			throw new EmployeeException(e.getMessage(),e);
		}	
	}

//	@Transactional
	@Override
	public String deleteEmployee(Integer empno) throws EmployeeException {
		try {
			repository.deleteById(empno);
			return empno+ " deleted";
		}catch(DataAccessException e) {
			throw new EmployeeException(e.getMessage(),e);
		}	
	}

	@Override
	public List<Employee> findByJobAndSalaryGreaterThan(String job, Double sal) throws EmployeeException {
		try {
			List<Employee> employeeList=repository.findByJobAndSalaryGreaterThan(job, sal);
			return employeeList;
		}catch(DataAccessException e) {
			throw new EmployeeException(e.getMessage(),e);
		}
	}

	@Override
	public List<Employee> findByEname(String ename) throws EmployeeException {
		try {
			List<Employee> employeeList=repository.findByEname(ename);
			return employeeList;
		}catch(DataAccessException e) {
			throw new EmployeeException(e.getMessage(),e);
		}
	}

	@Override
	public List<Employee> findByDeptnoAndJob(Integer deptno, String job) throws EmployeeException {
		try {
			List<Employee> employeeList=repository.findByDeptnoAndJob(deptno, job);
			return employeeList;
		}catch(DataAccessException e) {
			throw new EmployeeException(e.getMessage(),e);
		}
	}

}
