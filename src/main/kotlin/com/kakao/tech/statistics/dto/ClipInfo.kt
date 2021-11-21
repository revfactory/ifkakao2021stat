package com.kakao.tech.statistics.dto

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
    val createTime: String
)
