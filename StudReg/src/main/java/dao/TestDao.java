package dao;

import java.sql.SQLException;

public interface TestDao {
	public String getQuestion(int id);
	public String getAnswer(int id) throws SQLException ;
}
