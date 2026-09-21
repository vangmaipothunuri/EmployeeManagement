package demo;
import java.util.Scanner;
public class EmployeeTest {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Employee employee=new Employee();
		Attendance attendance=new Attendance();
		Salary salary=new Salary();
		int choice;
		do {
			System.out.println("\n==========================================");
			System.out.println("  EMPLOYEE ATTENDANCE & PAYROLL SYSTEM");
			System.out.println("===========================================");
			System.out.println("1. Enter Employee Details");
			System.out.println("2.Calculate Attendance");
			System.out.println("3.Calculate Salary");
			System.out.println("4.Display Employee details");
			System.out.println("5.exit");
			System.out.println("enter choice:");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("\n---enter employee details---");
				System.out.println("enter Employee id");
				employee.employeeId=sc.nextInt();
				sc.nextLine();
				System.out.println("enter Employee name");
				employee.employeeName=sc.nextLine();
				System.out.println("\nSelect Department:");
				System.out.println("1.IT");
				System.out.println("2.HR");
				System.out.println("3.FINANCE");
				System.out.println("4.MARKETING");
				System.out.println("enter department choice :");
				employee.departmentChoice=sc.nextInt();
				switch(employee.departmentChoice) {
				case 1:
					employee.department="IT";
					break;
				case 2:
					employee.department="HR";
					break;
				case 3:
					employee.department="FINANCE";
					break;
				case 4:
					employee.department="MARKETING";
					break;
				default:
					employee.department="unkonown";
					System.out.println("invalid department choice");
				}
					System.out.println("Enter basic salry:");
					employee.basicSalary=sc.nextDouble();
					if(employee.basicSalary>0) {
						System.out.println("Employee deatils entered successfully");	
					}else {
						System.out.println("Invalid salary .salary must be greater than zero");
						
					}
					break;
			case 2:
				System.out.println("\n*** ATTENDANCE CALCULATION  ****");
				System.out.println("Enter total working days:");
				attendance.totalWorkingDays =sc.nextInt();
				if(attendance.totalWorkingDays > 0) {
					attendance.presentDays=0;
					attendance.absentDays=0;
					for (int day =1;day<=attendance.totalWorkingDays;day++) {
						System.out.println("Day "+day +" - enter 1 for present ,0 for absent:");
						attendance.attendance=sc.nextInt();
						if(attendance.attendance==1) {
							attendance.presentDays++;
						}else if(attendance.attendance==0) {
							attendance.absentDays++;
						}
						else {
							System.out.println("Invalid input");
						}
					}
					attendance.attendancePercentage=((double) attendance.presentDays/attendance.totalWorkingDays)*100;
					System.out.println("\nPresent days :" +attendance.presentDays);
					System.out.println("Absent days :" + attendance.absentDays);
					System.out.println("attendance % :"+attendance.attendancePercentage + "%");
					if(attendance.attendancePercentage >=75) {
						System.out.println("Attendance Status: Elligible");
					
					}
					else {
						System.out.println("Attendance status : not elligible");
					}
				}else {
					System.out.println("wrking days must be greater than zero");
				}
				break;
			case 3:
				System.out.println("\n *** SALARY CALCULATION ***");
				if(employee.basicSalary >0) {
					if(attendance.totalWorkingDays>0) {
						if(attendance.attendancePercentage>=90) {
							salary.incentive=employee.basicSalary *0.10;
							salary.finalSalary=employee.basicSalary +salary.incentive;
							System.out.println("Attendance category : Excellent");
							System.out.println("Attendance incentive:10%");
							
						}else if(attendance.attendancePercentage>=75) {
							salary.incentive=0;
							salary.deduction=0;
							salary.finalSalary=employee.basicSalary;
							System.out.println("attendance category:good");
							System.out.println("attendance inceentive:0%");
						}else {
							salary.deduction=employee.basicSalary*0.10;
							salary.finalSalary=employee.basicSalary-salary.deduction;
							System.out.println("attendance category : low");
							System.out.println("attendance deduction:10%");
							
						}
						System.out.println(" basic salary : $" +employee.basicSalary);
						System.out.println("final salry : $"+ salary.finalSalary);
					}}
					else {
						System.out.println("please enter valid employee details first");
					}
					break;
			case 4:
				System.out.println("\n **** employee deatils ***");
				if(employee.employeeId !=0) {
					System.out.println("employee id:" +employee.employeeId);
					System.out.println("employee name:" +employee.employeeName);
					System.out.println("department :" +employee.department);
					System.out.println("basic Salary :" +employee.basicSalary);
					System.out.println("present days :" +attendance.presentDays);
					System.out.println("absent days :" +attendance.absentDays);
					System.out.println("Attenddance %:" + attendance.attendancePercentage);
					System.out.println("final salary :" +salary.finalSalary);
				}
				else {
					System.out.println("no employee details avaialable");
				}
				break;
				
			case 5:
				System.out.println("\n thanku for using system");
				break;
					default:
						System.out.println("Invalid menu choice please enter choice");
			}
				}
			while(choice!=5);
			sc.close();
			
		
	}
}