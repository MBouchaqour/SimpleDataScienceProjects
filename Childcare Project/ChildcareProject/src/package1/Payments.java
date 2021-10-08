package package1;

import java.sql.Date;

public class Payments extends Parents {

	private int Payments_id;
	private int Parents_id;
	private Date Payment_Date;
	private String Payment_Method;

	public Payments() {

	}

	public int getPayments_id() {
		return this.Payments_id;
	}

	public void setPayments_id(int payments_id) {
		this.Payments_id = payments_id;
	}

	public int getParents_id() {
		return this.Parents_id;
	}

	public void setParents_id(int parents_id) {
		this.Parents_id = parents_id;
	}

	public Date getPayment_Date() {
		return this.Payment_Date;
	}

	public void setPayment_Date(Date payment_Date) {
		this.Payment_Date = payment_Date;
	}

	public String getPayment_Method() {
		return this.Payment_Method;
	}

	public void setPayment_Method(String payment_Method) {
		this.Payment_Method = payment_Method;
	}

	public String toString() {

		return "Payments id: " + this.Parents_id + " Parent Id: " + this.Parents_id + " Payment date "
				+ this.Payment_Date + " Payment method: " + this.Payment_Method;
	}
}
