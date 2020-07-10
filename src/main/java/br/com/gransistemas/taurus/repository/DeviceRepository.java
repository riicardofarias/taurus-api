package br.com.gransistemas.taurus.repository;

import br.com.gransistemas.taurus.model.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface DeviceRepository extends PagingAndSortingRepository<Device, Long>, JpaSpecificationExecutor<Device> {
    Optional<Device> findByIdAndUsersId(long id, long userId);

    Page<Device> findAllByUsersId(long id, Pageable pageable);

    List<Device> findAllByUsersId(long id);
}
