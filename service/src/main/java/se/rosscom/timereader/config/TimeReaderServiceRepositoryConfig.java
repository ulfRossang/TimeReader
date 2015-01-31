package se.rosscom.timereader.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import se.rosscom.timereader.config.code.TimeReaderRepositoryConfig;
import se.rosscom.timereader.jpa.repository.CompetitionRepository;
import se.rosscom.timereader.jpa.repository.ReaderRegistrationRepository;
import se.rosscom.timereader.jpa.repository.ReaderRepository;

@Configuration
@ComponentScan ("se.rosscom.timereader")
public class TimeReaderServiceRepositoryConfig {

	@Autowired TimeReaderRepositoryConfig repositroyConfig;
        
	@Bean
	public ReaderRepository readerRepository() {
		return repositroyConfig.readerRepository();
	}
        @Bean
	public CompetitionRepository competitionRepository() {
		return repositroyConfig.competitionRepository();
	}

        @Bean
	public ReaderRegistrationRepository readerRegistrationRepository() {
		return repositroyConfig.readerRegistrationRepository();
	}



}
