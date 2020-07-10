package br.com.gransistemas.taurus.controller;

import br.com.gransistemas.taurus.exception.AppException;
import br.com.gransistemas.taurus.model.Zone;
import br.com.gransistemas.taurus.service.ZoneService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/zones")
public class ZoneController {
    private final ZoneService zoneService;

    public ZoneController(ZoneService zoneService) {
        this.zoneService = zoneService;
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<?> index(@RequestParam(value = "page", defaultValue = "1") int page){
        PageRequest pageable = PageRequest.of(page - 1, 10, Sort.by("id").descending());

        return new ResponseEntity<>(
            zoneService.findAllByUser(pageable), HttpStatus.OK
        );
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<?> create(@Valid @RequestBody Zone zone){
        if(zone.getPoints().size() < 3)
            throw new AppException("Você precisa desenhar a cerca virtual");

        zoneService.save(zone);

        return new ResponseEntity<>(zone, HttpStatus.OK);
    }

    @PutMapping(value = {"", "/"})
    public ResponseEntity<?> update(@Valid @RequestBody Zone body) {
        Zone zone = zoneService.findByIdAndUser(body.getId()).orElseThrow(AppException::new);

        zone.setName(body.getName());
        zone.setPoints(body.getPoints());
        zone.setColor(body.getColor());
        zone.setActive(body.isActive());

        body = zoneService.save(zone);

        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping(value = {"/{id}", "/{id}/"})
    public ResponseEntity<?> view(@PathVariable("id") long id){
        Zone zone = zoneService
            .findById(id)
        .orElseThrow(AppException::new);

        return new ResponseEntity<>(zone, HttpStatus.OK);
    }
}
