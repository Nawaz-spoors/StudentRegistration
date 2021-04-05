package business;

import java.sql.SQLException;

public interface TestBo {
	public String getQst(int id);
	public boolean getAns(int id,String ans) throws SQLException ;
}
