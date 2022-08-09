package com.linecruz.adviceslip.domain.usecase

import com.linecruz.adviceslip.data.model.SlipResponse
import com.linecruz.adviceslip.domain.repository.AdviceSlipRepository
import retrofit2.Response

class FetchAdviceSlipUseCase(private val repository: AdviceSlipRepository) {

    suspend fun fetchAdviceSlip(): Response<SlipResponse> {
        return repository.fetchSlipDevice()
    }
}