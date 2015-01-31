
package se.rosscom.timereader.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author ulfrossang
 */
@Entity
@Table (name="ReaderConfiguration" )
@Indexed
public class ReaderConfigurationEntity implements Serializable {
    
    @Id
    @Column(name = "ReaderId")
    private long readerId;

    
    @Basic(optional = true)
    @Column(name = "IPAdress")
    private String iPAdress;

    @Basic(optional = true)
    @Column(name = "Readpower")
    private long readPower;

    
    @Basic(optional = true)
    @Column(name = "ASyncOffTime")
    private long aSyncOffTime;

    public ReaderConfigurationEntity(long readerId) {
         this.readerId = readerId;
    }


    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(long readerId) {
        this.readerId = readerId;
    }

    public String getiPAdress() {
        return iPAdress;
    }

    public void setiPAdress(String iPAdress) {
        this.iPAdress = iPAdress;
    }

    public Long getReadPower() {
        return readPower;
    }

    public void setReadPower(long readPower) {
        this.readPower = readPower;
    }

    public Long getaSyncOffTime() {
        return aSyncOffTime;
    }

    public void setaSyncOffTime(long aSyncOffTime) {
        this.aSyncOffTime = aSyncOffTime;
    }
    


    public ReaderConfigurationEntity() {
    }
    
    
}
