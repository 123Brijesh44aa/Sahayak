package com.sahayak.app.domain.model

data class HelpRequest(
    val id: Long,
    val title: String,
    val description: String,
    val postedBy: String
)