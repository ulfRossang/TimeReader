//package se.rosscom.timereader.jpa;
//
//import com.github.springtestdbunit.DbUnitTestExecutionListener;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import javax.persistence.PersistenceContext;
//import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
//import org.jboss.logging.Logger;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
//import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
//import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
//import se.rosscom.timereader.jpa.repository.CompetitionRepositoryOld;
//
///**
// *
// * @author ulfrossang
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {PersistenceContext.class})
////@ContextConfiguration(locations = {"classpath:exampleApplicationContext-persistence.xml"})
//@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
//        DirtiesContextTestExecutionListener.class,
//        TransactionalTestExecutionListener.class,
//        DbUnitTestExecutionListener.class })
//public class CompetitionEntityTest {
//      
//    private final String cTestlopp = "TestLopp";
//    
//    public CompetitionEntityTest() {
//            
//        super();
//        // Mute SqlExceptionHelper log
//        Logger.getLogger(SqlExceptionHelper.class);
//    }
//
//    @Autowired
//    private CompetitionRepositoryOld repository;
//
//    @Before
//    public void setUp() throws Exception {
//
//        SimpleDateFormat format = new SimpleDateFormat("YYYY-mm-DD");
//        Date date = format.parse("2014-01-01");
//
//        repository = (CompetitionRepositoryOld) new CompetitionEntity(cTestlopp, date);
//
//    }
//    @Test
//    public void testPersist() throws Exception {
//        
//        CompetitionEntity competition = repository.find(cTestlopp);
//        System.out.println(competition.toString());
//        assert true;
//
//    }
//        
//
//}
