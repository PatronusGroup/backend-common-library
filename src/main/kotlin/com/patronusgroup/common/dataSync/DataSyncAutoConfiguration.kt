package com.patronusgroup.common.dataSync

import io.awspring.cloud.sqs.operations.SqsTemplate
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean

@AutoConfiguration
@EnableConfigurationProperties(DataSyncProperties::class)
@ConditionalOnClass(SqsTemplate::class)
class DataSyncAutoConfiguration {

    @Bean
    @ConditionalOnProperty(
        prefix = "common-library-data-sync",
        name = ["queue-name"]
    )
    fun dataSyncSQSPublisher(
        sqsTemplate: SqsTemplate,
        properties: DataSyncProperties,
    ) = DataSyncSQSPublisher(sqsTemplate, properties)
}