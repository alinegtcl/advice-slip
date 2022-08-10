package com.linecruz.adviceslip.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.linecruz.adviceslip.common.flow
import com.linecruz.adviceslip.domain.usecase.FetchAdviceSlipUseCase
import kotlinx.coroutines.launch

class MainViewModel(private val useCase: FetchAdviceSlipUseCase) : ViewModel() {

    private val _state = MutableLiveData<AdviceState>()
    val state: LiveData<AdviceState>
        get() = _state

    fun fetchAdvice() = viewModelScope.launch {
        _state.postValue(AdviceState.ShowLoading)
        val result = useCase.fetchAdviceSlip()
        result.flow(
            { advice ->
                _state.postValue(AdviceState.HideLoading)
                _state.postValue(AdviceState.AdviceSuccess(advice))
            }, { responseError ->
                _state.postValue(AdviceState.HideLoading)
                _state.postValue(AdviceState.AdviceError(responseError))
            }
        )
    }

}

