package com.kakao.tech.statistics.api

import com.fasterxml.jackson.annotation.JsonProperty

data class SessionWrapper<T>(@JsonProperty("session") val content: T)

data class ClipWrapper<T>(@JsonProperty("clip") val content: T)

fun <T> T.toSessionWrapper() = SessionWrapper(this)

fun <T> T.toClipWrapper() = ClipWrapper(this)