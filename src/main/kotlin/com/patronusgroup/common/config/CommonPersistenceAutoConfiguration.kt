package com.patronusgroup.common.config

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@ConditionalOnProperty("com.patronusgroup.common.persistence.enabled", havingValue = "true")
@EnableJpaRepositories(basePackages = ["com.patronusgroup.common.repository"])
@EntityScan(basePackages = ["com.patronusgroup.common.dao"])
class CommonPersistenceAutoConfiguration