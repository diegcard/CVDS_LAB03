package edu.eci.cvds.tdd.library.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void ShouldEqualsConstructorWithName(){
        User user = new User();
        user.setName("Diego");
        assertEquals(user.getName(), "Diego");
    }

    @Test
    public void ShouldEqualsId(){
        User user = new User();
        user.setId("312");
        assertEquals(user.getId(), "312");
    }


}
