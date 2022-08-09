package com.linecruz.adviceslip.data

import com.linecruz.adviceslip.data.model.SlipResponse
import com.linecruz.adviceslip.domain.entity.Advice

fun SlipResponse?.toAdvice() = this?.slip?.let {
    Advice(
        advice = it.advice
    )
}
