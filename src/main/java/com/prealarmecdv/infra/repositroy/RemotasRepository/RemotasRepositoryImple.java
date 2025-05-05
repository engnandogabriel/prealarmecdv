package com.prealarmecdv.infra.repositroy.RemotasRepository;
import com.prealarmecdv.application.repository.RemotaRepository;
import com.prealarmecdv.domain.entities.Remotas;
import com.prealarmecdv.infra.JPA.RemotaJPA;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RemotasRepositoryImple implements RemotaRepository {
    private RemotaJPA remotaJPA;

    public RemotasRepositoryImple(RemotaJPA remotaJPA) {
        this.remotaJPA = remotaJPA;
    }

    @Override
    public Optional<Remotas> getById(Long id) {
        return this.remotaJPA.findById(id).
                map(r -> Remotas.restore(r.getRemotaId(), r.getLocalId(),
                        r.getIp(), r.getDescricao(), r.getName(), r.getRailroad(),r.getSubdivision(),
                        r.getAddress(), r.getSite_id(), r.getChassis_id(), r.getChecksumSwExec(),
                        r.getSwDate(), r.getAtiva(), r.getHist()));
    }

    @Override
    public List<Remotas> findAllById(Iterable<Long> ids) {
        return this.remotaJPA.findAllById(ids)
                .stream()
                .map(r -> Remotas.restore(r.getRemotaId(), r.getLocalId(),
                        r.getIp(),r.getDescricao(),r.getName(),r.getRailroad(),r.getSubdivision(),
                        r.getAddress(),r.getSite_id(),r.getChassis_id(),r.getChecksumSwExec(),
                        r.getSwDate(),r.getAtiva(), r.getHist())).collect(Collectors.toList());
    }

    @Override
    public List<Remotas> getAllAddress() {
        return this.remotaJPA.findAll()
                .stream()
                .map(r -> Remotas.restore(r.getRemotaId(), r.getLocalId(),
                        r.getIp(),r.getDescricao(),r.getName(),r.getRailroad(),r.getSubdivision(),
                        r.getAddress(),r.getSite_id(),r.getChassis_id(),r.getChecksumSwExec(),
                        r.getSwDate(),r.getAtiva(), r.getHist())).collect(Collectors.toList());
    }
}
