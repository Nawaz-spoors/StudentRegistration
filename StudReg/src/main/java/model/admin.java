package model;

public class admin {
	private int id;
	private String name,password;
	
	public admin() {
	}
	
	@Override
	public String toString() {
		return "admin [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	public admin(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
