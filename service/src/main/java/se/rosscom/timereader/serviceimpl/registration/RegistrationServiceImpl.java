/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.rosscom.timereader.serviceimpl.registration;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import se.rosscom.timereader.dto.ReaderCalculateResultDTO;
import se.rosscom.timereader.dto.ReaderRegistrationDTO;
import se.rosscom.timereader.exception.ReaderServiceException;
import se.rosscom.timereader.jpa.StartIdEntity;
import se.rosscom.timereader.jpa.repository.ReaderRegistrationRepository;
import se.rosscom.timereader.service.registration.RegistrationService;

/**
 *
 * @author ulfrossang
 */
public class RegistrationServiceImpl implements RegistrationService {
    
    private final ReaderRegistrationRepository readerRegistrationRepository;
    private HashMap<String, Long> startMap = null;
    static final Logger log = Logger.getLogger(RegistrationServiceImpl.class.getName());
//    private ReaderMessageSender sender;
    
    

    public RegistrationServiceImpl(ReaderRegistrationRepository readerRegistrationRepository) throws ReaderServiceException {
        this.readerRegistrationRepository = readerRegistrationRepository;
        this.startMap = loadStartIds("Vansbro Marathon");
    }
    
    @Override
    public void regTag(ReaderRegistrationDTO readerRegistration) throws ReaderServiceException {
        log.info("Timereader reg tag. StartNr: " + startMap.get(readerRegistration.getRFID()) + " RFID: " + readerRegistration.getRFID() + " Time: " + readerRegistration.getReaderDatetime() );
        readerRegistrationRepository.addReg((long) readerRegistration.getReaderId(), readerRegistration.getRFID(), (long) readerRegistration.getAntennId(), readerRegistration.getReaderDatetime(), new Date(), (long) readerRegistration.getReaderCount());
//        try {
//            sender.sendMessage(readerRegistration.toString());
//        } catch (ReaderMessageException ex) {
//            Logger.getLogger(RegistrationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (JMSException ex) {
//            Logger.getLogger(RegistrationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @Override
    public HashMap<String, Long> loadStartIds(String competitionName) throws ReaderServiceException {
        List<StartIdEntity> startids = readerRegistrationRepository.fetchStartIds(competitionName);
        
        HashMap<String, Long> startMap = new HashMap<>();
        for (StartIdEntity start : startids) {
            startMap.put(start.getRFID(), start.getStartNr());
            
        }
        return startMap;
    }
    
    public Long calculateResult(ReaderCalculateResultDTO readerCalculateResultDTO) throws ReaderServiceException {
        
        /**
         * ge mig startid:t
         * 
         */
        return new Long(0);
    } 

    @Override
    public Long calculateResult(ReaderRegistrationDTO readerRegistrationDTO, HashMap<String, Long> startMap) throws ReaderServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
