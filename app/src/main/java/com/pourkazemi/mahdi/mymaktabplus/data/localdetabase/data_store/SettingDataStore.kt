package com.pourkazemi.mahdi.mymaktabplus.data.localdetabase.data_store

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

// At the top level of your kotlin file:
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "datastore_settings")

@Singleton
class SettingDataStore @Inject constructor(
    @ApplicationContext context: Context
) {
    private val dataStore = context.dataStore

    val preferences: Flow<PreferencesInfo> = dataStore.data.catch { cause ->
        Log.e("datastore_error", cause.message.toString())
    }.map { preference ->
        val theme: Theme = Theme.valueOf(preference[SettingPreferencesKey.KEY_THEME] ?: Theme.AUTO.name)
        val lang: Lang = Lang.valueOf(preference[SettingPreferencesKey.KEY_LANG] ?: Lang.ENGLISH.name)
        PreferencesInfo(
            theme = theme,
            lang = lang,
        )
    }

    suspend fun updateTheme(theme: Theme) {
        dataStore.edit {
            it[SettingPreferencesKey.KEY_THEME] = theme.name
        }
    }

    suspend fun updateLang(lang: Lang) {
        dataStore.edit {
            it[SettingPreferencesKey.KEY_LANG] = lang.name
        }
    }

    private object SettingPreferencesKey {
        val KEY_THEME = stringPreferencesKey("preferences_them")
        val KEY_LANG = stringPreferencesKey("preferences_lang")
    }
}
