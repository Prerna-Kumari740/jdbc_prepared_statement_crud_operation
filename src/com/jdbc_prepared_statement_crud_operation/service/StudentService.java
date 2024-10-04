package com.jdbc_prepared_statement_crud_operation.service;

import com.jdbc_prepared_statement_crud_operation.dao.StudentDao;
import com.jdbc_prepared_statement_crud_operation.dto.StudentDto;

public class StudentService {
	
	StudentDao dao = new StudentDao();
	 public StudentDto saveStudentService(StudentDto student) {
		 if(student.getName().length()<=8) {
			 return dao.saveStudentDao(student);
		 }else {
			 return null;
		 }
	 }

}
