package dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import model.TestMapper;
import model.test;

public class TestDaoImpl implements TestDao {
	DataSource ds;
	JdbcTemplate jt;
	public void setDs(DataSource ds) {
		jt=new JdbcTemplate(ds);
		this.ds = ds;
	}
	public DataSource getDs(){
		return ds;
	}
	public String getQuestion(int id) {
		String query="SELECT * FROM test where id="+id;
		test qst=jt.queryForObject(query, new TestMapper());
		//School x=jt.queryForObject(query,new BeanPropertyRowMapper<School>(School.class));
		
		return qst.getQst();
	}
	public String getAnswer(int id) throws SQLException {
		
		String query="SELECT * FROM test WHERE id="+id;
		//System.out.println("HI NAMASTEE");
		test ans=jt.queryForObject(query, new TestMapper());
		//System.out.println(ans.getAns());
		return ans.getAns();
	}

}
