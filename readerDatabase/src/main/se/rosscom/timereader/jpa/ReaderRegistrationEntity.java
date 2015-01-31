package se.rosscom.timereader.jpa;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author ulfrossang
 */

@Entity
@Table(name = "ReaderRegistration")
@Indexed

public class ReaderRegistrationEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
    @Column (name = "Id")
    private long iD;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ReaderID")
    private ReaderConfigurationEntity reader;

    @Column (name = "RFID")
    private String RFID;

    @Basic
    @Column (name = "AntennID")
    private long antennId;

    @Basic
    @Column (name = "ReaderDateTime")
    private Date readerDateTime;
    
    @Basic
    @Column (name = "AppDateTime")
    private Date appDateTime;

    @Basic
    @Column (name = "TimeStamp")
    private Timestamp timeStamp;
    
    @Basic
    @Column (name = "ReaderCount")
    private long readerCount;

    public long getiD() {
        return iD;
    }

    public void setiD(long iD) {
        this.iD = iD;
    }

    public ReaderConfigurationEntity getReader() {
        return reader;
    }

    public void setReader(ReaderConfigurationEntity reader) {
        this.reader = reader;
    }

    public String getRFID() {
        return RFID;
    }

    public void setRFID(String RFID) {
        this.RFID = RFID;
    }

    public long getAntennId() {
        return antennId;
    }

    public void setAntennId(long antennId) {
        this.antennId = antennId;
    }

    public Date getReaderDateTime() {
        return readerDateTime;
    }

    public void setReaderDateTime(Date readerDateTime) {
        this.readerDateTime = readerDateTime;
    }

    public Date getAppDateTime() {
        return appDateTime;
    }

    public void setAppDateTime(Date appDateTime) {
        this.appDateTime = appDateTime;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public long getReaderCount() {
        return readerCount;
    }

    public void setReaderCount(long readerCount) {
        this.readerCount = readerCount;
    }



    
}
