package se.rosscom.timereader.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.rosscom.timereader.jpa.CompetitionEntity;

/**
 *
 * @author ulfrossang
 */
public interface CompetitionRepositoryOld extends JpaRepository<CompetitionEntity, Long> {
    
    @Query(
        "Select c from Competition c where name = :searchTerm"
    )
    public CompetitionEntity find(@Param("searchterm") String searchTerm);
}
