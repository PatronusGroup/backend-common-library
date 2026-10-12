package com.patronusgroup.common.hive

import com.patronusgroup.common.dataSync.DataSyncSQSMessage
import io.awspring.cloud.sqs.operations.SqsTemplate

class HiveIntegrationSQSPublisher(
    private val sqsTemplate: SqsTemplate,
    private val properties: HiveIntegrationProperties
) {

    fun publish(message: DataSyncSQSMessage) {
        sqsTemplate.send(properties.queueName, message)
    }
}