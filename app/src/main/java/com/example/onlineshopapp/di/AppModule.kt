package com.example.onlineshopapp.di

import com.example.onlineshopapp.api.invoice.InvoiceApi
import com.example.onlineshopapp.api.otherContent.BlogApi
import com.example.onlineshopapp.api.otherContent.ContentApi
import com.example.onlineshopapp.api.otherContent.SliderApi
import com.example.onlineshopapp.api.person.UserApi
import com.example.onlineshopapp.api.product.ProductApi
import com.example.onlineshopapp.api.product.ProductCategoryApi
import com.example.onlineshopapp.api.product.ProductColorApi
import com.example.onlineshopapp.repository.invoice.InvoiceRepo
import com.example.onlineshopapp.repository.otherContent.BlogRepo
import com.example.onlineshopapp.repository.otherContent.ContentRepo
import com.example.onlineshopapp.repository.otherContent.SliderRepo
import com.example.onlineshopapp.repository.person.UserRepo
import com.example.onlineshopapp.repository.product.ProductCategoryRepo
import com.example.onlineshopapp.repository.product.ProductColorRepo
import com.example.onlineshopapp.repository.product.ProductRepo
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