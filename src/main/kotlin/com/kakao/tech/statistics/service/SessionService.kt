package com.kakao.tech.statistics.service

import com.kakao.tech.statistics.api.toSessionWrapper
import com.kakao.tech.statistics.dto.SessionInfo
import com.kakao.tech.statistics.dto.toMultipleSessionView
import com.kakao.tech.statistics.dto.toSessionResponse
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactive.asFlow
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import javax.annotation.PostConstruct

@Service
class SessionService(
    val webClientBuilder: WebClient.Builder
) {

    private lateinit var webClient: WebClient

    @PostConstruct
    fun setWebClient() {
        val exchangeStrategies = ExchangeStrategies.builder()
            .codecs { it.defaultCodecs().maxInMemorySize(-1) }
            .build()
        webClient = webClientBuilder
            .exchangeStrategies(exchangeStrategies)
            .build()
    }

    suspend fun getSessions() =
        webClient.get()
            .uri("https://if.kakao.com/v2/applyer/contents/day/3")
            .retrieve()
            .onStatus(HttpStatus::isError) {
                Mono.error(RuntimeException("Connection Failed"))
            }
            .bodyToMono(SessionInfo::class.java)
            .flatMapIterable { it.data }
}