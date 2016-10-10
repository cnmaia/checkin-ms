package br.mack.controller.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cmaia on 29/09/16
 */
public class CheckinRequest implements Serializable {
    private static final long serialVersionUID = 7328163616736874374L;

    private String event;
    private String location;
    private Double latitude;
    private Double longitude;
    private Long userId;
    private Date checkInTime;

    public String getEvent() {
        return event;
    }

    public CheckinRequest setEvent(String event) {
        this.event = event;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public CheckinRequest setLocation(String location) {
        this.location = location;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public CheckinRequest setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public CheckinRequest setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public CheckinRequest setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public CheckinRequest setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
        return this;
    }

    @Override
    public String toString() {
        return "CheckinRequest{" +
                "event='" + event + '\'' +
                ", location='" + location + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", userId=" + userId +
                ", checkInTime=" + checkInTime +
                '}';
    }

    public boolean isEmpty() {
        return this.checkInTime == null
                && this.latitude == null
                && this.longitude == null
                && this.userId == null
                && this.location == null
                && this.event == null;
    }
}
