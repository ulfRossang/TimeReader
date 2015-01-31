package se.rosscom.timereader.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "Reader")
@Indexed

public class ReaderEntity implements Comparable<ReaderEntity>, Serializable {
    
    @Id
    @Column (name = "ReaderId")
    private long readerId;

    @Id
    @Column (name = "Lap")
    private int lap;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "CompetitionPartId")
    @NotNull
    private CompetitionPartEntity competitionPart;

    @Basic
    @Column (name = "ReaderType")
    @NotNull
    private String readerType;


    private int readerTypeRed;
    
    @Basic
    @Column (name = "LengthFromStart")
    @NotNull
    private BigDecimal lengthFromStart;

    
   /**
    * @param readerEntity is a non-null aResult.
    *
    * @throws NullPointerException if aReaderEntityTO is null.
    */
    public int compareTo( ReaderEntity readerEntity ) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        //this optimization is usually worthwhile, and can
        //always be added
        if ( this.readerTypeRed == readerEntity.readerTypeRed ) {
            if (this.lap == readerEntity.lap) {
                return EQUAL;
            } else if (this.lap < readerEntity.lap) {
                return BEFORE;
            } else {
                return AFTER;
            }
            
        } else if (this.readerTypeRed < readerEntity.readerTypeRed) {
            
            return BEFORE;
        } else {
            return AFTER;
        }
    }

    public CompetitionPartEntity getCompetitionPart() {
        return competitionPart;
    }

    public void setCompetitionPart(CompetitionPartEntity competitionPart) {
        this.competitionPart = competitionPart;
    }
    

    public int getLap() {
        return lap;
    }

    public void setLap(int lap) {
        this.lap = lap;
    }

    public BigDecimal getLengthFromStart() {
        return lengthFromStart;
    }

    public void setLengthFromStart(BigDecimal lengthFromStart) {
        this.lengthFromStart = lengthFromStart;
    }

    public long getReaderId() {
        return readerId;
    }

    public void setReaderId(long readerId) {
        this.readerId = readerId;
    }

    public String getReaderType() {
        return readerType;
    }

    public void setReaderType(String readerType) {
        this.readerType = readerType;
        if (readerType.equals("Reg")) {
            setReaderTypeRed(0);
        } else if (readerType.equals("Start")) {
            setReaderTypeRed(1);
        } else if (readerType.equals("Split")) {
            setReaderTypeRed(2);
        } else if (readerType.equals("End")) {
            setReaderTypeRed(3);
        } else if (readerType.equals("Off")) {
            setReaderTypeRed(4);
        }
    }

    public int getReaderTypeRed() {
        return readerTypeRed;
    }

    public void setReaderTypeRed(int readerTypeRed) {
        this.readerTypeRed = readerTypeRed;
    }
    
}
