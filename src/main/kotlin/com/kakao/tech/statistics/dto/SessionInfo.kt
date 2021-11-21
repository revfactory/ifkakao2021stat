package com.kakao.tech.statistics.dto

class SessionInfo(
    val success: Boolean,
    val code: Int,
    val data: List<SessionData>,
    val count: Int,
    val errorMessage: String?
)

class SessionData(
    val idx: Long,
    val createdUserIdx: Long,
    val createdDateTime: String,
    val lastModifiedUserIdx: Long,
    val lastModifiedDateTime: String,
    val categoryIdx: Long,
    val title: String,
    val content: String,
    val contentTag: String,
    val spotlightYn: String,
    val field: String,
    val sessionType: String,
    val commentYn: String,
    val company: String,
    val reservationDate: String?,
    val reservationTime: String?,
    val linkList: Map<String, List<Link>>,
    val relationList: Map<String, List<String>>,
    val contentsSpeakerList: List<ContentsSpeaker>,
    val favoriteYn: String,
    val newCountentsYn: String,
    val updateCountentsYn: String,
    val companyName: String,
    val speakerName: String,
    val speakerLoginYn: String,
    val reservationUTC: Long,
    val reservationYn: String,
    val videoYn: String
)

class Link(
    val idx: Long,
    val contentsIdx: Long,
    val type: String,
    val fileSize: Long,
    val url: String,
    val description: String?,
    val mainYn: String
)

class ContentsSpeaker(
    val idx: Long,
    val contentsIdx: Long,
    val nameKo: String,
    val nameEn: String,
    val company: String?,
    val occupation: String?,
)