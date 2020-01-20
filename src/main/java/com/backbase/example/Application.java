package com.backbase.example;


import com.backbase.buildingblocks.backend.configuration.autoconfigure.BackbaseApplication;
import com.backbase.buildingblocks.jwt.internal.config.EnableInternalJwtConsumer;
import com.backbase.buildingblocks.registry.client.api.EnableRegistryClient;
import org.springframework.boot.SpringApplication;

@BackbaseApplication
@EnableInternalJwtConsumer
@EnableRegistryClient
public class Application {
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
