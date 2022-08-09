package com.linecruz.adviceslip.data.service

import com.linecruz.adviceslip.data.model.SlipResponse
import retrofit2.Response
import retrofit2.http.GET

interface AdviceSlipService {

    companion object {
        const val GET_ADVICE_SLIP = "/advice"
    }

    @GET(GET_ADVICE_SLIP)
    suspend fun getAdviceSlip(): Response<SlipResponse>
}