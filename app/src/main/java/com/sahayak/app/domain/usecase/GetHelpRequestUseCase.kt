package com.sahayak.app.domain.usecase

import com.sahayak.app.domain.model.HelpRequest
import com.sahayak.app.domain.repository.HelpRequestRepository
import javax.inject.Inject

class GetHelpRequestUseCase @Inject constructor(
    private val repository: HelpRequestRepository
) {
    suspend operator fun invoke(): Result<List<HelpRequest>> = repository.getHelpRequests()
}