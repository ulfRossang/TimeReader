/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.rosscom.timereader.dto;

/**
 *
 * @author ulfrossang
 */
public class StartIdDTO implements TransferObject {
    
    private String Rfid;
    private String StartId;

    public String getRfid() {
        return Rfid;
    }

    public void setRfid(String Rfid) {
        this.Rfid = Rfid;
    }

    public String getStartId() {
        return StartId;
    }

    public void setStartId(String StartId) {
        this.StartId = StartId;
    }
    
}
