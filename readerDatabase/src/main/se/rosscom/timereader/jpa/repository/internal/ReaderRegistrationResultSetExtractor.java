
package se.rosscom.timereader.jpa.repository.internal;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import se.rosscom.timereader.jpa.ReaderConfigurationEntity;
import se.rosscom.timereader.jpa.ReaderRegistrationEntity;

/**
 *
 * @author ulfrossang
 */
public class ReaderRegistrationResultSetExtractor implements ResultSetExtractor{

    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
        ReaderRegistrationEntity reg = new ReaderRegistrationEntity();
        reg.setiD(rs.getLong(1));
        reg.setReader(new ReaderConfigurationEntity(rs.getLong(2)));
        reg.setRFID(rs.getString(3));
        reg.setAntennId(rs.getLong(4));
        reg.setReaderDateTime(rs.getDate(5));
        reg.setAppDateTime(rs.getDate(6));
        reg.setTimeStamp(rs.getTimestamp(7));
        reg.setReaderCount(rs.getLong(8));
        return reg;
    }
    
    
}
