package se.digiport.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class TelemetryValidation {
    @JsonProperty("voltage_V")
    private double voltage;
    @JsonProperty("current_A")
    private double current;
    @JsonProperty("power_kW")
    private double power;
    @JsonProperty("contactor_closed")
    private boolean contactorClosed;
    private Instant timestamp;
    private long statusActiveTimeMs;

    // Getters and setters
    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getCurrent() {
        return current;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public boolean isContactorClosed() {
        return contactorClosed;
    }

    public void setContactorClosed(boolean contactorClosed) {
        this.contactorClosed = contactorClosed;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public long getStatusActiveTimeMs() {
        return statusActiveTimeMs;
    }

    public void setStatusActiveTimeMs(long statusActiveTimeMs) {
        this.statusActiveTimeMs = statusActiveTimeMs;
    }
}
