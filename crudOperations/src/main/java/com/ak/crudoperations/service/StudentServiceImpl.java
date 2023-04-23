package com.ak.crudoperations.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ak.crudoperations.dto.StudentDTO;
import com.ak.crudoperations.entity.Student;
import com.ak.crudoperations.exception.StudentException;
import com.ak.crudoperations.repository.StudentRepository;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	//get the details of all the students 
	@Override
	public List<StudentDTO> getAllStudent() throws StudentException {
		// TODO Auto-generated method stub
		Iterable<Student> itr=studentRepo.findAll();
		List<StudentDTO> stdlList=new ArrayList<>();
	
		
		itr.forEach((std->{
			StudentDTO studentDTO=new StudentDTO();
			studentDTO.setStudentId(std.getStudentId());
			studentDTO.setAddress(std.getAddress());
			studentDTO.setMobile(std.getMobile());
			studentDTO.setStream(std.getStream());
			studentDTO.setStudentName(std.getStudentName());
			
			stdlList.add(studentDTO);
			
		}));
		//itr.forEach((std->{}));
		
		if(stdlList.isEmpty())
		{
			throw new StudentException("No Students are inside Database");
		}
		
		return stdlList;
	}

	//add the student by passing student data 
	@Override
	public void addStudent(StudentDTO studentDTO) throws StudentException {
		// TODO Auto-generated method stub
		Student student=new Student();
		student.setAddress(studentDTO.getAddress());
		student.setMobile(studentDTO.getMobile());
		student.setStream(studentDTO.getStream());
		student.setStudentName(studentDTO.getStudentName());
		student.setStudentId(studentDTO.getStudentId());
		
		studentRepo.save(student);
		
	}

	//delete the student by student id 
	@Override
	public void deleteStudtent(Integer id) throws StudentException {
		// TODO Auto-generated method stub
		Optional<Student> op=studentRepo.findById(id);
		Student student=op.orElseThrow(()->new StudentException("Student Not Found Dear"));
		
		studentRepo.deleteById(id);
		
	}

	//update the student stream by passing the studentDTO
	
//	@Override
//	public void updateStream(StudentDTO studentDTO) throws StudentException {
//		// TODO Auto-generated method stub
//		Optional<Student> op=studentRepo.findById(studentDTO.getStudentId());
//		Student student=op.orElseThrow(()->new StudentException("Student Not Found Dear"));
//		
//		student.setStream(studentDTO.getStream());
//		studentRepo.save(student);
//	}
	
	@Override
	public void updateStream(StudentDTO studentDTO) throws StudentException {
		// TODO Auto-generated method stub
		Optional<Student> op=studentRepo.findById(studentDTO.getStudentId());
		Student student=op.orElseThrow(()->new StudentException("Studnet Not Fount Dear..."));
		
		student.setStream(studentDTO.getStream());
		studentRepo.save(student);
		
	}


	//delete all the student if not student inside the database
	
	@Override
	public void deleteAllStudent() throws StudentException {
		// TODO Auto-generated method stub
		
		Iterable<Student> itr=studentRepo.findAll();
		List<StudentDTO> studentDTOli=new ArrayList<StudentDTO>();
		
		itr.forEach((std)->{
			StudentDTO studentdto=new StudentDTO();
			studentdto.setStudentId(std.getStudentId());
			studentdto.setStudentName(std.getStudentName());
			studentdto.setMobile(std.getMobile());
			studentdto.setStream(std.getStream());
			studentdto.setAddress(std.getAddress());
			studentDTOli.add(studentdto);
		});
	
		if(studentDTOli.isEmpty())
		{
			throw new StudentException("No Record Found");
		}
		studentRepo.deleteAll();
		
		
	}

	//find student by its name and return the details of that student through 
	//studentDTO 
	
	@Override
	public StudentDTO findStudentByName(String name) throws StudentException {
		// TODO Auto-generated method stub
		Optional<Student> op=studentRepo.findByStudentName(name);
		Student student=op.orElseThrow(()->new StudentException("No student Found by given name"));
		
		StudentDTO studentDTO=new StudentDTO();
		studentDTO.setStudentId(student.getStudentId());
		studentDTO.setStudentName(student.getStudentName());
		studentDTO.setAddress(student.getAddress());
		studentDTO.setMobile(student.getMobile());
		studentDTO.setStream(student.getStream());
		
		return studentDTO;
		
	}

	
}
