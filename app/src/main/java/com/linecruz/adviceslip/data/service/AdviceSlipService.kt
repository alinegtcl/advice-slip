package com.linecruz.adviceslip.data.service

import com.linecruz.adviceslip.data.model.SlipResponse
import retrofit2.Response
import retrofit2.http.GET

interface AdviceSlipService {

    companion object {
        const val GET_ADVICE_SLIP_ENDPOINT = "https://api.adviceslip.com/advice"
    }

    @GET(GET_ADVICE_SLIP_ENDPOINT)
    suspend fun getAdviceSlip(): Response<SlipResponse>
}