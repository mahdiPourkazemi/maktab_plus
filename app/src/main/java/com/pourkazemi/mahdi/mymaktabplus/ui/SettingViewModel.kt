package com.pourkazemi.mahdi.mymaktabplus.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pourkazemi.mahdi.mymaktabplus.data.localdetabase.data_store.Lang
import com.pourkazemi.mahdi.mymaktabplus.data.localdetabase.data_store.SettingDataStore
import com.pourkazemi.mahdi.mymaktabplus.data.localdetabase.data_store.Theme
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val settingDataStore: SettingDataStore
) : ViewModel() {

    fun updateTheme(theme: Theme) {
        viewModelScope.launch {
            settingDataStore.updateTheme(theme)
        }
    }

    fun updateLang(lang: Lang) {
        viewModelScope.launch {
            settingDataStore.updateLang(lang)
        }
    }
}
