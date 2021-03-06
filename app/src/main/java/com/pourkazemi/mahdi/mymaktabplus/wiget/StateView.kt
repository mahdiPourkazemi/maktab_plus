package com.pourkazemi.mahdi.mymaktabplus.wiget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.pourkazemi.mahdi.mymaktabplus.R
import com.pourkazemi.mahdi.mymaktabplus.databinding.StateviewBinding

class StateView @JvmOverloads constructor(context: Context, attrs: AttributeSet) :
    ConstraintLayout(context, attrs) {
    private val binding: StateviewBinding
    var text: String = ""
        set(value) {
            field = value
            setStateText()
        }


    init {
        val view = inflate(context, R.layout.stateview, this)
        binding = StateviewBinding.bind(view)
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.StateView)
        text = attributes.getString(R.styleable.StateView_state_text) ?:
            attrs.getAttributeResourceValue(R.styleable.StateView_state_text, -1).run {
                context.resources.getString(this)
            }
        Log.d("StateView", "Log stateViw $text")
        attributes.recycle()
    }

    private fun setStateText() {
        binding.tv.text = text
    }

    fun onLoading() {
        binding.loadingAnime.isVisible = true
        binding.loadingAnime.playAnimation()
        binding.tv.isVisible = false
        // binding.tv.visibility= View.GONE
    }

    fun onSuccess() {
        binding.loadingAnime.isVisible = false
        binding.loadingAnime.pauseAnimation()
        binding.tv.isVisible = false
    }

    fun onFail() {
        binding.loadingAnime.isVisible = false
        binding.loadingAnime.pauseAnimation()
        binding.tv.isVisible = true
        text = "Retry" //@resource string
        binding.tv.isClickable=true
    }

    fun onEmpty() {
        binding.loadingAnime.isVisible = false
        binding.loadingAnime.pauseAnimation()
        binding.tv.isVisible = true
        text = "Empty"
        binding.tv.isClickable = false
    }

    fun clickRequest(request: () -> Unit) {
        binding.tv.setOnClickListener {
            request()
        }
    }
}