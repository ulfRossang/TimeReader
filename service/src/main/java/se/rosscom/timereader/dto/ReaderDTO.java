/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.rosscom.timereader.dto;

import java.math.BigDecimal;

/**
 *
 * @author ulfrossang
 */
public class ReaderDTO {
    
    private long readerId;
    private int lap;
    private long competitionPartId;
    private String readerType;
    private BigDecimal lengthFromStart;


    public long getReaderId() {
        return readerId;
    }

    public void setReaderId(long readerId) {
        this.readerId = readerId;
    }

    public int getLap() {
        return lap;
    }

    public void setLap(int lap) {
        this.lap = lap;
    }

    public long getCompetitionPartId() {
        return competitionPartId;
    }

    public void setCompetitionPartId(long competitionPartId) {
        this.competitionPartId = competitionPartId;
    }

    public String getReaderType() {
        return readerType;
    }

    public void setReaderType(String readerType) {
        this.readerType = readerType;
    }

    public BigDecimal getLengthFromStart() {
        return lengthFromStart;
    }

    public void setLengthFromStart(BigDecimal lengthFromStart) {
        this.lengthFromStart = lengthFromStart;
    }
    
}
