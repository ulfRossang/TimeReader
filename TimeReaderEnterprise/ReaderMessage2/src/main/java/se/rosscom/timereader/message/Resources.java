package se.rosscom.timereader.message;

import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;

/**
 * Application scoped JMS resources for the samples.
 * @author Patrik Dudits
 */
@JMSDestinationDefinitions({
    @JMSDestinationDefinition(
        name = Resources.READER_QUEUE,
        resourceAdapter = "jmsra",
        interfaceName = "javax.jms.Queue",
        destinationName="readerQueue",
        description="My Sync Queue"),
})
public class Resources {
    public static final String READER_QUEUE = "java:global/jms/readerQueue";
}
