
package se.rosscom.timereader.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ulfrossang
 */
@Entity
@Table(name = "ClientAuthorization" )
public class ClientAuthorizationEntity implements Serializable {
    
    @Id
    @Column(name = "CompetitionName")
    private String competitionName;

    @Id
    @Column(name = "User")
    @NotNull
    private String user;
 
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
  
    @Basic(optional = false)
    @Column(name = "ClientType")
    private String clientType;
    
    @Basic(optional = true)
    @Column(name = "Occupied")
    private int occupied;

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public int getOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }
    
    public ClientAuthorizationEntity(String competitionName, String user, String password, String clientType) {
        this.competitionName = competitionName;
        this.user = user;
        this.password = password;
        this.clientType = clientType;
    }

    protected ClientAuthorizationEntity() {
    }
    
}
