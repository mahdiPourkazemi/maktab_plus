package com.pourkazemi.mahdi.mymaktabplus.data

import com.pourkazemi.mahdi.mymaktabplus.data.localdetabase.LocalDataSource
import com.pourkazemi.mahdi.mymaktabplus.data.localdetabase.LocalDataSourceIm
import com.pourkazemi.mahdi.mymaktabplus.data.remotedata.RemoteDataSource
import com.pourkazemi.mahdi.mymaktabplus.data.remotedata.RemoteDataSourceIm
import com.pourkazemi.mahdi.mymaktabplus.data.remotedata.model.PictureItem
import com.pourkazemi.mahdi.mymaktabplus.di.IoDispatcher
import com.pourkazemi.mahdi.mymaktabplus.util.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    @IoDispatcher
    private val dispatcher: CoroutineDispatcher,
    private val remoteDataSourceIm: RemoteDataSource,
    private val localDataSourceIm: LocalDataSourceIm
) {
    suspend fun getRemoteItemList() = safeApiCall(dispatcher) {
       remoteDataSourceIm.getRemoteItemList()
    }
}