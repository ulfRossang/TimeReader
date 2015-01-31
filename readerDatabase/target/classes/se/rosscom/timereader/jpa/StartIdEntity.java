
package se.rosscom.timereader.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author ulfrossang
 */
@Entity
@Table (name="StartingGroup" )
@Indexed
public class StartIdEntity implements Serializable {
    
    
    @Id
    @Column (name = "StartNr")
    private long startNr;
    
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "CompetitionPartId")
    @NotNull
    private CompetitionPartEntity competitionPart;

    @Basic(optional = false)
    @NotNull
    @Column(name = "RFID")
    private String RFID;
        
    @Basic(optional = false)
    @NotNull
    @Column(name = "StartingGroup")
    private StartingGroupEntity startingGroup;


    public long getStartNr() {
        return startNr;
    }

    public void setStartNr(long startNr) {
        this.startNr = startNr;
    }

    public CompetitionPartEntity getCompetitionPart() {
        return competitionPart;
    }

    public void setCompetitionPart(CompetitionPartEntity competitionPart) {
        this.competitionPart = competitionPart;
    }

    public StartingGroupEntity getStartingGroup() {
        return startingGroup;
    }

    public void setStartingGroup(StartingGroupEntity startingGroup) {
        this.startingGroup = startingGroup;
    }

    public String getRFID() {
        return RFID;
    }

    public void setRFID(String RFID) {
        this.RFID = RFID;
    }

    
    public StartIdEntity(Long startNr, CompetitionPartEntity competitionPart) {
        this.startNr = startNr;
        this.competitionPart = competitionPart;
    }

    public StartIdEntity() {
    }
    
    
}
