package com.sahayak.app.data.remote.dto

import com.sahayak.app.domain.model.HelpRequest
import kotlinx.serialization.Serializable

@Serializable
data class HelpRequestDto(
    val id: Long,
    val title: String,
    val description: String,
    val postedBy: String
) {
    fun toDomain() = HelpRequest(id, title, description, postedBy)
}