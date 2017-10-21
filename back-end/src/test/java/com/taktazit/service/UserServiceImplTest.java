package com.taktazit.service;

import com.taktazit.Program;
import com.taktazit.domainobject.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Program.class})
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void testFindByUsername() {
        String user1 = "user1";
        User user = userService.findByUsername(user1);
        assertEquals(user1, user.getUsername());
    }
}
