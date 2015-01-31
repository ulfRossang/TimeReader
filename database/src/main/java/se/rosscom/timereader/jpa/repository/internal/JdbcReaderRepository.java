
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
	public List<ReaderEntity> findReaders(Long competitionId) throws ReaderDbException {
            String ql = null;
            if (competitionId != null) {
                ql = 
                        " SELECT READERID, LAP, COMPETITIONPARTID, READERTYPE, LENGTHFROMSTART"
                        + " FROM  " + ReaderEntity.class.getName() 
                        + " WHERE COMPETITIONPARTID = ?";
            } else {
                return null;
            }

            try {
                
                return jdbcTemplate.queryForList(ql, ReaderEntity.class, competitionId);
                        
            } catch (Exception e) {
                    throw new ReaderDbException("Find readers failed with exception: ", e);
            }

	}

}