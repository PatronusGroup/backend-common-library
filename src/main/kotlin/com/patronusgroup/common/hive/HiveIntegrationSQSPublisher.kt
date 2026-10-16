package com.patronusgroup.common.hive

import io.awspring.cloud.sqs.operations.SqsTemplate

class HiveIntegrationSQSPublisher(
    private val sqsTemplate: SqsTemplate,
    private val properties: HiveIntegrationProperties
) {

    fun publish(message: HiveIntegrationSQSMessage) {
        sqsTemplate.send(properties.queueName, message)
    }
}