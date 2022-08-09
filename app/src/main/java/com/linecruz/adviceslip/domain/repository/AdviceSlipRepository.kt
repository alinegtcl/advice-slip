package com.linecruz.adviceslip.domain.repository

import com.linecruz.adviceslip.data.model.SlipResponse
import retrofit2.Response

interface AdviceSlipRepository {

    suspend fun fetchSlipDevice() : Response<SlipResponse>
}