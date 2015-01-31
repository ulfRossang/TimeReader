package se.rosscom.timereader.service.reader;

import se.rosscom.timereader.exception.ReaderServiceException;
import java.util.List;
import se.rosscom.timereader.dto.ReaderConfigurationDTO;
import se.rosscom.timereader.dto.ReaderDTO;
import se.rosscom.timereader.jpa.ReaderEntity;
import se.rosscom.timereader.service.TimeReaderService;

/**
 *
 * @author ulfrossang
 */
public interface ReaderService extends TimeReaderService {

    void startReaders(String competitionName) throws ReaderServiceException;
    void startReadersMock(String competitionName) throws ReaderServiceException;
    void startReaders(String competitionName, ReaderConfigurationDTO readerConfiguration) throws ReaderServiceException;
    void startReadersMock(String competitionName, ReaderConfigurationDTO readerConfiguration) throws ReaderServiceException;
    void stopReaders(String competitionName) throws ReaderServiceException;
    void stopReadersMock(String competitionName) throws ReaderServiceException;
    List<ReaderEntity> findReaders(String competitionName) throws ReaderServiceException;
    List<ReaderDTO> findReadersList(String competitionName) throws ReaderServiceException;

}
