package com.linecruz.adviceslip.di

import com.linecruz.adviceslip.data.mapper.Mapper
import com.linecruz.adviceslip.data.mapper.MapperImpl
import com.linecruz.adviceslip.data.repository.AdviceSlipRepositoryImpl
import com.linecruz.adviceslip.data.service.AdviceSlipCreateService
import com.linecruz.adviceslip.domain.repository.AdviceSlipRepository
import com.linecruz.adviceslip.domain.usecase.FetchAdviceSlipUseCase
import com.linecruz.adviceslip.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    single { AdviceSlipCreateService().createService() }
    single<AdviceSlipRepository> { AdviceSlipRepositoryImpl(service = get()) }
    single<Mapper> { MapperImpl() }
    factory { FetchAdviceSlipUseCase(repository = get(), mapper = get()) }

    viewModel { MainViewModel(useCase = get()) }
}