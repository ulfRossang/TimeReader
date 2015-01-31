package se.rosscom.timereader.fx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.datafx.controller.FXMLController;
import org.datafx.controller.flow.action.FXMLFlowAction;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.datafx.controller.flow.action.ActionMethod;
import se.rosscom.timereader.exception.ReaderServiceException;

@FXMLController("/fxml/SceneStop.fxml")
public class StopViewController {

    @FXML
    @FXMLFlowAction("stop")
    private Button stopButton;


    @Inject
    private DataModel model;

    @PostConstruct
    public void init() {

    }
    
    @ActionMethod("stopReader")
    public void stopReader() throws ReaderServiceException {
        if (model.getReaderStarted()) {
            model.getReaderService().stopReaders("Vansbro Marathon");
            System.out.println("actionStop");
        } else {
            System.out.println("already stopped");
        }
    }
    

}
