package com.alan.android_sdk_task1.presentation.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.random.Random

class CustomRectangleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paintFilled = Paint().apply {
        style = Paint.Style.FILL
    }
    private val paintBorder = Paint().apply {
        style = Paint.Style.STROKE
        color = Color.BLACK
        strokeWidth = 8f
    }

    private var fillPercentage = 0
    private var fillColor = Color.RED

    init {
        setOnClickListener {
            fillPercentage += 10
            if (fillPercentage > 100) {
                fillPercentage = 0
            }
            fillColor = generateRandomColor()
            invalidate()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val widthFilled = (width * fillPercentage / 100).toFloat()
        paintFilled.color = fillColor
        canvas.drawRect(0f, 0f, widthFilled, height.toFloat(), paintFilled)
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paintBorder)
    }

    private fun generateRandomColor(): Int {
        return Color.rgb(
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
    }
}
