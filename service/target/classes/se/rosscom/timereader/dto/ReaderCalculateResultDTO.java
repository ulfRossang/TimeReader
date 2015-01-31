/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.rosscom.timereader.dto;

import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import se.rosscom.timereader.jpa.ReaderEntity;

/**
 *
 * @author ulfrossang
 */
public class ReaderCalculateResultDTO {
    
    private ReaderRegistrationDTO readerRegistrationDTO;
    private HashMap<String, Long> startMap;
    private List<ReaderDTO> readers;
    
//    @Inject
    public ReaderCalculateResultDTO(ReaderRegistrationDTO readerRegistrationDTO, HashMap<String, Long> startMap, List<ReaderDTO> readers) {
        this.readerRegistrationDTO = readerRegistrationDTO;
        this.startMap = startMap;
        this.readers = readers;
        
    }

    public ReaderCalculateResultDTO() {
        // Default
    }

    public ReaderRegistrationDTO getReaderRegistrationDTO() {
        return readerRegistrationDTO;
    }

    public void setReaderRegistrationDTO(ReaderRegistrationDTO readerRegistrationDTO) {
        this.readerRegistrationDTO = readerRegistrationDTO;
    }

    public HashMap<String, Long> getStartMap() {
        return startMap;
    }

    public void setStartMap(HashMap<String, Long> startMap) {
        this.startMap = startMap;
    }

    public List<ReaderDTO> getReaders() {
        return readers;
    }

    public void setReaders(List<ReaderDTO> readers) {
        this.readers = readers;
    }


    
    
    
}
