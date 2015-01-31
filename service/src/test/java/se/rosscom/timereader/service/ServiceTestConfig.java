
package se.rosscom.timereader.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.rosscom.timereader.config.TimeReaderServiceConfig;
import se.rosscom.timereader.config.TimeReaderServiceRepositoryConfig;
import se.rosscom.timereader.config.code.JndiDataConfig;
import se.rosscom.timereader.jpa.repository.CompetitionRepository;
import se.rosscom.timereader.jpa.repository.ReaderRegistrationRepository;
import se.rosscom.timereader.jpa.repository.ReaderRepository;
import se.rosscom.timereader.service.reader.ReaderService;
import se.rosscom.timereader.service.readerlistener.ReaderListenerService;
import se.rosscom.timereader.service.registration.RegistrationService;

public class ServiceTestConfig {

    public ReaderService readerService;
    public ReaderListenerService readerlistenerService;
    public RegistrationService registrationService;
    public ReaderRepository readerRepository;
    public CompetitionRepository competitionRepository;
    public ReaderRegistrationRepository readerRegistrationRepository;
    

    public ServiceTestConfig() {
    
            AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
            ctx.getEnvironment().setDefaultProfiles("dev");
//            ctx.getEnvironment().setDefaultProfiles("production");
            ctx.register(TimeReaderServiceRepositoryConfig.class);
            ctx.register(TimeReaderServiceConfig.class, JndiDataConfig.class);
            ctx.refresh();

            readerService = ctx.getBean(ReaderService.class);
            readerlistenerService = ctx.getBean(ReaderListenerService.class);
            registrationService = ctx.getBean(RegistrationService.class);
            readerRepository = ctx.getBean(ReaderRepository.class);
            competitionRepository = ctx.getBean(CompetitionRepository.class);
            readerRegistrationRepository = ctx.getBean(ReaderRegistrationRepository.class);

	}

}
