package com.linecruz.adviceslip.presentation

import com.linecruz.adviceslip.domain.entity.Advice

sealed class AdviceState {
    data class AdviceSuccess(val advice: Advice) : AdviceState()
    data class AdviceError(val error: String) : AdviceState()
    object ShowLoading : AdviceState()
    object HideLoading : AdviceState()
}