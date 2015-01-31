
package se.rosscom.timereader.jpa.repository.internal;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import se.rosscom.timereader.jpa.CompetitionPartEntity;
import se.rosscom.timereader.jpa.StartIdEntity;
import se.rosscom.timereader.jpa.StartingGroupEntity;

/**
 *
 * @author ulfrossang
 */
public class StartIdResultSetExtractor implements ResultSetExtractor{

    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
        StartIdEntity startId = new StartIdEntity();
        startId.setStartNr(rs.getLong(1));
        startId.setCompetitionPart(new CompetitionPartEntity(rs.getLong(2)));
        startId.setRFID(rs.getString(3));
        startId.setStartingGroup(new StartingGroupEntity(rs.getLong(4), new CompetitionPartEntity(rs.getLong(2))));
        return startId;
    }
    
    
}
