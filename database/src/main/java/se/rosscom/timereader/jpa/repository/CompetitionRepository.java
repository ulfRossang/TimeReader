
package se.rosscom.timereader.jpa.repository;

import se.rosscom.timereader.jpa.CompetitionEntity;

public interface CompetitionRepository {

	CompetitionEntity findById(String srcAcctId);


}
