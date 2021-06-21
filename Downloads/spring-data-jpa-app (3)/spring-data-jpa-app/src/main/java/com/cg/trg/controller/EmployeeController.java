package com.cg.trg.controller;

import java.util.List;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.trg.entity.Employee;
import com.cg.trg.exception.EmployeeException;
import com.cg.trg.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/empc")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	//http://localhost:8081/empc/emp/1
	@GetMapping("/emp/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Integer empno) {
		try {
			Employee employee=service.getEmployeeById(empno);
			return new ResponseEntity<>(employee,HttpStatus.OK);
		}catch(EmployeeException e) {
//			log.error(e.getMessage(),e);
		}
		return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);			

	}

	//http://localhost:8081/empc/emp
	@GetMapping("/emp")
	public ResponseEntity<List<Employee>> getEmployeeList() {
		try {
			List<Employee> employeeList=service.getAllEmployees();
			return new ResponseEntity<>(employeeList,HttpStatus.OK);
		}catch(EmployeeException e) {
//			log.error(e.getMessage(),e);
		}
		return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);	

	}

	@PostMapping("/emp")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
		try {
			
			Employee e= service.addEmployee(employee);
			return new ResponseEntity<>(e,HttpStatus.OK);
		}catch(EmployeeException e) {
//			log.error(e.getMessage(),e);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
	}

	@DeleteMapping("/emp/{id}")
	public  ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") Integer empno) {
		try {
			String status= service.deleteEmployee(empno);
//			return new ResponseEntity<>(status,HttpStatus.OK);
			return ResponseEntity.ok(status);
		}catch(EmployeeException e) {
//			log.error(e.getMessage(),e);
		}
		return new ResponseEntity<>("Unable to delete employee",HttpStatus.EXPECTATION_FAILED);
	}
	
	
	@PutMapping("/emp")
	public  ResponseEntity<Object> updateEmployee(@Valid @RequestBody Employee employee) {
		try {
			Employee e= service.updateEmployee(employee);
			return new ResponseEntity<>(e,HttpStatus.OK);
		}catch(EmployeeException e) {
//			log.error(e.getMessage(),e);
		}
		return new ResponseEntity<>(new Error("Unable to update employee"),HttpStatus.EXPECTATION_FAILED);
	}
	
	
	@GetMapping("/emp/{job}/{sal}")
	public ResponseEntity<List<Employee>> findByJobAndSalaryGreaterThan(@PathVariable(value = "job") String job, @PathVariable(value = "sal") Double sal){
		try {
			List<Employee> employeeList= service.findByJobAndSalaryGreaterThan(job, sal);
			return new ResponseEntity<>(employeeList,HttpStatus.OK);
		}catch(EmployeeException e) {
//			log.error(e.getMessage(),e);
		}
		return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
	}
	
}
