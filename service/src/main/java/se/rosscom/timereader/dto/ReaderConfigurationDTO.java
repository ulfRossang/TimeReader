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
public class ReaderConfigurationDTO {
    
    private String hostName              = "192.168.0.66/";
    private Integer asyncOffTime         = 10000;
    private Integer readPower            = 3150;
    
//    @Inject
    public ReaderConfigurationDTO(String hostName, Integer asyncOffTime, Integer readPower) {
        this.hostName = hostName;
        this.asyncOffTime = asyncOffTime;
        this.readPower = readPower;
        
    }

    public ReaderConfigurationDTO() {
        // Default
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getAsyncOffTime() {
        return asyncOffTime;
    }

    public void setAsyncOffTime(Integer asyncOffTime) {
        this.asyncOffTime = asyncOffTime;
    }

    public Integer getReadPower() {
        return readPower;
    }

    public void setReadPower(Integer readPower) {
        this.readPower = readPower;
    }
    
    
    
}
