package com.patronusgroup.common.hive.api.gateway

import com.patronusgroup.common.awsSecret.AwsSecretProvider
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean

@AutoConfiguration
@EnableConfigurationProperties(HiveApiProperties::class)
class HiveAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(IHiveGateway::class)
    fun hiveGateway(
        awsSecretProvider: AwsSecretProvider,
        props: HiveApiProperties
    ): IHiveGateway = HiveGateway(awsSecretProvider, props)
}