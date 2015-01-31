package se.rosscom.timereader.serviceimpl.readerlistener;

import com.thingmagic.Reader;
import java.util.ArrayList;
import java.util.List;
import se.rosscom.timereader.exception.ReaderServiceException;
import se.rosscom.timereader.service.readerlistener.ReaderListenerService;
import se.rosscom.timereader.serviceimpl.reader.ReaderMock;

public class ReaderListenerServiceImpl implements ReaderListenerService {

    private final List<Reader> readers;
    private final List<ReaderMock> readerMocks;
    

//    @Inject
    
    public ReaderListenerServiceImpl() {
        this.readers = new ArrayList<>();
        this.readerMocks = new ArrayList<>();

    }
    


    @Override
    public void addReader(Reader reader) throws ReaderServiceException {
        readers.add(reader);
    }

    @Override
    public void removeReader(Reader reader) throws ReaderServiceException {
        readers.remove(reader);
    }

    @Override
    public List<Reader> fetchReaders() throws ReaderServiceException {
        if (readers!=null) {
            return readers;
        } else {
            throw new ReaderServiceException("No reader found at competition: ");            
        }
    }

    @Override
    public List<ReaderMock> fetchReaderMocks() throws ReaderServiceException {
        if (readerMocks!=null) {
            return readerMocks;
        } else {
            throw new ReaderServiceException("No reader found at competition: ");            
        }
    }
    
    @Override
    public void addReader(ReaderMock reader) throws ReaderServiceException {
        readerMocks.add(reader);
    }

    @Override
    public void removeReader(ReaderMock reader) throws ReaderServiceException {
        readers.remove(reader);
    }

}
