package br.com.gransistemas.taurus.controller;

import br.com.gransistemas.taurus.model.Device;
import br.com.gransistemas.taurus.model.marker.Marker;
import br.com.gransistemas.taurus.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/central-control")
public class CentralController {
    private final DeviceService deviceService;

    public CentralController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<?> index() {
        Stream<Device> stream = StreamSupport.stream(deviceService.findAll().spliterator(), false);

        List<Marker> markers = stream
            .filter(c -> c.getPosition() != null && c.isActive()).map(Marker::new)
        .collect(Collectors.toList());

        return new ResponseEntity<>(markers, HttpStatus.OK);
    }
}
