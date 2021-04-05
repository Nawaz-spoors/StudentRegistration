package model;

public class School {
	@Override
	public String toString() {
		return "School [id=" + id + ",  dob=" + dob
				+ "]";
	}


	private String firstName,lastNAME,faterName,motherName,gender,mobile,dob,password;
	private int id,cls,result;
	
	
	public School(String firstName, String lastNAME, String faterName, String motherName, String gender, String mobile,
			String dob, String password, int id, int cls, int result) {
		super();
		this.firstName = firstName;
		this.lastNAME = lastNAME;
		this.faterName = faterName;
		this.motherName = motherName;
		this.gender = gender;
		this.mobile = mobile;
		this.dob = dob;
		this.password = password;
		this.id = id;
		this.cls = cls;
		this.result = result;
	}


	

	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastNAME() {
		return lastNAME;
	}




	public void setLastNAME(String lastNAME) {
		this.lastNAME = lastNAME;
	}




	public String getFaterName() {
		return faterName;
	}




	public void setFaterName(String faterName) {
		this.faterName = faterName;
	}




	public String getMotherName() {
		return motherName;
	}




	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getMobile() {
		return mobile;
	}




	public void setMobile(String mobile) {
		this.mobile = mobile;
	}




	public String getDob() {
		return dob;
	}




	public void setDob(String dob) {
		this.dob = dob;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getCls() {
		return cls;
	}




	public void setCls(int cls) {
		this.cls = cls;
	}




	public int getResult() {
		return result;
	}




	public void setResult(int result) {
		this.result = result;
	}




	public School() {
		super();
	}
	
}
