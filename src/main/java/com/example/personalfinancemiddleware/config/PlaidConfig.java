package com.example.personalfinancemiddleware.config;

import com.plaid.client.ApiClient;
import com.plaid.client.request.PlaidApi;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlaidConfig {

    @Value("${plaid.client-id}")
    private String clientId;

    @Value("${plaid.secret}")
    private String secret;

    @Value("${plaid.env}")
    private String environment; // sandbox / development / production

    @Bean
    public PlaidApi plaidApi() {

        HashMap<String, String> apiKeys = new HashMap<>();
        apiKeys.put("clientId", clientId);
        apiKeys.put("secret", secret);
        apiKeys.put("plaidVersion", "2020-09-14");

        PlaidEnvironment plaidEnv = PlaidEnvironment.fromString(environment);
        ApiClient apiClient = new ApiClient(apiKeys);
        apiClient.setPlaidAdapter(plaidEnv.getAdapter()); // Use Sandbox / Development / Production

        return apiClient.createService(PlaidApi.class);
    }
}
