package se.rosscom.timereader.serviceimpl.reader;

import com.thingmagic.ReadExceptionListener;
import com.thingmagic.ReadListener;
import com.thingmagic.Reader;
import com.thingmagic.TagReadData;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import se.rosscom.timereader.dto.ReaderConfigurationDTO;
import se.rosscom.timereader.dto.ReaderDTO;
import se.rosscom.timereader.exception.ReaderServiceException;
import se.rosscom.timereader.jpa.CompetitionEntity;
import se.rosscom.timereader.jpa.ReaderEntity;
import se.rosscom.timereader.jpa.repository.CompetitionRepository;
import se.rosscom.timereader.jpa.repository.ReaderRepository;
import se.rosscom.timereader.service.reader.ReaderService;
import se.rosscom.timereader.serviceimpl.readerlistener.RFIDReaderListener;
import se.rosscom.timereader.serviceimpl.readerlistener.ReaderListenerServiceImpl;
import se.rosscom.timereader.serviceimpl.registration.RegistrationServiceImpl;

public class ReaderServiceImpl implements ReaderService {

    private final ReaderRepository readerRepository;
    private final CompetitionRepository competitionRepository;
    private final RegistrationServiceImpl registrationServiceImpl;
    static final Logger log = Logger.getLogger(ReaderServiceImpl.class.getName());
    
    private final HashMap<String, ReaderListenerServiceImpl> readerListeners;
    private ReadExceptionListener exceptionListener;
   
    public ReaderServiceImpl(ReaderRepository readerRepository, 
                            CompetitionRepository competitionRepository, 
                            RegistrationServiceImpl registrationServiceImpl) {
        
        this.readerRepository = readerRepository;
        this.competitionRepository = competitionRepository;
        this.registrationServiceImpl = registrationServiceImpl;
        this.readerListeners = new HashMap();
    }
    
    

    @Override
    public void startReaders(String competitionName) throws ReaderServiceException {
        ReaderConfigurationDTO readerConfigurationDTO = new ReaderConfigurationDTO();
        this.startReaders(competitionName, readerConfigurationDTO);
    }
    @Override
    public void startReaders(String competitionName, ReaderConfigurationDTO readerConfigurationDTO) throws ReaderServiceException {
        Assert.notNull(competitionName);
        Assert.hasText(competitionName);
        
        log.info("------------------------------------------------------------------");
        log.info("Timereader: Start readers for: " + competitionName + " " + readerConfigurationDTO.getHostName());

        List<ReaderEntity> readers = findReaders(competitionName);
        ReaderListenerServiceImpl readerListenerServiceImpl = new ReaderListenerServiceImpl();

        for (ReaderEntity readerEntity : readers) {
            try {
                TimeReaderImpl timeReaderImpl = new TimeReaderImpl(readerConfigurationDTO);
                timeReaderImpl.reader.addReadExceptionListener(exceptionListener);
                ReadListener rl = new RFIDReaderListener(registrationServiceImpl, readerEntity.getReaderId());
                timeReaderImpl.reader.addReadListener(rl);
                timeReaderImpl.reader.startReading();

                log.info("Timereader: Reader id: " + readerEntity.getReaderId());

                readerListenerServiceImpl.addReader(timeReaderImpl.reader);
            } catch (RuntimeException e) {
               throw new ReaderServiceException(e.getMessage());
            }
        }
        readerListeners.put(competitionName, readerListenerServiceImpl);
        
    }

    public List<ReaderDTO> findReadersList(String competitionName) throws ReaderServiceException {
        
        List<ReaderDTO> readers = null;
        List<ReaderEntity> readersE = findReaders(competitionName);
        for(ReaderEntity readerE : readersE) {
            ReaderDTO readerDTO = new ReaderDTO();
            readerDTO.setReaderId(readerE.getReaderId());
            readerDTO.setLap(readerE.getLap());
            readerDTO.setCompetitionPartId(readerE.getCompetitionPart().getCompetitionPartId());
            readerDTO.setReaderType(readerE.getReaderType());
            readerDTO.setLengthFromStart(readerE.getLengthFromStart());
            readers.add(readerDTO);
        }
        return readers;
    }
    @Override
    public List<ReaderEntity> findReaders(String competitionName) throws ReaderServiceException {
        CompetitionEntity competition = competitionRepository.findByName(competitionName);
        return readerRepository.findReadersCompetition(competition.getCompetitionId());
    }

    @Override
    public void stopReaders(String competitionName) throws ReaderServiceException {

        Assert.notNull(competitionName);
        Assert.hasText(competitionName);
        
        ReaderListenerServiceImpl readerListenerServiceImpl = readerListeners.get(competitionName);
        if (readerListenerServiceImpl != null) {
            for (Reader reader : readerListenerServiceImpl.fetchReaders()) {
                // Shut down reader
                reader.stopReading();
                reader.destroy();

            }
            readerListeners.remove(competitionName);
            log.info("Timereader: Stopped readers: " + competitionName);
        }
    }

    @Override
    public void startReadersMock(String competitionName) throws ReaderServiceException {
        ReaderConfigurationDTO readerConfigurationDTO = new ReaderConfigurationDTO();
        this.startReadersMock(competitionName, readerConfigurationDTO);
    }
        
    @Override
    public void startReadersMock(String competitionName, ReaderConfigurationDTO readerConfigurationDTO) throws ReaderServiceException {
        Assert.notNull(competitionName);
        Assert.hasText(competitionName);
        log.info("------------------------------------------------------------------");
        log.info("Timereader: Start readers for: " + competitionName + " " + readerConfigurationDTO.getHostName());

        List<ReaderEntity> readers = findReaders(competitionName);
        ReaderListenerServiceImpl readerListenerServiceImpl = new ReaderListenerServiceImpl();

        for (ReaderEntity readerEntity : readers) {
            try {
                ReaderMock reader = new ReaderMock();
                HashMap<String, TagReadData> tagDataBaseForM6 = new HashMap<String, TagReadData>();
                ReadListener rl = new RFIDReaderListener(registrationServiceImpl, readerEntity.getReaderId());

                log.info("Timereader: Reader id: " + readerEntity.getReaderId());

                readerListenerServiceImpl.addReader(reader);
            } catch (RuntimeException e) {
               throw new ReaderServiceException(e.getMessage());
            }
        }
        readerListeners.put(competitionName, readerListenerServiceImpl);
    }

    @Override
    public void stopReadersMock(String competitionName) throws ReaderServiceException {
        Assert.notNull(competitionName);
        Assert.hasText(competitionName);
        ReaderListenerServiceImpl readerListenerServiceImpl = readerListeners.get(competitionName);
        readerListeners.remove(competitionName);
    }
}
