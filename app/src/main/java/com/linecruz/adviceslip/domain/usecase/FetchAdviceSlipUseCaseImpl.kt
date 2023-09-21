package com.linecruz.adviceslip.domain.usecase

import com.linecruz.adviceslip.domain.utils.Result
import com.linecruz.adviceslip.domain.mapper.Mapper
import com.linecruz.adviceslip.domain.entity.Advice
import com.linecruz.adviceslip.domain.output.AdviceSlipOutput
import com.linecruz.adviceslip.domain.input.AdviceSlipInput

class FetchAdviceSlipUseCaseImpl(
    private val repository: AdviceSlipOutput,
    private val mapper: Mapper
) : AdviceSlipInput {

    override suspend fun fetchAdviceSlip(): Result<Advice, String> {
        val result = repository.fetchSlipDevice()
        return if (result.isSuccessful) {
            val response = result.body()
            Result.Success(mapper.toAdvice(response!!))
        } else {
            Result.Error(result.errorBody().toString())
        }
    }
}