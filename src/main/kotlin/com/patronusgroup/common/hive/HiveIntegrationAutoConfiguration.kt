package com.patronusgroup.common.hive

import io.awspring.cloud.sqs.operations.SqsTemplate
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean

@AutoConfiguration
@EnableConfigurationProperties(HiveIntegrationProperties::class)
@ConditionalOnClass(SqsTemplate::class)
class HiveIntegrationAutoConfiguration {

    @Bean
    @ConditionalOnProperty(
        prefix = "common-library-hive-integration",
        name = ["queue-name"]
    )
    fun hiveIntegrationSQSPublisher(
        sqsTemplate: SqsTemplate,
        properties: HiveIntegrationProperties,
    ) = HiveIntegrationSQSPublisher(sqsTemplate, properties)
}