package com.patronusgroup.common.dataSync

import io.awspring.cloud.sqs.operations.SqsTemplate
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean

@AutoConfiguration
@ConditionalOnClass(SqsTemplate::class)
@ConditionalOnProperty(prefix = "common-library-data-sync", name = ["queue-name"])
@EnableConfigurationProperties(DataSyncProperties::class)
class DataSyncAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    fun dataSyncSQSPublisher(
        sqsTemplate: SqsTemplate,
        properties: DataSyncProperties,
    ) = DataSyncSQSPublisher(sqsTemplate, properties)
}