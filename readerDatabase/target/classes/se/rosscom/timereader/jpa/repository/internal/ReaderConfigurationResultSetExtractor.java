
package se.rosscom.timereader.jpa.repository.internal;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import se.rosscom.timereader.jpa.ReaderConfigurationEntity;

/**
 *
 * @author ulfrossang
 */
public class ReaderConfigurationResultSetExtractor implements ResultSetExtractor{

    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
        ReaderConfigurationEntity readerConf = new ReaderConfigurationEntity();
        readerConf.setReaderId(rs.getLong(1));
        readerConf.setiPAdress(rs.getString(2));
        readerConf.setReadPower(rs.getLong(3));
        readerConf.setaSyncOffTime(rs.getLong(4));
        return readerConf;
    }
    
    
}
