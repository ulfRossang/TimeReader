package se.rosscom.timereader.fx;

import org.datafx.controller.flow.injection.FlowScoped;
import se.rosscom.timereader.service.reader.ReaderService;

@FlowScoped
public class DataModel {

    
    private ReaderService readerService;
    private Boolean readerStarted;



    public Boolean getReaderStarted() {
        return readerStarted;
    }

    public void setReaderStarted(Boolean readerStarted) {
        this.readerStarted = readerStarted;
    }

    public ReaderService getReaderService() {
        return readerService;
    }

    public void setReaderService(ReaderService readerService) {
        this.readerService = readerService;
    }

}
