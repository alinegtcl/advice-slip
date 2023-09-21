package com.linecruz.adviceslip.domain.output

import com.linecruz.adviceslip.data.model.SlipResponse
import retrofit2.Response

interface AdviceSlipOutput {

    suspend fun fetchSlipDevice() : Response<SlipResponse>
}