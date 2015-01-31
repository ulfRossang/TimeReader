package se.rosscom.timereader.serviceimpl.reader;

import com.thingmagic.Gen2;
import com.thingmagic.Reader;
import com.thingmagic.ReaderException;
import com.thingmagic.SimpleReadPlan;
import com.thingmagic.TagProtocol;
import se.rosscom.timereader.dto.ReaderConfigurationDTO;
import se.rosscom.timereader.exception.ReaderServiceException;

/**
 *
 * @author ulfrossang
 */
public class TimeReaderImpl {
    
    final Reader reader;
    /**
     * Create, configure and connect to reader
     * 
     * Define the antenna port list to use for the reads
     * Define a read plan that will be execute when the reader is reading
     * Set a timeout the host waits for transport messages to and from the reader
     * Useful for slow processors
     * set asynchOffTime to 0 to enable continous streaming mode of operation
     * Useful for slow processors
     * Get User Profile
     * Set the appropiate regulatory region setting for the region of operation
     * Set the gen2 Session to 1 Allows reading of more than a single tag in the field
     * and does not put the tag to sleep for a long time so that the next read poit can read the tag.
     * Set the gen2 tag encoding scheme to the fastest data rate
     * Set the gen2 backcatter link frequency to the fastest link rate
     * Set the read power upto 3150cdBm depending on choice of antenna and area RF regulations
     * 
     * @param readerConfigurationDTO
     * @throws ReaderServiceException 
     */
    public TimeReaderImpl(final ReaderConfigurationDTO readerConfigurationDTO) throws ReaderServiceException {
        
        try {
            int[] antennas = new int[] {1,2,3,4};
            TagProtocol tagProto = TagProtocol.GEN2;
            SimpleReadPlan readPlan = new SimpleReadPlan(antennas, tagProto);
            
            try {
                reader = Reader.create("tmr://" + readerConfigurationDTO.getHostName());
                reader.connect();
            } catch (ReaderException e) {
                throw new ReaderServiceException("Reader connect failed",e);
            }            
            reader.paramSet("/reader/transportTimeout", 5000);
            reader.paramSet("/reader/read/asyncOffTime", readerConfigurationDTO.getAsyncOffTime());
            reader.paramSet("/reader/tagop/protocol", TagProtocol.GEN2);
            Object region = reader.paramGet("/reader/region/id");
            Object proto = reader.paramGet("/reader/tagop/protocol");
            Reader.Region regionToSet = Reader.Region.EU2;
            reader.paramSet("/reader/gen2/Session", Gen2.Session.S1);
            reader.paramSet("/reader/gen2/tagencoding", Gen2.TagEncoding.FM0);
            reader.paramSet("/reader/gen2/blf", Gen2.LinkFrequency.LINK640KHZ);
            reader.paramSet("/reader/read/plan", readPlan);
            reader.paramSet("/reader/radio/readPower", readerConfigurationDTO.getReadPower());
           
        } catch (com.thingmagic.ReaderCommException rc) {
            throw new ReaderServiceException("Reader communication failed",rc);
            
        } catch (ReaderException re) {
            throw new ReaderServiceException("Reader communication failed",re);
        
        } catch (RuntimeException e) {
            throw new ReaderServiceException("Other communication failed",e);

        }
    }
    
    
    
    

    
}
