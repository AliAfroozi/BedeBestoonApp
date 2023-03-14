package com.example.bedebestoon.di

import com.example.bedebestoon.api.invoice.InvoiceApi
import com.example.bedebestoon.api.otherContent.BlogApi
import com.example.bedebestoon.api.otherContent.ContentApi
import com.example.bedebestoon.api.otherContent.SliderApi
import com.example.bedebestoon.api.person.UserApi
import com.example.bedebestoon.api.product.ProductApi
import com.example.bedebestoon.api.product.ProductCategoryApi
import com.example.bedebestoon.api.product.ProductColorApi
import com.example.bedebestoon.repository.invoice.InvoiceRepo
import com.example.bedebestoon.repository.otherContent.BlogRepo
import com.example.bedebestoon.repository.otherContent.ContentRepo
import com.example.bedebestoon.repository.otherContent.SliderRepo
import com.example.bedebestoon.repository.person.UserRepo
import com.example.bedebestoon.repository.product.ProductCategoryRepo
import com.example.bedebestoon.repository.product.ProductColorRepo
import com.example.bedebestoon.repository.product.ProductRepo
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

    @Provides
    @Singleton
    fun provideBlogRepo(blogApi: BlogApi) : BlogRepo {
        return BlogRepo(blogApi)
    }

    @Provides
    @Singleton
    fun provideContentRepo(ContentApi: ContentApi) : ContentRepo {
        return ContentRepo(ContentApi)
    }

    @Provides
    @Singleton
    fun provideProductRepo(ProductApi: ProductApi) : ProductRepo {
        return ProductRepo(ProductApi)
    }

    @Provides
    @Singleton
    fun provideProductCategoryRepo(ProductCategoryApi: ProductCategoryApi) : ProductCategoryRepo {
        return ProductCategoryRepo(ProductCategoryApi)
    }

    @Provides
    @Singleton
    fun provideProductColorRepo(ProductColorApi: ProductColorApi) : ProductColorRepo {
        return ProductColorRepo(ProductColorApi)
    }

    @Provides
    @Singleton
    fun provideInvoiceRepo(InvoiceApi: InvoiceApi) : InvoiceRepo {
        return InvoiceRepo(InvoiceApi)
    }

    @Provides
    @Singleton
    fun provideUserRepo(UserApi: UserApi) : UserRepo {
        return UserRepo(UserApi)
    }


}