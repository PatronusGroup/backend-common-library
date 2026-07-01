package com.patronusgroup.common.dataSync

import io.awspring.cloud.sqs.operations.SqsTemplate

class DataSyncSQSPublisher(
    private val sqsTemplate: SqsTemplate,
    private val properties: DataSyncProperties
) {

    fun publish(message: DataSyncSQSMessage) {
        sqsTemplate.send(properties.queueName, message)
    }
}