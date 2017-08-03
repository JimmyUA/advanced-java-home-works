package com.sergey.prykhodko.homework8.mockito;

public class UserServiceImpl {
    private UserDAO userDAO;
    private SecurityService securityService;

    public UserServiceImpl(UserDAO dao, SecurityService security){
        userDAO = dao;
        securityService = security;
    }

    public void assignPassword(User user) throws Exception{
        String paaswordMd5 = securityService.md5(user.getPassword);
        user.setPassword(paaswordMd5);
        userDAO.updateUser(user);
    }
}
