package com.kakao.tech.statistics.dto

class ClipResponse(
    val playCount: Long,
    val likeCount: Long
)

fun Clip.toClipResponse() = ClipResponse(
    playCount = this.playCount,
    likeCount = this.likeCount
)

data class ClipView(
    val playCount: Long = 0,
    val likeCount: Long = 0
)

fun Clip.toClipView() = ClipView(this.playCount, this.likeCount)