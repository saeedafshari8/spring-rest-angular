package com.taktazit.dataaccessobject;

import com.taktazit.Program;
import com.taktazit.domainobject.Role;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Program.class})
public class RoleRepositoryTest {
    @Autowired
    private RoleRepository roleRepository;
    private Role role;

    @Before
    public void setUp() {
        role = new Role();
        role.setName("Test");
    }

    @Test
    public void testSave() {
        roleRepository.save(role);
        assertNotNull(role.getId());
    }

    @After
    public void tearDown() {
        roleRepository.delete(role);
    }
}
