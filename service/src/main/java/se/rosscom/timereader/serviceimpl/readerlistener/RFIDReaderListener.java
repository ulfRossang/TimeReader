package se.rosscom.timereader.serviceimpl.readerlistener;


import com.thingmagic.ReadListener;
import com.thingmagic.Reader;
import com.thingmagic.TagReadData;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import se.rosscom.timereader.dto.ReaderRegistrationDTO;
import se.rosscom.timereader.exception.ReaderServiceException;
import se.rosscom.timereader.serviceimpl.registration.RegistrationServiceImpl;

/**
 *
 * @author ulfrossang
 */
public class RFIDReaderListener implements ReadListener {

    private final RegistrationServiceImpl registrationServiceImpl;
    static final Logger log = Logger.getLogger(RFIDReaderListener.class.getName());
    public static Long readerId;

    
    public RFIDReaderListener (RegistrationServiceImpl registrationServiceImpl, Long readerId) {
        Assert.notNull(readerId);
      
        this.registrationServiceImpl = registrationServiceImpl;
        RFIDReaderListener.readerId = readerId;
    }
    
    @Override
    public void tagRead(Reader r, TagReadData tr) {
      
        ReaderRegistrationDTO reg = new ReaderRegistrationDTO();
        reg.setReaderId(RFIDReaderListener.readerId.intValue());
        reg.setAntennId(tr.getAntenna());
        reg.setRFID(tr.epcString());
        reg.setReaderDatetime(new Date(tr.getTime()));
        reg.setReaderCount(tr.getReadCount());
        log.info("Timereader tag: "+reg.toString());

        if (tr.getReadCount() == 1) {
            try {
                registerTag(reg);
            } catch (ReaderServiceException ex) {
             log.error("Timereader: Error registerTag: "+ reg.getReaderId() + " "+ ex.getMessage());
            }
        }
    }
    
    public void registerTag(ReaderRegistrationDTO reg) throws ReaderServiceException {

        registrationServiceImpl.regTag(reg);
        
    }
}
