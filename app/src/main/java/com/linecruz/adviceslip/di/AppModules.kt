package com.linecruz.adviceslip.di

import com.linecruz.adviceslip.data.mapper.MapperImpl
import com.linecruz.adviceslip.data.repository.AdviceSlipRepositoryImpl
import com.linecruz.adviceslip.data.service.AdviceSlipCreateService
import com.linecruz.adviceslip.domain.mapper.Mapper
import com.linecruz.adviceslip.domain.output.AdviceSlipOutput
import com.linecruz.adviceslip.domain.usecase.FetchAdviceSlipUseCaseImpl
import com.linecruz.adviceslip.presentation.viewmodel.MainViewModel
import com.linecruz.adviceslip.domain.input.AdviceSlipInput
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    single { AdviceSlipCreateService().createService() }
    single<AdviceSlipOutput> { AdviceSlipRepositoryImpl(service = get()) }
    single<Mapper> { MapperImpl() }
    factory<AdviceSlipInput> {
        FetchAdviceSlipUseCaseImpl(repository = get(), mapper = get())
    }

    viewModel { MainViewModel(useCase = get()) }
}