package package2;

import java.sql.Date;
import package1.Kids;

public class ClassRoom {
	private int ClassRoom_id;
	private Date ClassRoom_Date;
	private int Teacher_id;
	private int Week_id;
	private String kids_report;
	private int activity_id;
	private static int numberOfKids;

	public ClassRoom() {

	}

	public int getClassRoom_id() {
		return this.ClassRoom_id;
	}

	public void setClassRoom_id(int classRoom_id) {
		this.ClassRoom_id = classRoom_id;
	}

	public Date getClassRoom_Date() {
		return this.ClassRoom_Date;
	}

	public void setClassRoom_Date(Date classRoom_Date) {
		this.ClassRoom_Date = classRoom_Date;
	}

	public int getTeachers_id() {
		return this.Teacher_id;
	}

	public void setTeachers_id(int teachers_id) {
		this.Teacher_id = teachers_id;
	}

	public int getWeek_id() {
		return this.Week_id;
	}

	public void setWeek_id(int week_id) {
		this.Week_id = week_id;
	}

	public String getKids_report() {
		return this.kids_report;
	}

	public void setKids_report(String kids_report) {
		this.kids_report = kids_report;
	}

	public int getactivity_id() {
		return this.activity_id;
	}

	public void setactivity_id(int act_id) {
		this.activity_id = act_id;
	}

	public static void setNumberofKids(int num) {
		numberOfKids = num;
	}

	public static int getNumberofKids() {
		return numberOfKids;
	}

	public String toString() {

		return "ClassRoom id: " + this.ClassRoom_id + " ClassRoom Date created: " + this.ClassRoom_Date
				+ " Teacher id: " + this.Teacher_id + " Week Id: " + this.Week_id + " Kids report" + this.kids_report;
	}

}
