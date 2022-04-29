package com.pourkazemi.mahdi.mymaktabplus.data.remotedata

import com.pourkazemi.mahdi.mymaktabplus.data.remotedata.model.PictureItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PictureAPIService {
    @GET("v2/list")
    suspend fun getItemList(
        @Query("page") page:Int,
        @Query("limit") numberOfPicture:Int
    ):Response<List<PictureItem>>
}