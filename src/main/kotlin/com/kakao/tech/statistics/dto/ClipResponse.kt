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
    val id: Long = 0,
    val title: String = "",
    val description: String = "",
    val thumbnailUrl: String = "",
    val tagList: List<String> = emptyList(),
    val playCount: Long = 0,
    val likeCount: Long = 0,
    val createTime: String = ""
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