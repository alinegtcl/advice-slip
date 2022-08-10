package com.linecruz.adviceslip.domain.usecase

import com.linecruz.adviceslip.common.Result
import com.linecruz.adviceslip.data.toAdvice
import com.linecruz.adviceslip.domain.entity.Advice
import com.linecruz.adviceslip.domain.repository.AdviceSlipRepository

class FetchAdviceSlipUseCase(private val repository: AdviceSlipRepository) {

    suspend fun fetchAdviceSlip(): Result<Advice, String> {
        val result = repository.fetchSlipDevice()
        return if (result.isSuccessful) {
            val advice = result.body().toAdvice()
            Result.Success(advice!!)
        } else {
            Result.Error(result.errorBody().toString())
        }
    }
}