package com.example.customprogressbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        quiz_progress.setProgress(2)
        Handler().postDelayed({
            quiz_progress.setProgress(16)
            startActivity(Intent(this,NewActivity::class.java))
        },4000)
    }
}
