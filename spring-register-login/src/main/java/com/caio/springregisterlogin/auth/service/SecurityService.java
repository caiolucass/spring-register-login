package com.caio.springregisterlogin.auth.service;

public interface SecurityService {
    String findLoggedInUserName();
    void autoLogin(String username, String password);
}
