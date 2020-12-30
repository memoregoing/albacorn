package albacorn.albacorn.repository;

import albacorn.albacorn.domain.JobCondition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobConditionRepository extends JpaRepository<JobCondition, Long> {
}
