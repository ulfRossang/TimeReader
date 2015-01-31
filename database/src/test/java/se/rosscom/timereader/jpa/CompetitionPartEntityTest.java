//
//package se.rosscom.timereader.jpa;
//
//import com.github.springtestdbunit.DbUnitTestExecutionListener;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
//import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
//import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
//
//import java.util.List;
//import javax.persistence.PersistenceContext;
//
//import static org.hamcrest.Matchers.is;
//import static org.junit.Assert.assertThat;
//import org.junit.Before;
//import se.rosscom.timereader.jpa.repository.CompetitionPartRepository;
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
//public class CompetitionPartEntityTest {
//    
//    private final String cTestlopp = "TestLopp";
//    private final String cTestlopp1 = "TestLopp1";
//    private final String cLength = "Length";
//
//    @Autowired
//    private CompetitionPartRepository repository;
//    
//    @Before
//    public void setUp() throws Exception {
//        SimpleDateFormat format = new SimpleDateFormat("YYYY-mm-DD");
//        Date date = format.parse("2014-01-01");
//        CompetitionEntity competition =  new CompetitionEntity(cTestlopp, date);
//
//        repository = (CompetitionPartRepository) new CompetitionPartEntity(competition, 1l, cTestlopp1, 10d, cLength, null);
//
//    }
//
//    @Test
//    public void testPersist() throws Exception {
//        
//        List<CompetitionPartEntity> competitionParts = repository.find(cTestlopp);
//        System.out.println(competitionParts.toString());
//        assertThat(competitionParts.size(), is(0));
//
//    }
//
//}