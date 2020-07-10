package br.com.gransistemas.taurus.controller;

import br.com.gransistemas.taurus.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<?> index(@RequestParam(value = "page", defaultValue = "1") int page){
        PageRequest pageable = PageRequest.of(page - 1, 10);
        return new ResponseEntity<>(repository.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(value = {"/parent/{id}", "/parent/{id}/"})
    public ResponseEntity<?> subUsers(
        @PathVariable long id,
        @RequestParam(value = "page", defaultValue = "1") int page){

        PageRequest pageable = PageRequest.of(page - 1, 10);
        return new ResponseEntity<>(repository.findAllByParentId(id, pageable), HttpStatus.OK);
    }
}
