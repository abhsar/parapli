package se.digiport.device;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class DeviceController {

    @GetMapping("/api/devices")
    public List<Device> getDevices() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("/data.json");
        return objectMapper.readValue(inputStream, new TypeReference<List<Device>>() {});
    }

    @GetMapping("/api/devices/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable String id) throws IOException {
        List<Device> devices = getDevices();
        return devices.stream()
                .filter(device -> id.equals(device.getId()))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
