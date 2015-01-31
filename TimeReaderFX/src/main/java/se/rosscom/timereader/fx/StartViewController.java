package se.rosscom.timereader.fx;

import static java.lang.Boolean.TRUE;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.datafx.controller.FXMLController;
import org.datafx.controller.flow.action.ActionMethod;
import org.datafx.controller.flow.action.FXMLFlowAction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.rosscom.timereader.config.TimeReaderServiceConfig;
import se.rosscom.timereader.config.TimeReaderServiceRepositoryConfig;
import se.rosscom.timereader.config.code.JndiDataConfig;
import se.rosscom.timereader.exception.ReaderServiceException;
import se.rosscom.timereader.jpa.ReaderEntity;
import se.rosscom.timereader.jpa.repository.CompetitionRepository;
import se.rosscom.timereader.jpa.repository.ReaderRegistrationRepository;
import se.rosscom.timereader.jpa.repository.ReaderRepository;
import se.rosscom.timereader.service.reader.ReaderService;

@FXMLController("/fxml/SceneStart.fxml")
public class StartViewController {

    @FXML
    @FXMLFlowAction("start")
    private Button startButton;

    @Inject
    private DataModel model;
    private ReaderRepository readerRepository;
    private CompetitionRepository competitionRepository;
    private ReaderRegistrationRepository readerRegistrationRepository;
    private ReaderService readerService;

    @PostConstruct
    public void init() {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setDefaultProfiles("production");
        ctx.register(TimeReaderServiceRepositoryConfig.class);
        ctx.register(TimeReaderServiceConfig.class, JndiDataConfig.class);
        ctx.refresh();

        readerService = ctx.getBean(ReaderService.class);  
        model.setReaderService(readerService);

    }
    
    @ActionMethod("startReader")
    public void startReader() throws ReaderServiceException {
        model.getReaderService().startReaders("Vansbro Marathon");
        model.setReaderStarted(TRUE);
        List<ReaderEntity> readers = model.getReaderService().findReaders("Vansbro Marathon");
        for (ReaderEntity reader : readers) {
            System.out.println("TimeReaderFX startReader reader:" + reader.getReaderId());
        }
        System.out.println("actionStart");
    }


}
