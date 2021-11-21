package com.kakao.tech.statistics.utils

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import java.time.format.DateTimeFormatter

class EpochLocalDateTimeDeserializer : LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))