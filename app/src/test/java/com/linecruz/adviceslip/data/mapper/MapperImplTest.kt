package com.linecruz.adviceslip.data.mapper

import com.linecruz.adviceslip.util.TestData
import org.junit.Assert.*
import org.junit.Test

class MapperImplTest {
    private val mapper = MapperImpl()

    @Test
    fun `should receive a SlipResponse and return a Advice`() {
        val expectedResult = TestData.ADVICE_TEST
        val result = mapper.toAdvice(TestData.SLIP_RESPONSE_TEST)
        assertEquals(expectedResult, result)
    }
}