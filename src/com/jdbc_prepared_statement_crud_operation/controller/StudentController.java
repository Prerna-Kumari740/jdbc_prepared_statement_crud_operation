package com.jdbc_prepared_statement_crud_operation.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jdbc_prepared_statement_crud_operation.dao.StudentDao;
import com.jdbc_prepared_statement_crud_operation.dto.StudentDto;
import com.jdbc_prepared_statement_crud_operation.service.StudentService;

public class StudentController {
	public static void main(String[] args) {

		StudentDao dao = new StudentDao();

		StudentService service = new StudentService();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your Option");
		System.out.println("1.Insert\n2.Display\n3.Update\n4.Delete\n5.InsertManyData");
		int input = sc.nextInt();

		switch (input) {
		case 1: {
			System.out.println("Enter name:");
			String name = sc.nextLine();
			sc.next();
			System.out.println("Enter email");
			String email = sc.next();
			System.out.println("Enter dob");
			String dob = sc.next();
			System.out.println("Enter gender");
			String gender = sc.next();
			System.out.println("Enter phone");
			long phone = sc.nextLong();

			StudentDto st = new StudentDto(name,  LocalDate.parse(dob),phone, gender,email);
//			Student student2 = dao.saveStudentDao(st);
			StudentDto student2 = service.saveStudentService(st);

			if (student2 != null) {
				System.out.println("data stored....");
			} else {
				System.out.println("data not stored please check your code...");
				System.out.println("Please enter name less than 8 character ");
			}

		}
			break;
		case 2: {

			StudentDto[] student = dao.displayAllStudentDao();

			for (StudentDto student2 : student) {
				if (student2 != null) {
					System.out.println(student2);
					System.out.println(student2.getName().equals("a"));

				}
			}
		}
			break;
		case 3: {

			int a;
			do {
				System.out.println("What you want to update ? ");
				System.out.println("1.Name\n2.Email\n3.Phone\n4.DOB\n0 for exit");
				a = sc.nextInt();
				if (a == 1) {
					System.out.print("Enter student id to update student name : ");
					int id = sc.nextInt();
					System.out.print("Enter student new name to update : ");
					String name = sc.next();

					int value = dao.updateStudentNameByStudentIdDao(name, id);

					if (value == 1) {
						System.out.println("Data updated");
					} else {
						System.out.println("id is invalid");
					}
				} else if (a == 2) {
					System.out.print("Enter student id to update student Email : ");
					int id = sc.nextInt();
					System.out.print("Enter student new Email to update : ");
					String email = sc.next();

					int value = dao.updateStudentEmailByStudentIdDao(email, id);

					if (value == 1) {
						System.out.println("Data updated");
					} else {
						System.out.println("id is invalid");
					}
				} else if (a == 3) {
					System.out.print("Enter student id to update student Phone : ");
					int id = sc.nextInt();
					System.out.print("Enter student new Phone no to update : ");
					long phone = sc.nextLong();

					int value = dao.updateStudentPhoneByStudentIdDao(phone, id);

					if (value == 1) {
						System.out.println("Data updated");
					} else {
						System.out.println("id is invalid");
					}
				} else if (a == 4) {
					System.out.print("Enter student id to update student dob : ");
					int id = sc.nextInt();
					System.out.print("Enter student new DOB to update : ");
					String dob = sc.next();

					int value = dao.updateStudentdobByStudentIdDao(dob, id);

					if (value == 1) {
						System.out.println("Data updated");
					} else {
						System.out.println("id is invalid");
					}
				}

			} while (a != 0);

		}
			break;
		case 4: {
			System.out.println("Enter id : ");
			int id = sc.nextInt();

			int value = dao.deleteStudentByIdDao(id);
			if (value == 1) {
				System.out.println("Data deleted");
			} else {
				System.out.println("id is invalid");
			}
		}
			break;
		case 5: {

			System.out.println("Enter students you want to add");
			int size = sc.nextInt();
			System.out.println("Enter students details");

			List<StudentDto> students = new ArrayList<StudentDto>();

			int j = 1;
			for (int i = 0; i < size; i++) {
				System.out.println("Enter student " + j + " name");
				String name = sc.next();
				System.out.println("Enter student " + j + " dob");
				String dob = sc.next();
				System.out.println("Enter student " + j + " phone");
				long phone = sc.nextLong();
				System.out.println("Enter student " + j + " gender");
				String gender = sc.next();
				System.out.println("Enter student " + j + " email");
				String email = sc.next();

				StudentDto student = new StudentDto(name,  LocalDate.parse(dob),phone, gender,email);
				students.add(student);
				j++;

			}
			dao.saveMultipleStudentDao(students);

		}
			break;

		}

		sc.close();
	}
}