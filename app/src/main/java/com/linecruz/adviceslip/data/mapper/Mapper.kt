package com.linecruz.adviceslip.data.mapper

import com.linecruz.adviceslip.data.model.SlipResponse
import com.linecruz.adviceslip.domain.entity.Advice

interface Mapper {
    fun toAdvice(response: SlipResponse): Advice
}