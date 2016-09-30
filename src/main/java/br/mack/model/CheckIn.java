package br.mack.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by cmaia on 29/09/16
 */
@Entity
public class CheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private final User user;
    private final double latitude;
    private final double longitude;
    private final Date checkInTime;

    public CheckIn(Long id, User user, double latitude, double longitude, Date checkInTime) {
        this.id = id;
        this.user = user;
        this.latitude = latitude;
        this.longitude = longitude;
        this.checkInTime = checkInTime;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public static class Builder {
        private Long id;
        private User user;
        private double latitude;
        private double longitude;
        private Date checkInTime;

        public Builder(Long id) {
            this.id = id;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setLatitude(double latitude) {
            this.latitude = latitude;
            return this;
        }

        public Builder setLongitude(double longitude) {
            this.longitude = longitude;
            return this;
        }

        public Builder setCheckInTime(Date checkInTime) {
            this.checkInTime = checkInTime;
            return this;
        }

        public CheckIn build() {
            return new CheckIn(this.id, this.user, this.latitude, this.longitude, this.checkInTime);
        }
    }
}
