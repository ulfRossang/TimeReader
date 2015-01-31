
package se.rosscom.timereader.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author ulfrossang
 */
@Entity
@Table (name="Competition" )
@Indexed
public class CompetitionEntity implements Serializable {
    
    @Id
    @Column(name = "CompetitionId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long competitionId;

    @Basic(optional = false)
    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "CompetitionDate")
    private Date competitionDate;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Name")
    private String competitionName;

    public long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(long competitionId) {
        this.competitionId = competitionId;
    }

    public Date getCompetitionDate() {
        return competitionDate;
    }

    public void setCompetitionDate(Date competitionDate) {
        this.competitionDate = competitionDate;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }
    
    public CompetitionEntity(String competitionName, Date competitionDate) {
        this.competitionName = competitionName;
        this.competitionDate = competitionDate;
    }

    public CompetitionEntity() {
    }
    
    
}
