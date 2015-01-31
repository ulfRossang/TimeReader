package se.rosscom.timereader.jpa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.rosscom.timereader.jpa.CompetitionPartEntity;

/**
 *
 * @author ulfrossang
 */
public interface CompetitionPartRepository extends JpaRepository<CompetitionPartEntity, Long> {
    
    @Query(
        "Select c from CompetitionPart c where name = :searchTerm"
    )
    public List<CompetitionPartEntity> find(@Param("searchterm") String searchTerm);
}
