package se.rosscom.timereader.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.datafx.controller.flow.DefaultFlowContainer;
import org.datafx.controller.flow.Flow;
import org.datafx.controller.flow.action.FlowActionChain;
import org.datafx.controller.flow.action.FlowLink;
import org.datafx.controller.flow.action.FlowMethodAction;

public class MainTimeReader extends Application {
        

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Flow flow = new Flow(StartViewController.class).
                withAction(StartViewController.class, "start", new FlowActionChain(new FlowMethodAction("startReader"), new FlowLink<>(StopViewController.class))).
                withAction(StopViewController.class, "stop", new FlowActionChain(new FlowMethodAction("stopReader"), new FlowLink<>(StartViewController.class)));


        DefaultFlowContainer container = new DefaultFlowContainer();
        flow.createHandler().start(container);
        
        Scene scene = new Scene(container.getPane());
        scene.getStylesheets().add("styles/Styles.css");
        stage.setTitle("Time Reader");
       
        stage.setScene(scene);
        stage.show();


    }

}
