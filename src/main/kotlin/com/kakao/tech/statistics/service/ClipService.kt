package com.kakao.tech.statistics.service

import com.kakao.tech.statistics.api.toClipWrapper
import com.kakao.tech.statistics.dto.*
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import javax.annotation.PostConstruct

@Service
class ClipService(
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

    suspend fun getClip(videoClipId: Long) =
        webClient.get()
            .uri("https://tv.kakao.com/api/v1/ft/playmeta/cliplink/${videoClipId}")
            .retrieve()
            .onStatus(HttpStatus::isError) {
                Mono.error(RuntimeException("Connection Failed"))
            }
            .bodyToMono(ClipMeta::class.java)
            .map { it.clipLink.clip }
            .awaitSingle()
            .toClipView()
}