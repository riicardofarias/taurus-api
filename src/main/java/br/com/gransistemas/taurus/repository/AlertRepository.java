package br.com.gransistemas.taurus.repository;

import br.com.gransistemas.taurus.model.Notification;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AlertRepository extends PagingAndSortingRepository<Notification, Long> {
}
