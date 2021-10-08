package package2;

import java.sql.Date;

public class Teachers {
	private int Teacher_id;
	private String First_Name;
	private String Last_name;
	private String Phone_Number;
	private String Address;
	private Date Date_Started;
	private static int numberOfTeachers;

	public Teachers() {

	}

	public int getTeacher_id() {
		return this.Teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.Teacher_id = teacher_id;
	}

	public String getFirst_Name() {
		return this.First_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.First_Name = first_Name;
	}

	public String getLast_name() {
		return this.Last_name;
	}

	public void setLast_name(String last_name) {
		this.Last_name = last_name;
	}

	public String getPhone_Number() {
		return this.Phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		this.Phone_Number = phone_Number;
	}

	public String getAddress() {
		return this.Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public Date getDate_Started() {
		return this.Date_Started;
	}

	public void setDate_Started(Date date_Started) {
		this.Date_Started = date_Started;
	}

	public static int getNumberofTecher() {

		return Teachers.numberOfTeachers;
	}

	public String toString() {

		return "Teacher id: " + this.Teacher_id + " First name: " + this.First_Name + " Last name: " + this.Last_name
				+ " Address: " + this.Address + " Phone number" + this.Phone_Number + " Started Date: "
				+ this.Date_Started;
	}

}
