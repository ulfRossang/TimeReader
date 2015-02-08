package se.rosscom.timereader.service.registration;


import java.util.Date;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import se.rosscom.timereader.dto.ReaderRegistrationDTO;
import se.rosscom.timereader.exception.ReaderServiceException;
import se.rosscom.timereader.service.ServiceTestConfig;

public class ReaderRegistrationServiceTests {

    private RegistrationService registrationService;
    private ReaderRegistrationDTO reg;
        
        
	@Before
	public void setUp() throws ReaderServiceException {
            
            ServiceTestConfig serviceTestConfig = new ServiceTestConfig();
            registrationService = serviceTestConfig.registrationService;
            reg = new ReaderRegistrationDTO();
            reg.setReaderId(10);
            reg.setRFID("E2009037870201501130A0D5");
            reg.setAntennId(1);
            reg.setReaderCount(1);
            reg.setReaderDatetime(new Date());
	}

//        @Test
	public void testReaderRegistration() throws ReaderServiceException {
            //regTag
            registrationService.regTag(reg);
            System.out.println("regTagOk!");
            assert true;
            
            // loadStartid
            HashMap<String, Long> startIds = registrationService.loadStartIds("Vansbro Marathon");
            if (!startIds.isEmpty()) {
                System.out.println(startIds.values());
            }
            
        }        
//	@Test
//	public void testRegTag() throws ReaderServiceException {
//            registrationService.regTag(reg);
//            assert true;
//	}
//        
//        
//        @Test
//        public void testLoadStartId() throws ReaderServiceException {
//            HashMap<String, Long> startIds = registrationService.loadStartIds("Vansbro Marathon");
//            if (!startIds.isEmpty()) {
//                System.out.println(startIds.values());
//            }
//        }
        
}
