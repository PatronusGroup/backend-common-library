package com.patronusgroup.common.awsSecret

import com.fasterxml.jackson.databind.ObjectMapper
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient

class AwsSecretProvider (
    private val secretsManagerClient: SecretsManagerClient,
    private val objectMapper: ObjectMapper
) {

    fun <T> getSecretValue(secretId: String, clazz: Class<T>): T {
        val response = secretsManagerClient.getSecretValue {
            it.secretId(secretId)
        }

        return objectMapper.readValue(response.secretString(), clazz)
    }

    inline fun <reified T> getSecretValue(secretId: String): T =
        getSecretValue(secretId, T::class.java)
}