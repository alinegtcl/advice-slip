package com.linecruz.adviceslip.domain.usecase

import com.linecruz.adviceslip.common.Result
import com.linecruz.adviceslip.data.mapper.Mapper
import com.linecruz.adviceslip.domain.entity.Advice
import com.linecruz.adviceslip.domain.repository.AdviceSlipRepository

class FetchAdviceSlipUseCase(
    private val repository: AdviceSlipRepository,
    private val mapper: Mapper
) {
    suspend fun fetchAdviceSlip(): Result<Advice, String> {
        val result = repository.fetchSlipDevice()
        return if (result.isSuccessful) {
            val response = result.body()
            Result.Success(mapper.toAdvice(response!!))
        } else {
            Result.Error(result.errorBody().toString())
        }
    }
}