package com.example.onlineshopapp.di

import com.example.onlineshopapp.api.invoice.InvoiceApi
import com.example.onlineshopapp.api.otherContent.BlogApi
import com.example.onlineshopapp.api.otherContent.ContentApi
import com.example.onlineshopapp.api.product.ColorApi
import com.example.onlineshopapp.api.otherContent.SliderApi
import com.example.onlineshopapp.api.person.UserApi
import com.example.onlineshopapp.api.product.ProductApi
import com.example.onlineshopapp.api.product.ProductCategoryApi
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
            .baseUrl("https://10.0.2.2:9090")
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
    fun provideColorApi(): ColorApi {
        return provideRetrofit().create(ColorApi::class.java)
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