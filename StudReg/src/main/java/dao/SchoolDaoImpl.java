package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import model.School;
import model.ScoolMapper;

public class SchoolDaoImpl implements SchoolDao {
	DataSource ds;
	JdbcTemplate jt;
	
	public void setDs(DataSource ds) {
		jt=new JdbcTemplate(ds);
		this.ds = ds;
	}
	public DataSource getDs(){
		return ds;
	}
	public int insertStud(School s) {
		String q1="SELECT COUNT(*) FROM school";
		int count=jt.queryForObject(q1, Integer.class);
		String query="INSERT INTO school values(?,?,?,?,?,?,?,?,?,?,?)";
		String pwd=s.getDob().replaceAll("/", "")+s.getFirstName();
		return jt.update(query,count+1,s.getFirstName(),s.getLastNAME(),s.getFaterName(),s.getMotherName(),s.getGender(),s.getMobile(),s.getCls(),s.getResult(),s.getDob(),pwd);
	}

	public int delete(int id) {
		String query="DELETE FROM school WHERE id="+"'"+id+"'";
		return jt.update(query);
	}

	public String findByname(String first, String last) {
		String query="SELECT password FROM school WHERE first="+"'"+first+"'"+" AND last="+"'"+last+"'";
		try {
		School x=jt.queryForObject(query,new BeanPropertyRowMapper<School>(School.class));
		return x.getPassword();
		}
		catch (Exception e){
			return "0";
		}
		
	}

	public School findById(int id) {
		String query="SELECT * FROM school WHERE id="+id;

		School x=jt.queryForObject(query,new ScoolMapper());
//		System.out.println(x.getPassword());
		return x;
	}
	public List<School> view() {
		String query="SELECT * FROM school";
		List<School> lis= jt.query(query,new ScoolMapper());
//		System.out.println(lis.get(1).getAdmno());
		return lis;
	}
	public int update(School s) {
		String query="UPDATE school SET first=?,last=?,father=?,mother=?,gender=?,mobile=?,class=0,result=0,DateOfBirth=?,password=? WHERE id=?";
		String pwd=s.getDob().replaceAll("/", "")+s.getFirstName();
		jt.update(query,s.getFirstName(),s.getLastNAME(),s.getFaterName(),s.getMotherName(),s.getGender(),s.getMobile(),s.getDob(),pwd,s.getId());
		System.out.println("1 record updated");
		return 0;
	}
	public void updateClass(int id, int cls) {
		// TODO Auto-generated method stub
		String query="UPDATE school SET result=? WHERE id=?";
		jt.update(query,cls,id);
		System.out.println("1 record updated");
	}

}
