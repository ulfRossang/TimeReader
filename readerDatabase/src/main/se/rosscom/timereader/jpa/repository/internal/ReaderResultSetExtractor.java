
package se.rosscom.timereader.jpa.repository.internal;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import se.rosscom.timereader.jpa.CompetitionPartEntity;
import se.rosscom.timereader.jpa.ReaderEntity;

/**
 *
 * @author ulfrossang
 */
public class ReaderResultSetExtractor implements ResultSetExtractor{

    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
        ReaderEntity reader = new ReaderEntity();
        reader.setReaderId(rs.getLong(1));
        reader.setLap(rs.getInt(2));
        reader.setCompetitionPart(new CompetitionPartEntity(rs.getInt(3)));
        reader.setReaderType(rs.getString(4));
        reader.setLengthFromStart(rs.getBigDecimal(5));
        return reader;
    }
    
    
}
