package albacorn.albacorn.repository;

import albacorn.albacorn.domain.JobPost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
        jobPostRepository.findById(post.getId)
        //then
    }
}