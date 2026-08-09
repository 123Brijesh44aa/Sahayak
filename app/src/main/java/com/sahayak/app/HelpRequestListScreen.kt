package com.sahayak.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sahayak.app.domain.model.HelpRequest
import com.sahayak.app.ui.HelpRequestCard

@Composable
fun HelpRequestListScreen(requests: List<HelpRequest>, modifier: Modifier){
    LazyColumn(modifier = modifier.fillMaxSize().padding(top = 70.dp)) {
        items(requests, key = { it.id }){ request ->
            HelpRequestCard(request = request)
        }
    }
}