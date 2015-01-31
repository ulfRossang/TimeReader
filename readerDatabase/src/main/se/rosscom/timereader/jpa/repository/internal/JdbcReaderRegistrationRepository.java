
package se.rosscom.timereader.jpa.repository.internal;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import se.rosscom.timereader.jpa.ReaderConfigurationEntity;
import se.rosscom.timereader.jpa.ReaderRegistrationEntity;
import se.rosscom.timereader.jpa.StartIdEntity;
import se.rosscom.timereader.jpa.repository.*;

public class JdbcReaderRegistrationRepository implements ReaderRegistrationRepository {

	private final JdbcTemplate jdbcTemplate;

	public JdbcReaderRegistrationRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

    @Override
    public void addReg(Long readerId, String RFID, Long antennId, Date readerDateTime, Date appDateTime, Long readerCount) {

        ReaderConfigurationEntity readerconf = new ReaderConfigurationEntity(readerId);
        String ql = null;
        if (readerId != null && RFID != null && antennId != null && readerDateTime != null) {
            ql = "insert into ReaderRegistration (ReaderID, RFID, AntennID, ReaderDateTime, AppDateTime, TimeStamp, ReaderCount) values(?,?,?,?,?,?,?)";

            jdbcTemplate.update(ql, new Object[] { readerId, RFID, antennId, readerDateTime, appDateTime, new Timestamp(appDateTime.getTime()), readerCount });
      
        }
        
    }

    @Override
    public List<ReaderRegistrationEntity> getReg(String RFID) {
        
            String ql = null;

            if (RFID != null) {
                ql = 
                        " SELECT * "
                        + " FROM  ReaderRegistration " 
                        + " WHERE RFID = ?";
            } else {
                return null;
            }

            return jdbcTemplate.query( ql,new Object[] { RFID }, new ReaderRegistrationRowMapper());

    }

    @Override
    public List<StartIdEntity> fetchStartIds(String competitionName) {
        
        String ql = null;

        if (competitionName != null) {
            ql = 
                " Select S.StartNr, S.CompetitionPartId, S.RFID, S.StartingGroupId "
                    + " From Startid S, CompetitionPart C "
                    + " Where S.CompetitionPartId = C.CompetitionPartId "
                    + " And C.competitionPartId IN "
                    +       " (select CompetitionId "
                    +       " FROM Competition "
                    +       " Where Name = ? )";
        } else {
            return null;
        }
            
        return jdbcTemplate.query( ql,new Object[] { competitionName }, new StartIdRowMapper());
    }

}