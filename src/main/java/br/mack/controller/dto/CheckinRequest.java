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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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
