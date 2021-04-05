package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class ScoolMapper implements RowMapper<School>{

	public School mapRow(ResultSet rs, int rowNum) throws SQLException {
		School s=new School();
		s.setId(rs.getInt("id"));
		s.setFirstName(rs.getString("first"));
		s.setLastNAME(rs.getString("last"));
		s.setFaterName(rs.getString("father"));
		s.setMotherName(rs.getString("mother"));
		s.setMobile(rs.getString("mobile"));
		s.setGender(rs.getString("gender"));
		s.setDob(rs.getString("DateOfBirth"));
		s.setCls(rs.getInt("class"));
		s.setPassword(rs.getString("password"));
		s.setResult(rs.getInt("result"));
		//s.se
		
		return s;
	}

}
