package com.example.bedebestoon.di

import com.example.bedebestoon.api.invoice.InvoiceApi
import com.example.bedebestoon.api.otherContent.BlogApi
import com.example.bedebestoon.api.otherContent.ContentApi
import com.example.bedebestoon.api.product.ProductColorApi
import com.example.bedebestoon.api.otherContent.SliderApi
import com.example.bedebestoon.api.person.UserApi
import com.example.bedebestoon.api.product.ProductApi
import com.example.bedebestoon.api.product.ProductCategoryApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://10.0.2.2:8080")
            .client(UnsafeSSLConfig.unsafeOkHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideSliderApi(): SliderApi {
        return provideRetrofit().create(SliderApi::class.java)
    }

    @Singleton
    @Provides
    fun provideBlogApi(): BlogApi {
        return provideRetrofit().create(BlogApi::class.java)
    }

    @Singleton
    @Provides
    fun provideColorApi(): ProductColorApi {
        return provideRetrofit().create(ProductColorApi::class.java)
    }

    @Singleton
    @Provides
    fun provideContentApi(): ContentApi {
        return provideRetrofit().create(ContentApi::class.java)
    }

    @Singleton
    @Provides
    fun provideInvoiceApi(): InvoiceApi {
        return provideRetrofit().create(InvoiceApi::class.java)
    }

    @Singleton
    @Provides
    fun provideProductCategoryApi(): ProductCategoryApi {
        return provideRetrofit().create(ProductCategoryApi::class.java)
    }

    @Singleton
    @Provides
    fun provideProductApi(): ProductApi {
        return provideRetrofit().create(ProductApi::class.java)
    }

    @Singleton
    @Provides
    fun provideUserApi(): UserApi {
        return provideRetrofit().create(UserApi::class.java)
    }


}