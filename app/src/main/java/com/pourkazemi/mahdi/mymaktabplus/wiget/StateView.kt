package com.pourkazemi.mahdi.mymaktabplus.wiget

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.pourkazemi.mahdi.mymaktabplus.R
import com.pourkazemi.mahdi.mymaktabplus.databinding.StateviewBinding

class StateView @JvmOverloads constructor(context: Context, attrs: AttributeSet) :
    ConstraintLayout(context, attrs) {
    private val binding: StateviewBinding

    init {
        val view = inflate(context, R.layout.stateview, this)
        binding = StateviewBinding.bind(view)

    //#Goodbye until nextTime
/*        val attributes = context.obtainStyledAttributes(attrs, R.styleable.BenefitView)
        imageView.setImageDrawable(attributes.getDrawable(R.styleable.BenefitView_image))
        textView.text = attributes.getString(R.styleable.BenefitView_text)
        attributes.recycle()*/
    }

}