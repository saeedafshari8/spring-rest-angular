package com.taktazit.service;

import com.taktazit.Program;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Program.class})
public class UserDetailsServiceImplTest {
    @Autowired
    private UserDetailsService userDetailsService;

    @Test
    public void testLoadUserByUsername() {
        String user1 = "user1";
        UserDetails userDetails = userDetailsService.loadUserByUsername(user1);
        assertEquals(user1, userDetails.getUsername());
    }
}
