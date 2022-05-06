package com.pourkazemi.mahdi.mymaktabplus.ui

import androidx.lifecycle.ViewModel
import com.pourkazemi.mahdi.mymaktabplus.data.localdetabase.data_store.SettingDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val settingDataStore: SettingDataStore
) : ViewModel() {

    val preferences = settingDataStore.preferences
}