package com.peerbitskuldeep.quizappdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(Constants.USER_NAME)
        val correctAns = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        val totalQ = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)

        tvUserName.text = username
        tvScore.text = "Your score is $correctAns out of $totalQ"

        btnFinsih.setOnClickListener{

            startActivity(Intent(this, MainActivity::class.java))

        }

    }
}