package com.linecruz.adviceslip.di

import android.app.Application
import android.telephony.TelephonyManager
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.stopKoin
import org.koin.dsl.koinApplication
import org.koin.test.check.checkModules
import org.koin.test.mock.MockProviderRule

class AppDependencyTest {

    @get:Rule
    val observerRule = InstantTaskExecutorRule()

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        mockkObject(
            clazz.java
        )
    }

    @Before
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `checks if the project has all dependencies being injected`() {
        val mockContext = mockk<Application> {
            every { getSystemService(any()) } returns mockk<TelephonyManager>(relaxUnitFun = true)
        }
        koinApplication {
            androidContext(mockContext)
            modules(appModules)
        }.checkModules {
            defaultValue<SavedStateHandle>(mockk())
        }
    }
}
