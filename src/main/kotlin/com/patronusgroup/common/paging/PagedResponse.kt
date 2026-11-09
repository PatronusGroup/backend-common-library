package com.patronusgroup.common.paging

import org.springframework.data.domain.Page

data class PagedResponse<T>(
    val items: List<T>,
    val page: Int,
    val size: Int,
    val totalElements: Long,
    val totalPages: Int,
)

fun <T> Page<T>.toResponse() = PagedResponse(
    items = content,
    page = number,
    size = size,
    totalElements = totalElements,
    totalPages = totalPages,
)