package com.kakao.tech.statistics.api

import com.kakao.tech.statistics.dto.ClipView
import com.kakao.tech.statistics.service.ClipService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/clips")
class ClipController(
    val clipService: ClipService
) {

    @GetMapping("/{videoClipId}")
    suspend fun getSession(@PathVariable videoClipId: Long): ClipView {
        return clipService.getClip(videoClipId)
    }
}