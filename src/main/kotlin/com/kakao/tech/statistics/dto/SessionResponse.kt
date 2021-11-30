package com.kakao.tech.statistics.dto

class SessionResponse(
    val idx: Long,
    val title: String,
    val content: String,
    val contentTag: String,
    val companyName: String,
    val speakerName: String,
    val videoLink: String,
    val playCount: Long,
    val likeCount: Long
)

fun SessionData.toSessionResponse(clipView: ClipView) = SessionResponse(
    idx = this.idx,
    title = this.title,
    content = this.content,
    contentTag = this.contentTag,
    companyName = this.companyName,
    speakerName = this.speakerName,
    videoLink = this.linkList["VIDEO"]?.first()?.url.orEmpty(),
    playCount = clipView.playCount,
    likeCount = clipView.likeCount
)

class MultipleSessionView(
    val articles: List<SessionResponse> = emptyList(),
    val articlesCount: Int = 0,
)

fun List<SessionResponse>.toMultipleSessionView() = MultipleSessionView(this, this.size)

class SessionDiffView(

)