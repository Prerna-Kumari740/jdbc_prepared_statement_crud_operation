package com.jdbc_prepared_statement_crud_operation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.jdbc_prepared_statement_crud_operation.connection.StudentConnection;
import com.jdbc_prepared_statement_crud_operation.dto.StudentDto;

public class StudentDao {
	
	Connection connection = StudentConnection.getStudentConnection();
	
	PreparedStatement ps;
	
	private final String INSERTSTUDENTQUERY = "insert into student (name,dob,phone,gender,email) values(?,?,?,?,?,?)";
	private final String DISPLAYSTUDENTQUERY = "SELECT * FROM student ";
	private final String Update_Student_Name_By_Student_Id = "update student set name = ? where id=?";
	private final String Update_Student_Email_By_Student_Id= "update student set email = ? where id=?";
	private final String Update_Student_phone_By_Student_Id = "update student set phone = ? where id=?";
	private final String Update_Student_dob_By_Student_Id = "update student set dob = ? where id=?";
	private final String Update_Student_gender_By_Student_Id = "update student set gender = ? where id=?";
	private final String delete_Student_By_Id = "delete from student where id=?";
	
	public StudentDto saveStudentDao(StudentDto studentDto) {
		try {
			ps = connection.prepareStatement(INSERTSTUDENTQUERY);
			ps.setString(1, studentDto.getName() );
			ps.setObject(2, studentDto.getDob() );
			ps.setLong(3, studentDto.getPhone());
			ps.setString(4, studentDto.getGender() );
			ps.setString(5, studentDto.getEmail() );
			ps.execute();
			return studentDto;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public StudentDto[] displayAllStudentDao() {
		try {
			ps = connection.prepareStatement(DISPLAYSTUDENTQUERY);
			ResultSet resultSet = ps.executeQuery();
			StudentDto[] st = new StudentDto[10];
			int i = 0;

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nm = resultSet.getString("name");
				LocalDate dob = resultSet.getDate("dob").toLocalDate();
				long phn = resultSet.getLong("phone");
				String gen = resultSet.getString("gender");
				String eml = resultSet.getString("email");

				StudentDto student = new StudentDto(id, nm,  dob,phn ,gen,eml);
				st[i] = student;

				i++;
			}
			return st;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
//	UPDATE

	public int updateStudentNameByStudentIdDao(String name, int id) {

		try {
			ps = connection.prepareStatement(Update_Student_Name_By_Student_Id);
			ps.setString(1, name);
			ps.setInt(2, id);

			return ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			return 0;
		}
	}

	public int updateStudentEmailByStudentIdDao(String email, int id) {

		try {
			ps = connection.prepareStatement(Update_Student_Email_By_Student_Id);
			ps.setString(1, email);
			ps.setInt(2, id);

			return ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			return 0;
		}
	}

	public int updateStudentPhoneByStudentIdDao(long phone, int id) {

		try {
			ps = connection.prepareStatement(Update_Student_phone_By_Student_Id);
			ps.setLong(1, phone);
			ps.setInt(2, id);

			return ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			return 0;
		}
	}

	public int updateStudentdobByStudentIdDao(String dob, int id) {

		try {
			ps = connection.prepareStatement(Update_Student_dob_By_Student_Id);
			ps.setString(1, dob);
			ps.setInt(2, id);

			return ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			return 0;
		}
	}
	
//	DELETE

	public int deleteStudentByIdDao(int id) {

		try {
			ps = connection.prepareStatement(delete_Student_By_Id);
			ps.setInt(1, id);

			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
//	saveMultipeStudenstDao(List<Student> students)
	
	public List<StudentDto> saveMultipleStudentDao(List<StudentDto> students){
		try {
			ps=connection.prepareStatement(INSERTSTUDENTQUERY);
			for(StudentDto student : students) {
				
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setLong(3, student.getPhone());
			ps.setObject(4, student.getDob());
			ps.setString(5, student.getGender());
			ps.addBatch();
			}
			ps.executeBatch();
			return students;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	

}
