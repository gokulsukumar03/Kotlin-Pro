package com.kotlin.demo.base.custom

import android.content.Context
import android.graphics.Color
import android.text.TextUtils
import android.util.AttributeSet
import android.widget.TextView

class CustomTextView : TextView{

    constructor(context: Context) : super(context){
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet):    super(context, attrs){
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?,    defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    fun init(context: Context){
    }

    override fun setMaxLines(maxLines: Int) {
        super.setMaxLines(1)
    }

    override fun setAllCaps(allCaps: Boolean) {
        super.setAllCaps(false)
    }

    override fun setEllipsize(where: TextUtils.TruncateAt?) {
        super.setEllipsize(TextUtils.TruncateAt.END)
    }

    override fun setTextSize(size: Float) {
        super.setTextSize(40f)
    }

    override fun setTextColor(color: Int) {
        super.setTextColor(Color.RED)
    }

}