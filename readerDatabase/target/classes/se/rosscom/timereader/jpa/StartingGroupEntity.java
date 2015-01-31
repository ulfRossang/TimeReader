
package se.rosscom.timereader.jpa;

import java.io.Serializable;
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
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author ulfrossang
 */
@Entity
@Table (name="StartingGroup" )
@Indexed
public class StartingGroupEntity implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)       
    @Column (name = "Id")
    private long id;
    
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "CompetitionPartId")
    @NotNull
    private CompetitionPartEntity competitionPart;

    @Basic(optional = false)
    @NotNull
    @Column(name = "StartArea")
    private String startArea;

    @Basic(optional = false)
    @NotNull
    @Column(name = "AutomaticStart")
    private Long automaticStart;

    @Basic(optional = false)
    @NotNull
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "OfficialStartTime")
    private Timestamp officialStartTime;
    
    @Basic(optional = false)
    @NotNull
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "ActualStartTime")
    private Timestamp actualStartTime;

    public long getiD() {
        return id;
    }

    public void setiD(long id) {
        this.id = id;
    }

    public CompetitionPartEntity getCompetitionPart() {
        return competitionPart;
    }

    public void setCompetitionPart(CompetitionPartEntity competitionPart) {
        this.competitionPart = competitionPart;
    }

    public String getStartArea() {
        return startArea;
    }

    public void setStartArea(String startArea) {
        this.startArea = startArea;
    }

    public Long getAutomaticStart() {
        return automaticStart;
    }

    public void setAutomaticStart(Long automaticStart) {
        this.automaticStart = automaticStart;
    }

    public Timestamp getOfficialStartTime() {
        return officialStartTime;
    }

    public void setOfficialStartTime(Timestamp officialStartTime) {
        this.officialStartTime = officialStartTime;
    }

    public Timestamp getActualStartTime() {
        return actualStartTime;
    }

    public void setActualStartTime(Timestamp actualStartTime) {
        this.actualStartTime = actualStartTime;
    }

    
    public StartingGroupEntity(Long id, CompetitionPartEntity competitionPart) {
        this.id = id;
        this.competitionPart = competitionPart;
    }

    public StartingGroupEntity() {
    }
    
    
}
