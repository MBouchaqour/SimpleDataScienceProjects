package package1;

public class Parents {
	private int Parents_id;
	private String First_Name;
	private String Last_Name;
	private String Phone_Number;
	private String Address;
	private int numberOfKids;

	public Parents() {

	}

	public int getParents_id() {
		return this.Parents_id;
	}

	public void setParents_id(int parents_id) {
		this.Parents_id = parents_id;
	}

	public String getFirst_Name() {
		return this.First_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.First_Name = first_Name;
	}

	public String getLast_Name() {
		return this.Last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.Last_Name = last_Name;
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

	public int getNumberOfKids() {
		return this.numberOfKids;
	}

	public void setNumberOfKids(int numberOfKids) {
		this.numberOfKids = numberOfKids;
	}

	public String toString() {

		return "Parent id: " + this.Parents_id + " First name: " + this.First_Name + " Last name: " + this.Last_Name
				+ " Phone: " + this.Phone_Number + "Address: " + this.Address + " Number of kids" + this.numberOfKids;
	}
}
