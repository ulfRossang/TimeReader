
package se.rosscom.timereader.jpa;

import java.util.List;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.rosscom.timereader.config.JndiDataConfig;
import se.rosscom.timereader.config.StandaloneDataConfig;
import se.rosscom.timereader.jpa.repository.ReaderRepository;
import se.rosscom.timereader.jpa.repository.TimeReaderDbException;

public class IntegrationTests {

	@Test
	public void testFindReaders() throws TimeReaderDbException {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setDefaultProfiles("dev");
                
		ctx.register(StandaloneDataConfig.class);
                
//		ctx.register(StandaloneDataConfig.class, JndiDataConfig.class);
		ctx.refresh();

		ReaderRepository readerRepository = ctx.getBean(ReaderRepository.class);
                List<ReaderEntity> readers = readerRepository.findReaders(new Long(1));
                assert !readers.isEmpty();

	}

}
