package se.rosscom.timereader.jpa.repository;

import se.rosscom.timereader.jpa.CompetitionPartEntity;

/**
 *
 * @author ulfrossang
 */
public interface CompetitionPartRepository  {
    
    CompetitionPartEntity findById(String srcAcctId);
}
