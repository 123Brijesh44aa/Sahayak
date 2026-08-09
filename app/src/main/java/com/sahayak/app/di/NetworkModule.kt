package com.sahayak.app.di

import com.sahayak.app.data.remote.HelpRequestApi
import com.sahayak.app.data.repository.HelpRequestRepositoryImpl
import com.sahayak.app.domain.model.HelpRequest
import com.sahayak.app.domain.repository.HelpRequestRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideJson(): Json = Json { ignoreUnknownKeys = true }

    @Provides
    @Singleton
    fun provideRetrofit(json: Json): Retrofit =
        Retrofit.Builder()
            .baseUrl("http://10.41.175.92:8080/")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()

    @Provides
    @Singleton
    fun provideHelpRequestApi(retrofit: Retrofit): HelpRequestApi =
        retrofit.create(HelpRequestApi::class.java)


    @Provides
    @Singleton
    fun provideHelpRequestRepository(api: HelpRequestApi): HelpRequestRepository =
        HelpRequestRepositoryImpl(api)
}