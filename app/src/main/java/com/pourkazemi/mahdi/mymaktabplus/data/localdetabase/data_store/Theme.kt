package com.pourkazemi.mahdi.mymaktabplus.data.localdetabase.data_store

import androidx.appcompat.app.AppCompatDelegate

enum class Theme(
    val value: Int
) {
    LIGHT(AppCompatDelegate.MODE_NIGHT_NO),
    NIGHT(AppCompatDelegate.MODE_NIGHT_YES),
    AUTO(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
}