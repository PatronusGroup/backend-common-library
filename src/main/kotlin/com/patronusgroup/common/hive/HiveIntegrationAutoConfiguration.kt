package com.patronusgroup.common.hive

import io.awspring.cloud.sqs.operations.SqsTemplate
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean

@AutoConfiguration
@ConditionalOnClass(SqsTemplate::class)
@ConditionalOnProperty(prefix = "common-library-hive-integration", name = ["queue-name"])
@EnableConfigurationProperties(HiveIntegrationProperties::class)
class HiveIntegrationAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    fun hiveIntegrationSQSPublisher(
        sqsTemplate: SqsTemplate,
        properties: HiveIntegrationProperties,
    ) = HiveIntegrationSQSPublisher(sqsTemplate, properties)
}