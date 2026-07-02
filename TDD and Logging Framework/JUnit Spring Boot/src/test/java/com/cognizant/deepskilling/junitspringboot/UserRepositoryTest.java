package com.cognizant.deepskilling.junitspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        User user = new User();
        user.setId(1L);
        user.setName("Erwin");
        userRepository.save(user);

        List<User> result = userRepository.findByName("Erwin");

        assertEquals(1, result.size());
        assertEquals("Erwin", result.get(0).getName());
    }
}