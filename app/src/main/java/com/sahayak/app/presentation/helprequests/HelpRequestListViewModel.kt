package com.sahayak.app.presentation.helprequests

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sahayak.app.domain.usecase.GetHelpRequestUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HelpRequestListViewModel @Inject constructor(
    private val getHelpRequests: GetHelpRequestUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow<HelpRequestListUiState>(HelpRequestListUiState.Loading)
    val uiState: StateFlow<HelpRequestListUiState> = _uiState.asStateFlow()

    init {
        loadRequests()
    }

    fun loadRequests() {
        viewModelScope.launch {
            _uiState.value = HelpRequestListUiState.Loading
            getHelpRequests()
                .onSuccess { _uiState.value = HelpRequestListUiState.Success(it) }
                .onFailure { _uiState.value = HelpRequestListUiState.Error(it.message ?: "Unknown error") }
        }
    }
}