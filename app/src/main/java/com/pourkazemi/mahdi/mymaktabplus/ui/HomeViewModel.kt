package com.pourkazemi.mahdi.mymaktabplus.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pourkazemi.mahdi.mymaktabplus.data.Repository
import com.pourkazemi.mahdi.mymaktabplus.data.remotedata.model.PictureItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _pictureListState:
            MutableStateFlow<List<PictureItem>> = MutableStateFlow(listOf())
    val pictureListState get() = _pictureListState.asStateFlow()
init {
    getPictureList()
}
    fun getPictureList() {
        viewModelScope.launch{
          val mRos= repository.getRemoteItemList()
            mRos.collect{
               it.
            }
        }
    }
}