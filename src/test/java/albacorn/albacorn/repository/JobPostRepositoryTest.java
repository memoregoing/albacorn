package albacorn.albacorn.repository;

import albacorn.albacorn.domain.JobPost;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JobPostRepositoryTest {

    @Autowired
    JobPostRepository jobPostRepository;

    @Test
    public void testJobPost() throws Exception {
        //given
        JobPost post = new JobPost("post1");
        jobPostRepository.save(post);
        //when
        JobPost findJobPost = jobPostRepository.findById(post.getId()).orElseThrow(NullPointerException::new);
        //then
        assertThat(findJobPost.getId()).isEqualTo(post.getId());
        assertThat(findJobPost.getTitle()).isEqualTo(post.getTitle());
    }

    @Test
    public void basicCRUD() throws Exception {
        //given
        JobPost title1 = new JobPost("title1");
        JobPost title2 = new JobPost("title2");
        jobPostRepository.save(title1);
        jobPostRepository.save(title2);

        //단건 검증
        JobPost findJobPost1 = jobPostRepository.findById(title1.getId()).orElseThrow();
        JobPost findJobPost2 = jobPostRepository.findById(title2.getId()).orElseThrow();
        assertThat(findJobPost1.getId()).isEqualTo(title1.getId());
        assertThat(findJobPost2.getId()).isEqualTo(title2.getId());
        assertThat(findJobPost1.getTitle()).isEqualTo(title1.getTitle());
        assertThat(findJobPost2.getTitle()).isEqualTo(title2.getTitle());

        //리스트 조회
        List<JobPost> all = jobPostRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

        long count = jobPostRepository.count();
        assertThat(count).isEqualTo(2);

        //삭제 검증
        jobPostRepository.delete(title1);
        jobPostRepository.delete(title2);

        long count1 = jobPostRepository.count();
        assertThat(count1).isEqualTo(0);
    }
}