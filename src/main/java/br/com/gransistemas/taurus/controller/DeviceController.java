package br.com.gransistemas.taurus.controller;

import br.com.gransistemas.taurus.exception.AppException;
import br.com.gransistemas.taurus.model.Device;
import br.com.gransistemas.taurus.service.DeviceService;
import br.com.gransistemas.taurus.util.mapper.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/devices")
public class DeviceController {
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<?> index(
        @RequestParam(value = "page", defaultValue = "1") int page,
        @RequestParam(value = "filter", required = false) String filter) {

        Device criteria = Optional.ofNullable(
            Mapper.as(filter, Device.class)
        ).orElse(new Device());

        return new ResponseEntity<>(deviceService.findAll(criteria, page), HttpStatus.OK);
    }

    @GetMapping(value = {"/{id}", "/{id}/"})
    public ResponseEntity<?> view(@PathVariable("id") long id){
        Device device = deviceService
            .findById(id)
        .orElseThrow(AppException::new);

        return new ResponseEntity<>(device, HttpStatus.OK);
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<?> create(@Valid @RequestBody Device device) {
        deviceService.save(device);

        return new ResponseEntity<>(device, HttpStatus.OK);
    }

    @PutMapping(value = {"", "/"})
    public ResponseEntity<?> update(@Valid @RequestBody Device body) {
        Device device = deviceService
            .findByIdAndUser(body.getId())
        .orElseThrow(AppException::new);

        body.setPosition(device.getPosition());
        body.setUsers(device.getUsers());
        body.setActive(body.isActive());

        body = deviceService.save(body);

        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
