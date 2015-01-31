package se.rosscom.timereader.service.registration;

import java.util.HashMap;
import se.rosscom.timereader.dto.ReaderRegistrationDTO;
import se.rosscom.timereader.service.TimeReaderService;
import se.rosscom.timereader.exception.ReaderServiceException;

/**
 *
 * @author ulfrossang
 */
public interface RegistrationService extends TimeReaderService {

    void regTag(ReaderRegistrationDTO readerRegistration) throws ReaderServiceException;
    HashMap<String, Long> loadStartIds(String competitionName) throws ReaderServiceException;
    Long calculateResult(ReaderRegistrationDTO readerRegistrationDTO, HashMap<String, Long> startMap) throws ReaderServiceException;

}
