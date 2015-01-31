package se.rosscom.timereader.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("production")
public class JndiDataConfig implements DataConfig {

	@Bean
	public DataSource dataSource() {
		try {
			Context ctx = new InitialContext();
			return (DataSource) ctx.lookup("java:com/env/jdbc/RFIDReader");
		} catch (NamingException ex) {
			throw new RuntimeException(ex);
		}
	}

}
