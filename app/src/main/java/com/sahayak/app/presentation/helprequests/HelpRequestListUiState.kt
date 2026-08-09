package com.sahayak.app.presentation.helprequests

import com.sahayak.app.domain.model.HelpRequest

sealed interface HelpRequestListUiState {
    data object Loading: HelpRequestListUiState
    data class  Success(val requests: List<HelpRequest>): HelpRequestListUiState
    data class Error(val message: String): HelpRequestListUiState
}