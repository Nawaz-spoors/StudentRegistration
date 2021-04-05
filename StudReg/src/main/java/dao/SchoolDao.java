package dao;

import java.util.List;

import model.School;

public interface SchoolDao {
	public int insertStud(School s);
	public int delete(int id);
	public String findByname(String first,String last);
	public School findById(int id);
	public List<School> view();
	public int update(School student);
	public void updateClass(int id,int cls);
}
