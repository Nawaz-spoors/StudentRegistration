package dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import model.admin;

public class AdminDaoImpl implements AdminDao {
	DataSource ds;
	JdbcTemplate jt;
	
	public void setDs(DataSource ds) {
		jt=new JdbcTemplate(ds);
		this.ds = ds;
	}
	public DataSource getDs(){
		return ds;
	}

	public String authenticateByName(String name) {
		String query="SELECT password FROM admin WHERE name="+"'"+name+"'";
		admin x=jt.queryForObject(query,new BeanPropertyRowMapper<admin>(admin.class));
//		System.out.println(x.getPassword());
		return x.getPassword();
		
	}

}
