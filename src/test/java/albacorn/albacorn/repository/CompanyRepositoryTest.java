package albacorn.albacorn.repository;

import albacorn.albacorn.domain.Company;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class CompanyRepositoryTest {

    @Autowired
    CompanyRepository companyRepository;

    @Test
    public void testCompany() throws Exception {
        //given
        Company company = new Company("company1");
        Company saveCompany = companyRepository.save(company);
        //when
        Company findCompany = companyRepository.findById(saveCompany.getId()).orElseThrow(NullPointerException::new);
        //then
        assertThat(findCompany.getId()).isEqualTo(company.getId());
        assertThat(findCompany.getName()).isEqualTo(company.getName());
        assertThat(findCompany).isEqualTo(company);
    }

    @Test
    public void basicCRUD() throws Exception {
        //given
        Company company1 = new Company("company1");
        Company company2 = new Company("company2");
        companyRepository.save(company1);
        companyRepository.save(company2);

        //리스트 조회
        List<Company> all = companyRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

        //카운트 검증
        long count = companyRepository.count();
        assertThat(count).isEqualTo(2);

        companyRepository.delete(company1);
        companyRepository.delete(company2);

        long deleteCount = companyRepository.count();
        assertThat(deleteCount).isEqualTo(0);
    }
}