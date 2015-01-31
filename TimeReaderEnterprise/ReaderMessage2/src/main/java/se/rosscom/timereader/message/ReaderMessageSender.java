
package se.rosscom.timereader.message;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSRuntimeException;
import javax.jms.Queue;
import se.rosscom.timereader.dto.ReaderRegistrationDTO;
import se.rosscom.timereader.exception.ReaderMessageException;
/**
 * Sending a readermessage.
 * @author Ulf Rossäng
 */
@Stateless
public class ReaderMessageSender {

    @Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
    ConnectionFactory connectionFactory;
    @Inject
    JMSContext context;
    
    @Resource(mappedName = Resources.READER_QUEUE)
    Queue readerQueue;

    public void sendMessage(String message) throws ReaderMessageException, JMSException {
        try (JMSContext context = connectionFactory.createContext();){
            context.createProducer().send(readerQueue, message);
        } catch (JMSRuntimeException ex) {
            // handle exception (details omitted)
        }
    }
}
