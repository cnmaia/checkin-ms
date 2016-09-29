package br.mack.controller.dto;

import java.io.Serializable;

/**
 * Created by cmaia on 29/09/16
 */
public class CheckinRequest implements Serializable {
    private static final long serialVersionUID = 7328163616736874374L;

    private double latitude;
    private double longitude;
    private long userId;

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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CheckinRequest{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", userId=" + userId +
                '}';
    }
}
