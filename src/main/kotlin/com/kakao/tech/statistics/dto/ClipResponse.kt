package com.kakao.tech.statistics.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.kakao.tech.statistics.utils.EpochLocalDateTimeDeserializer
import java.time.LocalDateTime

class ClipResponse(
    val playCount: Long,
    val likeCount: Long
)

fun Clip.toClipResponse() = ClipResponse(
    playCount = this.playCount,
    likeCount = this.likeCount
)

data class ClipView(
    val id: Long = 0,
    val title: String = "",
    val description: String = "",
    val thumbnailUrl: String = "",
    val tagList: List<String> = emptyList(),
    val playCount: Long = 0,
    val likeCount: Long = 0,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    val createTime: LocalDateTime? = null
)

fun Clip.toClipView() = ClipView(
    id = this.id,
    title = this.title,
    description = this.description,
    thumbnailUrl = this.thumbnailUrl,
    tagList = this.tagList,
    playCount = this.playCount,
    likeCount = this.likeCount,
    createTime = this.createTime
)