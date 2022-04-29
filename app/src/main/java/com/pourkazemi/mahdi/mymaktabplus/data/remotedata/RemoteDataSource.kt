package com.pourkazemi.mahdi.mymaktabplus.data.remotedata

import com.pourkazemi.mahdi.mymaktabplus.data.remotedata.model.PictureItem
import retrofit2.Response

interface RemoteDataSource {
suspend fun getRemoteItemList():Response<List<PictureItem>>
}