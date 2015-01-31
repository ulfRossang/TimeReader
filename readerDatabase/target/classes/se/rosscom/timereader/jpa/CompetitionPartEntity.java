package se.rosscom.timereader.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table (name = "CompetitionPart")
@Indexed
public class CompetitionPartEntity implements Serializable {
    
    @Id
    @Column(name = "CompetitionPartId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long competitionPartId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "Name")
    private String name;

    @Basic(optional = true)
    @Column(name = "CompetitionLength")
    private double compLength;
    
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "CompetitionId")
    @NotNull
    private CompetitionEntity competition;

    @Basic(optional = false)
    @Column(name = "Type")
    private String type;

    @Basic
    @Column(name = "Time")
    private BigDecimal time;

    public CompetitionPartEntity() {
    }

    public long getCompetitionPartId() {
        return competitionPartId;
    }

    public void setCompetitionPartId(long competitionPartId) {
        this.competitionPartId = competitionPartId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCompLength() {
        return compLength;
    }

    public void setCompLength(double compLength) {
        this.compLength = compLength;
    }

    public CompetitionEntity getCompetition() {
        return competition;
    }

    public void setCompetition(CompetitionEntity competition) {
        this.competition = competition;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getTime() {
        return time;
    }

    public void setTime(BigDecimal time) {
        this.time = time;
    }
    

    public CompetitionPartEntity(long competitionPartId) {
        this.competitionPartId = competitionPartId;
    }    
    
    
}
