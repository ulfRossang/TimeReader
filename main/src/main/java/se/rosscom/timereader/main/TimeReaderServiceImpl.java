package se.rosscom.timereader.main;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.LogManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.rosscom.timereader.config.TimeReaderServiceConfig;
import se.rosscom.timereader.config.code.JndiDataConfig;
import se.rosscom.timereader.exception.ReaderServiceException;
import se.rosscom.timereader.service.TimeReaderService;
import se.rosscom.timereader.service.reader.ReaderService;


/**
 *
 * @author ulfrossang
 */
public class TimeReaderServiceImpl implements TimeReaderService, Runnable {

    private static volatile boolean running = false;
    private AnnotationConfigApplicationContext ctx;
    ReaderService readerService;
    static final org.apache.log4j.Logger logger = LogManager.getLogger("TimeReaderServiceImpl");



    @Override
    public void run() {
        logger.info("running");

        ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setDefaultProfiles("production");
        ctx.register(TimeReaderServiceConfig.class, JndiDataConfig.class);
        ctx.refresh();
        readerService = ctx.getBean(ReaderService.class);
        try {
//            readerService.startReaders("Vansbro Marathon");
            readerService.startReadersMock("Vansbro Marathon");
            
        } catch (ReaderServiceException ex) {
//            Logger.getLogger(TimeReaderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void stop() {
       
        try {
            readerService.stopReaders("Vansbro Marathon");
//            readerService.stopReadersMock("Vansbro Marathon");
            
        } catch (ReaderServiceException ex) {
        }
    }
}

