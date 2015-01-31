//package se.rosscom.timereader.jpa;
//
//import org.junit.After;
//import org.junit.Before;
//
//import java.util.List;
//import se.rosscom.timereader.test.InMemoryPersistence;
//
//public class ClientAuthorizationEntityTest {
//
//    private InMemoryPersistence persistence;
//
//
//    @Before
//    public void setUp() throws Exception {
//         persistence = new InMemoryPersistence();
//    }
//
//    public void testPersist() throws Exception {
//        
//        List<ClientAuthorizationEntity> clientAuthorizations = persistence.createQuery("select c from ClientAuthorizationEntity c ").getResultList();
//        for (ClientAuthorizationEntity clientAuthorization : clientAuthorizations) {
//            System.out.println(clientAuthorization.toString());
//            assert true;
//        }
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        persistence.close();
//    }
//
//}
