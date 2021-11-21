package com.kakao.tech.statistics.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.kakao.tech.statistics.utils.EpochLocalDateTimeDeserializer
import java.time.LocalDateTime

class ClipInfo(
    val clipLink: ClipLink
)

class ClipLink(
    val clip: Clip
)

class Clip(
    val id: Long,
    val title: String,
    val description: String,
    val thumbnailUrl: String,
    val tagList: List<String>,
    val playCount: Long,
    val likeCount: Long,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = EpochLocalDateTimeDeserializer::class)
    val createTime: LocalDateTime
)
