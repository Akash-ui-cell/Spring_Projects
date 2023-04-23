package com.ak.crudoperations.dto;

public class StudentDTO {
	private Integer studentId;
	private String studentName;
	private Double mobile;
	private String stream;
	private String address;
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	 
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Double getMobile() {
		return mobile;
	}
	public void setMobile(Double mobile) {
		this.mobile = mobile;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
