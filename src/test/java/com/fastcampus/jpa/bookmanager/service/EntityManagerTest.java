package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.domain.Gender;
import com.fastcampus.jpa.bookmanager.domain.User;
import com.fastcampus.jpa.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * @author TaeWK
 */

@SpringBootTest
@Transactional
public class EntityManagerTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void entityManagerTest(){
        System.out.println(entityManager.createQuery("select u from User u")
                .getResultList());
    }


    @Test
    void cacheFindTest(){

        System.out.println(userRepository.findById(1L).get());
        System.out.println(userRepository.findById(1L).get());
        System.out.println(userRepository.findById(1L).get());

        /*
        System.out.println(userRepository.findByEmail("martin@fastcampus.com"));
        System.out.println(userRepository.findByEmail("martin@fastcampus.com"));*/
    }

    @Test
    void cacheFindTest2(){
        User user = userRepository.findById(1l)
                .get();
        user.setName("marrrrrrrtin");
        userRepository.save(user);
        user.setEmail("marrrrrrtin@fastcampus.com");
        userRepository.save(user);
    }
}




