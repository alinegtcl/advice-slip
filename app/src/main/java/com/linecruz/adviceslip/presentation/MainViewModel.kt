package com.linecruz.adviceslip.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.linecruz.adviceslip.data.toAdvice
import com.linecruz.adviceslip.domain.usecase.FetchAdviceSlipUseCase
import kotlinx.coroutines.launch

class MainViewModel(private val useCase: FetchAdviceSlipUseCase) : ViewModel() {

    private val _state = MutableLiveData<AdviceState>()
    val state : LiveData<AdviceState>
        get() = _state

    fun fetchAdvice() = viewModelScope.launch {
        _state.postValue(AdviceState.ShowLoading)
        val result = useCase.fetchAdviceSlip()
        if (result.isSuccessful) {
            val advice = result.body().toAdvice()
            _state.postValue(AdviceState.HideLoading)
            _state.postValue(AdviceState.AdviceSuccess(advice!!))
        } else {
            _state.postValue(AdviceState.HideLoading)
            _state.postValue(AdviceState.AdviceError(result.errorBody().toString()))
        }
    }

}

