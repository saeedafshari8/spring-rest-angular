package com.taktazit.dataaccessobject;

import com.taktazit.Program;
import com.taktazit.domainobject.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Program.class})
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    private User user;

    @Before
    public void setUp() {
        user = new User();
        user.setUsername("user3");
        user.setPassword("123456");
    }

    @Test
    public void testSave() {
        userRepository.save(user);
        assertNotNull(user.getId());
    }

    @Test
    public void testGetByUsername() {
        userRepository.save(user);
        User newUser = userRepository.getByUsername(user.getUsername());
        assertEquals(user.getUsername(), newUser.getUsername());
        assertEquals(new Long(1), userRepository.getByUsername("user1").getId());
    }

    @After
    public void tearDown() {
        userRepository.delete(user);
    }
}
