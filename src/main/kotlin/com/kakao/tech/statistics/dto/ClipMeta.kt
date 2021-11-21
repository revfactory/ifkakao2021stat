package com.kakao.tech.statistics.dto

class ClipMeta(
    val clipLink: ClipLink
)

class ClipLink(
    val clip: Clip
)

class Clip(
    val playCount: Long,
    val likeCount: Long
)
