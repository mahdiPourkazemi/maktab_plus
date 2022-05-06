package com.pourkazemi.mahdi.mymaktabplus.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pourkazemi.mahdi.mymaktabplus.R
import com.pourkazemi.mahdi.mymaktabplus.data.localdetabase.data_store.Lang
import com.pourkazemi.mahdi.mymaktabplus.data.localdetabase.data_store.Theme
import com.pourkazemi.mahdi.mymaktabplus.databinding.FragmentSettingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment : Fragment(R.layout.fragment_setting) {

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SettingViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingBinding.bind(view)

        init()
    }

    private fun init() = with(binding) {
        settingThemes.setOnCheckedChangeListener { radioGroup, checkedId ->
            val theme =  when(checkedId) {
                light.id -> Theme.LIGHT
                night.id -> Theme.NIGHT
                else -> Theme.AUTO
            }
            viewModel.updateTheme(theme)
        }

        settingLangs.setOnCheckedChangeListener { radioGroup, checkedId ->
            val lang =  when(checkedId) {
                english.id -> Lang.ENGLISH
                persian.id -> Lang.PERSIAN
                else -> throw Exception("Invalid lang")
            }
            viewModel.updateLang(lang)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}