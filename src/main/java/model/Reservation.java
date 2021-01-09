package main.java.model;

public class Reservation {
	
	public int id;
	public String date;
	public int userId;
	public int bookcopyId;
	
	@Override
	public String toString() {
		return "Reservation [id=" + id +
				", date=" + date +
				", userId=" + userId +
				", bookcopyId=" + bookcopyId + "]";
	}
	
	

}
