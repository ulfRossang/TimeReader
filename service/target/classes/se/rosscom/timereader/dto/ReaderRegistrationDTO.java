package se.rosscom.timereader.dto;

import java.util.Date;

/**
 *
 * @author ulfrossang
 */
public class ReaderRegistrationDTO implements TransferObject{
    
    private int ReaderId;
    private String RFID;
    private int AntennId;
    private Date ReaderDatetime;
    private int ReaderCount;

    public int getReaderId() {
        return ReaderId;
    }

    public void setReaderId(int ReaderId) {
        this.ReaderId = ReaderId;
    }

    public String getRFID() {
        return RFID;
    }

    public void setRFID(String RFID) {
        this.RFID = RFID;
    }

    public int getAntennId() {
        return AntennId;
    }

    public void setAntennId(int AntennId) {
        this.AntennId = AntennId;
    }

    public Date getReaderDatetime() {
        return ReaderDatetime;
    }

    public void setReaderDatetime(Date ReaderDatetime) {
        this.ReaderDatetime = ReaderDatetime;
    }

    public int getReaderCount() {
        return ReaderCount;
    }

    public void setReaderCount(int ReaderCount) {
        this.ReaderCount = ReaderCount;
    }
    
    
    @Override
    public String toString() {
        
        return getReaderId() + " " + getAntennId() + " " + getRFID() + " " + getReaderDatetime() + " " + getReaderCount();

    }
}
