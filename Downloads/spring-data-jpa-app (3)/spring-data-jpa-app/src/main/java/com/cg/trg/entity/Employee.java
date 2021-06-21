package com.cg.trg.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Entity class, @Entity and @Id are mandatory annotations

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
//If the @Table annotation is ignored, then class name will be the table name
@Table(name = "employee_cg")
//static queries
@NamedQueries(	{	
		@NamedQuery(name = "all-emp",query = "select e from Employee e"),
		@NamedQuery(name= "all-emp-10", query = "select e from Employee e where e.deptno=10"),
		@NamedQuery(name = "all-developers", query = "select e from Employee e where LOWER(e.job)= LOWER('Developer')" )
})
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empno;	
	@NotBlank(message = "Name is mandatory")
	@Size(min = 3,max = 20, message = "Name should be atleast 3 characters and not more than 20 characters")
	private String ename;
	@Temporal(TemporalType.DATE)
	private Date hiredate;
	private String job;
	private Double sal;
	private Integer deptno;
	
	
}
