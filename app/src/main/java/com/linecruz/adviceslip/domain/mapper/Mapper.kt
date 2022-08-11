package com.linecruz.adviceslip.domain.mapper

import com.linecruz.adviceslip.data.model.SlipResponse
import com.linecruz.adviceslip.domain.entity.Advice

interface Mapper {
    fun toAdvice(response: SlipResponse): Advice
}