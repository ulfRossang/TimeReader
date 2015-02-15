package se.rosscom.timereader.service.reader;


import se.rosscom.timereader.exception.ReaderServiceException;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import se.rosscom.timereader.jpa.ReaderEntity;
import se.rosscom.timereader.service.ServiceTestConfig;

public class ReaderServiceTests {

    private ReaderService readerService;
    private ServiceTestConfig serviceTestConfig;
        
        
	@Before
	public void setUp() {
            
            serviceTestConfig = new ServiceTestConfig();
            readerService = serviceTestConfig.readerService;

	}
        
	@Test
	public void testReader() throws ReaderServiceException {    
                        
            List<ReaderEntity> readers = readerService.findReaders("Vansbro Marathon");
            for (ReaderEntity readerEntity : readers) {
                System.out.println("Readers: "+readerEntity.getReaderId() + " " + readerEntity.getLap() + " " + readerEntity.getReaderType()+ " " +readerEntity.getLengthFromStart()+ " ");
            }
            assertThat(readers.size(), equalTo(1));
            
                        
            readerService.startReadersMock("Vansbro Marathon");
            System.out.println("StartReaderOk!");
            assert true;
            
                        
            readerService.stopReadersMock("Vansbro Marathon");
            System.out.println("StopReaderOk!");
            assert true;
            
        }    

//	@Test
	public void testFindReaders() throws ReaderServiceException {

            List<ReaderEntity> readers = readerService.findReaders("Vansbro Marathon");
            for (ReaderEntity readerEntity : readers) {
                System.out.println("Readers: "+readerEntity.getReaderId() + " " + readerEntity.getLap() + " " + readerEntity.getReaderType()+ " " +readerEntity.getLengthFromStart()+ " ");
            }
            assertThat(readers.size(), equalTo(1));
	}
        
//        @Test
	public void testStartReadersMock() throws ReaderServiceException {

            readerService.startReadersMock("Vansbro Marathon");
            assert true;
	}
        
        
//        @Test(expected = ReaderServiceException.class)
        public void testStartReadersNoConnection() throws ReaderServiceException {

            readerService.startReaders("Vansbro Marathon");
	}    
        
       // @Test
        public void testStopReadersMock() throws ReaderServiceException {
            readerService.startReadersMock("Vansbro Marathon");
            readerService.stopReadersMock("Vansbro Marathon");
            assert true;
        }
//        @Test
	public void testStopReaders() throws ReaderServiceException {

            readerService.stopReaders("Vansbro Marathon");
            assert true;
	}    
        
        //        @Test
	public void testStartReadersIT() throws ReaderServiceException {

            readerService.startReaders("Vansbro Marathon");
            assert true;
            
            readerService.stopReaders("Vansbro Marathon");
            assert true;
	}
        
//        @Test
	public void testStopReadersIT() throws ReaderServiceException {

            readerService.stopReaders("Vansbro Marathon");
            assert true;
	}   
       
}
