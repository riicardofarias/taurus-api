package br.com.gransistemas.taurus.service;

import br.com.gransistemas.taurus.model.Event;
import br.com.gransistemas.taurus.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EventService{
    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public Event save(Event event){
        if(event.isNew()){
            event.setCreatedAt(new Date());
        }

        return repository.save(event);
    }
}
