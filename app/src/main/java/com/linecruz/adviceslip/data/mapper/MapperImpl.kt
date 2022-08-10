package com.linecruz.adviceslip.data.mapper

import com.linecruz.adviceslip.data.model.SlipResponse
import com.linecruz.adviceslip.domain.entity.Advice

class MapperImpl : Mapper {
    override fun toAdvice(response: SlipResponse): Advice {
        return Advice(advice = response.slip.advice)
    }
}