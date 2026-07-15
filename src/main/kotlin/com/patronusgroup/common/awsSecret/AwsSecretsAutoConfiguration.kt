package com.patronusgroup.common.awsSecret

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient

@AutoConfiguration
class AwsSecretsAutoConfiguration {

    @Bean
    @ConditionalOnBean(SecretsManagerClient::class)
    @ConditionalOnMissingBean
    fun awsSecretProvider(
        secretsManagerClient: SecretsManagerClient,
        objectMapper: ObjectMapper,
    ) = AwsSecretProvider(
        secretsManagerClient,
        objectMapper
    )
}