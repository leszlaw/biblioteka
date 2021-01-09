package main.java.model;

public class Opinion {
	
	public int id;
	public int rate;
	public String text;
	public int userId;
	public int bookId;
	
	@Override
	public String toString() {
		return "Opinion [id=" + id +
				", rate=" + rate +
				", text=" + text +
				", userId=" + userId +
				", bookId=" + bookId
				+ "]";
	}
	
	

}
