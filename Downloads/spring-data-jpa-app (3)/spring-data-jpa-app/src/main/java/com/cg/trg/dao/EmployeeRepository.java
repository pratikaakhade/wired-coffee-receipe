package com.cg.trg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.trg.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	public List<Employee> findByEname(String ename);
	public List<Employee> findByDeptnoAndJob(Integer deptno,String job);	
	
//	@Query("select e from Employee e where e.job= :pjob AND e.sal > :psal")
//	public List<Employee> 
//			findByJobAndGreaterThanSalary(@Param("pjob") String job,
//											@Param("psal") Double sal);
	
	
	
	@Query("SELECT e FROM Employee e WHERE e.job = ?1 AND e.sal > ?2")
    List<Employee> findByJobAndSalaryGreaterThan(String job, Double sal);
	
	//is same as
	// List<Employee> findByJobAndSalGreaterThan(String job, Double sal);
}
