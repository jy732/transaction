package com.example.personalfinancemiddleware.service.impl;

import com.example.personalfinancemiddleware.service.PlaidService;
import com.plaid.client.request.PlaidApi;
import com.plaid.client.model.TransactionsGetRequest;
import com.plaid.client.model.TransactionsGetResponse;
import com.example.personalfinancemiddleware.model.Transaction;
import com.example.personalfinancemiddleware.model.User;
import com.example.personalfinancemiddleware.repository.TransactionRepository;
import com.example.personalfinancemiddleware.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class PlaidServiceImpl implements PlaidService {

    private final PlaidApi plaidApi;

    private final UserRepository userRepository;

    private final TransactionRepository transactionRepository;

    public PlaidServiceImpl(@Autowired PlaidApi plaidApi,
                            @Autowired UserRepository userRepository,
                            @Autowired TransactionRepository transactionRepository) {
        this.plaidApi = plaidApi;
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    // Poll transactions for all users (for demo, you can start with one user)
    public void pollTransactionsForAllUsers() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            pollTransactionsForUser(user);
        }
    }

    @Override
    public void pollTransactionsForUser(User user) {
        Long userId = user.getId();
        log.info("Polling transaction for user {}", user);
        try {
            LocalDate startDate = LocalDate.now().minusDays(30); // Customize range
            LocalDate endDate = LocalDate.now();

            TransactionsGetRequest request = new TransactionsGetRequest()
                    .accessToken(user.getPlaidAccessToken())
                    .startDate(startDate)
                    .endDate(endDate);

            // Fetch transactions
            TransactionsGetResponse response = plaidApi
                    .transactionsGet(request)
                    .execute()
                    .body();

            response.getTransactions().forEach(plaidTx -> {
                // Optionally: check if transaction already exists using plaidTransactionId
                Transaction tx = Transaction.builder()
                        .user(user)
                        .date(plaidTx.getDate())
                        .amount(plaidTx.getAmount())
                        .merchant(plaidTx.getMerchantName())
                        .description(plaidTx.getName())
                        .category("Others") // Default, categorize later
                        .isManuallyCategorized(false)
                        .alertSent(false)
                        .rawData(plaidTx.toString())
                        .build();
                transactionRepository.save(tx);
            });

        } catch (Exception ex) {
            log.error("Failed to insert transaction record for userId {}, error: {}", userId, ex.getMessage());
        }
    }
}