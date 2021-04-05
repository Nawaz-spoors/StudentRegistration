package business;

import java.sql.SQLException;

import dao.TestDao;

public class TestBoImpl implements TestBo {
	TestDao dao;

	public TestDao getDao() {
		return dao;
	}

	public void setDao(TestDao dao) {
		this.dao = dao;
	}

	public String getQst(int id) {
		// TODO Auto-generated method stub
		return dao.getQuestion(id);
	}

	public boolean getAns(int id, String ans) throws SQLException  {
		// TODO Auto-generated method stub
		//System.out.println(ans+"in TEST BO IMPL");
		return ans.equals(dao.getAnswer(id));
	}

}
