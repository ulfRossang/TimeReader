package se.rosscom.timereader.message;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.jms.JMSException;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import se.rosscom.timereader.exception.ReaderMessageException;
import se.rosscom.timereader.exception.TimeReaderException;

@RunWith(Arquillian.class)
public class ReaderTest {

    @EJB
    @Inject
    ReaderMessageSender readerSender;

    @Test
    public void testReaderMessage() throws ReaderMessageException, JMSException {
        String message = "The test message for reader queue";
        
        // To be done
//        readerSender.sendMessage(message);

//        assertEquals(message, readerReceiver.receiveMessage());
    }

//    @Deployment
//    public static WebArchive deploy() {
//        WebArchive war = ShrinkWrap.create(WebArchive.class)
//                .addClass(ReaderMessageSender.class)
//                .addClass(Resources.class)
//                .addClass(ReaderMessageException.class)
//                .addClass(TimeReaderException.class)
//                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
//            System.out.println(war.toString(true));
//        return war;
//    }

}
