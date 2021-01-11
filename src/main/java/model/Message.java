package main.java.model;

public class Message {
	
	public int id;
	public String date;
	public int senderId;
	public int receiverId;

	@Override
	public String toString() {
		return "Message{" +
				"id=" + id +
				", date='" + date + '\'' +
				", senderId=" + senderId +
				", receiverId=" + receiverId +
				'}';
	}
}
