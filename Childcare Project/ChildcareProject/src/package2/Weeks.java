package package2;

import java.sql.Date;

public class Weeks {
	private int Week_id;
	private Date Start_date;
	private Date End_date;
	private int Days_Worked;

	public Weeks() {

	}

	public int getWeek_id() {
		return this.Week_id;
	}

	public void setWeek_id(int week_id) {
		this.Week_id = week_id;
	}

	public Date getStart_date() {
		return this.Start_date;
	}

	public void setStart_date(Date start_date) {
		this.Start_date = start_date;
	}

	public Date getEnd_date() {
		return this.End_date;
	}

	public void setEnd_date(Date end_date) {
		this.End_date = end_date;
	}

	public int getDays_Worked() {
		return this.Days_Worked;
	}

	public void setDays_Worked(int days_Worked) {
		this.Days_Worked = days_Worked;
	}

	public String toString() {

		return "Week id: " + this.Week_id + " Started Date: " + this.Start_date + " Ended Date: " + this.End_date
				+ " Number of works day: " + this.Days_Worked;
	}
}
