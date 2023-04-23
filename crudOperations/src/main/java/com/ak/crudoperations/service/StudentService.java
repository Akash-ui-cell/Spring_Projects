package com.ak.crudoperations.service;

import java.util.List;

import com.ak.crudoperations.dto.StudentDTO;
import com.ak.crudoperations.exception.StudentException;

public interface StudentService {
	//Create
	public void addStudent(StudentDTO studentDTO) throws StudentException;
	
	//Read
	public List<StudentDTO> getAllStudent() throws StudentException;
	public StudentDTO findStudentByName(String name)throws StudentException;
	
	//delete
	public void deleteStudtent(Integer id)throws StudentException;
	public void deleteAllStudent()throws StudentException;
	
	//update
	//public void updateStream(StudentDTO studentDTO)throws StudentException;
	public void updateStream(StudentDTO studentDTO)throws StudentException;
	

}
