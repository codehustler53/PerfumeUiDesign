package com.codehustlers.youtube.codehustlers101.customviews

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class VerticalTextView: AppCompatTextView {

    constructor(context: Context): super(context)

    constructor(context: Context, attr: AttributeSet): super(context, attr)

    constructor(context: Context, attr: AttributeSet, defStyle: Int): super(context, attr, defStyle)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(heightMeasureSpec, widthMeasureSpec)
        setMeasuredDimension(measuredHeight, measuredWidth)
    }

    override fun onDraw(canvas: Canvas?) {
        val textPaint = paint
        textPaint.color = currentTextColor
        canvas?.save()
        canvas?.translate(0f, height.toFloat())
        canvas?.rotate(-90f)
        layout.draw(canvas)
        canvas?.restore()
    }

}