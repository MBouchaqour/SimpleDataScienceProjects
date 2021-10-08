package package2;

import java.sql.Date;

public class Schedule {
	private int Schedule_id;
	private int ClassRoom_id;
	private int Kids_id;
	private Date Schedule_Date;
	private String Start_Time;
	private String End_Time;

	public Schedule() {

	}

	public int getSchedule_id() {
		return this.Schedule_id;
	}

	public void setSchedule_id(int schedule_id) {
		this.Schedule_id = schedule_id;
	}

	public int getClassRoom_id() {
		return this.ClassRoom_id;
	}

	public void setClassRoom_id(int classRoom_id) {
		this.ClassRoom_id = classRoom_id;
	}

	public int getKids_id() {
		return this.Kids_id;
	}

	public void setKids_id(int kids_id) {
		this.Kids_id = kids_id;
	}

	public Date getSchedule_Date() {
		return this.Schedule_Date;
	}

	public void setSchedule_Date(Date schedule_Date) {
		this.Schedule_Date = schedule_Date;
	}

	public String getStart_Time() {
		return this.Start_Time;
	}

	public void setStart_Time(String start_Time) {
		this.Start_Time = start_Time;
	}

	public String getEnd_Time() {
		return this.End_Time;
	}

	public void setEnd_Time(String end_Time) {
		this.End_Time = end_Time;
	}

	public String toString() {

		return "Schedule id: " + this.Schedule_id + " Classroom_Id: " + this.ClassRoom_id + " Kids_Id " + this.Kids_id
				+ " Date created: " + this.Schedule_Date + " Time Start: " + this.Start_Time + " Time end: "
				+ this.End_Time;
	}
}
