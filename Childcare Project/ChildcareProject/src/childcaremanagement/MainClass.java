package childcaremanagement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import package1.*;
import package2.*;

public class MainClass {
	static final String url = "jdbc:mysql://localhost:3306/childcaresystem";
	static final String user = "root";
	static final String password = "root";
	static final Scanner kb = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
//########################### MENU ##############################
		int num;
		try {
			do {
				System.out.println("----- Main menu -----");
				System.out.println("1 - Input Data");
				System.out.println("2 - Manage Data");
				System.out.println("3 - Search Data");
				System.out.println("4 - Exit");
				System.out.print("Enter your choice: ");
				num = kb.nextInt();
				switch (num) {
				case 1:
					inputData();
					break;
				case 2:
					managingData();
					break;
				case 3:
					searchData();
					break;
				case 4:
					System.out.println("Thank you!");
					break;
				default:
					System.out.println("Please pick the right choice");
					break;
				}

			} while (!(num == 4));

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

//########################### Input Data Menu ##############################
	public static void inputData() {
		int num;
		do {
			System.out.println();
			System.out.println("----- Input data menu -----");
			System.out.println("1 - Parents");
			System.out.println("2 - Kids");
			System.out.println("3 - Teachers");
			System.out.println("4 - Exit");
			System.out.print("Enter your choice: ");
			num = kb.nextInt();
			switch (num) {
			case 1:
				inputParents();
				break;
			case 2:
				inputKids();
				break;
			case 3:
				inputTeachers();
				break;

			case 4:
				System.out.println("Back to main menu.");
				break;
			default:
				System.out.println("Please pick the right choice");
				break;
			}

		} while (!(num == 4));

	}

//########################### Input Parents ##############################
	public static void inputParents() {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		Parents p = new Parents();

		try {
			System.out.println("############## Parents ##############\n");
			System.out.println("Enter Parent Id: ");
			p.setParents_id(kb.nextInt());
			kb.nextLine();
			System.out.println("Enter your first name: ");
			p.setFirst_Name(kb.nextLine());
			System.out.println("Enter your last name: ");
			p.setLast_Name(kb.nextLine());
			System.out.println("Enter your Address: ");
			p.setAddress(kb.nextLine());
			System.out.println("Enter Parent phone number: ");
			p.setPhone_Number(kb.nextLine());
			System.out.println("How many kids? ");
			p.setNumberOfKids(kb.nextInt());

			myConn = DriverManager.getConnection(url, user, password);

			String sql = "insert into Parents "
					+ " (Parents_ID, First_Name, Last_Name, Address, Phone_Number, Number_of_Kids)"
					+ " values(?,?,?,?,?,?)";

			myStmt = myConn.prepareStatement(sql);

			myStmt.setInt(1, p.getParents_id());
			myStmt.setString(2, p.getFirst_Name());
			myStmt.setString(3, p.getLast_Name());
			myStmt.setString(4, p.getAddress());
			myStmt.setString(5, p.getPhone_Number());
			myStmt.setInt(6, p.getNumberOfKids());

			myStmt.executeUpdate();

			System.out.println("Insert complete.");
		} catch (Exception exc) {
			exc.printStackTrace();

		}

	}

//########################### Input Kids ##############################
	public static void inputKids() {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		Kids k = new Kids();
		try {
			myConn = DriverManager.getConnection(url, user, password);
			Statement myStmt1 = myConn.createStatement();
			ResultSet myRs = myStmt1.executeQuery("SELECT * FROM PARENTS");
			int numberofparents = 0;
			System.out.println("############## List of Parents ##############");
			while (myRs.next()) {
				numberofparents++;
				System.out.println(myRs.getInt("Parents_ID") + ", " + myRs.getString("First_Name") + " , "
						+ myRs.getString("Last_Name"));
			}
			if (numberofparents == 0) {
				System.out.println("You need to enter parent's information first");
			} else {
				String data1, data2, data3;
				System.out.println("############## Kids ##############\n");
				System.out.println("Enter your Id: ");
				k.setKids_id(kb.nextInt());
				kb.nextLine();
				System.out.println("Enter your first name: ");
				k.setFirst_name(kb.nextLine());
				System.out.println("Enter your last name: ");
				k.setLast_name(kb.nextLine());
				System.out.println("Enter your date of birth(yyyy-mm-dd): ");
				data1 = kb.nextLine();
				Date doB = Date.valueOf(data1);
				k.setDateOfBirth(doB);
				System.out.println("Enter your start date(yyyy-mm-dd): ");
				data2 = kb.nextLine();
				Date dst = Date.valueOf(data2);
				k.setStart_Date(dst);
				System.out.println("Enter end date(yyyy-mm-dd): ");
				data3 = kb.nextLine();
				Date endDt = Date.valueOf(data3);
				k.setEnd_Date(endDt);
				System.out.println("Enter your status: ");
				k.setStatus(kb.nextLine());
				System.out.println("Enter your parent's id");
				k.setParents_id(kb.nextInt());

				myConn = DriverManager.getConnection(url, user, password);

				String sql = "insert into kids "
						+ " (Kids_ID, First_Name, Last_Name, Date_Of_Birth, Start_Date, End_Date, kids_Status, Parents_ID)"
						+ " values(?,?,?,?,?,?,?,?)";

				myStmt = myConn.prepareStatement(sql);

				myStmt.setInt(1, k.getKids_id());
				myStmt.setString(2, k.getFirst_name());
				myStmt.setString(3, k.getLast_name());
				myStmt.setDate(4, k.getDateOfBirth());
				myStmt.setDate(5, k.getStart_Date());
				myStmt.setDate(6, k.getEnd_Date());
				myStmt.setString(7, k.getStatus());
				myStmt.setInt(8, k.getParents_id());

				myStmt.executeUpdate();

				System.out.println("Insert complete.");

			}

		} catch (Exception exc) {
			exc.getMessage();
		}

	}

//########################### Input Teachers ##############################
	public static void inputTeachers() {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		Teachers t = new Teachers();
		try {
			String sd;
			System.out.println("############## Teacher ##############\n");
			System.out.println("Enter your id: ");
			t.setTeacher_id(kb.nextInt());
			kb.nextLine();
			System.out.print("Enter your first name: ");
			t.setFirst_Name(kb.nextLine());
			System.out.print("Enter your Last Name: ");
			t.setLast_name(kb.nextLine());
			System.out.print("Enter your phone Number: ");
			t.setPhone_Number(kb.nextLine());
			System.out.print("Enter your address: ");
			t.setAddress(kb.nextLine());
			System.out.print("Enter a start date(yyyy-mm-dd): ");
			sd = kb.nextLine();
			Date StartedDate = Date.valueOf(sd);
			t.setDate_Started(StartedDate);

			myConn = DriverManager.getConnection(url, user, password);

			String sql = "insert into Teacher "
					+ " (Teacher_ID, First_Name, Last_Name, Phone_Number, Address, Start_date)"
					+ " values (?, ?, ?, ?, ?, ?)";

			myStmt = myConn.prepareStatement(sql);

			myStmt.setInt(1, t.getTeacher_id());
			myStmt.setString(2, t.getFirst_Name());
			myStmt.setString(3, t.getLast_name());
			myStmt.setString(4, t.getPhone_Number());
			myStmt.setString(5, t.getAddress());
			myStmt.setDate(6, t.getDate_Started());

			myStmt.executeUpdate();
			System.out.println("Insert complete.");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

//########################### Manage Data Menu ##############################
	public static void managingData() {
		int num;
		do {
			System.out.println();
			System.out.println("----- Manage data menu -----");
			System.out.println("1 - Payments");
			System.out.println("2 - Classroom");
			System.out.println("3 - Schedule");
			System.out.println("4 - Exit");
			System.out.print("Enter your choice: ");
			num = kb.nextInt();
			switch (num) {
			case 1:
				managePayments();
				break;
			case 2:
				managingClassroom();
				break;
			case 3:
				kidSchedule();
				break;

			case 4:
				System.out.println("Back to main menu.");
				break;
			default:
				System.out.println("Please pick the right choice");
				break;
			}

		} while (!(num == 4));
	}

//########################### Payments ##############################
	public static void managePayments() {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		Payments payments = new Payments();
		try {
			myConn = DriverManager.getConnection(url, user, password);
			Statement myStmt1 = myConn.createStatement();
			ResultSet myRs = myStmt1.executeQuery("SELECT * FROM PARENTS");
			int numberofparents = 0;
			while (myRs.next()) {
				numberofparents++;
				System.out.println(myRs.getInt("Parents_ID") + ", " + myRs.getString("First_Name") + " , "
						+ myRs.getString("Last_Name"));
			}
			if (numberofparents == 0) {
				System.out.println("You need to enter parents information first");
			} else {
				String pd;
				System.out.println("############## Payments ##############\n");
				System.out.println("Enter payment Id: ");
				payments.setPayments_id(kb.nextInt());
				System.out.println("Enter parent id related to this payment: ");
				payments.setParents_id(kb.nextInt());
				kb.nextLine();
				System.out.println("Enter payment date(yyyy-mm-dd): ");
				pd = kb.nextLine();
				Date paymentDate = Date.valueOf(pd);
				payments.setPayment_Date(paymentDate);
				System.out.println("Enter payment method: ");
				payments.setPayment_Method(kb.nextLine());

				myConn = DriverManager.getConnection(url, user, password);

				String sql = "insert into Payments" + " (Payments_ID, Parents_ID, Payment_Date, Payment_Method)"
						+ " values(?,?,?,?)";

				myStmt = myConn.prepareStatement(sql);

				myStmt.setInt(1, payments.getPayments_id());
				myStmt.setInt(2, payments.getParents_id());
				myStmt.setDate(3, payments.getPayment_Date());
				myStmt.setString(4, payments.getPayment_Method());

				myStmt.executeUpdate();

				System.out.println("Insert complete.");

			}

		} catch (Exception exc) {
			exc.getMessage();
		}
	}

//########################### Manage Classroom Menu ##############################
	public static void managingClassroom() {
		int num;
		do {
			System.out.println();
			System.out.println("----- Classroom  menu -----");
			System.out.println("1 - Enter Weeks");
			System.out.println("2 - Enter Activities");
			System.out.println("3 - Create Classroom");
			System.out.println("4 - Exit");
			System.out.print("Enter your choice: ");
			num = kb.nextInt();
			switch (num) {
			case 1:
				manageweek();
				break;
			case 2:
				manageActivity();
				break;
			case 3:
				creatClass();
				break;
			case 4:
				System.out.println("Back to manage data menu.");
				break;
			default:
				System.out.println("Please pick the right choice");
				break;
			}

		} while (!(num == 4));
	}

//########################### Weeks ##############################	
	public static void manageweek() {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		Weeks week = new Weeks();

		try {
			String sd, ed;
			System.out.println("############## Weeks ##############\n");
			System.out.println("Enter week Id: ");
			week.setWeek_id(kb.nextInt());
			kb.nextLine();
			System.out.println("Enter week's started date(yyyy-mm-dd): ");
			sd = kb.nextLine();
			Date startDate = Date.valueOf(sd);
			week.setStart_date(startDate);
			System.out.println("Enter week's ended date(yyyy-mm-dd): ");
			ed = kb.nextLine();
			Date endDate = Date.valueOf(ed);
			week.setEnd_date(endDate);
			System.out.println("Enter how many days you have worked this week: ");
			week.setDays_Worked(kb.nextInt());

			myConn = DriverManager.getConnection(url, user, password);

			String sql = "insert into Weeks " + " (Week_ID, Start_Date, End_Date, Days_Worked)" + " values(?,?,?,?)";

			myStmt = myConn.prepareStatement(sql);

			myStmt.setInt(1, week.getWeek_id());
			myStmt.setDate(2, week.getStart_date());
			myStmt.setDate(3, week.getEnd_date());
			myStmt.setInt(4, week.getDays_Worked());

			myStmt.executeUpdate();

			System.out.println("Insert complete.");
		} catch (Exception exc) {
			exc.printStackTrace();

		}
	}

//########################### Activities ##############################
	public static void manageActivity() {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		Activities activity = new Activities();

		try {
			String dc;
			System.out.println("############## Activities ##############\n");
			System.out.println("Enter activity Id: ");
			activity.setActivity_id(kb.nextInt());
			kb.nextLine();
			System.out.println("Enter actitvity's name: ");
			activity.setTitle(kb.nextLine());
			System.out.println("Enter the date this activity was created(yyyy-mm-dd): ");
			dc = kb.nextLine();
			Date dateCreated = Date.valueOf(dc);
			activity.setActivity_Date(dateCreated);

			myConn = DriverManager.getConnection(url, user, password);

			String sql = "insert into Activity " + " (Activity_ID, Tile, Activity_date)" + " values(?,?,?)";

			myStmt = myConn.prepareStatement(sql);

			myStmt.setInt(1, activity.getActivity_id());
			myStmt.setString(2, activity.getTitle());
			myStmt.setDate(3, activity.getActivity_Date());

			myStmt.executeUpdate();

			System.out.println("Insert complete.");
		} catch (Exception exc) {

			exc.printStackTrace();

		}
	}

// ########################### Input Class Room ##############################
	public static void creatClass() {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		Activities a = new Activities();
		Weeks w = new Weeks();
		Teachers t = new Teachers();
		ClassRoom cr = new ClassRoom();
		try {
			myConn = DriverManager.getConnection(url, user, password);
			Statement myStmt1 = myConn.createStatement();
			ResultSet myRs = myStmt1.executeQuery("SELECT * FROM weeks");
			int numberofweeks = 0;
			System.out.println("#############Weeks#############");

			while (myRs.next()) {
				numberofweeks++;
				System.out.println(myRs.getInt("Week_ID") + ", " + myRs.getDate("Start_Date") + " , "
						+ myRs.getDate("End_Date") + " , " + myRs.getInt("Days_Worked"));
			}

			myRs = myStmt1.executeQuery("SELECT * FROM teacher");
			int numberofteacher = 0;
			System.out.println("#############Teachers#############");

			while (myRs.next()) {
				numberofteacher++;
				System.out.println(myRs.getInt("Teacher_ID") + ", " + myRs.getString("First_name") + " , "
						+ myRs.getString("Last_Name"));
			}

			myRs = myStmt1.executeQuery("SELECT * FROM activity");
			int numberofactivities = 0;
			System.out.println("#############activity#############");

			while (myRs.next()) {
				numberofactivities++;
				System.out.println(myRs.getInt("Activity_ID") + ", " + myRs.getString("Tile") + " , "
						+ myRs.getDate("Activity_date"));
			}

			if ((numberofweeks == 0) || (numberofteacher == 0) || (numberofactivities == 0)) {
				System.out.println("You need to have Activities, Weeks and teachers information");

			}

			else {
				String data1;
				System.out.println("############## Create ClassRoom ##############\n");
				System.out.println("Enter your Class-Room ID: ");
				cr.setClassRoom_id(kb.nextInt());

				kb.nextLine();
				System.out.println("Enter classroom date (yyyy-mm-dd): ");
				data1 = kb.nextLine();
				Date dcr = Date.valueOf(data1);
				cr.setClassRoom_Date(dcr);
				System.out.println("Enter Teacher ID: ");
				cr.setTeachers_id(kb.nextInt());
				System.out.println("Enter Activity ID: ");
				cr.setactivity_id(kb.nextInt());
				System.out.println("Enter week ID: ");
				cr.setWeek_id(kb.nextInt());
				kb.nextLine();
				System.out.println("Enter kids report: ");
				cr.setKids_report(kb.nextLine());
				System.out.println("Enter number of kids: ");
				ClassRoom.setNumberofKids(kb.nextInt());

				myConn = DriverManager.getConnection(url, user, password);

				String sql = "insert into classroom"
						+ " (classRoom_ID, ClassRoom_Date, Teacher_ID, Activity_ID, Week_ID, ClassRoom_Report, NumberOfkids)"
						+ " values(?,?,?,?,?,?,?)";

				myStmt = myConn.prepareStatement(sql);

				myStmt.setInt(1, cr.getClassRoom_id());
				myStmt.setDate(2, cr.getClassRoom_Date());
				myStmt.setInt(3, cr.getTeachers_id());
				myStmt.setInt(4, cr.getactivity_id());
				myStmt.setInt(5, cr.getWeek_id());
				myStmt.setString(6, cr.getKids_report());
				myStmt.setInt(7, ClassRoom.getNumberofKids());

				myStmt.executeUpdate();

				System.out.println("Insert complete.");

			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

//########################### Schedule ##############################
	public static void kidSchedule() {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		Schedule schedule = new Schedule();

		try {
			myConn = DriverManager.getConnection(url, user, password);
			Statement myStmt1 = myConn.createStatement();
			ResultSet myRs = myStmt1.executeQuery("SELECT * FROM Kids");
			int numberofkids = 0;
			int numberofclassroom = 0;
			System.out.println("#############Kids#############");

			while (myRs.next()) {
				numberofkids++;
				System.out.println(myRs.getInt("Kids_ID") + ", " + myRs.getString("First_Name") + " , "
						+ myRs.getString("Last_Name"));
			}
			myRs = myStmt1.executeQuery("SELECT * FROM classroom");
			System.out.println("#############Class-Room#############");

			while (myRs.next()) {
				numberofclassroom++;
				System.out.println(myRs.getInt("ClassRoom_ID") + ", " + myRs.getDate("ClassRoom_Date") + " , "
						+ myRs.getInt("NumberOfKids"));
			}

			if (numberofkids == 0) {
				System.out.println("You have not yet set kids information");
			} else if (numberofclassroom == 0) {

				System.out.println("You have not yet set Classrooms information");

			}

			else {
				String sd;
				System.out.println("############## Schedule ##############\n");
				System.out.println("Enter schedule Id: ");
				schedule.setSchedule_id(kb.nextInt());
				System.out.println("Enter classroom id: ");
				schedule.setClassRoom_id(kb.nextInt());
				System.out.println("Enter kids id: ");
				schedule.setKids_id(kb.nextInt());
				kb.nextLine();
				System.out.println("Enter schedule date(yyyy-mm-dd): ");
				sd = kb.nextLine();
				Date scheduleDate = Date.valueOf(sd);
				schedule.setSchedule_Date(scheduleDate);
				System.out.println("Enter time started: ");
				schedule.setStart_Time(kb.nextLine());
				System.out.println("Enter time ended: ");
				schedule.setEnd_Time(kb.nextLine());

				myConn = DriverManager.getConnection(url, user, password);

				String sql = "insert into schedule"
						+ " (Schedule_ID, ClassRoom_ID, Kids_ID, Schedule_date, Start_time, End_time)"
						+ " values(?,?,?,?,?,?)";

				myStmt = myConn.prepareStatement(sql);

				myStmt.setInt(1, schedule.getSchedule_id());
				myStmt.setInt(2, schedule.getClassRoom_id());
				myStmt.setInt(3, schedule.getKids_id());
				myStmt.setDate(4, schedule.getSchedule_Date());
				myStmt.setString(5, schedule.getStart_Time());
				myStmt.setString(6, schedule.getEnd_Time());

				myStmt.executeUpdate();

				System.out.println("Insert complete.");
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

//########################### Search Data Menu ##############################
	public static void searchData() {
		int num;
		do {
			System.out.println();
			System.out.println("----- Search data menu -----");
			System.out.println("1 - Search Parents by ID");
			System.out.println("2 - Number of Kids enrolled in the system");
			System.out.println("3 - List of all the teachers name");
			System.out.println("4 - Advanced Search");
			System.out.println("5 - Exit");
			System.out.print("Enter your choice: ");
			num = kb.nextInt();
			switch (num) {
			case 1:
				searchParents();
				break;
			case 2:
				numOfKids();
				break;
			case 3:
				teachersName();
				break;
			case 4:
				advancedSearch();
			case 5:
				// System.out.println("Back to main menu.");
				break;
			default:
				System.out.println("Please pick the right choice");
				break;
			}

		} while (!(num == 5));
	}

//########################### Search Parents ##############################
	public static void searchParents() {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		Parents p = new Parents();

		try {
			System.out.println("############## Search Parents by ID ##############\n");
			System.out.println("Enter Parent Id: ");
			p.setParents_id(kb.nextInt());
			kb.nextLine();

			myConn = DriverManager.getConnection(url, user, password);

			String sql = ("SELECT * FROM childcaresystem.parents where Parents_ID = ?");

			myStmt = myConn.prepareStatement(sql);

			myStmt.setInt(1, p.getParents_id());

			ResultSet rs = myStmt.executeQuery();
			if (rs.next()) {
				do {
					String bar = "-------------------------------------------------------------------------------------------------------------------------------------------------";
					System.out.println(String.format("| %s | %-25s | %-25s | %-25s | %-35s | %s ", "ID", "First Name",
							"Last Name", "Phone Number", "Address", "Number of Kids"));
					System.out.println(String.format("%s", bar));
					System.out.print(String.format("| %s  |", rs.getInt(1)));
					System.out.print(String.format(" %-25s |", rs.getString(2)));
					System.out.print(String.format(" %-25s |", rs.getString(3)));
					System.out.print(String.format(" %-25s |", rs.getString(4)));
					System.out.print(String.format(" %-35s |", rs.getString(5)));
					System.out.print(String.format(" %s", rs.getString(6)));
					System.out.print("\n");
				} while (rs.next());
			} else {
				System.out.println("Records not found...");
			}
			myConn.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

//########################### Number of Kids ##############################
	public static void numOfKids() {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = DriverManager.getConnection(url, user, password);

			System.out.println("############## Number of kids enrolled in the Child Care ##############\n");

			String sql = ("SELECT COUNT(Kids_ID) FROM kids");

			myStmt = myConn.prepareStatement(sql);

			ResultSet rs = myStmt.executeQuery();

			if (rs.next()) {
				do {
					System.out.println("Kids Enrolled");
					System.out.println("   " + rs.getInt(1) + "  ");
				} while (rs.next());
			} else {
				System.out.println("Records not found...");
			}
			myConn.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

//########################### Search Teachers Name ##############################	
	public static void teachersName() {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = DriverManager.getConnection(url, user, password);

			System.out.println("############## List of all the teachers name ##############\n");

			String sql = ("SELECT First_Name, Last_Name FROM TEACHER");

			myStmt = myConn.prepareStatement(sql);

			ResultSet rs = myStmt.executeQuery();

			if (rs.next()) {
				do {
					System.out.println("Teachers Name");
					System.out.println("   " + rs.getString(1) + " " + rs.getString(2));
				} while (rs.next());
			} else {
				System.out.println("Records not found...");
			}
			myConn.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public static void advancedSearch() {
		int num;
		do {
			System.out.println();
			System.out.println("----- Advanced Search menu -----");
			System.out.println("1 - Parents by their payments");
			System.out.println("2 - Teachers by their classes");
			System.out.println("3 - Kids by their schedules");
			System.out.println("4 - Exit");
			System.out.print("Enter your choice: ");
			num = kb.nextInt();
			switch (num) {
			case 1:
				parentbypayment();
				break;
			case 2:
				teacherbyclass();
				break;
			case 3:
				kidsbyschedule();
				break;
			case 4:
				System.out.println("Back to Search menu.");
				break;
			default:
				System.out.println("Please pick the right choice");
				break;
			}

		} while (!(num == 4));
	}

	public static void parentbypayment() {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		Parents p = new Parents();

		try {
			System.out.println("############## Parents and their payments information ##############\n");
			System.out.println("Enter Parent Id: ");
			p.setParents_id(kb.nextInt());
			kb.nextLine();

			myConn = DriverManager.getConnection(url, user, password);

			String sql = ("SELECT * FROM childcaresystem.parents where Parents_ID = ?");

			myStmt = myConn.prepareStatement(sql);

			myStmt.setInt(1, p.getParents_id());

			ResultSet rs = myStmt.executeQuery();

			int num = 0;
			if (rs.next()) {
				do {
					String bar = "-------------------------------------------------------------------------------------------------------------------------------------------------";
					System.out.println(String.format("| %s | %-25s | %-25s | %-25s | %-35s | %s ", "ID", "First Name",
							"Last Name", "Phone Number", "Address", "Number of Kids"));
					System.out.println(String.format("%s", bar));
					System.out.print(String.format("| %s  |", rs.getInt(1)));
					System.out.print(String.format(" %-25s |", rs.getString(2)));
					System.out.print(String.format(" %-25s |", rs.getString(3)));
					System.out.print(String.format(" %-25s |", rs.getString(4)));
					System.out.print(String.format(" %-35s |", rs.getString(5)));
					System.out.print(String.format(" %s", rs.getString(6)));
					System.out.print("\n");
				} while (rs.next());

				System.out.println("\n####### Parents payments information #########\n");
				sql = ("SELECT * FROM childcaresystem.payments where Parents_ID = ?");

				myStmt = myConn.prepareStatement(sql);

				myStmt.setInt(1, p.getParents_id());

				ResultSet rs1 = myStmt.executeQuery();
				if (rs1.next()) {

					System.out.println(String.format("| %s | %s | %-15s | %-25s ", "Payments ID", "Parent ID",
							"Payment Date", "Payment Method"));
					do {
						String bar = "------------------------------------------------------------";
						System.out.println(String.format("%s", bar));
						System.out.print(String.format("| %10s |", rs1.getInt(1)));
						System.out.print(String.format(" %10s |", rs1.getInt(2)));
						System.out.print(String.format(" %-15s |", rs1.getDate(3)));
						System.out.print(String.format(" %-25s ", rs1.getString(4)));
						System.out.println("\n");
					} while (rs1.next());

				} else {
					System.out.println("Records not found...");
				}
			} else {
				System.out.println("Records not found...");
			}

			myConn.close();

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	public static void teacherbyclass() {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		Teachers t = new Teachers();

		try {
			System.out.println("############## Techers and their class-room information ##############\n");
			System.out.println("Enter Teacher Id: ");
			t.setTeacher_id(kb.nextInt());
			kb.nextLine();

			myConn = DriverManager.getConnection(url, user, password);

			String sql = ("SELECT * FROM childcaresystem.teacher where Teacher_ID = ?");

			myStmt = myConn.prepareStatement(sql);

			myStmt.setInt(1, t.getTeacher_id());

			ResultSet rs = myStmt.executeQuery();

			int num = 0;
			if (rs.next()) {
				do {
					String bar = "---------------------------------------------------------------------------------------------------------------------------------------------------";
					System.out.println(String.format("| %s | %-25s | %-25s | %-25s | %-35s | %-15s ", "Teacher ID",
							"First Name", "Last Name", "Phone Number", "Address", "Start data"));

					System.out.println(String.format("%s", bar));
					System.out.print(String.format("| %-10s |", rs.getInt(1)));
					System.out.print(String.format(" %-25s |", rs.getString(2)));
					System.out.print(String.format(" %-25s |", rs.getString(3)));
					System.out.print(String.format(" %-25s |", rs.getString(4)));
					System.out.print(String.format(" %-35s |", rs.getString(5)));
					System.out.print(String.format(" %-15s ", rs.getDate(6)));

				} while (rs.next());

				System.out.println("\n####### Teacher's classroom information #########\n");
				sql = ("SELECT * FROM childcaresystem.classroom where Teacher_ID = ?");

				myStmt = myConn.prepareStatement(sql);

				myStmt.setInt(1, t.getTeacher_id());

				ResultSet rs1 = myStmt.executeQuery();
				if (rs1.next()) {
					System.out.println(String.format("| %s | %-15s | %-10s | %-10s | %-10s | %-35s | %-8s",
							"ClassRoom ID", "ClassRoom Date", "Teacher ID", "Activity ID", "Week ID",
							"ClassRoom Report", "Number of Kids"));
					do {
						String bar = "--------------------------------------------------------------------------------------------------------------------------------";
						System.out.println(String.format("%s", bar));
						System.out.print(String.format("| %-12s |", rs1.getInt(1)));
						System.out.print(String.format(" %-15s |", rs1.getDate(2)));
						System.out.print(String.format(" %-10s |", rs1.getInt(3)));
						System.out.print(String.format(" %-11s |", rs1.getInt(4)));
						System.out.print(String.format(" %-10s |", rs1.getInt(5)));
						System.out.print(String.format(" %-35s |", rs1.getString(6)));
						System.out.print(String.format(" %-8s ", rs1.getInt(7)));

					} while (rs1.next());

				} else {
					System.out.println("Records not found...");
				}
			} else {
				System.out.println("Records not found...");
			}

			myConn.close();

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	public static void kidsbyschedule() {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		Kids k = new Kids();

		try {
			System.out.println("############## Kids and their schedule information ##############\n");
			System.out.println("Enter kid Id: ");
			k.setKids_id(kb.nextInt());
			kb.nextLine();

			myConn = DriverManager.getConnection(url, user, password);

			String sql = ("SELECT * FROM childcaresystem.kids where kids_ID = ?");

			myStmt = myConn.prepareStatement(sql);

			myStmt.setInt(1, k.getKids_id());

			ResultSet rs = myStmt.executeQuery();

			if (rs.next()) {
				do {
					String bar = "--------------------------------------------------------------------------------------------------------";
					System.out.println(String.format("| %s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s",
							"Kids ID", "First Name", "Last Name", "Date Of Birth", "Start Date", "End Date",
							"Kids Status", "Parent ID"));
					System.out.println(String.format("%s", bar));

					System.out.print(String.format("| %-7s |", rs.getInt(1)));
					System.out.print(String.format(" %-10s |", rs.getString(2)));
					System.out.print(String.format(" %-10s |", rs.getString(3)));
					System.out.print(String.format(" %-13s |", rs.getDate(4)));
					System.out.print(String.format(" %-10s |", rs.getDate(5)));
					System.out.print(String.format(" %-9s |", rs.getDate(6)));
					System.out.print(String.format(" %-10s |", rs.getString(7)));
					System.out.print(String.format(" %-10s ", rs.getInt(8)));

				} while (rs.next());

				System.out.println("\n####### kid's schedule information #########\n");
				sql = ("SELECT * FROM childcaresystem.schedule where kids_ID = ?");

				myStmt = myConn.prepareStatement(sql);

				myStmt.setInt(1, k.getKids_id());

				ResultSet rs1 = myStmt.executeQuery();
				if (rs1.next()) {
					String bar = "-------------------------------------------------------------------------------";
					System.out.println(String.format("| %s | %-10s | %-10s | %-10s | %-10s | %-10s ", "Schedule ID",
							"ClassRoom ID", "Kids ID", "Schedule date", "Start time", "End time"));

					do {
						System.out.println(String.format("%s", bar));

						System.out.print(String.format("| %-11s |", rs1.getInt(1)));
						System.out.print(String.format(" %-12s |", rs1.getInt(2)));
						System.out.print(String.format(" %-10s |", rs1.getInt(3)));
						System.out.print(String.format(" %-13s |", rs1.getDate(4)));
						System.out.print(String.format(" %-10s |", rs1.getString(5)));
						System.out.print(String.format(" %-9s ", rs1.getString(6)));

					} while (rs1.next());

				} else {
					System.out.println("Records not found...");
				}
			} else {
				System.out.println("Records not found...");
			}

			myConn.close();

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}