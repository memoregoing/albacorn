package albacorn.albacorn.repository;

import albacorn.albacorn.domain.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostRepository extends JpaRepository<JobPost, Long> {
}
