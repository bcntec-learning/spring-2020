package bcntec.spring.data.b_jpa_repository.test;

import bcntec.spring.data.b_jpa_repository.UserRepository;
import bcntec.spring.data.entities.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackageClasses = {UserRepository.class})
@EntityScan(basePackageClasses = UserEntity.class)

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TestRepository {
    @Autowired
    UserRepository repository;

    @Test
    public void assert_not_null() {
        assertNotNull(repository);
    }

    @Test
    public void assert_first() {
        Optional<UserEntity> f = repository.findById(1L);
        Assert.assertTrue(f.isPresent());
        UserEntity u = f.get();
        assertEquals(u.getName(), "Juan");
    }
}
