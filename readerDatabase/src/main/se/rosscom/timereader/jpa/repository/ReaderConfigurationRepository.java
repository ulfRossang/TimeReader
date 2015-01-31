
package se.rosscom.timereader.jpa.repository;

import java.util.List;
import se.rosscom.timereader.jpa.ReaderConfigurationEntity;

public interface ReaderConfigurationRepository {

        List<ReaderConfigurationEntity> getReaderConf(Long readerId);
        void addReaderConfiguration(Long readerId, String ipAdress, Long readPower, Long aSyncOffTime);


}
