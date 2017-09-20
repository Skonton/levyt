package fi.haagahelia.levyt.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import fi.haagahelia.levyt.bean.Levy;


public class LevyDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void talleta(Levy levy) {
		String sql = "insert into levy(nimi, artisti, julkaisuvuosi) values(?,?,?)";
		Object[] parametrit = new Object[] { levy.getNimi(), levy.getArtisti(), levy.getJulkaisuvuosi() };

		jdbcTemplate.update(sql, parametrit);

	}

	public Levy etsi(int id) {
		String sql = "select nimi, artisti, julkaisuvuosi, id from levy where id = ?";
		Object[] parametrit = new Object[] { id };
		RowMapper<Levy> mapper = new LevyRowMapper();

		Levy l = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		return l;

	}

	public List<Levy> haeKaikki() {

		String sql = "select id, artisti, nimi, julkaisuvuosi from levy";
		RowMapper<Levy> mapper = new LevyRowMapper();
		List<Levy> levyt = jdbcTemplate.query(sql, mapper);

		return levyt;
	}
	
}
