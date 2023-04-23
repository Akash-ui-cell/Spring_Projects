package com.ak.crudoperations.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ak.crudoperations.entity.Student;
import com.ak.crudoperations.exception.StudentException;

//public interface StudentRepository extends CrudRepository<Student,Integer> {
//
//	public Optional<Student> findByStudentName(String name)throws StudentException;
//}
public interface StudentRepository extends CrudRepository<Student, Integer>{
	public Optional<Student> findByStudentName(String name)throws StudentException;
}