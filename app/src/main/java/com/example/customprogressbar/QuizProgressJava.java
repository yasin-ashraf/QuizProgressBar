package com.example.customprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class QuizProgressJava extends ConstraintLayout {

    ProgressBar progressBar;
    TextView progressText;
    private int quizSteps;

    public QuizProgressJava(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs,context);
    }

    public QuizProgressJava(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs,context);
    }

    private void init(AttributeSet attrs,Context context) {
        View.inflate(context, R.layout.quiz_progress_view, this);
        progressBar = findViewById(R.id.progress);
        progressText = findViewById(R.id.progress_count);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.QuizProgress);
        try {
            int initialProgress = typedArray.getInt(R.styleable.QuizProgress_initial_progress,0);
            quizSteps = typedArray.getInt(R.styleable.QuizProgress_quiz_steps,20);

            progressBar.setProgress(initialProgress);
            progressBar.setMax(quizSteps);
            progressText.setText(String.valueOf(initialProgress));
            if(initialProgress > 9) progressText.setTextColor(Color.parseColor("#FFFFFF"));
        } finally {
            typedArray.recycle();
        }
    }

    private void setProgress(int progress) {
        if(progress > quizSteps) {
            throw new IllegalArgumentException("Progress should be less than "+ quizSteps );
        }else {
            progressBar.setProgress(progress);
            progressText.setText(String.valueOf(progress));
            if(progress > 9) progressText.setTextColor(Color.parseColor("#FFFFFF"));
        }
    }
}
