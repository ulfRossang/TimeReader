
package se.rosscom.timereader.config.code;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.rosscom.timereader.jpa.repository.CompetitionRepository;
import se.rosscom.timereader.jpa.repository.ReaderConfigurationRepository;
import se.rosscom.timereader.jpa.repository.ReaderRegistrationRepository;
import se.rosscom.timereader.jpa.repository.ReaderRepository;
import se.rosscom.timereader.jpa.repository.internal.JdbcCompetitionRepository;
import se.rosscom.timereader.jpa.repository.internal.JdbcReaderConfigurationRepository;
import se.rosscom.timereader.jpa.repository.internal.JdbcReaderRegistrationRepository;
import se.rosscom.timereader.jpa.repository.internal.JdbcReaderRepository;

@Configuration
public class TimeReaderRepositoryConfig {

	@Autowired DataConfig dataConfig;


	@Bean
	public ReaderRepository readerRepository() {
            return new JdbcReaderRepository(dataConfig.dataSource());
 	}

        @Bean
	public CompetitionRepository competitionRepository() {
            return new JdbcCompetitionRepository(dataConfig.dataSource());
 	}
        @Bean
	public ReaderRegistrationRepository readerRegistrationRepository() {
            return new JdbcReaderRegistrationRepository(dataConfig.dataSource());
 	}

        @Bean
	public ReaderConfigurationRepository readerConfigurationRepository() {
            return new JdbcReaderConfigurationRepository(dataConfig.dataSource());
 	}

}
