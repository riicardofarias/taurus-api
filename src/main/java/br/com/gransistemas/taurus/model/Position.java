package br.com.gransistemas.taurus.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "positions")
public class Position extends BaseModel {
    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "speed")
    private double speed;

    @Column(name = "course")
    private double course;

    @Column(name = "odometer")
    private int odometer;

    @Column(name = "alarm")
    private String alarm;

    @JsonProperty("key_ignition")
    @Column(name = "key_ignition")
    private int keyIgnition;

    @Column(name = "power")
    private double power;

    @JsonProperty("battery_level")
    @Column(name = "battery_level")
    private double batteryLevel;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "date")
    private Date date;

    @JsonProperty("created_at")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "created_at")
    private Date createdAt;

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public double getSpeed() { return speed; }
    public void setSpeed(double speed) { this.speed = speed; }

    public double getCourse() { return course; }
    public void setCourse(double course) { this.course = course; }

    public int getOdometer() { return odometer; }
    public void setOdometer(int odometer) { this.odometer = odometer; }

    public String getAlarm() { return alarm; }
    public void setAlarm(String alarm) { this.alarm = alarm; }

    public int getKeyIgnition() { return keyIgnition; }
    public void setKeyIgnition(int keyIgnition) { this.keyIgnition = keyIgnition; }

    public double getPower() { return power; }
    public void setPower(double power) { this.power = power; }

    public double getBatteryLevel() { return batteryLevel; }
    public void setBatteryLevel(double batteryLevel) { this.batteryLevel = batteryLevel; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}
