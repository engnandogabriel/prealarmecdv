package com.prealarmecdv.application.repository;
import com.prealarmecdv.domain.entities.Remotas;
import java.util.List;
import java.util.Optional;

public interface RemotaRepository {
    Optional<Remotas> getById(Long id);
    List<Remotas> findAllById(Iterable<Long> ids);
    List<String> getAllAddress();
}
