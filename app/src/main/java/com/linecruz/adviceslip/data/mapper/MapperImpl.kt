package com.linecruz.adviceslip.data.mapper

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.linecruz.adviceslip.data.model.SlipResponse
import com.linecruz.adviceslip.domain.entity.Advice
import com.linecruz.adviceslip.domain.mapper.Mapper
import okhttp3.ResponseBody
import java.io.IOException

class MapperImpl : Mapper {
    override fun toAdvice(response: SlipResponse): Advice {
        return Advice(advice = response.slip.advice)
    }

    inline fun <reified A> String?.fromJson(): A {
        return GsonBuilder().create().fromJson(this, object: TypeToken<A>() {}.type)
    }

    @Throws(IOException::class)
    inline fun <reified A> ResponseBody.toObject(): A {
        return string().fromJson()
    }
}