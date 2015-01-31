    
package se.rosscom.timereader.jpa.repository;

import java.util.Date;
import java.util.List;
import se.rosscom.timereader.jpa.ReaderRegistrationEntity;
import se.rosscom.timereader.jpa.StartIdEntity;

public interface ReaderRegistrationRepository {

        void addReg(Long readerId, String RFID, Long antennId, Date readerDateTime, Date appDateTime, Long readerCount);
        List<ReaderRegistrationEntity> getReg(String RFID);
        List<StartIdEntity> fetchStartIds(String competitionName);

}
