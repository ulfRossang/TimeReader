package se.rosscom.timereader.jpa.repository.internal;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import se.rosscom.timereader.jpa.CompetitionEntity;

/**
 *
 * @author ulfrossang
 */
public class CompetitionRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        CompetitionEntity competition = new CompetitionEntity();
        competition.setCompetitionId(rs.getLong(1));
        competition.setCompetitionDate(rs.getDate(2));
        competition.setCompetitionName(rs.getString(3));
        return competition;
    }
    
}
