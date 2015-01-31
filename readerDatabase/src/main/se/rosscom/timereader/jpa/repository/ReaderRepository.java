
package se.rosscom.timereader.jpa.repository;

import java.util.List;
import se.rosscom.timereader.jpa.ReaderEntity;

public interface ReaderRepository {

        ReaderEntity findReader(Long readerId, Long lap, Long competitionId);
	List<ReaderEntity> findReaders(Long competitionId);
	List<ReaderEntity> findReadersCompetition(Long competitionId);


}
