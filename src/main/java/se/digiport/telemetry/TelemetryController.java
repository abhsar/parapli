package se.digiport.telemetry;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/api/telemetry")
public class TelemetryController {

    private final List<String> statusKeys;
    private final JsonNode statuses;

    public TelemetryController() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("/status.json");
        JsonNode rootNode = objectMapper.readTree(inputStream);
        statuses = rootNode.get("Statuses");
        statusKeys = new ArrayList<>();
        statuses.fieldNames().forEachRemaining(statusKeys::add);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Telemetry> getTelemetry(@PathVariable String id) throws IOException {
        // Check if device exists (optional, but good practice)
        // For now, we'll just return a random status for any ID

        Random random = new Random();
        String randomStatusKey = statusKeys.get(random.nextInt(statusKeys.size()));
        Telemetry telemetry = new ObjectMapper().treeToValue(statuses.get(randomStatusKey), Telemetry.class);

        // Randomize telemetry values
        TelemetryValidation validation = telemetry.getTelemetryValidation();
        validation.setVoltage(randomize(validation.getVoltage(), 0.01));
        validation.setCurrent(randomize(validation.getCurrent(), 0.01));
        validation.setPower(randomize(validation.getPower(), 0.01));
        validation.setTimestamp(Instant.now());
        validation.setStatusActiveTimeMs(ThreadLocalRandom.current().nextLong(1000, 3600000));


        return ResponseEntity.ok(telemetry);
    }

    private double randomize(double value, double percentage) {
        Random random = new Random();
        double deviation = value * percentage;
        return value + (random.nextDouble() * 2 - 1) * deviation;
    }
}
