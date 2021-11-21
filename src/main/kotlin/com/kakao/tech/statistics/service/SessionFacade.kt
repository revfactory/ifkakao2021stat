package com.kakao.tech.statistics.service

import com.kakao.tech.statistics.dto.*
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactive.asFlow
import org.springframework.stereotype.Component

@Component
class SessionFacade(
    private val sessionService: SessionService,
    private val clipService: ClipService
) {
    suspend fun getSessions(): MultipleSessionView {
        return sessionService.getSessions()
            .asFlow()
            .map { mapToSessionView(it) }
            .toList()
            .toMultipleSessionView()
    }

    private suspend fun mapToSessionView(sessionData: SessionData): SessionResponse {
        val clipView = sessionData.linkList["VIDEO"]?.firstOrNull()?.url?.let {
            if (it.startsWith("https://tv.kakao.com"))
                clipService.getClip(it.split("/").last().toLong())
            else
                ClipView()
        }?: ClipView()
        return sessionData.toSessionResponse(clipView)
    }
}