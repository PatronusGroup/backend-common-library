package com.patronusgroup.common.extension

fun Map<*, *>?.toStringStringMap(): HashMap<String, String?>? {
    this ?: return null
    return this
        .filterKeys { it is String }
        .mapKeys { it.key as String }
        .mapValues { it.value as? String }
        .let { HashMap(it) }
}

fun Any?.toStringStringMap(): HashMap<String, String?>? {
    val map = this as? Map<*, *> ?: return null
    return map.entries
        .filter { it.key is String }
        .associate { it.key as String to it.value as? String }
        .let { HashMap(it) }
}