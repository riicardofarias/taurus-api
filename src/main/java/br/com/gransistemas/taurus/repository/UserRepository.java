package br.com.gransistemas.taurus.repository;

import br.com.gransistemas.taurus.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Page<User> findAllByParentId(long id, Pageable pageable);
}
