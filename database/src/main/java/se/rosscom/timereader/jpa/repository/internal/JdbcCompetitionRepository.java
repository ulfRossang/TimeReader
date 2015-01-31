
package se.rosscom.timereader.jpa.repository.internal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import se.rosscom.timereader.jpa.CompetitionEntity;
import se.rosscom.timereader.jpa.ReaderEntity;
import se.rosscom.timereader.jpa.repository.*;


public class JdbcCompetitionRepository implements CompetitionRepository {

	private final JdbcTemplate jdbcTemplate;

	public JdbcCompetitionRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public CompetitionEntity findById(String srcAcctId) {
		return jdbcTemplate.queryForObject("select id, competitionDate, competitionName from competition where id = ?", new CompetitionRowMapper(), srcAcctId);
	}
        
        	private static class CompetitionRowMapper implements RowMapper<CompetitionEntity> {

		@Override
		public CompetitionEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new CompetitionEntity(rs.getString("id"), new Date() );
		}

	}
                

}