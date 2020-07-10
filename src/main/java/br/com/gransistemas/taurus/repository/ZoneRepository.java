package br.com.gransistemas.taurus.repository;

import br.com.gransistemas.taurus.model.Zone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ZoneRepository extends PagingAndSortingRepository<Zone, Long>, JpaSpecificationExecutor<Zone> {
    Optional<Zone> findByIdAndUsersId(long id, long userId);

    Page<Zone> findAllByUsersId(long id, Pageable pageable);

    List<Zone> findAllByUsersId(@Param("id") long id);
}
