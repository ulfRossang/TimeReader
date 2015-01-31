
package se.rosscom.timereader.config;

import se.rosscom.timereader.jpa.*;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.rosscom.timereader.jpa.repository.ReaderRepository;
import se.rosscom.timereader.jpa.repository.TimeReaderDbException;

public class IntegrationTests {

//    static Logger log= null;
	@Test
	public void testFindReaders() throws TimeReaderDbException {

//            log = Logger.getLogger(IntegrationTests.class.getName());
		
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
