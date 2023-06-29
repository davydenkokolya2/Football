package com.example.football.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TimeViewModel @Inject constructor() : ViewModel() {
    private val _stateTime = MutableStateFlow<Long?>(60)
    val stateTime: StateFlow<Long?> = _stateTime

    fun loadState(time: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateTime.emit(time)
        }
    }
}
