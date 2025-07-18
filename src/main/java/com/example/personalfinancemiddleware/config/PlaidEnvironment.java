package com.example.personalfinancemiddleware.config;

import com.plaid.client.ApiClient;

public enum PlaidEnvironment {
    SANDBOX(ApiClient.Sandbox),
    PRODUCTION(ApiClient.Production);

    private final String adapter;

    PlaidEnvironment(String adapter) {
        this.adapter = adapter;
    }

    public String getAdapter() {
        return adapter;
    }

    public static PlaidEnvironment fromString(String env) {
        return switch (env.toLowerCase()) {
            case "sandbox" -> SANDBOX;
            case "production" -> PRODUCTION;
            default -> throw new IllegalArgumentException("Unknown Plaid environment: " + env);
        };
    }
}
