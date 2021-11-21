package com.kakao.tech.statistics.api

import com.kakao.tech.statistics.dto.MultipleSessionView
import com.kakao.tech.statistics.service.SessionFacade
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sessions")
class SessionController(
    val sessionFacade: SessionFacade
) {

    @GetMapping
    suspend fun getSessions(): MultipleSessionView {
        return sessionFacade.getSessions()
    }

    @GetMapping("/{sessionId}")
    suspend fun getSession(@PathVariable sessionId: Long) {

    }
}