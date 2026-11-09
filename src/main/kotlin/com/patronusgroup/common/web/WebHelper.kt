package com.patronusgroup.common.web

import org.springframework.core.ParameterizedTypeReference

inline fun <reified T: Any> typeRef(): ParameterizedTypeReference<T> = object: ParameterizedTypeReference<T>(){}