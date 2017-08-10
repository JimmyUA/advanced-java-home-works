package com.sergey.prykhodko.homework8.mockito;

import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserServiceImplTest {

    @Test
    public void updateUserIsCalledAfterInvokingAssignPassword(){
        User userMock = mock(User.class);
        UserDAO daoMock = mock(UserDAO.class);
        SecurityService securityServiceMock = mock(SecurityService.class);
        UserServiceImpl userService = new UserServiceImpl(daoMock, securityServiceMock);

        try {
            userService.assignPassword(userMock);
        } catch (Exception e) {
            e.printStackTrace();
        }

        verify(daoMock, atLeastOnce()).updateUser(userMock);
    }

    @Test
    public void setPasswordInUserShouldBeCalledAfterInvokingAssignPassword(){
        User userMock = mock(User.class);
        UserDAO daoMock = mock(UserDAO.class);
        SecurityService securityServiceMock = mock(SecurityService.class);
        UserServiceImpl userService = new UserServiceImpl(daoMock, securityServiceMock);

        try {
            userService.assignPassword(userMock);
        } catch (Exception e) {
            e.printStackTrace();
        }

        verify(userMock).setPassword(any());
    }
}