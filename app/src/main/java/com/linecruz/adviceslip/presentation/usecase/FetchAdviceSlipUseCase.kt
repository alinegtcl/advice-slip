package com.linecruz.adviceslip.presentation.usecase

import com.linecruz.adviceslip.common.Result
import com.linecruz.adviceslip.domain.entity.Advice

interface FetchAdviceSlipUseCase {
    suspend fun fetchAdviceSlip(): Result<Advice, String>
}