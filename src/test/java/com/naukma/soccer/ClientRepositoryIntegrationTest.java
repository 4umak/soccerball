package com.naukma.soccer;

import com.naukma.soccer.entities.Client;
import com.naukma.soccer.entities.Role;
import com.naukma.soccer.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClientRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    private List<Role> roleList;

    @Before
    public void initSetUp() {
        Role roleAdmin = Role.builder().name("ADMIN").build();
        entityManager.persist(roleAdmin);
        entityManager.flush();

        roleList = new ArrayList<>();
        roleList.add(roleAdmin);
    }

    @Test
    public void whenFindByEmailThenReturnUser() {
        Client client = Client.builder()
                .first_name("Name")
                .last_name("Surname")
                .email("client@client.com")
                .password("password")
                .roleList(roleList)
                .build();
        entityManager.persist(client);
        entityManager.flush();

        Client found = userRepository.findByEmail(client.getEmail());

        assertEquals(found.getFirst_name(), client.getFirst_name());
    }

}
