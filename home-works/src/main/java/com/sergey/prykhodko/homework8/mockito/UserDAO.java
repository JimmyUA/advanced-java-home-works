package com.sergey.prykhodko.homework8.mockito;

public class UserDAO {
    private String password = "old";

    public void updateUser(User user){
        password = user.getPassword();
    }
}
