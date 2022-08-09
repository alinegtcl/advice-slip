package com.linecruz.adviceslip.data.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AdviceSlipServiceImpl {
    companion object {
        const val ADVICE_SLIP_BASE_URL = "https://api.adviceslip.com"
    }

    fun getService() : AdviceSlipService {
        val retrofit = Retrofit.Builder()
            .baseUrl(ADVICE_SLIP_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(AdviceSlipService::class.java)
    }
}