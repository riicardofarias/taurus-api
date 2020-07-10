package br.com.gransistemas.taurus.repository;

import br.com.gransistemas.taurus.model.DeviceEvent;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DeviceEventRepository extends PagingAndSortingRepository<DeviceEvent, Long> {
    Iterable<DeviceEvent> findAllByDevice_Id(long id);
}
