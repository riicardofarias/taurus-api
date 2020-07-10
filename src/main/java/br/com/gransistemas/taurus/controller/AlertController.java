package br.com.gransistemas.taurus.controller;

import br.com.gransistemas.taurus.repository.AlertRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/alerts")
public class AlertController {
    private final AlertRepository repository;

    public AlertController(AlertRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<?> index(@RequestParam(value = "page", defaultValue = "1") int page){
        PageRequest pageable = PageRequest.of(page - 1, 10);
        return new ResponseEntity<>(repository.findAll(pageable), HttpStatus.OK);
    }
}
