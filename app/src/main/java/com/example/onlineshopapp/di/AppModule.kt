package com.example.onlineshopapp.di

import com.example.onlineshopapp.api.SliderApi
import com.example.onlineshopapp.repository.SliderRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Inject
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