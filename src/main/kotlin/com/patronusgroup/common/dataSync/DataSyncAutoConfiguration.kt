package com.patronusgroup.common.dataSync

import io.awspring.cloud.sqs.operations.SqsTemplate
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean

@AutoConfiguration
@EnableConfigurationProperties(DataSyncProperties::class)
class DataSyncAutoConfiguration {

    @Bean
    fun dataSyncSQSPublisher(
        sqsTemplate: SqsTemplate,
        properties: DataSyncProperties,
    ): DataSyncSQSPublisher {
        return DataSyncSQSPublisher(sqsTemplate, properties)
    }
}