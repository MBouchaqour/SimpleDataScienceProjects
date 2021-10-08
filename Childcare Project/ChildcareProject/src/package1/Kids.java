package package1;

import java.sql.Date;

public class Kids extends Parents {
	private int Kids_id;
	private String First_name;
	private String Last_name;
	private Date DateOfBirth;
	private Date Start_Date;
	private Date End_Date;
	private String Status;
	private int Parents_id;
	private static int numberOfKids;

	public Kids() {

	}

	public int getKids_id() {
		return this.Kids_id;
	}

	public void setKids_id(int kids_id) {
		this.Kids_id = kids_id;
	}

	public String getFirst_name() {
		return this.First_name;
	}

	public void setFirst_name(String first_name) {
		this.First_name = first_name;
	}

	public String getLast_name() {
		return this.Last_name;
	}

	public void setLast_name(String last_name) {
		this.Last_name = last_name;
	}

	public Date getDateOfBirth() {
		return this.DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.DateOfBirth = dateOfBirth;
	}

	public Date getStart_Date() {
		return this.Start_Date;
	}

	public void setStart_Date(Date start_Date) {
		this.Start_Date = start_Date;
	}

	public Date getEnd_Date() {
		return this.End_Date;
	}

	public void setEnd_Date(Date end_Date) {
		this.End_Date = end_Date;
	}

	public String getStatus() {
		return this.Status;
	}

	public void setStatus(String status) {
		this.Status = status;
	}

	public int getParents_id() {
		return this.Parents_id;
	}

	public void setParents_id(int parents_id) {
		this.Parents_id = parents_id;
	}

	public void setNumberofKids(int num) {
		numberOfKids = num;
	}

	public String toString() {

		return "kids id: " + this.Kids_id + " First name: " + this.First_name + " Last name: " + this.Last_name
				+ " Status: " + this.Status + " Started date: " + this.Start_Date + " End Date: " + this.End_Date
				+ " Parent id" + this.Parents_id;
	}
}
