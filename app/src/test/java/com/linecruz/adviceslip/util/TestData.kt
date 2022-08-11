package com.linecruz.adviceslip.util

import com.linecruz.adviceslip.data.model.Slip
import com.linecruz.adviceslip.data.model.SlipResponse
import com.linecruz.adviceslip.domain.entity.Advice

object TestData {
    private const val ADVICE_DEFAULT = "Bring beer you must!"
    private const val ADVICE_ID_DEFAULT = "01"

    val SLIP_RESPONSE_TEST = SlipResponse(Slip(ADVICE_DEFAULT, ADVICE_ID_DEFAULT))
    val ADVICE_TEST = Advice(ADVICE_DEFAULT)
}