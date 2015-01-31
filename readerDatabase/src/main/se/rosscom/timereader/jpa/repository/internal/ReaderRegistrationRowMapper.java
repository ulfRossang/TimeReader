package se.rosscom.timereader.jpa.repository.internal;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ulfrossang
 */
public class ReaderRegistrationRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        ReaderRegistrationResultSetExtractor readerResultSetExtractor = new ReaderRegistrationResultSetExtractor();
        return readerResultSetExtractor.extractData(rs);
    }
    
}
