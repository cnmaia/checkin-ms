package br.mack.controller.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cmaia on 29/09/16
 */
public class CheckInInfoResponse implements Serializable {
    private static final long serialVersionUID = 9158674668967492490L;

    private double latitude;
    private double longitude;
    private String userEmail;
    private Date checkinTime;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(Date checkinTime) {
        this.checkinTime = checkinTime;
    }

    @Override
    public String toString() {
        return "CheckInInfoResponse{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", userEmail='" + userEmail + '\'' +
                ", checkinTime=" + checkinTime +
                '}';
    }
}
