package model;

public class test {
	private String qst,ans;
	private int id;
	
	
	public test(String qst, String ans, int id) {
		super();
		this.qst = qst;
		this.ans = ans;
		this.id = id;
	}

	public String getQst() {
		return qst;
	}

	public void setQst(String qst) {
		this.qst = qst;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public test() {
		super();
	}

	@Override
	public String toString() {
		return "test [qst=" + qst + ", ans=" + ans + ", id=" + id + "]";
	}

	
	

}
