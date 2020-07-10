package br.com.gransistemas.taurus.repository;

import br.com.gransistemas.taurus.model.Event;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EventRepository extends PagingAndSortingRepository<Event, Long>, JpaSpecificationExecutor<Event> {

}
