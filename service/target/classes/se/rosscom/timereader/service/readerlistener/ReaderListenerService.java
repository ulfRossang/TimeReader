package se.rosscom.timereader.service.readerlistener;

import se.rosscom.timereader.exception.ReaderServiceException;
import com.thingmagic.Reader;
import java.util.List;
import se.rosscom.timereader.service.TimeReaderService;
import se.rosscom.timereader.serviceimpl.reader.ReaderMock;

/**
 *
 * @author ulfrossang
 */
public interface ReaderListenerService extends TimeReaderService {
    
    void addReader(Reader reader) throws ReaderServiceException;
    void removeReader(Reader reader) throws ReaderServiceException;
    List<Reader> fetchReaders() throws ReaderServiceException;
    List<ReaderMock> fetchReaderMocks() throws ReaderServiceException;
    
    void addReader(ReaderMock reader) throws ReaderServiceException;
    void removeReader(ReaderMock reader) throws ReaderServiceException;  
    
}
