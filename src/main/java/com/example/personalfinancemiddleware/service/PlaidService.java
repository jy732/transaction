package com.example.personalfinancemiddleware.service;

import com.example.personalfinancemiddleware.model.User;

public interface PlaidService {

    void pollTransactionsForAllUsers();

    void pollTransactionsForUser(User user);
}
