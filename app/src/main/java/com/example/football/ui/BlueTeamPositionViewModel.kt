package com.example.football.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.football.utils.PlayerPositions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlueTeamPositionViewModel @Inject constructor() : ViewModel() {
    private val _statePosition = MutableStateFlow<PlayerPositions?>(PlayerPositions.DEFENDING)
    val statePosition: StateFlow<PlayerPositions?> = _statePosition

    fun loadState(playerPositions: PlayerPositions) {
        viewModelScope.launch(Dispatchers.IO) {
            _statePosition.emit(playerPositions)
        }
    }
}