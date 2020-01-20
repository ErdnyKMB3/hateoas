package com.backbase.example.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * <p>
 * Override SpringLiquibase bean because:
 * <ol>
 * <li>liquibase-hana extension supports 3.4.2 and below versions of liquibase
 * <li>Spring boot 2 don't support 3.4.2 liquibase (only 3.5.5 and higher
 * version)
 * </ol>
 *
 * @see "{@link LiquibaseAutoConfiguration}"
 */
@Configuration
@EnableConfigurationProperties({ LiquibaseProperties.class })
public class LiquibaseConfiguration {
    private final DataSource dataSource;
    private final LiquibaseProperties properties;

    @Autowired
    public LiquibaseConfiguration(DataSource dataSource, LiquibaseProperties properties) {
        this.dataSource = dataSource;
        this.properties = properties;
    }

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog(this.properties.getChangeLog());
        liquibase.setContexts(this.properties.getContexts());
        liquibase.setDefaultSchema(this.properties.getDefaultSchema());
        liquibase.setDropFirst(this.properties.isDropFirst());
        liquibase.setShouldRun(this.properties.isEnabled());
        liquibase.setLabels(this.properties.getLabels());
        liquibase.setChangeLogParameters(this.properties.getParameters());
        liquibase.setRollbackFile(this.
                properties.getRollbackFile());
        return liquibase;
    }

}
