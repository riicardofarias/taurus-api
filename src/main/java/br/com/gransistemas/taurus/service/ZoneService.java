package br.com.gransistemas.taurus.service;

import br.com.gransistemas.taurus.model.Zone;
import br.com.gransistemas.taurus.repository.ZoneRepository;
import br.com.gransistemas.taurus.util.UserContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ZoneService {
    private final ZoneRepository repository;
    private final UserContext context;

    public ZoneService(ZoneRepository repository, UserContext context) {
        this.repository = repository;
        this.context = context;
    }

    public Optional<Zone> findById(long id){
        return repository.findById(id);
    }

    @Transactional
    public Zone save(Zone zone){
        if(zone.isNew()) {
            zone.setCreatedAt(new Date());
            zone.addUser(context.getUser());
        }

        return repository.save(zone);
    }

    public Optional<Zone> findByIdAndUser(long id){
        return repository.findByIdAndUsersId(id, context.getId());
    }

    public Page<Zone> findAllByUser(Pageable pageable){
        return repository.findAllByUsersId(context.getId(), pageable);
    }

    public List<Zone> findAllByUser(){
        return repository.findAllByUsersId(context.getId());
    }
}
