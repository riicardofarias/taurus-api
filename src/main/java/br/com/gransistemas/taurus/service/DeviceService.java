package br.com.gransistemas.taurus.service;

import br.com.gransistemas.taurus.model.Device;
import br.com.gransistemas.taurus.repository.DeviceRepository;
import br.com.gransistemas.taurus.repository.specification.DeviceSpecification;
import br.com.gransistemas.taurus.util.UserContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class DeviceService {
    private final UserContext context;
    private final DeviceRepository repository;

    public DeviceService(UserContext context, DeviceRepository repository) {
        this.context = context;
        this.repository = repository;
    }

    public Device save(Device device){
        if(device.isNew()){
            device.addUser(context.getUser());
        }

        return repository.save(device);
    }

    public Optional<Device> findById(long id){
        return repository.findById(id);
    }

    public Optional<Device> findByIdAndUser(long id){
        return repository.findByIdAndUsersId(id, context.getId());
    }

    public Page<Device> findAll(Device criteria, int page){
        PageRequest pageable = PageRequest.of(page - 1, 10, Sort.by("id").descending());

        final Specification<Device> specification = where(DeviceSpecification.id(criteria.getId()))
            .and(DeviceSpecification.name(criteria.getName()))
        .and(DeviceSpecification.imei(criteria.getImei()));

        return repository.findAll(specification, pageable);
    }

    public Iterable<Device> findAll(){
        return repository.findAll();
    }
}
