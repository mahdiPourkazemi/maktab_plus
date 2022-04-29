package com.pourkazemi.mahdi.mymaktabplus.di

import com.pourkazemi.mahdi.mymaktabplus.data.remotedata.PictureAPIService
import com.pourkazemi.mahdi.mymaktabplus.data.remotedata.RemoteDataSource
import com.pourkazemi.mahdi.mymaktabplus.data.remotedata.RemoteDataSourceIm
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object Module {
    private const val BASE_URL = "https://picsum.photos/"

    //important note
    @Provides
    @IoDispatcher
    fun provideDispatchers(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    fun providesRemoteDataSource(provide: PictureAPIService): RemoteDataSource {
        return RemoteDataSourceIm(provide)
    }

    @Singleton
    @Provides
    fun jsonConvertorFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Singleton
    @Provides
    fun providesRetroFit(
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(gsonConverterFactory).build()

    @Singleton
    @Provides
    fun providesService(retrofit: Retrofit): PictureAPIService =
        retrofit.create(PictureAPIService::class.java)
}
