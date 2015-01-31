
package se.rosscom.timereader.config.code;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.rosscom.timereader.jpa.*;
import se.rosscom.timereader.jpa.repository.CompetitionRepository;
import se.rosscom.timereader.jpa.repository.ReaderConfigurationRepository;
import se.rosscom.timereader.jpa.repository.ReaderRegistrationRepository;
import se.rosscom.timereader.jpa.repository.ReaderRepository;
import se.rosscom.timereader.jpa.repository.TimeReaderDbException;

public class DatabaseTests {

        public AnnotationConfigApplicationContext ctx;
        public ReaderRepository readerRepository;
        public CompetitionRepository competitionRepository;
        public ReaderRegistrationRepository readerRegistrationRepository;
        public ReaderConfigurationRepository readerConfigurationRepository;
        

        static Logger log= null;
        
        
    	@Before
	public void setUp() {
            
            log = Logger.getLogger(DatabaseTests.class.getName());
            ctx = new AnnotationConfigApplicationContext();
            ctx.getEnvironment().setDefaultProfiles("dev");
//            ctx.getEnvironment().setDefaultProfiles("production");

            ctx.register(TimeReaderRepositoryConfig.class, JndiDataConfig.class, StandaloneDataConfig.class);
            ctx.refresh();

            readerRepository = ctx.getBean(ReaderRepository.class);
            competitionRepository = ctx.getBean(CompetitionRepository.class);
            readerRegistrationRepository = ctx.getBean(ReaderRegistrationRepository.class);
            readerConfigurationRepository = ctx.getBean(ReaderConfigurationRepository.class);
            
	}
        

        @Test
	public void testSql() throws TimeReaderDbException {
 
            List<ReaderEntity> readers = readerRepository.findReadersCompetition(new Long(1));
            for (ReaderEntity reader : readers) {
                System.out.println("Reader: " + reader.getCompetitionPart().getCompetitionPartId() + " " + reader.getLap() + " " + reader.getLengthFromStart()+ " " + reader.getReaderId());
            }
            assert !readers.isEmpty();
            
            readers = readerRepository.findReaders(new Long(1));
            for (ReaderEntity reader : readers) {
                System.out.println("Reader: " + reader.getCompetitionPart().getCompetitionPartId() + " " + reader.getLap() + " " + reader.getLengthFromStart()+ " " + reader.getReaderId());
            }
            assert !readers.isEmpty();
            
            CompetitionEntity comp = competitionRepository.findByName(new String("Vansbro Marathon"));
            System.out.println(comp.getCompetitionId() + " " + comp.getCompetitionDate() + " " + comp.getCompetitionName());
            assert !comp.equals(null);
            
            java.util.Date now = new java.util.Date(); 
            
            List<ReaderConfigurationEntity> confs = readerConfigurationRepository.getReaderConf(new Long(10));
            
            for (ReaderConfigurationEntity conf : confs) {
                System.out.println("Reader confs: " + conf.getReaderId() + " " + conf.getiPAdress() + " " + conf.getReadPower() + " " + conf.getaSyncOffTime());
            }
            
           readerRegistrationRepository.addReg(new Long(10), "E2009037870201501130A0D5", new Long(1), now, now, new Long(1));

            List<ReaderRegistrationEntity> regs = readerRegistrationRepository.getReg("E2009037870201501130A0D5");
            for (ReaderRegistrationEntity reg: regs) {
                System.out.println("Regs id:" + reg.getiD() + " " + reg.getReader().getReaderId() + " " + reg.getRFID() + " " + 
                        reg.getAntennId() + " " + reg.getReaderDateTime().toString() + " " + reg.getAppDateTime().toString() + " " +
                        reg.getTimeStamp() + " " + reg.getReaderCount());
            }
            
            List<StartIdEntity> startIds = readerRegistrationRepository.fetchStartIds("Vansbro Marathon");
            for (StartIdEntity startId : startIds) {
                System.out.println("StartId:" + startId.getStartNr()+ " " + startId.getCompetitionPart().getCompetitionPartId() + " " + startId.getStartingGroup().getiD() + " " + 
                        startId.getRFID());
                
            }

        
        }
        
        

//        @Test
	public void testFindCompetition() throws TimeReaderDbException {

            CompetitionRepository competitionRepository = ctx.getBean(CompetitionRepository.class);
//            assert !competitionRepository.isEmpty();

	}
        
        @After
        public void tearDown() {
            ctx.close();
            ctx.destroy();
        }


}
