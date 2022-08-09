package com.linecruz.adviceslip.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SlipResponse(
    @SerializedName("slip")
    val slip: Slip
) : Serializable

data class Slip(
    @SerializedName("advice")
    val advice: String,
    @SerializedName("slip_id")
    val slip_id: String
)