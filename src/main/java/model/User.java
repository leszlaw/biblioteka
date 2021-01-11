package main.java.model;

public class User {
	
	public int id;
	public String name;
	public String lastName;
	public String date;
	public int authId;
	public int contactId;
	public int addressId;
	public int roleId;

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", lastName='" + lastName + '\'' +
				", date='" + date + '\'' +
				", authId=" + authId +
				", contactId=" + contactId +
				", addressId=" + addressId +
				", roleId=" + roleId +
				'}';
	}
}
