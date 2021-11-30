package com.kakao.tech.statistics.service

import com.kakao.tech.statistics.dto.MultipleSessionView
import com.kakao.tech.statistics.utils.JsonHelper
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service

@Service
class SessionDiffService {
    private val jsonHelper: JsonHelper = JsonHelper()


    fun diff(): MultipleSessionView {

        return jsonHelper.readFile<MultipleSessionView>(ClassPathResource("result/result-20211122.json").file)
    }
}