package com.patronusgroup.common.hive

import io.awspring.cloud.sqs.operations.SqsTemplate

class HiveIntegrationSQSPublisher(
    private val sqsTemplate: SqsTemplate,
    private val properties: HiveIntegrationProperties
) {

    fun publish(
        message: HiveIntegrationSQSMessage
    ) {
        sqsTemplate.send { to ->
            to.queue(properties.queueName)
                .payload(message)
                .messageGroupId(message.type.name)
                .messageDeduplicationId(message.messageDeduplicationId)
        }
    }
}