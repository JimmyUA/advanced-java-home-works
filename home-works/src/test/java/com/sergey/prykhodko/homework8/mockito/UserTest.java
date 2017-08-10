package com.sergey.prykhodko.homework8.mockito;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void setUserShouldSetNewPassword(){
        User user = new User();
        String testString = "password";

        user.setPassword(testString);

        assertEquals(testString, user.getPassword());
    }


}