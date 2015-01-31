package se.rosscom.timereader.jpa.repository.internal;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ulfrossang
 */
public class ReaderRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        ReaderResultSetExtractor readerResultSetExtractor = new ReaderResultSetExtractor();
        return readerResultSetExtractor.extractData(rs);
    }
    
}
