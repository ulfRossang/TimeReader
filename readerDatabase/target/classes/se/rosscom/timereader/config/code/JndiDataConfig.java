
package se.rosscom.timereader.config.code;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Profile("production")
public class JndiDataConfig implements DataConfig {

	@Bean
        @Override
	public DataSource dataSource() {
            try {
                    
                DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
                driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
                driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/RFIDReader");
                driverManagerDataSource.setUsername("ulfrossang");
                driverManagerDataSource.setPassword("vansbro");

                return driverManagerDataSource;

            } catch (Exception ex) {
                    throw new RuntimeException(ex);
            }
	}

}
