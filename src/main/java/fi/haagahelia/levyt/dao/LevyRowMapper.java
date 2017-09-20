package fi.haagahelia.levyt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.haagahelia.levyt.bean.Levy;



public class LevyRowMapper implements RowMapper<Levy> {

	public Levy mapRow(ResultSet rs, int rowNum) throws SQLException {
		Levy l = new Levy();
		l.setArtisti(rs.getString("artisti"));
		l.setJulkaisuvuosi(rs.getInt("julkaisuvuosi"));
		l.setNimi(rs.getString("nimi"));
		l.setId(rs.getInt("id"));
		
		return l;
	}

}