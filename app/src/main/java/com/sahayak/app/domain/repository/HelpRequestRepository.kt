package com.sahayak.app.domain.repository

import com.sahayak.app.domain.model.HelpRequest

interface HelpRequestRepository{
    suspend fun getHelpRequests(): Result<List<HelpRequest>>
}