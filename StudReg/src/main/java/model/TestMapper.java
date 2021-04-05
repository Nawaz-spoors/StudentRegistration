package model;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class TestMapper implements RowMapper<test>{

	public test mapRow(ResultSet rs, int rowNum) throws SQLException {
		test t=new test();
		t.setId(rs.getInt(1));
		t.setQst(rs.getString(2));
		t.setAns(rs.getString(3));
		return t;
	}

}
