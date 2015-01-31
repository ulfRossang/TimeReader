
package se.rosscom.timereader.jpa.repository;

import java.util.List;
import se.rosscom.timereader.jpa.ReaderEntity;

public interface ReaderRepository {

	List<ReaderEntity> findReaders(Long competitionId) throws ReaderDbException;


}
