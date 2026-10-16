package com.patronusgroup.common.hive.api.gateway

import com.patronusgroup.common.awsSecret.AwsSecretProvider
import com.patronusgroup.common.awsSecret.hive.HiveApiConfig
import com.patronusgroup.common.hive.api.*
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

class HiveGateway(
    private val awsSecretProvider: AwsSecretProvider,
    private val hiveApiProperties: HiveApiProperties
) : IHiveGateway {

    private val logger = LoggerFactory.getLogger(javaClass)

    private val webClient = WebClient.builder().build()

    val hiveConfig: HiveApiConfig by lazy {
        awsSecretProvider.getSecretValue(hiveApiProperties.configSecret)
    }

    override fun createOrder(order: OrderRequest): OrderResponse {

        logger.info("Received order to be pushed to Hive: $order")

        return webClient.post()
            .uri("${hiveApiProperties.url}/merchant_api/v2/orders")
            .bodyValue(order)
            .header(HttpHeaders.AUTHORIZATION, "Bearer ${hiveConfig.token}")
            .header(HttpHeaders.CONTENT_TYPE, "application/json")
            .retrieve()
            .onStatus({ it.isError }) { response ->
                response.bodyToMono(String::class.java)
                    .defaultIfEmpty("No response body")
                    .flatMap { body ->
                        Mono.error(
                            HiveApiException(
                                statusCode = response.statusCode().value(),
                                responseBody = body
                            )
                        )
                    }
            }
            .bodyToMono(OrderResponse::class.java)
            .block() ?: run {
                throw HiveApiException(
                    statusCode = 999,
                    responseBody = "Hive returned empty response."
                )
            }
    }

    override fun getSalesChannels(): SalesChannelsResponse {

        return webClient.get()
            .uri("${hiveApiProperties.url}/merchant_api/v2/sales_channels")
            .header(HttpHeaders.AUTHORIZATION, "Bearer ${hiveConfig.token}")
            .header(HttpHeaders.CONTENT_TYPE, "application/json")
            .retrieve()
            .onStatus({ it.isError }) { response ->
                response.bodyToMono(String::class.java)
                    .defaultIfEmpty("No response body")
                    .flatMap { body ->
                        Mono.error(
                            HiveApiException(
                                statusCode = response.statusCode().value(),
                                responseBody = body
                            )
                        )
                    }
            }
            .bodyToMono(SalesChannelsResponse::class.java)
            .block() ?: SalesChannelsResponse(emptyList())
    }

    override fun getShipmentByMerchantOrderId(orderId: String): Shipment? {

        return webClient.get()
            .uri { uriBuilder ->
                uriBuilder
                    .scheme(hiveApiProperties.scheme)
                    .host(hiveApiProperties.host)
                    .path("/merchant_api/v2/shipments")
                    .queryParam("merchant_order_id[in]", orderId)
                    .build()
            }
            .header(HttpHeaders.AUTHORIZATION, "Bearer ${hiveConfig.token}")
            .header(HttpHeaders.CONTENT_TYPE, "application/json")
            .retrieve()
            .onStatus({ it.isError }) { response ->
                response.bodyToMono(String::class.java)
                    .defaultIfEmpty("No response body")
                    .flatMap { body ->
                        Mono.error(
                            HiveApiException(
                                statusCode = response.statusCode().value(),
                                responseBody = body
                            )
                        )
                    }
            }
            .bodyToMono(ShipmentsResponse::class.java)
            .flatMap { response ->
                Mono.justOrEmpty(response.shipments.firstOrNull())
            }
            .block()
    }
}