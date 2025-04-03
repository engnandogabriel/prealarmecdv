package com.prealarmecdv.infra.JPA;
import com.prealarmecdv.infra.domain.LeiturasDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LeiturasJPA extends JpaRepository<LeiturasDomain, Long> {
    @Query(value = """
    SELECT l.*
    FROM tbleituras l
    JOIN tbremota r ON l.remota_id = r.id
    WHERE r.address LIKE 'CV km %'
    AND CAST(SUBSTRING(r.address, 7) AS UNSIGNED) BETWEEN :kmInicio AND :kmFim
    AND l.corrente_recebida BETWEEN :correnteMin AND :correnteMax
    AND l.hist BETWEEN :dataInicio AND :dataFim
    ORDER BY l.remota_id ASC
    """, nativeQuery = true)
    List<LeiturasDomain> findAnomalias(
            @Param("kmInicio") int kmInicio,
            @Param("kmFim") int kmFim,
            @Param("correnteMin") double correnteMin,
            @Param("correnteMax") double correnteMax,
            @Param("dataInicio") LocalDateTime dataInicio,
            @Param("dataFim") LocalDateTime dataFim
    );
    @Query(value = """
    SELECT l.*
    FROM tbleituras l
    JOIN tbremota r ON l.remota_id = r.id
    WHERE r.address LIKE 'CV km %'
    AND CAST(SUBSTRING(r.address, 7) AS UNSIGNED) BETWEEN :kmInicio AND :kmFim
    AND l.resistencia > :resistencia
    AND l.hist BETWEEN :dataInicio AND :dataFim
    ORDER BY l.remota_id ASC
    """, nativeQuery = true)
    List<LeiturasDomain> findResistance(
            @Param("kmInicio") int kmInicio,
            @Param("kmFim") int kmFim,
            @Param("resistencia") double resistencia,
            @Param("dataInicio") LocalDateTime dataInicio,
            @Param("dataFim") LocalDateTime dataFim
    );
    @Query(value = """
    SELECT l.*
    FROM tbleituras l
    JOIN tbremota r ON l.remota_id = r.id
    WHERE r.address LIKE 'CV km %'
      AND CAST(SUBSTRING_INDEX(r.address, 'CV km ', -1) AS UNSIGNED) BETWEEN :inicio AND :fim
      AND l.hist BETWEEN :dataInicio AND :dataFim
    ORDER BY l.hist ASC
""", nativeQuery = true)
    List<LeiturasDomain> findByDistrict(
            @Param("inicio") int inicio,
            @Param("fim") int fim,
            @Param("dataInicio") LocalDateTime dataInicio,
            @Param("dataFim") LocalDateTime dataFim
    );


    @Query(value = """
        SELECT l.*
        FROM tbleituras l
        JOIN tbremota r ON l.remota_id = r.id
        WHERE r.address = :address
        AND l.hist BETWEEN :dataInicio AND :dataFim
        ORDER BY l.hist ASC
    """, nativeQuery = true)
    List<LeiturasDomain> fundByAddress(@Param("address") String address,
                                       @Param("dataInicio") LocalDateTime dataInicio,
                                       @Param("dataFim") LocalDateTime dataFim);
}
