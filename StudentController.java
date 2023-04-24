package com.org.student;

import java.util.Scanner;

public class StudentController {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("1) SAVE STUDENT DETAILS ");
		System.out.println("2) DISPLAY STUDENT DETAILS ");
		System.out.println("3) UPDATE STUDENT DETAILS ");
		System.out.println("4) DELETE STUDENT DETAILS ");
		System.out.println("ENTER YOUR CHOICE : ");
		int ch = sc.nextInt();

		switch (ch) {
		case 1: {

			System.out.println(" Enter Student Roll no : ");
			int roll = sc.nextInt();
			sc.nextLine();
			System.out.println(" Enter Name Of The Student : ");
			String name = sc.nextLine();
			System.out.println(" Enter Age Of The Student : ");
			int age = sc.nextInt();
			System.out.println(" Enter Email Of The Student : ");
			String email = sc.next(); // in next() no need to provide sc.nextLine(), i.e, dummy space
			System.out.println(" Enter Gender Of The Student : ");
			String gender = sc.next();

			boolean res = StudentCRUD.saveStudent(roll, name, age, email, gender);
			if (res) {
				System.out.println(" Student Data Entered Successfully ! ");
			} else {
				System.out.println(" Something Went Wrong !  ");
				System.out.println(" Contact - @Jyoti Prakash :) ");
			}

		}
			break;

		case 2: {
			StudentCRUD.displayStudentDetails();
		}
			break;

		case 3: {
			System.out.println("Enter the student roll :");
			int roll = sc.nextInt();
			System.out.println("a) To update the name ");
			System.out.println("b) To update age ");
			System.out.println("c) To update email ");
			System.out.println("d) To update name, age, email, gender ");
			char choice = sc.next().charAt(0);

			switch (choice) {
			case 'a': {
				sc.nextLine();
				System.out.println("Enter student name you want to update :");
				String name = sc.nextLine();

				int res = StudentCRUD.updateName(roll, name);
				if (res != 0) {
					System.out.println("student name successfully updated.");
				} else {
					System.err.println("roll no doesn't exist ! ");
				}

			}
				break;

			case 'b': {
				sc.nextLine();
				System.out.println("Enter student age you want to update :");
				int age = sc.nextInt();

				int res = StudentCRUD.updateAge(roll, age);
				if (res != 0) {
					System.out.println("student age successfully updated.");
				} else {
					System.err.println("roll no doesn't exist ! ");
				}

			}
				break;

			case 'c': {
				sc.nextLine();
				System.out.println("Enter student email you want to update :");
				String email = sc.nextLine();

				int res = StudentCRUD.updateName(roll, email);
				if (res != 0) {
					System.out.println("student name successfully updated.");
				} else {
					System.err.println("roll no doesn't exist ! ");
				}

			}
				break;

			case 'd': {
				sc.nextLine();
				System.out.println("Enter student name you want to update :");
				String name = sc.nextLine();
				System.out.println("Enter student age you want to update :");
				int age = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter student email you want to update :");
				String email = sc.nextLine();
				System.out.println("Enter student gender you want to update :");
				String gender = sc.nextLine();

				int res = StudentCRUD.updateStudent(roll, name, age, email, gender);
				if (res != 0) {
					System.out.println("student data successfully updated.");
				} else {
					System.err.println("roll no doesn't exist ! ");			// it will give error in red color
				}

			}
				break;

			default:
				System.err.println("Invalid Choice !");
				break;
			}

		}
			break;

		case 4: { // to delete

			System.out.println("Enter Student Rollno : ");
			int roll = sc.nextInt();
			int res = StudentCRUD.deleteStudentData(roll);
			if (res == 0) {
				System.err.println("Their is no data in specified rollno !");
			} else {
				System.out.println("Data Deleted Successfully :)");
			}

		}
			break;

		default:
			System.err.println("Unexpected Value : " + ch);
		}
		sc.close();
	}
}
