package com.sahayak.app.presentation.helprequests

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sahayak.app.ui.HelpRequestCard

@Composable
fun HelpRequestListRoute(viewModel: HelpRequestListViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    HelpRequestListScreen(uiState,onRetry = viewModel::loadRequests)
}

@Composable
fun HelpRequestListScreen(
    uiState: HelpRequestListUiState,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    when(uiState) {
        is HelpRequestListUiState.Loading -> Box(modifier.fillMaxSize(), Alignment.Center) {
            CircularProgressIndicator()
        }
        is HelpRequestListUiState.Success -> LazyColumn(modifier.fillMaxSize()) {
            items(uiState.requests, key = { it.id }){
                HelpRequestCard(it)
            }
        }
        is HelpRequestListUiState.Error -> Box(modifier.fillMaxSize(), Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(uiState.message)
                Spacer(Modifier.height(8.dp))
                Button(onClick = onRetry) { Text("Retry") }
            }
        }
    }
}