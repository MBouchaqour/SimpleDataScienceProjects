package package2;

import java.sql.Date;

public class Activities {
	private int Activity_id;
	private String Title;
	private Date Activity_Date;

	public Activities() {

	}

	public int getActivity_id() {
		return this.Activity_id;
	}

	public void setActivity_id(int activity_id) {
		this.Activity_id = activity_id;
	}

	public String getTitle() {
		return this.Title;
	}

	public void setTitle(String title) {
		this.Title = title;
	}

	public Date getActivity_Date() {
		return this.Activity_Date;
	}

	public void setActivity_Date(Date activity_Date) {
		this.Activity_Date = activity_Date;
	}

}