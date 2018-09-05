package com.yabanya.auth.orm.repository;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = RepositoryTestSpringBootApplication.class)
public abstract class AbstractRepositoryIT  {

}
