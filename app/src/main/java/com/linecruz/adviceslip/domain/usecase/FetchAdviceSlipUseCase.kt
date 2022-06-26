package com.linecruz.adviceslip.domain.usecase

import com.linecruz.adviceslip.data.model.SlipResponse
import com.linecruz.adviceslip.domain.entity.Advice
import com.linecruz.adviceslip.domain.repository.AdviceSlipRepository

class FetchAdviceSlipUseCase (private val repository: AdviceSlipRepository) {

    suspend fun fetchAdviceSlip() : Advice? {
        return repository.fetchSlipDevice().body().toAdvice()
    }
}

private fun SlipResponse?.toAdvice() = this?.slip?.let {
    Advice(
        advice = it.advice
    )
}

