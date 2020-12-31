package albacorn.albacorn.repository;

import albacorn.albacorn.domain.JobCondition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class JobConditionRepositoryTest {

    @Autowired
    JobConditionRepository jobConditionRepository;

    @Test
    public void testJobCondition() throws Exception {
        //given
        JobCondition jobCondition = new JobCondition(0, 0);
        JobCondition saveJobCondition = jobConditionRepository.save(jobCondition);
        //when
        JobCondition findJobCondition = jobConditionRepository.findById(saveJobCondition.getId()).orElseThrow(NullPointerException::new);
        //then
        assertThat(findJobCondition.getId()).isEqualTo(jobCondition.getId());
        assertThat(findJobCondition.getActivatedCount()).isEqualTo(0L);
        assertThat(findJobCondition.getDeactivatedCount()).isEqualTo(0L);
    }

    @Test
    public void basicCRUD() throws Exception {
        //given
        JobCondition jobCondition1 = new JobCondition(0, 0);
        JobCondition jobCondition2 = new JobCondition(0, 0);
        jobConditionRepository.save(jobCondition1);
        jobConditionRepository.save(jobCondition2);

        // 단건 조회 검증
        JobCondition findJobCondition1 = jobConditionRepository.findById(jobCondition1.getId()).orElseThrow(NullPointerException::new);
        JobCondition findJobCondition2 = jobConditionRepository.findById(jobCondition2.getId()).orElseThrow(NullPointerException::new);
        assertThat(findJobCondition1.getActivatedCount()).isEqualTo(0);
        assertThat(findJobCondition2.getActivatedCount()).isEqualTo(0);
        assertThat(findJobCondition1.getDeactivatedCount()).isEqualTo(0);
        assertThat(findJobCondition2.getDeactivatedCount()).isEqualTo(0);

        //리스트 조회 검증
        List<JobCondition> all = jobConditionRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

        //카운트 검증
        long count = jobConditionRepository.count();
        assertThat(count).isEqualTo(2);

        //삭제 검증
        jobConditionRepository.delete(jobCondition1);
        jobConditionRepository.delete(jobCondition2);

        long deleteCount = jobConditionRepository.count();
        assertThat(deleteCount).isEqualTo(0);
    }
}