
package se.rosscom.timereader.jpa.repository.internal;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import se.rosscom.timereader.jpa.CompetitionEntity;
import se.rosscom.timereader.jpa.repository.*;


public class JdbcCompetitionRepository implements CompetitionRepository {

	private final JdbcTemplate jdbcTemplate;

	public JdbcCompetitionRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public CompetitionEntity findByName(String competitionName) {
            
            String ql = null;

            if (competitionName != null) {
                ql = 
                        " SELECT * "
                        + " FROM  Competition " 
                        + " WHERE NAME = ?";
            } else {
                return null;
            }
            return (CompetitionEntity) jdbcTemplate.queryForObject(ql, new Object[] { competitionName }, new CompetitionRowMapper());
	}
}