package se.rosscom.timereader.service.reader;


import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import se.rosscom.timereader.exception.ReaderServiceException;
import se.rosscom.timereader.service.IntegrationTests;
import se.rosscom.timereader.service.ServiceTestConfig;

@Category(IntegrationTests.class)
public class ReaderServiceIntegrationTests implements IntegrationTests {

    private ReaderService readerService;
        
        
	@Before
	public void setUp() {
            
            ServiceTestConfig serviceTestConfig = new ServiceTestConfig();
            readerService = serviceTestConfig.readerService;

	}

        @Test(expected = ReaderServiceException.class)
        public void testStartReadersNoConnection() throws ReaderServiceException {

            readerService.startReaders("Vansbro Marathon");
	}    
        
        
        @Test
	public void testStartReadersIT() throws ReaderServiceException {

            readerService.startReaders("Vansbro Marathon");
            assert true;
            
            readerService.stopReaders("Vansbro Marathon");
            assert true;
	}
        

}
