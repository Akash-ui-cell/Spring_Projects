package com.ak.crudoperations.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ak.crudoperations.dto.StudentDTO;
import com.ak.crudoperations.exception.StudentException;
import com.ak.crudoperations.service.StudentServiceImpl;

@RestController
@RequestMapping("students/")
@CrossOrigin
public class StudentApi {
	
	@Autowired
	private StudentServiceImpl studentService;
	
	@GetMapping("get/")
	public  ResponseEntity<List<StudentDTO>> getAllStudent() throws StudentException
	{
		List<StudentDTO> studentList=studentService.getAllStudent();
		return new ResponseEntity<>(studentList,HttpStatus.OK);
	}
	
	@PostMapping("add/")
	public ResponseEntity<String> addStudent(@RequestBody StudentDTO studentDTO) throws StudentException
	{
		studentService.addStudent(studentDTO);
		String msg="New Student Added";
		
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@DeleteMapping("del/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id) throws StudentException
	{
		studentService.deleteStudtent(id);
		String msg="Student deleted with id: "+id;
		
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	
//	@PutMapping("update/")
//	public ResponseEntity<String> updateStream(@RequestBody StudentDTO studentDTO) throws StudentException
//	{
//		studentService.updateStream(studentDTO);
//		String msg="Stream Updated with id: "+studentDTO.getStudentId();
//		
//		return new ResponseEntity<>(msg,HttpStatus.ACCEPTED);
//	}
	
	@PutMapping("update")
	public ResponseEntity<String> updateStream(@RequestBody StudentDTO studentDTO, @RequestParam String city)throws StudentException
	{
		studentService.updateStream(studentDTO);
		String msg="Stream Updated With Id:"+studentDTO.getStudentId()+city;
		
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("delall/")
	public ResponseEntity<String> deleteAllStudents() throws StudentException
	{
		studentService.deleteAllStudent();
		String msg="All students are deleted ";
		
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	
	@GetMapping("getbyname/{name}")
	public ResponseEntity<StudentDTO> getStudentByName(@PathVariable String name) throws StudentException
	{
		StudentDTO studentDTO=studentService.findStudentByName(name);
		
		return new ResponseEntity<StudentDTO>(studentDTO,HttpStatus.ACCEPTED);
	}
}
