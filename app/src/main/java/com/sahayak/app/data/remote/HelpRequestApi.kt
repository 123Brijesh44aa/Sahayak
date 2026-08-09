package com.sahayak.app.data.remote

import com.sahayak.app.data.remote.dto.HelpRequestDto
import retrofit2.http.GET

interface HelpRequestApi {

    @GET("api/help-requests")
    suspend fun getAll(): List<HelpRequestDto>
}