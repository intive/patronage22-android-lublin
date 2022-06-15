package com.intive.patronage22.lublin.di

import com.intive.patronage22.lublin.data.api.PatronageService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataModule {
    private val BASE_URL = "http://proxy-patronageapi.bsolutions.usermd.net/api/"

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesPatronageService(retrofit: Retrofit): PatronageService {
        return retrofit.create(PatronageService::class.java)
    }
}