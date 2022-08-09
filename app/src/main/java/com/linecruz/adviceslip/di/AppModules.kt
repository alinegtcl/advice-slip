package com.linecruz.adviceslip.di

import com.linecruz.adviceslip.data.repository.AdviceSlipRepositoryImpl
import com.linecruz.adviceslip.data.service.AdviceSlipServiceImpl
import com.linecruz.adviceslip.domain.repository.AdviceSlipRepository
import com.linecruz.adviceslip.domain.usecase.FetchAdviceSlipUseCase
import com.linecruz.adviceslip.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    single { AdviceSlipServiceImpl().getService() }
    single<AdviceSlipRepository> { AdviceSlipRepositoryImpl(service = get()) }
    factory { FetchAdviceSlipUseCase(repository = get()) }

    viewModel { MainViewModel(useCase = get()) }
}