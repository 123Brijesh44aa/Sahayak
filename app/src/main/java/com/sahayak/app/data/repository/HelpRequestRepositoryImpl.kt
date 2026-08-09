package com.sahayak.app.data.repository

import com.sahayak.app.data.remote.HelpRequestApi
import com.sahayak.app.domain.model.HelpRequest
import com.sahayak.app.domain.repository.HelpRequestRepository
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class HelpRequestRepositoryImpl @Inject constructor(
    private val api: HelpRequestApi
): HelpRequestRepository {

    override suspend fun getHelpRequests(): Result<List<HelpRequest>> {
        return try {
            val requests = api.getAll().map { it.toDomain() }
            Result.success(requests)
        } catch (e: IOException){
            Result.failure(Exception("No internet connection. Please try again.",e))
        } catch (e: HttpException){
            Result.failure(Exception("Server error (${e.code()}), please try again.",e))
        }
    }


}