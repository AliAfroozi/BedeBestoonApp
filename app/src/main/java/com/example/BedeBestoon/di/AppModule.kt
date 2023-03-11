package com.example.BedeBestoon.di

import com.example.BedeBestoon.api.invoice.InvoiceApi
import com.example.BedeBestoon.api.otherContent.BlogApi
import com.example.BedeBestoon.api.otherContent.ContentApi
import com.example.BedeBestoon.api.otherContent.SliderApi
import com.example.BedeBestoon.api.person.UserApi
import com.example.BedeBestoon.api.product.ProductApi
import com.example.BedeBestoon.api.product.ProductCategoryApi
import com.example.BedeBestoon.api.product.ProductColorApi
import com.example.BedeBestoon.repository.invoice.InvoiceRepo
import com.example.BedeBestoon.repository.otherContent.BlogRepo
import com.example.BedeBestoon.repository.otherContent.ContentRepo
import com.example.BedeBestoon.repository.otherContent.SliderRepo
import com.example.BedeBestoon.repository.person.UserRepo
import com.example.BedeBestoon.repository.product.ProductCategoryRepo
import com.example.BedeBestoon.repository.product.ProductColorRepo
import com.example.BedeBestoon.repository.product.ProductRepo
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