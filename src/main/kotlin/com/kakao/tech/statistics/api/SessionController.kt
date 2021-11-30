package com.kakao.tech.statistics.api

import com.kakao.tech.statistics.dto.MultipleSessionView
import com.kakao.tech.statistics.service.SessionDiffService
import com.kakao.tech.statistics.service.SessionFacade
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sessions")
class SessionController(
    val sessionFacade: SessionFacade,
    val sessionDiffService: SessionDiffService
) {

    private val log: Logger = LoggerFactory.getLogger(javaClass)

    @GetMapping
    suspend fun getSessions(): MultipleSessionView {
        return sessionFacade.getSessions()
    }

    @GetMapping("/{sessionId}")
    suspend fun getSession(@PathVariable sessionId: Long) {

    }

    @GetMapping("/diff")
    suspend fun getDiff(): MultipleSessionView {
        return sessionDiffService.diff()
    }
}