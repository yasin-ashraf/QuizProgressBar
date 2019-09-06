package com.example.customprogressbar

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.quiz_progress_view.view.*

class QuizProgress @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        View.inflate(context, R.layout.quiz_progress_view, this)
        val ta = context.obtainStyledAttributes(attrs, R.styleable.QuizProgress)
        try {
            val initialProgress = ta.getInt(R.styleable.QuizProgress_initial_progress,0)
            val quizSteps = ta.getInt(R.styleable.QuizProgress_quiz_steps,20)
            progress.progress = initialProgress
            progress.max = quizSteps
            progress_count.text = initialProgress.toString()
            if(initialProgress > 9) progress_count.setTextColor(Color.parseColor("#FFFFFF"))
        } finally {
            ta.recycle()
        }
    }

    fun setProgress(progressNow : Int) {
        require(progressNow < 21) { "Progress should be less than 20" }
        progress.progress = progressNow
        progress_count.text = progressNow.toString()
        if(progressNow > 9) progress_count.setTextColor(Color.parseColor("#FFFFFF"))
    }
}