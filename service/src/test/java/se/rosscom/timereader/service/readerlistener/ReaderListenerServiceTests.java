package se.rosscom.timereader.service.readerlistener;


import se.rosscom.timereader.exception.ReaderServiceException;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import se.rosscom.timereader.service.ServiceTestConfig;
import se.rosscom.timereader.serviceimpl.reader.ReaderMock;

public class ReaderListenerServiceTests {

    private ReaderListenerService readerListenerService;
        
        
	@Before
	public void setUp() throws ReaderServiceException {
            
            ServiceTestConfig serviceTestConfig = new ServiceTestConfig();
            readerListenerService = serviceTestConfig.readerlistenerService;
            ReaderMock reader = new ReaderMock();
            readerListenerService.addReader(reader);
            

	}

        
	@Test
	public void testAddReader() throws ReaderServiceException {
            ReaderMock reader = new ReaderMock();
            readerListenerService.addReader(reader);
            assert true;
	}
        
        @Test
	public void testFetchReaderMocks() throws ReaderServiceException {
    
            
            List<ReaderMock> readerMocks = readerListenerService.fetchReaderMocks();
            assertThat(readerMocks.size(), equalTo(1));
	}
}
