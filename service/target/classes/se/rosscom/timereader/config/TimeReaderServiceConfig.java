package se.rosscom.timereader.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import se.rosscom.timereader.exception.ReaderServiceException;
import se.rosscom.timereader.jpa.repository.CompetitionRepository;
import se.rosscom.timereader.jpa.repository.ReaderRegistrationRepository;
import se.rosscom.timereader.jpa.repository.ReaderRepository;
import se.rosscom.timereader.service.reader.ReaderService;
import se.rosscom.timereader.service.readerlistener.ReaderListenerService;
import se.rosscom.timereader.service.registration.RegistrationService;
import se.rosscom.timereader.serviceimpl.reader.ReaderServiceImpl;
import se.rosscom.timereader.serviceimpl.readerlistener.ReaderListenerServiceImpl;
import se.rosscom.timereader.serviceimpl.registration.RegistrationServiceImpl;

@Configuration
@ComponentScan ("se.rosscom.timereader")
public class TimeReaderServiceConfig {

        @Autowired
        ReaderRepository readerRepository;
          
        @Autowired
        CompetitionRepository competitionRepository;
          
        @Autowired
        ReaderRegistrationRepository readerRegistrationRepository;
        

	@Bean
	public ReaderService readerService() throws ReaderServiceException {
		return new ReaderServiceImpl(readerRepository, competitionRepository,  (RegistrationServiceImpl) registrationService());
	}

	@Bean
	public ReaderListenerService readerListenerService() {
		return new ReaderListenerServiceImpl();
	}
        
	@Bean
	public RegistrationService registrationService() throws ReaderServiceException {
		return new RegistrationServiceImpl(readerRegistrationRepository);
	}

}
