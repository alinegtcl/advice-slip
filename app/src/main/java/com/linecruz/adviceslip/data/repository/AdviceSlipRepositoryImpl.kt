package com.linecruz.adviceslip.data.repository

import com.linecruz.adviceslip.data.model.SlipResponse
import com.linecruz.adviceslip.data.service.AdviceSlipService
import com.linecruz.adviceslip.domain.output.AdviceSlipOutput
import retrofit2.Response

class AdviceSlipRepositoryImpl(
    private val service: AdviceSlipService
) : AdviceSlipOutput {

    override suspend fun fetchSlipDevice(): Response<SlipResponse> {
        return service.getAdviceSlip()
    }
}