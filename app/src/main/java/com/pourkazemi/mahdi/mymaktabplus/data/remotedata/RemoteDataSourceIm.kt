package com.pourkazemi.mahdi.mymaktabplus.data.remotedata

import com.pourkazemi.mahdi.mymaktabplus.data.remotedata.model.PictureItem
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSourceIm (val pictureAPIService: PictureAPIService ):RemoteDataSource {
    override suspend fun getRemoteItemList(): Response<List<PictureItem>> {
       return pictureAPIService.getItemList(1,100)
    }

}
