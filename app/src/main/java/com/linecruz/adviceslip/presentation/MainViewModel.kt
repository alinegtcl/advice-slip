package com.linecruz.adviceslip.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.linecruz.adviceslip.common.flow
import com.linecruz.adviceslip.presentation.usecase.FetchAdviceSlipUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val useCase: FetchAdviceSlipUseCase) : ViewModel() {

    private val _state = MutableStateFlow<AdviceState>(AdviceState.HideLoading)
    val state = _state.asStateFlow()

    fun fetchAdvice() = viewModelScope.launch {
        _state.value = AdviceState.ShowLoading
        val result = useCase.fetchAdviceSlip()
        result.flow(
            { advice ->
                _state.value = AdviceState.HideLoading
                _state.value = AdviceState.AdviceSuccess(advice)
            }, { responseError ->
                _state.value = AdviceState.HideLoading
                _state.value = AdviceState.AdviceError(responseError)
            }
        )
    }
}

