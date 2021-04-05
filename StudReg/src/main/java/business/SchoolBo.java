package business;

import java.util.List;

import model.School;

public interface SchoolBo {
public int insert(School s);
public int del(int id);
public List<School> display();
public boolean authenticateByName(String first,String last,String pwd);
public boolean authenticateByRoll(int id,String pwd);
public School findById(int id);
public int update(School student);
public void updateClass(int id,int cls);
/*
 * public void insert(int id, String frstName, String lstName, String father,
 * String mother, String gender, String phone, String dob, String pwd);
 */
}
