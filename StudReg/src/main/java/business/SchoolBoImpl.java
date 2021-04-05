
package business;

import java.util.List;

import dao.SchoolDao;
import model.School;

public class SchoolBoImpl implements SchoolBo{
	SchoolDao dao;

	public SchoolDao getDao() {
		return dao;
	}

	public void setDao(SchoolDao dao) {
		this.dao = dao;
	}

	public int insert(School s) {
		
		return dao.insertStud(s);
	}

	public int del(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	public List<School> display() {
		
		return dao.view();
	}

	public boolean authenticateByName(String first, String last, String pwd) {
		String res=dao.findByname(first, last);
		return res.equals(pwd);
	}

	public boolean authenticateByRoll(int id, String pwd) {
		String res=dao.findById(id).getPassword();
		return res.equals(pwd);
	}

	public School findById(int id) {
		
		return dao.findById(id);
	}

	public int update(School student) {
		
		return dao.update(student);
	}
	public void updateClass(int id,int cls) {
		dao.updateClass(id, cls);
	}

}
