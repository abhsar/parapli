package se.digiport.telemetry;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Telemetry {
    private int id;
    private String description;
    @JsonProperty("telemetry_validation")
    private TelemetryValidation telemetryValidation;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TelemetryValidation getTelemetryValidation() {
        return telemetryValidation;
    }

    public void setTelemetryValidation(TelemetryValidation telemetryValidation) {
        this.telemetryValidation = telemetryValidation;
    }
}
