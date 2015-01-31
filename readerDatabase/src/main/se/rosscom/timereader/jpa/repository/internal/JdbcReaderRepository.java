
package se.rosscom.timereader.jpa.repository.internal;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import se.rosscom.timereader.jpa.ReaderEntity;
import se.rosscom.timereader.jpa.repository.*;

public class JdbcReaderRepository implements ReaderRepository {

	private final JdbcTemplate jdbcTemplate;

	public JdbcReaderRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

                
        @Override
	public List<ReaderEntity> findReaders(Long competitionId) {
            String ql = null;

            if (competitionId != null) {
                ql = 
                        " SELECT * "
                        + " FROM  Reader " 
                        + " WHERE COMPETITIONPARTID = ?";
            } else {
                return null;
            }

            return jdbcTemplate.query( ql,new Object[] { competitionId }, new ReaderRowMapper());
	}

        @Override
	public List<ReaderEntity> findReadersCompetition(Long competitionId) {
            String ql = null;

            if (competitionId != null) {
                ql = 
                        " SELECT R.readerId, R.lap, R.competitionPartId, R.readerType, R.lengthFromStart "
                        + " FROM  Reader R, CompetitionPart C" 
                        + " WHERE C.COMPETITIONPARTID = ?" 
                        + " AND R.competitionPartid = C.competitionPartId";
            } else {
                return null;
            }

            return jdbcTemplate.query( ql,new Object[] { competitionId }, new ReaderRowMapper());
	}
        

    @Override
    public ReaderEntity findReader(Long readerId, Long lap, Long competitionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}