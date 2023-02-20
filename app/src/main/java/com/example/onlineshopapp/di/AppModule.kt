package com.example.onlineshopapp.di

import com.example.onlineshopapp.api.otherContent.SliderApi
import com.example.onlineshopapp.repository.SliderRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSliderRepo(sliderApi: SliderApi) : SliderRepo {
        return SliderRepo(sliderApi)
    }
}