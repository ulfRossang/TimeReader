
package se.rosscom.timereader.jpa.repository.internal;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import se.rosscom.timereader.jpa.ReaderConfigurationEntity;
import se.rosscom.timereader.jpa.repository.*;

public class JdbcReaderConfigurationRepository implements ReaderConfigurationRepository {

	private final JdbcTemplate jdbcTemplate;

	public JdbcReaderConfigurationRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

    @Override
    public List<ReaderConfigurationEntity> getReaderConf(Long readerId) {
            String ql = null;

            if (readerId != null) {
                ql = 
                        " SELECT * "
                        + " FROM  ReaderConfiguration " 
                        + " WHERE readerId = ?";
            } else {
                return null;
            }

            return jdbcTemplate.query( ql,new Object[] { readerId }, new ReaderConfigurationRowMapper());
    }
        
    @Override
    public void addReaderConfiguration(Long readerId, String ipAdress, Long readPower, Long aSyncOffTime) {

        String ql = null;
        
        ql = "insert into ReaderConfiguration ( ReaderId, IpAdress, Readpower, AsyncOffTime) values (?,?,?,?)";
        
        jdbcTemplate.update(ql, new Object[] {readerId, ipAdress, readPower, aSyncOffTime});
        
    }

}