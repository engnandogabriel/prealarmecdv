package com.prealarmecdv.infra.JPA;
import com.prealarmecdv.infra.domain.RemotasDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemotaJPA extends JpaRepository<RemotasDomain, Long> {
    List<RemotasDomain> findAllById(Iterable<Long> ids);
    @Query(value = "SELECT r.address FROM tbremota r", nativeQuery = true)
    List<String> getAllAddress();
}
