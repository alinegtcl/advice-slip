package com.linecruz.adviceslip.domain.input

import com.linecruz.adviceslip.domain.utils.Result
import com.linecruz.adviceslip.domain.entity.Advice

interface AdviceSlipInput {
    suspend fun fetchAdviceSlip(): Result<Advice, String>
}